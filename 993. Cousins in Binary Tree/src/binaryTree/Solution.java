package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
	public boolean isCousins(TreeNode root, int x, int y) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			boolean cousins = false;
			boolean sibling = false;
			int nodesAtLevel = queue.size();
			
			for(int i = 0; i < nodesAtLevel; i++) {
				TreeNode node = queue.remove();
				if(node == null) {
					sibling = false;
				} else {
					if(node.val == x || node.val == y) {
						if(!cousins) {
							cousins = sibling = true;
						} else {
							return !sibling;
						}
					}
					if(node.left != null) queue.add(node.left);
					if(node.right != null) queue.add(node.right);
					queue.add(null);
				}
			}
			if(cousins) return false;
		}
		return false;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(sol.isCousins(root,4,3));
	}
}
