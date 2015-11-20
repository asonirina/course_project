package by.bsu.project.checker;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.SingleTest;
import by.bsu.project.general.model.Task;
import com.google.common.io.Files;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by iason
 * on 11/20/2015.
 */
public abstract class ProgramsChecker {
    protected ProgramFilesEntity entity;
    protected Task task;

    protected List<String> messages = new ArrayList<>();
    protected StringBuffer testResults = new StringBuffer();
    protected String dir;

    protected abstract void getMessages(InputStream in) throws IOException;
    protected abstract String getCmd() throws Exception;
    protected abstract InputStream getStream(Process p);



    protected ProgramsChecker(ProgramFilesEntity entity, Task task) {
        this.entity = entity;
        this.task = task;
        createDir();
    }

    private void createDir() {
        File tmp = Files.createTempDir();
        tmp.deleteOnExit();
        dir = tmp.getAbsolutePath();
    }

    public boolean check() throws Exception {
        FileUtils.writeStringToFile(new File(dir + "/" + entity.getFileName()), new String(entity.getFile()));

        Process process = Runtime.getRuntime().exec(getCmd(), null, new File(dir));
        int result = process.waitFor();

        if (result == 0) {
            return checkAllInputFiles();
        } else {
            getMessages(getStream(process));
            testResults.append("Ошибка компиляции");
            deleteDir(dir);
            return false;
        }
    }

    protected String getPathToExe () {
        return dir + "/" + getName(entity.getFileName()) + ".exe";
    }


    private boolean checkAllInputFiles() throws IOException, InterruptedException {
        boolean res = true;
        List<SingleTest> tests = task.getTests();

        for (SingleTest test: tests) {
            FileUtils.writeByteArrayToFile(new File(dir + "/in.txt"), test.getDataIn());
            FileUtils.writeByteArrayToFile(new File(dir + "/right.txt"), test.getDataOut());
            Process p = Runtime.getRuntime().exec(getPathToExe(), null, new File(dir));

            Checker checker = new TimeChecker();
            TimeLimiter limiter = new SimpleTimeLimiter();
            Checker proxy = limiter.newProxy(checker, Checker.class, 60000, TimeUnit.MILLISECONDS);
            try {
                proxy.runProcess(p);
            } catch (UncheckedTimeoutException e) {

                p.destroy();
                testResults.append(test.getTestNum()).append(":" + ETestingConstants.UserTaskStatus.FAILED.getName() + ";");
                res = false;
            }

            if (!compareFiles()) {
                res = false;
                testResults.append(test.getTestNum()).append(":" + ETestingConstants.UserTaskStatus.FAILED.getName() + ";");
            } else {
                testResults.append(test.getTestNum()).append(":" + ETestingConstants.UserTaskStatus.PASSED.getName() + ";");
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

    protected String getName(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf('.'));
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

    public String getTestResults() {
        return testResults.toString();
    }
}
