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
public class PascalProgramsChecker extends ProgramsChecker {

    public PascalProgramsChecker(ProgramFilesEntity entity, Task task) {
        super(entity, task);
    }
    @Override
    protected void getMessages(InputStream in) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while (br.ready()) {
            String line = br.readLine();
            if (line.startsWith("Fatal:") || line.startsWith("Error:")) {
                messages.add(line);
            }
        }
    }

    @Override
    protected String getCmd() throws Exception {
        String tmpDir = System.getProperty("java.io.tmpdir") + "\\";
        PropertiesConfiguration config = new PropertiesConfiguration("compilers.properties");
        String pp = tmpDir + config.getProperty("pas");
        return String.format("%s\\bin.w32\\vpc -b %s -O%s\\units.w32 -L%s\\lib.w32 -E%s -R%s\\res.w32",
                pp, dir + "\\" + entity.getFileName(), pp, pp, dir, pp);
    }

    @Override
    protected InputStream getStream(Process p) {
        return p.getInputStream();
    }

}
