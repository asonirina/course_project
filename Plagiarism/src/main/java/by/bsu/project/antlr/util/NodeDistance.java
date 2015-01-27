package by.bsu.project.antlr.util;


import by.bsu.project.antlr.model.TreeNode;

public interface NodeDistance {
	public int rename(TreeNode n1, TreeNode n2);
	public int delete(TreeNode n1, TreeNode n2);
	public int insert(TreeNode n1, TreeNode n2);
}
