package by.bsu.project.utils;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.SingleTest;
import by.bsu.project.general.model.Task;
import com.google.common.io.Files;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static by.bsu.project.general.constants.ETestingConstants.UserTaskStatus;

public class ProgramFilesUtil {
    private ProgramFilesEntity entity;
    private Task task;

    private String cmdC;
    private String cmdCpp;
    private String cmdPascal;
    private String cmdJava;
    private List<String> messages = new ArrayList<>();
    private StringBuffer testResults = new StringBuffer();


    private String dir;

    private static final Logger logger = Logger.getLogger(ProgramFilesUtil.class);

    public ProgramFilesUtil(ProgramFilesEntity entity, Task task) throws ConfigurationException {
        String tmpDir = System.getProperty("java.io.tmpdir") + "\\";
        this.entity = entity;
        this.task = task;
        File tmp = Files.createTempDir();
        tmp.deleteOnExit();
        dir = tmp.getAbsolutePath();
        PropertiesConfiguration config = new PropertiesConfiguration("compilers.properties");
        cmdC = tmpDir + config.getProperty("c") + " " + dir + "/" + entity.getFileName();
        cmdCpp = tmpDir + config.getProperty("cpp") + " " + dir + "/" + entity.getFileName() + " -I" + tmpDir + "compilers/dm/dm/stlport/stlport";
        String pp = tmpDir + config.getProperty("pas");
        cmdPascal = String.format("%s\\bin.w32\\vpc -b %s -O%s\\units.w32 -L%s\\lib.w32 -E%s -R%s\\res.w32",
                pp, dir + "\\" + entity.getFileName(), pp, pp, dir, pp);
        cmdJava = System.getenv("JAVA_HOME") + "/bin/" + config.getProperty("java") + " " + dir + "/" + entity.getFileName();
    }

    public boolean checkFile() throws IOException, InterruptedException {
        try {
            String postfix = getPostfix(entity.getFileName());
            String cmd = "";

            if (postfix.equals(ETestingConstants.POSTFIX_CPP)) {
                cmd = cmdCpp;
            } else if (postfix.equals(ETestingConstants.POSTFIX_PASCAL_PAS) || postfix.equals(ETestingConstants.POSTFIX_PASCAL_P)) {
                cmd = cmdPascal;
            } else if (postfix.equals(ETestingConstants.POSTFIX_C)) {
                cmd = cmdC;
            } else if (postfix.equals(ETestingConstants.POSTFIX_JAVA)) {
                cmd = cmdJava;
            }
            return compile(cmd, postfix);
        } catch (IOException | InterruptedException ex) {
            testResults.append("Output file not found");
            deleteDir(dir);
            throw ex;
        }
    }


    private boolean compile(String cmd, String postfix) throws IOException, InterruptedException {
        FileUtils.writeStringToFile(new File(dir + "/" + entity.getFileName()), new String(entity.getFile()));

        Process process = Runtime.getRuntime().exec(cmd, null, new File(dir));

        int result = process.waitFor();

        if (result == 0) {
            return checkAllInputFiles(postfix);
        } else {
            if (postfix.equals(ETestingConstants.POSTFIX_CPP)) {
                getDigitalMarsMessages(process.getInputStream());
            } else if (postfix.equals(ETestingConstants.POSTFIX_PASCAL_PAS) || postfix.equals(ETestingConstants.POSTFIX_PASCAL_P)) {
                getFreePascalMessages(process.getInputStream());
            } else if (postfix.equals(ETestingConstants.POSTFIX_C)) {
                getTinyCCompilerMessages(process.getErrorStream());
            } else if (postfix.equals(ETestingConstants.POSTFIX_JAVA)) {
                getJavaMessages(process.getErrorStream());
            }
            testResults.append("Ошибка компиляции");
            deleteDir(dir);
            return false;
        }
    }

    private void getDigitalMarsMessages(InputStream in) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while (br.ready()) {
            line = br.readLine();
            if (line.contains("Error:")) {
                messages.add(line.substring(line.lastIndexOf("Error:")));
            }

        }
    }

    private void getFreePascalMessages(InputStream in) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while (br.ready()) {
            line = br.readLine();
            if (line.startsWith("Fatal:") || line.startsWith("Error:")) {
                messages.add(line);
            }
        }
    }

    private void getJavaMessages(InputStream in) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while (br.ready()) {
            line = br.readLine();
//            if (line.startsWith("Fatal:")) {
            messages.add(line);
//            }
        }
    }

    private void getTinyCCompilerMessages(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while (br.ready()) {
            line = br.readLine();
        }
        messages.add(line.substring(line.lastIndexOf(":") + 1));
    }

    private boolean checkAllInputFiles(String postfix) throws IOException, InterruptedException {
        boolean res = true;
        List<SingleTest> tests = task.getTests();

        for (SingleTest test: tests) {
            FileUtils.writeByteArrayToFile(new File(dir + "/in.txt"), test.getDataIn());
            FileUtils.writeByteArrayToFile(new File(dir + "/right.txt"), test.getDataOut());
            Process p = null;
            if (postfix.equals(ETestingConstants.POSTFIX_JAVA)) {
                p = Runtime.getRuntime().exec("java -cp " + dir + " " + getName(entity.getFileName()), null, new File(dir));
            } else {
                p = Runtime.getRuntime()
                        .exec(dir + "/" + getName(entity.getFileName()) + ".exe", null, new File(dir));
            }
            Checker checker = new TimeChecker();
            TimeLimiter limiter = new SimpleTimeLimiter();
            Checker proxy = limiter.newProxy(checker, Checker.class, 60000, TimeUnit.MILLISECONDS);
            try {
                proxy.runProcess(p);
            } catch (UncheckedTimeoutException e) {
                logger.error("Unable to run file " + e.getMessage());
                p.destroy();
                testResults.append(test.getTestNum()).append(":" + UserTaskStatus.FAILED.getName() + ";");
                res = false;
            }

            if (!compareFiles()) {
                res = false;
                testResults.append(test.getTestNum()).append(":" + UserTaskStatus.FAILED.getName() + ";");
            } else {
                testResults.append(test.getTestNum()).append(":" + UserTaskStatus.PASSED.getName() + ";");
            }
        }
        deleteDir(dir);

        return res;
    }

    private void deleteDir(String dir) {
        File folder = new File(dir);
        for (File file : folder.listFiles()) {
            file.delete();
        }

        folder.delete();
    }

    private String getName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    private String getPostfix(String fileName) {
        return fileName.substring(fileName.indexOf("."));
    }

    private boolean compareFiles() throws IOException {
        File outFile = new File(dir + "/out.txt");
        if (!outFile.exists()){
            return false;
        }
        List out = getList(outFile);
        List right = getList(new File(dir + "/right.txt"));

        if (out.size() != right.size()) {
            return false;
        }

        for (int i = 0; i < out.size(); ++i) {
            if (!out.get(i).equals(right.get(i))) {
                return false;
            }
        }

        return true;
    }

    private List getList(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        List<String> result = new ArrayList<>();

        while (br.ready()) {
            result.add(br.readLine().trim());
        }

        br.close();
        return result;
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getTestResults() {
        return testResults.toString();
    }
}
