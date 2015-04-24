package by.bsu.project.antlr.util;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.model.AttributeCounting;

import java.util.List;

/**
 * User: iason
 * Date: 16.03.14
 */
public class AttributeCountingUtil {

    public static int checkAC(List<ProgramFilesEntity> list, AttributeCounting ac) {
        if (list.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (ProgramFilesEntity a : list) {
            int diff = getDiff(a.getAc(), ac);
            if (max < diff) {
                max = diff;
            }
        }
        return max;
    }

    public static int getDiff(AttributeCounting ac1, AttributeCounting ac2) {
        if(ac1 == null || ac2==null){
            return 0;
        }
        double res = 0;
        res += 10 / (Math.abs(ac1.getSpaces() - ac2.getSpaces()) + 1);
        res += 10 / (Math.abs(ac1.getMethods() - ac2.getMethods()) + 1);
        res += 10 / (Math.abs(ac1.getTabs() - ac2.getTabs()) + 1);
        res += 10 / (Math.abs(ac1.getMethods() - ac2.getMethods()) + 1);

        return (int) res;
    }
}
