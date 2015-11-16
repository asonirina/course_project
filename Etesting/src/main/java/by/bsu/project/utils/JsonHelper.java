package by.bsu.project.utils;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
import org.apache.commons.lang.math.RandomUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * User: iason
 * Date: 07.04.15
 */
public class JsonHelper {
    public String createJson(List<UserInfoEntity> users) throws Exception{
        JSONObject obj = new JSONObject();
        obj.put("name", "Program Files");

        JSONArray students = new JSONArray();
        for (UserInfoEntity user: users) {
            JSONObject student = new JSONObject();
            student.put("name", user.getFirstName() + " " + user.getSecondName());

            JSONArray programFiles = new JSONArray();
            for(ProgramFilesEntity program: user.getProgramFiles()) {
                if (program.getRunStatus() == ETestingConstants.COMPLETE_FILE) {
                    JSONObject programFile = new JSONObject();
                    programFile.put("name", "Lab #" + program.getProgramName() + ", Plagiarism = " + program.getPlagiat2());
                    programFile.put("size", String.valueOf(50 + program.getPlagiat2()));
                    programFile.put("color", user.getId().equals(program.getCluster()) ? "white" : "orange");
                    programFiles.add(programFile);
                }
            }
            student.put("children", programFiles);
            if (!programFiles.isEmpty()) {
                students.add(student);
            }
        }
        obj.put("children", students);

        return new String(obj.toJSONString().getBytes(), "windows-1251");
    }
}
