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
	public boolean checkSymmetry(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return root1.val == root2.val && 
				checkSymmetry(root1.left, root2.right) &&
				checkSymmetry(root1.right, root2.left);
				
	}
	public boolean isSymmetric(TreeNode root) {
		return checkSymmetry(root,root);
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(sol.isSymmetric(root));
	}
}
