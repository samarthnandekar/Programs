package Tree;

/*
Find k-th smallest element in BST (Order Statistics in BST)
Given root of binary search tree and K as input, find K-th smallest element in BST.
For example, in the following BST, if k = 3, then output should be 10, and if k = 5, then output should be 14.

                  20
                /    \
               8      22
              / \ 
             4   12
                /  \
               10  14
 */

import java.util.Stack;
public class _61_Kth_Smallest_Element_In_BST {

	public static void main(String[] args) {
          Node root= new Node(20);
          root.left=new Node(8);
          root.right=new Node(22);
          root.left.left= new Node(4);
          root.left.right=new Node(12);
          root.left.right.left= new Node(10);
          root.left.right.right= new Node(14);
          
          _61_Kth_Smallest_Element_In_BST obj= new _61_Kth_Smallest_Element_In_BST();
           obj.printInorder(root);
           System.out.println();
          System.out.println(obj.inorder(root));
          
          System.out.println();
          System.out.println(obj.kthSmallest(root, 3));
          System.out.println();
          System.out.println(obj.kthSmallest_2nd(root, 3));
          
	}
	
	void printInorder(Node root)
	{
		if (root!=null)
		{
			printInorder(root.left);
			System.out.print("    "+root.key);
			printInorder(root.right);
		}
	}
	/*
	Solution: Inorder traversal
	Time complexity: O(n)
	Space compleixty: O(n) */
	static int k=3;
	 int inorder(Node root) {
		    
		 if (root==null) 
			 return -1;
		    
		   int x = inorder(root.left);
		   if (k == 0) 
		    	return x;
		   
		   if (--k == 0)
			   return root.key;
		   
		   return inorder(root.right);
		  }
	
	 public int kthSmallest(Node root, int k) {
	        Stack<Node> stack = new Stack<>();
	        Node n = root;
	        while(n.left!=null) {
	            stack.push(n);
	            n = n.left; 
	        }
	        
	        while(k>0 && (n!=null || !stack.isEmpty())) {
	            if(n==null) {
	                n = stack.pop();
	                if(--k==0) return n.key;
	                n = n.right;
	            } else {
	                stack.push(n);
	                n = n.left;
	            }
	        }
	        return n.key;
	 }
	 
	 public  int  kthSmallest_2nd(Node root ,int  k ) {
	        if (root ==  null  || k <=  0 ) {
	            return  - 1 ;
	        }

	        Stack <Node> stack =  new  Stack <> ();
	        stack.add(root);
	        Node node = root;
	        while(!stack.isEmpty()) {
	            // Left first
	            while(node != null  && node.left !=null ) {
	                stack.add(node.left);
	                node = node.left;
	            }
	            // Process left / curr
	            node = stack.pop();
	            k-- ;
	            if (k ==  0 ) {
	                return node.key;
	            }
	            node = node.right;
	            if (node!= null ) {
	                stack . push (node);
	            }
	         }
	         return  - 1 ;
	    }
}
