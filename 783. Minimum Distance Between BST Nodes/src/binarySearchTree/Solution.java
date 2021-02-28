package binarySearchTree;

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
	Integer prev = null;
	Integer ans = Integer.MAX_VALUE;
	public int minDiffInBST(TreeNode root) {
		if(root != null) {
			minDiffInBST(root.left);
			if(prev != null)
				ans = Math.min(ans, root.val-prev);
			prev = root.val;
			minDiffInBST(root.right);
		}
		return ans;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(sol.minDiffInBST(root));
	}
}
