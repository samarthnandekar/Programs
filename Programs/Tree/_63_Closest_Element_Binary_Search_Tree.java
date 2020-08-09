package Tree;

/*
 https://www.geeksforgeeks.org/find-closest-element-binary-search-tree/
 
 Find the closest element in Binary Search Tree
Given a binary search tree and a target node K. The task is to find the node with minimum absolute difference with given target value K.

                  9
                /   \
               4      17
             /  \        \
            3    6         22
                /  \       /    
               5    7     20 
        
   // For above binary search tree
Input  :  k = 4
Output :  4

Input  :  k = 18
Output :  17

Input  :  k = 12
Output :  9


Solution:-

A simple solution for this problem is to store Inorder traversal of given binary search tree in an auxiliary array and then by taking absolute difference of each element find the node having minimum absolute difference with given target value K in linear time.

An efficient solution for this problem is to take advantage of characteristics of BST. Here is the algorithm to solve this problem :

1) If target value K is present in given BST, then it’s the node having minimum absolute difference.
2) If target value K is less than the value of current node then move to the left child.
3) If target value K is greater than the value of current node then move to the right child.
 Time complexity : O(h) where h is height of given Binary Search Tree.              
               
 */
public class _63_Closest_Element_Binary_Search_Tree {

	static int min_diff, min_diff_key; 
	
	public static void main(String[] args) {
		  Node  root = new Node(9); 
		    root.left    = new Node(4); 
		    root.right   = new Node(17); 
		    root.left.left = new Node(3); 
		    root.left.right = new Node(6); 
		    root.left.right.left = new Node(5); 
		    root.left.right.right = new Node(7); 
		    root.right.right = new Node(22); 
		    root.right.right.left = new Node(20); 
		    int k = 18; 
		    System.out.println( maxDiff(root, k)); 

	}

	// Function to find node with minimum absolute 
	// difference with given K 
	// min_diff   -. minimum difference till now 
	// min_diff_key  -. node having minimum absolute   difference with K 
	
	//Time complexity : O(h) where h is height of given Binary Search Tree.
	static void maxDiffUtil(Node  ptr, int k) 
	{ 
	    if (ptr == null) 
	        return ; 
	   
	    // If k itself is present 
	    if (ptr.key == k) 
	    { 
	        min_diff_key = k; 
	        return; 
	    } 
	   
	    // update min_diff and min_diff_key by checking current node value 
	    if (min_diff > Math.abs(ptr.key - k)) 
	    { 
	        min_diff = Math.abs(ptr.key - k); 
	        min_diff_key = ptr.key; 
	    } 
	   
	    // if k is less than ptr.key then move in  left subtree else in right subtree 
	    if (k < ptr.key) 
	        maxDiffUtil(ptr.left, k); 
	    else
	        maxDiffUtil(ptr.right, k); 
	} 
	   
	// Wrapper over maxDiffUtil() 
	static int maxDiff(Node  root, int k) 
	{ 
	    // Initialize minimum difference 
	    min_diff = 999999999; min_diff_key = -1; 
	   
	    // Find value of min_diff_key (Closest key in tree with k) 
	    maxDiffUtil(root, k); 
	   
	    return min_diff_key; 
	} 
	
	
	 // Iterative approach
	public int closestValue(Node root, double target) {
	    double min=Double.MAX_VALUE;
	    int result = root.key;
	 
	    while(root!=null){
	        if(target>root.key){
	 
	            double diff = Math.abs(root.key-target);
	            if(diff<min){
	                min = Math.min(min, diff);
	                result = root.key;
	            }
	            root = root.right;
	        }else if(target<root.key){
	 
	            double diff = Math.abs(root.key-target);
	            if(diff<min){
	                min = Math.min(min, diff);
	                result = root.key;
	            }
	            root = root.left;
	        }else{
	            return root.key;
	        }
	    }
	    return result;
	}
}
