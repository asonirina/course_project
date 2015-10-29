package by.bsu.project.antlr.util;

import by.bsu.project.antlr.model.SerializableUtil;
import by.bsu.project.antlr.rted.RTED;
import by.bsu.project.general.model.ProgramFilesEntity;
import by.bsu.project.antlr.tree.TreeParser;
import by.bsu.project.antlr.model.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: iason
 * Date: 10.05.14
 */
public class TreeCompareUtil {
    public static Map<String, Object> checkTrees(List<ProgramFilesEntity> programs, List<TreeNode> tree) throws Exception{
        Map<String, Object> map = new HashMap<>();
        List<int[]> compare = null;

        int max = 0;
        for (ProgramFilesEntity entity : programs) {
            TreeParser builder = new TreeParser(entity.getLang());
            List<TreeNode> nodes = SerializableUtil.getTree(entity.getTreeContent());

            TreeEditDistance.numerateTree(nodes.get(0));
            TreeEditDistance.numerateTree(tree.get(0));
            Collections.sort(nodes, new OrderComparator());
            Collections.sort(tree, new OrderComparator());

            RTED c = new RTED();
            int sim = (int) (100 * Math.exp(- Math.pow(c.nonNormalizedTreeDist(tree, nodes), 2) / (nodes.size() * tree.size())));
            if (max < sim) {
                compare = c.computeEditMapping();
                max = sim;
            }
        }

        map.put("max", max);
        map.put("compare", compare);
        return map;
    }
}
