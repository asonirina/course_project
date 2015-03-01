package by.bsu.project.utils;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.UserInfoEntity;
import com.google.common.io.Files;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProgramFilesUtil {
    private MultipartFile file;
    private String programName;
    String form;
    private String cmdC;
    private String cmdCpp;
    private String cmdPascal;
    private String cmdJava;
//    private String path = System.getenv("CATALINA_HOME") + "/bin/";
private String path =System.getProperty("java.io.tmpdir") + "\\";
    private List<String> messages = new ArrayList<>();
    private StringBuffer testResults = new StringBuffer();

    private String dir;

    private static final Logger logger = Logger.getLogger(ProgramFilesUtil.class);

    public ProgramFilesUtil(MultipartFile file, UserInfoEntity user, String programName) throws Exception {
        this.file = file;
        this.programName = programName;
        this.form = user.getForm();
        File tmp = Files.createTempDir();
        tmp.deleteOnExit();
        dir = tmp.getAbsolutePath();
        PropertiesConfiguration config = new PropertiesConfiguration("compilers.properties");
        cmdC = path+config.getProperty("c") + " "  + dir + "/" + file.getOriginalFilename();
        cmdCpp =path+config.getProperty("cpp") + " "  + dir + "/" + file.getOriginalFilename() + " -I"+path+"compilers/dm/dm/stlport/stlport";
       // cmdPascal = path + config.getProperty("pas") + " " + dir + "/" + file.getOriginalFilename();
        String pp = path + config.getProperty("pas");
        cmdPascal = String.format("%s\\bin.w32\\vpc -b %s -O%s\\units.w32 -L%s\\lib.w32 -E%s -R%s\\res.w32",
                pp,  dir + "\\" + file.getOriginalFilename(), pp, pp, dir, pp);
        cmdJava = System.getenv("JAVA_HOME")+"/bin/"+config.getProperty("java") + " " +dir+ "/"+ file.getOriginalFilename();
    }

    public boolean checkFile() throws Exception {
        try {
        String postfix = getPostfix(file.getOriginalFilename());
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
        } catch (Exception ex) {
            testResults.append("Output file not found");
            deleteDir(dir);
            throw ex;
        }
    }


    private boolean compile(String cmd, String postfix) throws Exception {
        file.transferTo(new File(dir + "/" + file.getOriginalFilename()));

        Process  process = Runtime.getRuntime().exec(cmd, null, new File(dir));

        int result  = process.waitFor();

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

    private boolean checkAllInputFiles(String postfix) throws Exception {
        boolean res = true;
        File inDir = new File(path + "/tasks/" + form+ "/" + programName + "/in");

        for (int i = 0; i < inDir.list().length; ++i) {
            FileUtils.copyFile(new File(path + "/tasks/"  + form+ "/"+ programName + "/in/in" + String.valueOf(i + 1) + ".txt"), new File(dir + "/in.txt"));
            FileUtils.copyFile(new File(path + "/tasks/"  + form+ "/"+ programName + "/out/out" + String.valueOf(i + 1) + ".txt"), new File(dir + "/right.txt"));

            Process p = null;
            if (postfix.equals(ETestingConstants.POSTFIX_JAVA)) {
                p = Runtime.getRuntime().exec("java -cp "  + dir + " " + getName(file.getOriginalFilename()), null, new File(dir));
            } else {
                p = Runtime.getRuntime()
                        .exec( dir + "/" + getName(file.getOriginalFilename()) + ".exe", null, new File(dir));
            }
            Checker checker = new TimeChecker();
            TimeLimiter limiter = new SimpleTimeLimiter();
            Checker proxy = limiter.newProxy(checker, Checker.class, 60000, TimeUnit.MILLISECONDS);
            try {
                proxy.runProcess(p);
            } catch (UncheckedTimeoutException e) {
                logger.error("Unable to run file " + e.getMessage());
                p.destroy();
                testResults.append(i + 1).append(":" + ETestingConstants.FAILED_STATUS + ";");
                res = false;
            }

            if (!compareFiles()) {
                res = false;
                testResults.append(i + 1).append(":" + ETestingConstants.FAILED_STATUS + ";");
            } else {
                testResults.append(i + 1).append(":" + ETestingConstants.PASSED_STATUS + ";");
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

    private boolean compareFiles() throws Exception {
        List out = getList(new File( dir + "/out.txt"));
        List right = getList(new File( dir + "/right.txt"));

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

    private List getList(File file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        List<String> result = new ArrayList<>();
        String line = br.readLine();

        while (line != null) {
            result.add(line.trim());
            line = br.readLine();
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
