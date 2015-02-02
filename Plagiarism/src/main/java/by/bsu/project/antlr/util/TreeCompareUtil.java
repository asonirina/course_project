package by.bsu.project.antlr.util;

import by.bsu.project.antlr.lang.LangWrap.Lang;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.general.huffman.Huffman;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: iason
 * Date: 10.05.14
 */
public class TreeCompareUtil {
    public static int checkTrees(List<ProgramFilesEntity> programs, List<TreeNode> tree) {
        String source[] = getTokenizedString(tree);
        int max = 0;
        for (ProgramFilesEntity entity : programs) {
            TreeParser builder = new TreeParser(String.valueOf(entity.getId()), Lang.JAVA);
            List<TreeNode> nodes = builder.getTree(Huffman.expand(entity.getFile()));
            String arr[] = getTokenizedString(nodes);
            int sim = (int) (100 * Math.exp(- Math.pow(LevensteinDistanceHelper.distance(source, arr), 2) / (source.length * arr.length)));
            if (max < sim) {
                max = sim;
            }
        }

        return max;
    }

    private static String[] getTokenizedString(List<TreeNode> list) {
        List<String> res = new ArrayList<>();
        Collections.sort(list, new CustomComparator());
        for (TreeNode node : list) {
            if (node.getOperation() != null) {
                res.add(node.getOperation().name());
            }
        }

        return res.toArray(new String[res.size()]);
    }

    // todo: make flexible measure, depending on type om compared values, example while - for = 0.5 ect



}
