package by.bsu.project.utils;

import by.bsu.project.constants.ETestingConstants;
import by.bsu.project.entity.UserInfoEntity;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;


public class ProgramFilesUtil {
    private MultipartFile file;
    private String programName;
    private String cmdC;
    private String cmdCpp;
    private String cmdPascal;
    private String path = "C:/tomcat/bin/";
    private List<String> messages = new ArrayList<>();
    private List<String> testResults = new ArrayList<>();

    private String dir;

    public ProgramFilesUtil(MultipartFile file, UserInfoEntity user, String programName) throws Exception {
        this.file = file;
        this.programName = user.getForm() + '.' + programName;
        dir = user.getLogin() + programName;

        new File(dir).mkdir();
        cmdC = "C:/tcc/tcc.exe " + path + dir + "/" + file.getOriginalFilename();
        cmdCpp = "C:/dm/bin/dmc.exe " + path + dir + "/" + file.getOriginalFilename() + " -I/dm/stlport/stlport";
        cmdPascal = "C:/FPC1/2.2.0/bin/i386-win32/fpc.exe " + path + dir + "/" + file.getOriginalFilename();

    }

    public boolean checkFile() throws Exception {
        String postfix = getPostfix(file.getOriginalFilename());
        String cmd = "";

        if (postfix.equals(ETestingConstants.POSTFIX_CPP)) {
            cmd = cmdCpp;
        } else if (postfix.equals(ETestingConstants.POSTFIX_PASCAL_PAS) || postfix.equals(ETestingConstants.POSTFIX_PASCAL_P)) {
            cmd = cmdPascal;
        } else if (postfix.equals(ETestingConstants.POSTFIX_C)) {
            cmd = cmdC;
        }

        return compile(cmd, postfix);
    }


    private boolean compile(String cmd, String postfix) throws Exception {
        file.transferTo(new File(path + dir + "/" + file.getOriginalFilename()));

        Process process = Runtime.getRuntime().exec(cmd, null, new File(dir));

        int result = process.waitFor();

        if (result == 0) {
            return checkAllInputFiles();
        } else {

            if (postfix.equals(ETestingConstants.POSTFIX_CPP)) {
                getDigitalMarsMessages(process.getInputStream());
            }
            if (postfix.equals(ETestingConstants.POSTFIX_PASCAL_PAS) || postfix.equals(ETestingConstants.POSTFIX_PASCAL_P)) {
                getFreePascalMessages(process.getInputStream());
            }
            if (postfix.equals(ETestingConstants.POSTFIX_C)) {
                getTinyCCompilerMessages(process.getErrorStream());
            }
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
            if (line.startsWith("Fatal:")) {
                messages.add(line);
            }
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

    private boolean checkAllInputFiles() throws Exception {
        boolean res = true;
        File inDir = new File("tasks/" + programName + "/in");

        for (int i = 0; i < inDir.list().length; ++i) {
            FileUtils.copyFile(new File("tasks/" + programName + "/in/in" + String.valueOf(i + 1) + ".txt"), new File(dir + "/in.txt"));
            FileUtils.copyFile(new File("tasks/" + programName + "/out/out" + String.valueOf(i + 1) + ".txt"), new File(dir + "/right.txt"));

            Process p = Runtime.getRuntime()
                    .exec(path + dir + "/" + getName(file.getOriginalFilename()) + ".exe", null, new File(dir));
            Checker checker = new TimeChecker();
            TimeLimiter limiter = new SimpleTimeLimiter();
            Checker proxy = limiter.newProxy(checker, Checker.class, 120000, TimeUnit.MILLISECONDS);
            try {
                proxy.compileFile(p);
            } catch (UncheckedTimeoutException e) {
                e.printStackTrace();
                p.destroy();
                testResults.add("not passed");
                res = false;
            }


            if (!compareFiles()) {
                res = false;
                testResults.add("not passed");
            } else {
                testResults.add("passed");
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
        List out = getList(new File(path + dir + "/out.txt"));
        List right = getList(new File(path + dir + "/right.txt"));

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

    public List<String> getTestResults() {
        return testResults;
    }
}
