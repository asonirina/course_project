package by.bsu.project.antlr.model;

import by.bsu.project.general.lang.LangWrap.Operation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public TreeNode(Integer id, String name, TreeNode node) {
        this.id = id;
        this.name = name;
        this.parent = node;
        this.parentId = (parent != null) ? parent.getId() : null;
        if (parent != null) {
            parent.addChild(this);
            parentName = node.getName();
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

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public static List<TreeNode> getTree(byte data[]) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(data));
        List<TreeNode> list = (List<TreeNode>) ois.readObject();
        ois.close();
        return list;
    }

    public static byte[] getBytes(List<TreeNode> list) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(list);
        oos.close();
        return baos.toByteArray();
    }

}
