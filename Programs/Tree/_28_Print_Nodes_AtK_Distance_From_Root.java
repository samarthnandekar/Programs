package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 */
public class _28_Print_Nodes_AtK_Distance_From_Root {

	
	 Node root; 
	   
	    void printKDistant(Node node, int k)  
	    { 
	        if (node == null) 
	            return; 
	        if (k == 0)  
	        { 
	            System.out.print(node.key + " "); 
	            return; 
	        }  
	        else 
	        { 
	            printKDistant(node.left, k - 1); 
	            printKDistant(node.right, k - 1); 
	        } 
	    } 
	    
	    /*
	    https://www.geeksforgeeks.org/print-nodes-k-distance-root-iterative/
	    Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.

		For example :
		Input :
                20
              /   \
            10    30
           / \    / \
          5  15  25  40
             /
            12

		and k = 3
		Root is at level 1.
		
		Output :
		5 15 25 40 */
	    
	    boolean printKDistant_iterative(Node root, int klevel) 
	    { 
	        Queue<Node> q = new LinkedList<Node>(); 
	        int level = 1; 
	        boolean flag = false; 
	        q.add(root); 
	      
	        // extra NULL is pushed to keep track  of all the nodes to be pushed before 
	        // level is incremented by 1 
	        q.add(null); 
	        while (!q.isEmpty()) { 
	            Node temp = q.poll(); 
	      
	            // print when level is equal to k 
	            if (level == klevel && temp != null) { 
	                flag = true; 
	                System.out.print(temp.key + " "); 
	            } 
 
	            
	            if (temp == null)
	            { 
	                if (q.peek()!=null) 
	                    q.add(null); 
	                level += 1; 
	      
	                // break the loop if level exceeds the given level number 
	                if (level > klevel) 
	                    break; 
	            } else { 
	                if (temp.left!=null) 
	                    q.add(temp.left); 
	      
	                if (temp.right!=null) 
	                    q.add(temp.right); 
	            } 
	        }
	      
	        return flag; 
	    } 
	      
	    /* Driver program to test above functions */
	    public static void main(String args[]) { 
	    	_28_Print_Nodes_AtK_Distance_From_Root tree = new _28_Print_Nodes_AtK_Distance_From_Root(); 
	          
	        /* Constructed binary tree is 
	                1 
	              /   \ 
	             2     3 
	            /  \   / 
	           4    5 8  
	        */
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(8); 
	   
	        tree.printKDistant(tree.root, 2); 
	        tree.printKDistant_iterative(tree.root, 3);
	    } 
	} 

