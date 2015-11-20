package by.bsu.project.checker;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by iason
 * on 11/20/2015.
 */
public class JavaProgramsChecker extends ProgramsChecker {

    public JavaProgramsChecker(ProgramFilesEntity entity, Task task) {
        super(entity, task);
    }
    @Override
    protected void getMessages(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while (br.ready()) {
            String line = br.readLine();
            messages.add(line);
        }
    }

    @Override
    protected String getCmd() throws Exception {
        PropertiesConfiguration config = new PropertiesConfiguration("compilers.properties");
        return System.getenv("JAVA_HOME") + "/bin/" + config.getProperty("java") + " " + dir + "/" + entity.getFileName();
    }

    @Override
    protected InputStream getStream(Process p) {
        return p.getErrorStream();
    }


    protected String getPathToExe () {
        return "java -cp " + dir + " " + getName(entity.getFileName());
    }


}
