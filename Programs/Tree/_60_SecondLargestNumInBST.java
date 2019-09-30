package Tree;

/*
 * https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/
Second largest element in BST:- Given a Binary Search Tree(BST), find the second largest element.

Examples:- Input: Root of below BST
    10
   /
  5

Output:  5

Input: Root of below BST
        10
      /   \
    5      20
             \ 
              30 

Output:  20
Source: Microsoft Interview  */

public class _60_SecondLargestNumInBST {

	Node root;
	
	public static void main(String[] args) {
 
			_60_SecondLargestNumInBST tree = new _60_SecondLargestNumInBST(); 
	          
	        /* Let us create following BST 
	              50 
	           /     \ 
	          30      70 
	         /  \    /  \ 
	       20   40  60   80 */
	         
	        tree.insert(50); 
	        tree.insert(30); 
	        tree.insert(20); 
	        tree.insert(40); 
	        tree.insert(70); 
	        tree.insert(60); 
	        tree.insert(80); 
	  
	        tree.secondLargest(tree.root); 
	    } 
	
	
	Node insertRec(Node node, int data) 
    { 
        /* If the tree is empty, return a new node */
        if (node == null) { 
            this.root = new Node(data); 
            return this.root; 
        } 
        /* Otherwise, recur down the tree */
        if (data < node.key) { 
            node.left = this.insertRec(node.left, data); 
        } else { 
            node.right = this.insertRec(node.right, data); 
        } 
        return node; 
    } 
	
	// function to insert new nodes 
    public void insert(int data) 
    { 
        this.root = this.insertRec(this.root, data); 
    } 
    
 // class that stores the value of count 
    public class count { 
        int c = 0; 
    } 
  
    // Function to find 2nd largest element 
    void secondLargestUtil(Node node, count C) 
    {    
        // Base cases, the second condition is important to avoid unnecessary recursive calls 
        if (node == null || C.c >= 3) 
            return; 
              
        // Follow reverse inorder traversal so that the largest element is visited first 
        this.secondLargestUtil(node.right, C);  
          
         // Increment count of visited nodes 
        C.c++; 
          
        // If c becomes k now, then this is the 2nd largest 
        if (C.c == 3) { 
            System.out.print("2nd largest element is "+ node.key); 
            return; 
        } 
          
         // Recur for left subtree 
        this.secondLargestUtil(node.left, C);  
    } 
  
    // Function to find 2nd largest element 
    void secondLargest(Node node) 
    {    
        // object of class count 
        count C = new count();  
        this.secondLargestUtil(this.root, C); 
    } 

}
