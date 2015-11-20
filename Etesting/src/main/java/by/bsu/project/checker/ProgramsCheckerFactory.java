package by.bsu.project.checker;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.Task;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iason
 * on 11/20/2015.
 */
public class ProgramsCheckerFactory {
    public static ProgramsChecker createChecker(ProgramFilesEntity entity, Task task) throws Exception{
        String postfix = getPostfix(entity.getFileName());
        switch (postfix) {
            case ETestingConstants.POSTFIX_CPP: {
                return new DMProgramsChecker(entity, task);
            }
            case ETestingConstants.POSTFIX_PASCAL_PAS:
            case ETestingConstants.POSTFIX_PASCAL_P:
                return new PascalProgramsChecker(entity, task);

            case ETestingConstants.POSTFIX_C:
                return new TinyCProgramsChecker(entity, task);

            case ETestingConstants.POSTFIX_JAVA:
                return new JavaProgramsChecker(entity, task);

            default:
                throw new Exception("Unknown extension!");
        }
    }

    private static String getPostfix(String fileName) {
        return fileName.substring(fileName.indexOf("."));
    }
}
