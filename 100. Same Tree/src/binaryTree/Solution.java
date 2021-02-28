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
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null)
			return true;
		if(p == null || q == null)
			return false;
		return p.val == q.val && 
				isSameTree(p.right, q.right) &&
				isSameTree(p.left, q.left);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		System.out.println(sol.isSameTree(root, root1));
	}
}
