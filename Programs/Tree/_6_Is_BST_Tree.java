package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class _6_Is_BST_Tree {

	
	
	

	//Method 1 :- store value in array and check array should be sorted
	
	
	
	// Method 2
	Integer last_printed=null;
	
	boolean checkBST(Node n) 
	{
		if (n == null) return true;
		
		 // Check I recurse left
		 if (!checkBST(n.left)) 
			 return false;
		
		 // Check current
		 if (last_printed != null && n.key <= last_printed) {
		 return false;
		 }
		 last_printed = n.key;
		
		 // Check I recurse right
		 if (!checkBST(n.right))
			 return false;
		 
		 return true;// All good!
	}
	
	
	public boolean isBST(Node root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.key <= min || root.key > max){
            return false;
        }
        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }


    public boolean isBSTIterative(Node root) {
        if (root == null) {
            return true;
        }

        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        int prev = Integer.MIN_VALUE;
        int current;
        while ( true ) {
            if (node != null) {
                stack.addFirst(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                node = stack.pollFirst();
                current = node.key;
                if (current < prev) {
                    return false;
                }
                prev = current;
                node = node.right;
            }
        }
        return true;
    }
}
