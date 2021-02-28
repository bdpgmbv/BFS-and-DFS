package binaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){

	}
	TreeNode(int val){
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	public void dfs(TreeNode root, List<Integer> tree) {
		if(root != null) {
			if(root.left == null && root.right == null)
				tree.add(root.val);
			dfs(root.left, tree);
			dfs(root.right, tree);
		}
	}
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> tree1 = new ArrayList<>();
		List<Integer> tree2 = new ArrayList<>();
		dfs(root1,tree1);
		return tree1.equals(tree2);
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(8);
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(5);
		root1.left.left = new TreeNode(6);
		root1.left.right = new TreeNode(7);
		root1.right = new TreeNode(1);
		root1.right.left = new TreeNode(4);
		root1.right.right = new TreeNode(2);
		root1.right.right.left = new TreeNode(9);
		root1.right.right.right = new TreeNode(8);
		System.out.println(sol.leafSimilar(root, root1));
	}
}
