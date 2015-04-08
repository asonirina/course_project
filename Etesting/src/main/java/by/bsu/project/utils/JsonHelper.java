package by.bsu.project.utils;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.UserInfoEntity;
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
                JSONObject programFile = new JSONObject();
                programFile.put("name", program.getProgramName());
                programFile.put("size", "2000");
                programFile.put("color", user.getNeuralNode().getId().equals(program.getCluster())?"white" : "orange");
                programFiles.add(programFile);
            }
            student.put("children", programFiles);

            students.add(student);
        }
        obj.put("children", students);

        return obj.toJSONString();
    }
}
