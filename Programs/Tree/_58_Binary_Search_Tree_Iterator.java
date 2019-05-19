package Tree;

import java.util.Stack;

/*
 
Link:-https://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
 
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST. 
Calling next() will return the next smallest number in the BST. Note: next() and hasNext() should run in average O(1) time
and uses O(h) memory, where h is the height of the tree.


 */
public class _58_Binary_Search_Tree_Iterator {


	
	Stack<Node> stack;
	 
	public void BSTIterator(Node root) {
		stack = new Stack<Node>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();
	}
 
	public int next() {
		Node node = stack.pop();
		int result = node.key;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
