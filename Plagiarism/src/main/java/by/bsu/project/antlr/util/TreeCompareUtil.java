package by.bsu.project.antlr.util;

import by.bsu.project.antlr.rted.RTED;
import by.bsu.project.general.lang.LangWrap.Lang;
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
//        String source[] = getTokenizeString(tree);
        int max = 0;
        for (ProgramFilesEntity entity : programs) {
            TreeParser builder = new TreeParser(String.valueOf(entity.getId()), entity.getLang());
            List<TreeNode> nodes = builder.getTree(Huffman.expand(entity.getFile()));
//            String arr[] = getTokenizeString(nodes);

            TreeEditDistance.numerateTree(nodes.get(0));
            TreeEditDistance.numerateTree(tree.get(0));
            Collections.sort(nodes, new OrderComparator());
            Collections.sort(tree, new OrderComparator());

            RTED c = new RTED();
            int sim = (int) (100 * Math.exp(- Math.pow(c.nonNormalizedTreeDist(nodes, tree), 2) / (nodes.size() * tree.size())));
            //(int) (100 * Math.exp(- Math.pow(LevensteinDistanceHelper.distance(source, arr), 2) / (source.length * arr.length)));
            if (max < sim) {
                max = sim;
            }
        }

        return max;
    }

    private static String[] getTokenizeString(List<TreeNode> list) {
        List<String> res = new ArrayList<>();
        Collections.sort(list, new CustomComparator());
        for (TreeNode node : list) {
            if (node.getOperation() != null) {
                res.add(node.getOperation().name());
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
