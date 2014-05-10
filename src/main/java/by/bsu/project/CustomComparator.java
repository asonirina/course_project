package by.bsu.project;

import by.bsu.project.plagiat.model.TreeNode;

import java.util.Comparator;

/**
 * User: iason
 * Date: 10.05.14
 */
public class CustomComparator implements Comparator<TreeNode> {
    public int compare(TreeNode node1, TreeNode node2) {
        return node1.getId().compareTo(node2.getId());
    }

}
