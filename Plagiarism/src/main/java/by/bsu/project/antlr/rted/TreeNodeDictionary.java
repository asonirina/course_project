package by.bsu.project.antlr.rted;

import by.bsu.project.antlr.model.CustomNodeDistance;
import by.bsu.project.antlr.model.NodeDistance;
import by.bsu.project.antlr.model.TreeNode;

import java.util.Hashtable;
import java.util.Map;

public class TreeNodeDictionary {
    private int count;
    private Map<TreeNode, Integer> nodeInt;
    private Map<Integer, TreeNode> intNode;
    private NodeDistance nd = new CustomNodeDistance();

     public  TreeNodeDictionary() {
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

    public double insert() {
         return 1.0;
    }
    public double delete() {
        return 1.0;
    }
    public double rename(int i1, int i2) {
        return nd.rename(read(i1), read(i2));
    }
}

