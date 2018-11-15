package Tree;

//https://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/

/* Algorithm:- size(tree)
1. If tree is empty then return 0
2. Else
     (a) Get the size of left subtree recursively  i.e., call 
          size( tree->left-subtree)
     (a) Get the size of right subtree recursively  i.e., call 
          size( tree->right-subtree)
     (c) Calculate size of the tree as following:
            tree_size  =  size(left-subtree) + size(right-
                               subtree) + 1
     (d) Return tree_size */
public class _3_SizeOfTree 
	{ 
	    Node root;
	  
	    /* Given a binary tree. Print its nodes in level order using array for implementing queue */
	    int size() 
	    { 
	        return size(root); 
	    } 
	  
	    /* computes number of nodes in tree */
	    int size(Node node) 
	    { 
	        if (node == null) 
	            return 0; 
	        else
	            return(size(node.left) + 1 + size(node.right)); 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        /* creating a binary tree and entering the nodes */
	    	_3_SizeOfTree tree = new _3_SizeOfTree(); 
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	  
	        System.out.println("The size of binary tree is : "
	                            + tree.size()); 
	    } 
	
}
