package Tree;

import java.awt.print.PrinterIOException;
import java.security.Principal;
import java.util.Arrays;

/* Convert binary tree to BST  :- Binary Tree to Binary Search Tree Conversion
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
 */

public class _4_BinaryTree_to_BST {

	
	Node root;
	
	
	static void printOrder(Node node)
	{
		if(node!=null)
		{
			printOrder(node.left);
			System.out.print(node.data + "  ");
			printOrder(node.right);
			
		}
		
	}
	
   static int count=0;
	static int countNode(Node node)
	{
		if(node!=null)
		{
			countNode(node.left);
			count++;
			countNode(node.right);
		}
		
		return count;
	}
	
	// conver binary to BST
	 static Node binaryToBST(Node node)
	 {
		 //
		 int tCount=countNode(node);
		 int [] arr= new int [tCount];
		 
		 copyDateInArray(arr,node);
		 
		 System.out.println("");
		 
		 Arrays.sort(arr);
		 
		 copyArrayInTree(arr,node);
		 return null;
	 }
	static int j=0;
	static void copyArrayInTree(int [] arr, Node node)
	 {
		 
		if(node!=null)
		{
			copyArrayInTree(arr,node.left);
			
			node.data=arr[j];
			j++;
			copyArrayInTree(arr,node.right);
		}
	 }
	 
	 
	static int i=0; 
	static void copyDateInArray(int []arr,Node node)
	 {
		 if(node!=null)
		 {
			 copyDateInArray(arr,node.left);
			 
			 arr[i]=node.data;
			 i++;
			 copyDateInArray(arr,node.right);
			 
		 }
	 }
	 
	
	 public static void main (String[] args) 
	    {
		 
		 Node root= new Node(10);
		 Node n1= new Node(2);
		 Node n2= new Node(8);
		 Node n3= new Node(4);
		 Node n4= new Node(7);
		 
		 root.left=n1;
		 root.right=n4;
		 
		 n1.left=n2;
		 n1.right=n3;
		 
		 printOrder(root);
		 
		// int tCount=countNode(root);
		// System.out.println();
		 //System.out.println(tCount);
		 binaryToBST(root);
		 
		 printOrder(root);
		 
	    }
	 
	 
}
