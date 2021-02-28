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
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		int leftChild = Integer.MAX_VALUE;
		int rightChild = Integer.MAX_VALUE;
		if(root.left != null)
			leftChild = minDepth(root.left);
		if(root.right != null)
			rightChild = minDepth(root.right);
		return Math.min(leftChild, rightChild) + 1;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(sol.minDepth(root));
	}
}
