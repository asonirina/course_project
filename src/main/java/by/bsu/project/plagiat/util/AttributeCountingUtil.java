package by.bsu.project.plagiat.util;

import by.bsu.project.entity.ProgramFilesEntity;
import by.bsu.project.plagiat.model.AttributeCounting;

/**
 * User: iason
 * Date: 16.03.14
 */
public class AttributeCountingUtil {

    public static AttributeCounting getACByProgramFile(ProgramFilesEntity filesEntity) {
        AttributeCounting ac = new AttributeCounting(filesEntity.getProgramName());
        String content = String.valueOf(filesEntity.getFile());

        return ac;
    }
}
