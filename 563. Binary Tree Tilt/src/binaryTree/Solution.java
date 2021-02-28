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
	int result = 0;
	public int calculateResult(TreeNode root) {
		if(root == null)
			return 0;
		int leftChild = calculateResult(root.left);
		int rightChild = calculateResult(root.right);
		result += Math.abs(leftChild-rightChild);
		return leftChild+rightChild+root.val;
	}
	public int findTilt(TreeNode root) {
		calculateResult(root);
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(7);
		System.out.println(sol.findTilt(root));
	}
}
