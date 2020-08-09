package Tree;

/*
Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

             6
          /    \
        2        8
       / \      /  \
      0   4    7    9
         /  \
        3    5
 
Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Note:- All of the nodes' values will be unique. p and q are different and both values will exist in the BST.

Link:- https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
236. Lowest Common Ancestor of a Binary Tree
 */


public class _25_Lowest_Common_Ancestor_LCA_BST {	

	// * Time complexity O(height of tree)
   // * Space complexity O(height of tree)
	 /* Function to find LCA of n1 and n2. The function assumes that both n1 and n2 are present in BST */
  Node lca(Node node, int n1, int n2)  
  { 
      if (node == null) 
          return null; 
 
      // If both n1 and n2 are smaller than root, then LCA lies in left 
      if (node.key > n1 && node.key > n2) 
          return lca(node.left, n1, n2); 
 
      // If both n1 and n2 are greater than root, then LCA lies in right 
      else if (node.key < n1 && node.key < n2)  
          return lca(node.right, n1, n2); 
      else
        return node; 
  } 
  /*
   * Time complexity of above solution is O(h) where h is height of tree. Also, the above solution requires O(h) 
   * extra space in function call stack for recursive function calls. We can avoid extra space using iterative solution.
   */
   Node lca_itr(Node root, int n1, int n2) 
  { 
      while (root != null) 
      { 
           // If both n1 and n2 are smaller than root, then LCA lies in left 
          if (root.key > n1 && root.key > n2) 
             root = root.left; 
    
          // If both n1 and n2 are greater than root, then LCA lies in right 
          else if (root.key < n1 && root.key < n2) 
             root = root.right; 
    
          else break; 
      } 
      return root; 
  }
}

