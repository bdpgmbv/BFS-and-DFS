package binaryTree;


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
	public int height(TreeNode root) {
		if(root == null)
			return -1;
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left, right) + 1;
	}
	public boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		return Math.abs(height(root.left) - height(root.right)) < 2 &&
				isBalanced(root.right)  &&
				isBalanced(root.left);
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(sol.isBalanced(root));
	}
}
