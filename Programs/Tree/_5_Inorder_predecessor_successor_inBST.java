package Tree;
/* https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/

Input: root node, key
output: predecessor node, successor node

1. If root is NULL
      then return
2. if key is found then
    a. If its left subtree is not null
        Then predecessor will be the right most 
        child of left subtree or left child itself.
    b. If its right subtree is not null
        The successor will be the left most child 
        of right subtree or right child itself.
    return
3. If key is smaller then root node
        set the successor as root
        search recursively into left subtree
    else
        set the predecessor as root
        search recursively into right subtree           */

public class _5_Inorder_predecessor_successor_inBST 
{
  Node root; 

	static void findPreSuc(Node root, Node pre, Node suc, int key) 
	{ 
	    // Base case 
	    if (root == null)
	    	return; 
	  
	    // If key is present at root 
	    if (root.key == key) 
	    { 
	        // the maximum value in left subtree is predecessor 
	        if (root.left != null) 
	        { 
	            Node tmp = root.left; 
	            while (tmp.right!=null) 
	                tmp = tmp.right; 
	            pre = tmp ; 
	        } 
	  
	        // the minimum value in right subtree is successor 
	        if (root.right != null) 
	        { 
	            Node tmp = root.right ; 
	            while (tmp.left!=null) 
	                tmp = tmp.left ; 
	            suc = tmp ; 
	        } 
	        return ; 
	    } 
	  
	    // If key is smaller than root's key, go to left subtree 
	    if (root.key > key) 
	    { 
	        suc = root ; 
	        findPreSuc(root.left, pre, suc, key) ; 
	    } 
	    else // go to right subtree 
	    { 
	        pre = root ; 
	        findPreSuc(root.right, pre, suc, key) ; 
	    } 
	} 
	  
	// A utility function to create a new BST node 
	Node newNode(int item) 
	{ 
	    Node temp =  new Node(item); 
	    return temp; 
	} 
	  
	/* A utility function to insert a new node with given key in BST */
	static Node insert(Node node, int key) 
	{ 
	    if (node == null) 
	    	return new Node(key); 
	    if (key < node.key) 
	        node.left  = insert(node.left, key); 
	    else
	        node.right = insert(node.right, key); 
	    return node; 
	} 
	  
	// Driver program to test above function 
	 public static void main(String[] args)  
	{ 
	    int key = 65;    //Key to be searched in BST 
	  
	   /* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	       20   40  60   80 */
	    Node root = null; 
	    root = insert(root, 50); 
	    insert(root, 30); 
	    insert(root, 20); 
	    insert(root, 40); 
	    insert(root, 70); 
	    insert(root, 60); 
	    insert(root, 80); 
	  
	  
	    Node pre = null, suc = null; 
	  
	    findPreSuc(root, pre, suc, key); 
	    if (pre != null) 
	      System.out.println("Predecessor is " + pre.key);
	    else
	    	System.out.println("No Predecessor"); 
	  
	    if (suc != null) 
	      System.out.println("Successor is " + pre.key);
	    else
	    	System.out.println("No Successor"); 
	}
}
