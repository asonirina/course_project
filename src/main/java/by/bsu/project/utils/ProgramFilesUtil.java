package by.bsu.project.utils;

import by.bsu.project.constants.ETestingConstants;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ProgramFilesUtil {
    private MultipartFile file;
    private String cmdC;
    private String cmdCpp;
    private String cmdPascal;

    public ProgramFilesUtil(MultipartFile file) {
        this.file = file;
        cmdC = "cmd /C C:/tcc/tcc.exe C:/tomcat/bin/" + file.getOriginalFilename();
        cmdCpp = "C:/dm/bin/dmc.exe C:/tomcat/bin/" + file.getOriginalFilename() + " -I/dm/stlport/stlport";
        cmdPascal = "C:/FPC1/2.2.0/bin/i386-win32/fpc.exe C:/tomcat/bin/" + file.getOriginalFilename();
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

        return compile(cmd);
    }

    private boolean compile(String cmd) throws Exception {
        file.transferTo(new File("C:/tomcat/bin/" + file.getOriginalFilename()));

        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();

        Process p1 = Runtime.getRuntime().exec("C:/tomcat/bin/" + getName(file.getOriginalFilename()) + ".exe");
        p1.waitFor();

        return compareFiles();
    }

    private String getName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    private String getPostfix(String fileName) {
        return fileName.substring(fileName.indexOf("."));
    }

    private boolean compareFiles() throws Exception {
        List out1 = getList(new File("C:/tomcat/bin/out.txt"));
        List right1 = getList(new File("C:/tomcat/bin/hello.txt"));

        if (out1.size() != right1.size()) {
            return false;
        }

        for (int i = 0; i < out1.size(); ++i) {
            if (!out1.get(i).equals(right1.get(i))) {
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
            result.add(line);
            line = br.readLine();
        }

        br.close();
        return result;
    }

}
