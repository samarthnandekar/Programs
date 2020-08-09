package BFS;

import java.util.LinkedList;
import java.util.Queue;

/* Link:- https://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
 
 Find Minimum Depth of a Binary Tree
Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from root node down to
 the nearest leaf node.

For example, minimum height of below Binary Tree is 2.

		    1
		  /	  \
		2	   3
	  /  \
	 4	  5
		
 */

public class _5_Minimum_Depth_of_Binary_Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(1); 
	    root.left = new Node(2); 
	    root.right = new Node(3); 
	    root.left.left = new Node(4); 
	    root.left.right = new Node(5);

	    System.out.println(minDepth(root));
	}
	
	static int minDepth(Node root) 
	{ 
	    // Corner Case 
	    if (root == null) 
	        return 0; 
	  
	    // Create an empty queue for level order tarversal 
	    Queue<Qitem> q= new LinkedList<Qitem>();
	  
	    // Enqueue Root and initialize depth as 1 
	    Qitem qi = new Qitem(root, 1); 
	    q.add(qi); 
	  
	    // Do level order traversal 
	    int depth=0;
	    while(!q.isEmpty())
	    {
	       // Remove the front queue item 
	       qi = q.poll();
	  
	       // Get details of the remove item 
	       Node node = qi.node; 
	        
	  
	       // If this  is the first leaf node seen so far 
	       // Then return its depth as answer 
	       if (node.left == null && node.right == null) 
	          {
	    	   depth=qi.depth;
	    	   break;
	          }
	  
	       // If left subtree is not NULL, add it to queue 
	       if (node.left != null) 
	       { 
	          qi.node  = node.left; 
	          qi.depth = depth + 1; 
	          q.add(qi); 
	       } 
	  
	       // If right subtree is not NULL, add it to queue 
	       if (node.right != null) 
	       { 
	          qi.node  = node.right; 
	          qi.depth = depth+1; 
	          q.add(qi); 
	       } 
	    } 
	    
	    return depth;
	} 

}


class Qitem
{
	Node node;
	int depth;
	
	Qitem(Node node, int de)
	{
		this.node=node;
		depth=de;
	}
}