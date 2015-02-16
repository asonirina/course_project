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
        res += 10 / (Math.abs(ac1.getAssigns() - ac2.getAssigns()) + 1);
        res += 10 / (Math.abs(ac1.getCalls() - ac2.getCalls()) + 1);
        res += 10 / (Math.abs(ac1.getCycles() - ac2.getCycles()) + 1);
        res += 10 / (Math.abs(ac1.getDivides() - ac2.getDivides()) + 1);
        res += 10 / (Math.abs(ac1.getFunctions() - ac2.getFunctions()) + 1);
        res += 10 / (Math.abs(ac1.getIfs() - ac2.getIfs()) + 1);
        res += 10 / (Math.abs(ac1.getMinuses() - ac2.getMinuses()) + 1);
        res += 10 / (Math.abs(ac1.getMultiples() - ac2.getMultiples()) + 1);
        res += 10 / (Math.abs(ac1.getPluses() - ac2.getPluses()) + 1);
        res += 10 / (Math.abs(ac1.getVariables() - ac2.getVariables()) + 1);

        return (int) res;
    }
}
