package by.bsu.project.antlr.model;

import by.bsu.project.general.lang.LangWrap.Operation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: iason
 * Date: 24.03.14
 */
public class TreeNode implements Serializable {
    private Integer id;
    private Integer parentId;
    private String name;
    private Operation operation;
    private TreeNode parent;
    private String parentName;
    private Integer i;

    private Integer tokenIndex = -10;

    public TreeNode(Integer id, String name, TreeNode node) {
        this.id = id;
        this.name = name;
        this.parent = node;
        this.parentId = (parent != null) ? parent.getId() : -1;
        if (parent != null) {
            parent.addChild(this);
            parentName = node.getName();
        }
    }
    public TreeNode(Integer id, String name, TreeNode node, Operation operation) {
        this(id, name, node);
        this.operation = operation;
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

    public Operation getOperation() {
        return operation;
    }

    public void setName(String name) {
        this.name = name;
        for (TreeNode node: children) {
            node.setParentName(name);
        }
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    private void addChild(TreeNode node) {
        children.add(node);
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public Integer getTokenIndex() {
        return tokenIndex;
    }

    public void setTokenIndex(Integer tokenIndex) {
        this.tokenIndex = tokenIndex;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;

        TreeNode treeNode = (TreeNode) o;

        if (name != null ? !name.equals(treeNode.name) : treeNode.name != null) return false;
        if (operation != treeNode.operation) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (operation != null ? operation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", operation=" + operation +
                ", i=" + i +
                '}';
    }
}
