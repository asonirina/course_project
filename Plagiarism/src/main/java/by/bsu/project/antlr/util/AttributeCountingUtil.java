package by.bsu.project.antlr.util;

import by.bsu.project.general.model.AttributeCounting;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.javacc.general.ParseException;
import by.bsu.project.javacc.general.UnsupportedLanguageException;

import java.util.List;

/**
 * User: iason
 * Date: 16.03.14
 */
public class AttributeCountingUtil {
    public static int checkAttributes(List<ProgramFilesEntity> list, AttributeCounting ac) throws ParseException, UnsupportedLanguageException {

        if (list.isEmpty()) {
            return 0;
        }
        int max = 0;

        for (ProgramFilesEntity e : list) {
            int diff = AttributeCounting.getDiff(e.getAc(), ac);
            if (max < diff) {
                max = diff;
            }
        }
        return max;
    }
}
