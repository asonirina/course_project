package by.bsu.project.plagiat.model;

import java.util.List;

/**
 * User: iason
 * Date: 24.03.14
 */
public class TreeNode {
    private String name;
    private String operation;
    private TreeNode parent;

    public TreeNode(String name, String operation) {
        this.name = name;
        this.operation = operation;
    }
    private List<TreeNode> children;

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getOperation() {
        return operation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
