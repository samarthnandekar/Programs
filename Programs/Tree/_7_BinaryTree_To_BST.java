package Tree;

import java.util.Arrays;

/* https://www.geeksforgeeks.org/binary-tree-to-binary-search-tree-conversion/
Given a Binary Tree, convert it to a Binary Search Tree. The conversion must be done in such a way that keeps the original structure of Binary Tree.
Examples.

Example 1
Input:
          10
         /  \
        2    7
       / \
      8   4
      
Output:
          8
         /  \
        4    10
       / \
      2   7


Example 2
Input:
          10
         /  \
        30   15
       /      \
      20       5
Output:
          15
         /  \
       10    20
       /      \
      5        30
      
 Solution:- Following is a 3 step solution for converting Binary tree to Binary Search Tree.
1) Create a temp array arr[] that stores inorder traversal of the tree. This step takes O(n) time.
2) Sort the temp array arr[]. Time complexity of this step depends upon the sorting algorithm. In the following implementation,
 Quick Sort is used which takes (n^2) time. This can be done in O(nLogn) time using Heap Sort or Merge Sort.
3) Again do inorder traversal of tree and copy array elements to tree nodes one by one. This step takes O(n) time.      */


public class _7_BinaryTree_To_BST {

	Node root;
	
	/* A helper function that stores inorder traversal of a tree rooted 
	  with node */
	static void storeInorder (Node node, int inorder[], int index_ptr) 
	{ 
	    // Base Case 
	    if (node == null) 
	        return; 
	  
	    /* first store the left subtree */
	    storeInorder (node.left, inorder, index_ptr); 
	  
	    /* Copy the root's data */
	    inorder[index_ptr] = node.key; 
	    index_ptr++;  // increase index for next entry 
	  
	    /* finally store the right subtree */
	    storeInorder (node.right, inorder, index_ptr); 
	} 
	  
	/* A helper function to count nodes in a Binary Tree */
	static int countNodes (Node root) 
	{ 
	    if (root == null) 
	     return 0; 
	    return countNodes (root.left) + 
	           countNodes (root.right) + 1; 
	} 

	  
	/* A helper function that copies contents of arr[] to Binary Tree. This functon basically does Inorder traversal of Binary Tree and  
	   one by one copy arr[] elements to Binary Tree nodes */
	static void arrayToBST (int arr[], Node root, int index_ptr) 
	{ 
	    // Base Case 
	    if (root == null) 
	      return; 
	  
	    /* first update the left subtree */
	    arrayToBST (arr, root.left, index_ptr); 
	  
	    /* Now update root's data and increment index */
	    root.key = arr[index_ptr]; 
	    index_ptr++; 
	  
	    /* finally update the right subtree */
	    arrayToBST (arr, root.right, index_ptr); 
	} 
	  
	// This function converts a given Binary Tree to BST 
	static void binaryTreeToBST (Node root) 
	{ 
	    // base case: tree is empty 
	    if(root == null) 
	       return; 
	  
	    /* Count the number of nodes in Binary Tree so that 
	       we know the size of temporary array to be created */
	    int n = countNodes(root); 
	  
	    // Create a temp array arr[] and store inorder traversal of tree in arr[] 
	    int arr[] = new int[n]; 
	    int i = 0; 
	    storeInorder (root, arr, i); 
	  
	    // Sort the array using library function for quick sort 
	    Arrays.sort(arr);; 
	  
	    // Copy array elements back to Binary Tree 
	    i = 0; 
	    arrayToBST (arr, root, i); 
	  

	} 

	  
	/* Utility function to print inorder traversal of Binary Tree */
	static void printInorder (Node node) 
	{ 
	    if (node == null) 
	        return; 
	  
	    /* first recur on left child */
	    printInorder (node.left); 
	  
	    /* then print the data of node */
	    System.out.println(node.key); 
	  
	    /* now recur on right child */
	    System.out.println(node.right); 
	} 
	  
	/* Driver function to test above functions */
	public static void main(String[] args) 
	{ 
	     Node root = null; 
	  
	    /* Constructing tree given in the above figure 
	          10 
	         /  \ 
	        30   15 
	       /      \ 
	      20       5   */
	    root = new Node(10); 
	    root.left = new Node(30); 
	    root.right = new Node(15); 
	    root.left.left = new Node(20); 
	    root.right.right = new Node(5); 
	  
	    // convert Binary Tree to BST 
	    binaryTreeToBST (root); 
	  
	    System.out.println("Following is Inorder Traversal of the converted BST: \n"); 
	    printInorder (root); 
	  
	    
	} 
	
}
