package by.bsu.project.antlr.util;

import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.javacc.util.JavaCCNodesExtractor;

import java.util.List;

/**
 * User: iason
 * Date: 16.03.14
 */
public class JavaCCNodesUtil {
    public static int checkNodes(List<ProgramFilesEntity> list, ProgramFilesEntity current) {
        if (list.isEmpty()) {
            return 0;
        }
        try {
            List<String> nodes1 = JavaCCNodesExtractor.getNodes(current.getFile(), current.getLang());
            int max = 0;
            for (ProgramFilesEntity a : list) {
                List<String> nodes2 = JavaCCNodesExtractor.getNodes(a.getFile(), a.getLang());
                int diff = LinesAlignment.diff(nodes1, nodes2);
                if (max < diff) {
                    max = diff;
                }
            }
            return max;
        } catch (Exception ex) {
            return 0;
        }
    }
}
