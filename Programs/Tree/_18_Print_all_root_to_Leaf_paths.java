package Tree;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
Given a binary tree, print all root-to-leaf paths
leetcode :- 257 Binary Tree Paths 

For the below example tree, all root-to-leaf paths are: 
10 –> 8 –> 3
10 –> 8 –> 5
10 –> 2 –> 2

                 10 
               /    \
              8      2
            /  \    /
           3    5  2    


Approach 1: - Recursive approach
              Time Complexity: O(n2) where n is number of nodes.

Approach 2:- Simplified DFS Solution

 */
public class _18_Print_all_root_to_Leaf_paths {

	Node root; 
    
    /*Given a binary tree, print out all of its root-to-leaf 
      paths, one per line. Uses a recursive helper to do  the work.*/
    void printPaths(Node node)  
    { 
        int path[] = new int[1000]; 
        printPathsRecur(node, path, 0); 
    } 
   
    /* Recursive helper function -- given a node, and an array containing the path from the root node up to but not  
       including this node, print out all the root-leaf paths. Time Complexity: O(n2) where n is number of nodes.*/
    void printPathsRecur(Node node, int path[], int pathLen)  
    { 
        if (node == null) 
            return; 
   
        /* append this node to the path array */
        path[pathLen] = node.key; 
        pathLen++; 
   
        /* it's a leaf, so print the path that led to here  */
        if (node.left == null && node.right == null) 
            printArray(path, pathLen); 
        else 
        { 
            /* otherwise try both subtrees */
            printPathsRecur(node.left, path, pathLen); 
            printPathsRecur(node.right, path, pathLen); 
        } 
    } 
   
    void printArray(int ints[], int len)  
    { 
        int i; 
        for (i = 0; i < len; i++)  
        { 
            System.out.print(ints[i] + " "); 
        } 
        System.out.println(""); 
    } 
   
    public static void main(String args[])  
    { 
    	_18_Print_all_root_to_Leaf_paths tree = new _18_Print_all_root_to_Leaf_paths(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(2); 
          
        /* Let us test the built tree by printing Insorder traversal */
        tree.printPaths(tree.root); 
        
        System.out.println("Second approach");
        binaryTreePaths(tree.root);
    }
    
    // Approach 2:- Simplified DFS Solution
    static public List<String> binaryTreePaths(Node root) {
    	 
        String sb = "";
        ArrayList<String> result = new ArrayList<String>();
     
        helper(root, result, sb);
     
        for(String val:result)
        {
        	System.out.println(val);
        }
        
        return result;
    }
     
    static public void helper(Node root, ArrayList<String> result, String s){
        if(root==null){
            return;
        }
     
        s = s+"->"+root.key;
     
        if(root.left==null &&root.right==null){
            result.add(s.substring(2));
            return;
        }
     
        if(root.left!=null){
            helper(root.left, result, s);
        }
        if(root.right!=null){
            helper(root.right, result, s);
        }
    }
}
