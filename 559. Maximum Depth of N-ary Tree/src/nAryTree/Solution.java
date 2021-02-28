package nAryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

public class Solution {
	public int maxDepth(Node root) {
		if(root == null) {
			return 0;
		} else if(root.children.isEmpty()){
			return 1;
		} else {
			List<Integer> heights = new LinkedList<>();
			for(Node child: root.children) {
				heights.add(maxDepth(child));
			}
			return Collections.max(heights) + 1;
		}
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		Node root = new Node(1,new ArrayList<Node>());
		root.children.add(new Node(3,new ArrayList<Node>()));
		root.children.add(new Node(2,new ArrayList<Node>()));
		root.children.add(new Node(4,new ArrayList<Node>()));
		root.children.get(0).children.add(new Node(5,new ArrayList<Node>()));
		root.children.get(0).children.add(new Node(6,new ArrayList<Node>()));
		System.out.println(sol.maxDepth(root));
	}
}
