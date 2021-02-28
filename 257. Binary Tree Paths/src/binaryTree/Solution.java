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
	public void findPaths(TreeNode root, String path, List<String> paths) {
		if(root != null) {
			path += root.val;
			
			if(root.left == null && root.right == null)
				paths.add(path);
			else 
				path += "->";
				findPaths(root.left, path, paths);
				findPaths(root.right, path, paths);
		}
	}
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		findPaths(root,"",paths);
		return paths;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		System.out.println(sol.binaryTreePaths(root));
	}
}
