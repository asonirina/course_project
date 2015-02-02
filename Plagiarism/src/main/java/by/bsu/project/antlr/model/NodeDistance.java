package by.bsu.project.antlr.model;


import by.bsu.project.antlr.model.TreeNode;

public interface NodeDistance {
	public double rename(TreeNode n1, TreeNode n2);
	public double delete(TreeNode n1, TreeNode n2);
	public double insert(TreeNode n1, TreeNode n2);
}
