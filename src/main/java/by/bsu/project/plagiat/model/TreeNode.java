package by.bsu.project.plagiat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * User: iason
 * Date: 24.03.14
 */
public class TreeNode {
    private Long id;
    private Long parentId;
    private String name;
    private String operation;
    private TreeNode parent;

    public TreeNode(Long id, String name, TreeNode node) {
        this.id = id;
        this.name = name;
        this.parent = node;
        this.parentId = (parent != null) ? parent.getId() : null;
        if (parent != null) {
            parent.addChild(this);
        }
    }

    private List<TreeNode> children = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    private void addChild(TreeNode node) {
        children.add(node);
    }
}
