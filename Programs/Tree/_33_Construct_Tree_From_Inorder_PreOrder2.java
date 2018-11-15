package Tree;

import java.util.HashMap;

//Time Complexity : O(n)


public class _33_Construct_Tree_From_Inorder_PreOrder2 {

	
	/* Recursive function to construct binary of size 
	len from Inorder traversal in[] and Preorder traversal  
	pre[]. Initial values of inStrt and inEnd should be  
	0 and len -1. The function doesn't do any error  
	checking for cases where inorder and preorder  
	do not form a tree */

	static int preIndex = 0;

	static Node buildTree(char in[], char pre[], int inStrt,  int inEnd, HashMap<Character, Integer> mp) 
	{ 
	    
	  
	    if (inStrt > inEnd) 
	        return null; 
	  
	    /* Pick current node from Preorder traversal using preIndex and increment preIndex */
	    int curr = pre[preIndex++]; 
	    Node tNode = new Node(curr); 
	  
	    /* If this node has no children then return */
	    if (inStrt == inEnd) 
	        return tNode; 
	  
	    /* Else find the index of this node in Inorder traversal */
	    int inIndex = mp.get((char)curr); 
	  
	    /* Using index in Inorder traversal, construct left and right subtress */
	    tNode.left = buildTree(in, pre, inStrt, inIndex - 1, mp); 
	    tNode.right = buildTree(in, pre, inIndex + 1, inEnd, mp); 
	  
	    return tNode; 
	} 
	  
	// This function mainly creates an unordered_map, then calls buildTree() 
    static Node buldTreeWrap(char in[], char pre[], int len) 
	{ 
	    // Store indexes of all items so that we we can quickly find later 
	    HashMap<Character, Integer> mp=  new HashMap<Character, Integer>(); 
	    for (int i = 0; i < len; i++) 
	    	mp.put(in[i], i); 
	  
	    return buildTree(in, pre, 0, len - 1, mp); 
	} 
	  
	/* This funtcion is here just to test buildTree() */
	static void printInorder( Node node) 
	{ 
	    if (node == null) 
	        return; 
	    printInorder(node.left); 
	    System.out.print( (char)node.key + "  "); 
	    printInorder(node.right); 
	} 
	  
	/* Driver program to test above functions */
	public static void main(String [] args) 
	{ 
	    char in[] = { 'D', 'B', 'E', 'A', 'F', 'C' }; 
	    char pre[] = { 'A', 'B', 'D', 'E', 'C', 'F' }; 
	    int len = in.length; 
	  
	    Node root = buldTreeWrap(in, pre, len); 
	  
	    /* Let us test the built tree by printing Insorder traversal */
	    System.out.println("Inorder traversal of the constructed tree is \n"); 
	    printInorder(root); 
	} 
}
