package by.bsu.project.antlr.model;

import java.util.Hashtable;
import java.util.Map;

public class TreeNodeDistanceMap extends TreeNodeDistance {
    private int count;
    private Map<TreeNode, Integer> nodeInt;
    private Map<Integer, TreeNode> intNode;

     public  TreeNodeDistanceMap() {
        count = 0;
        nodeInt = new Hashtable<>();
        intNode = new Hashtable<>();
    }

    public int store(TreeNode node) {
        if (nodeInt.containsKey(node)) {
            return nodeInt.get(node);
        } else {
            Integer intKey = count++;
            nodeInt.put(node, intKey);
            intNode.put(intKey, node);
            return intKey;
        }
    }

    public TreeNode read(Integer labelID) {
        return intNode.get(labelID);
    }

    public double rename(int i1, int i2) {
        return rename(read(i1), read(i2));
    }
}

