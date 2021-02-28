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
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		} else {
			int leftHeight = maxDepth(root.left);
			int rightHeight = maxDepth(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(sol.maxDepth(root));
	}
}
