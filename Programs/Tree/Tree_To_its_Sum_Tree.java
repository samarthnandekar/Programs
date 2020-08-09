/** 
@Author  - sn656
Creation - Date Nov 24, 2018 8:32:34 PM

*/

package Microsoft;

/**
  link :- https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
  
Convert a given tree to its Sum Tree
  Given a Binary Tree where each node has positive and negative values. Convert this to a tree where each node contains the sum of the left and right sub trees in the original tree. The values of leaf nodes are changed to 0.
  For example, the following tree

                  10
               /      \
             -2        6
           /   \      /  \ 
         8     -4    7    5
should be changed to

               20(4-2+12+6)
               /      \
          4(8-4)      12(7+5)
           /   \      /  \ 
         0      0    0    0
  
 
 */
public class Tree_To_its_Sum_Tree 
{

	Node root; 
	   
    // Convert a given tree to a tree where every node contains sum of 
    // values of nodes in left and right subtrees in the original tree 
    int toSumTree(Node node)  
    { 
        // Base case 
        if (node == null) 
            return 0; 
   
        // Store the old value 
        int old_val = node.data; 
   
        // Recursively call for left and right subtrees and store the sum as new value of this node 
        node.data = toSumTree(node.left) + toSumTree(node.right); 
   
        // Return the sum of values of nodes in left and right subtrees and old_value of this node 
        return node.data + old_val; 
    } 
   
    // A utility function to print inorder traversal of a Binary Tree 
    void printInorder(Node node)  
    { 
        if (node == null) 
            return; 
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
    } 
   
    /* Driver function to test above functions */
    public static void main(String args[])  
    { 
    	Tree_To_its_Sum_Tree tree = new Tree_To_its_Sum_Tree(); 
   
        /* Constructing tree given in the above figure */
        tree.root = new Node(10); 
        tree.root.left = new Node(-2); 
        tree.root.right = new Node(6); 
        tree.root.left.left = new Node(8); 
        tree.root.left.right = new Node(-4); 
        tree.root.right.left = new Node(7); 
        tree.root.right.right = new Node(5); 
   
        tree.toSumTree(tree.root); 
   
        // Print inorder traversal of the converted tree to test result  of toSumTree() 
        System.out.println("Inorder Traversal of the resultant tree is:"); 
        tree.printInorder(tree.root); 
    } 
}

