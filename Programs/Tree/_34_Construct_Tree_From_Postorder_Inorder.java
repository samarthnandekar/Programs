package Tree;

/* https://www.geeksforgeeks.org/construct-a-binary-tree-from-postorder-and-inorder/
 
 Construct a Binary Tree from Postorder and Inorder Given Postorder and Inorder traversals, construct the tree.

Examples:

Input : 
in[]   = {2, 1, 3}
post[] = {2, 3, 1}

Output : Root of below tree
      1
    /   \
   2     3 

Input : 
in[]   = {4, 8, 2, 5, 1, 6, 3, 7}
post[] = {8, 4, 5, 2, 6, 7, 3, 1} 

Output : Root of below tree
          1
       /     \
     2        3
   /    \   /   \
  4     5   6    7
    \
      8
  
 We have already discussed construction of tree from Inorder and Preorder traversals. The idea is similar.
Let us see the process of constructing tree from in[] = {4, 8, 2, 5, 1, 6, 3, 7} and post[] = {8, 4, 5, 2, 6, 7, 3, 1}

1) We first find the last node in post[]. The last node is “1”, we know this value is root as root always appear in the end of
 postorder traversal.

2) We search “1” in in[] to find left and right subtrees of root. Everything on left of “1” in in[] is in left subtree and
 everything on right is in right subtree.

         1
       /    \
[4, 8, 2, 5]   [6, 3, 7] 
3) We recur the above process for following two.
….b) Recur for in[] = {6, 3, 7} and post[] = {6, 7, 3}
…….Make the created tree as right child of root.
….a) Recur for in[] = {4, 8, 2, 5} and post[] = {8, 4, 5, 2}.
…….Make the created tree as left child of root.

Below is the implementation of above idea. One important observation is, we recursively call for right subtree before left subtree
 as we decrease index of postorder index whenever we create a new node. 
  
*/

public class _34_Construct_Tree_From_Postorder_Inorder {

	/* Recursive function to construct binary of size n from  Inorder traversal in[] and Postrder traversal 
    post[].  Initial values of inStrt and inEnd should be 0 and n -1.  The function doesn't do any error 
    checking for cases where inorder and postorder do not form a tree */
 Node buildUtil(int in[], int post[], int inStrt, int inEnd, Index pIndex) 
 { 
     // Base case 
     if (inStrt > inEnd) 
         return null; 

     /* Pick current node from Postrder traversal using postIndex and decrement postIndex */
     Node node = new Node(post[pIndex.index]); 
     (pIndex.index)--; 

     /* If this node has no children then return */
     if (inStrt == inEnd) 
         return node; 

     /* Else find the index of this node in Inorder traversal */
     int iIndex = search(in, inStrt, inEnd, node.key); 

     /* Using index in Inorder traversal, construct left and right subtress */
     node.right = buildUtil(in, post, iIndex + 1, inEnd, pIndex); 
     node.left = buildUtil(in, post, inStrt, iIndex - 1, pIndex); 

     return node; 
 } 

 // This function mainly initializes index of root and calls buildUtil() 
 Node buildTree(int in[], int post[], int n) 
 { 
     Index pIndex = new Index(); 
     pIndex.index = n - 1; 
     return buildUtil(in, post, 0, n - 1, pIndex); 
 } 

 /* Function to find index of value in arr[start...end]  The function assumes that value is postsent in in[] */
 int search(int arr[], int strt, int end, int value) 
 { 
     int i; 
     for (i = strt; i <= end; i++) { 
         if (arr[i] == value) 
             break; 
     } 
     return i; 
 } 

 /* This funtcion is here just to test  */
 void preOrder(Node node) 
 { 
     if (node == null) 
         return; 
     System.out.print(node.key + " "); 
     preOrder(node.left); 
     preOrder(node.right); 
 } 

 public static void main(String[] args) 
 { 
	 _34_Construct_Tree_From_Postorder_Inorder tree = new _34_Construct_Tree_From_Postorder_Inorder(); 
     int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 }; 
     int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 }; 
     int n = in.length; 
     Node root = tree.buildTree(in, post, n); 
     System.out.println("Preorder of the constructed tree : "); 
     tree.preOrder(root); 
 }
	
}

//Class Index created to implement pass by reference of Index 
class Index { 
 int index; 
} 