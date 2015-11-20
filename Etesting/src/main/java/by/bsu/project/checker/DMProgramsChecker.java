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
public class DMProgramsChecker extends ProgramsChecker {

    public DMProgramsChecker(ProgramFilesEntity entity, Task task) {
        super(entity, task);
    }
    @Override
    protected void getMessages(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while (br.ready()) {
            String line = br.readLine();
            if (line.contains("Error:")) {
                messages.add(line.substring(line.lastIndexOf("Error:")));
            }
        }
    }

    @Override
    protected String getCmd() throws Exception {
        String tmpDir = System.getProperty("java.io.tmpdir") + "\\";
        PropertiesConfiguration config = new PropertiesConfiguration("compilers.properties");
        return tmpDir + config.getProperty("cpp") + " " + dir + "/" + entity.getFileName() + " -I" + tmpDir + "compilers/dm/dm/stlport/stlport";
    }

    @Override
    protected InputStream getStream(Process p) {
        return p.getInputStream();
    }
}
