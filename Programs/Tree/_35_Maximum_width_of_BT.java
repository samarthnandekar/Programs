package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 
 Maximum width of a binary tree
Given a binary tree, write a function to get the maximum width of the given tree. Width of a tree is maximum of widths of all levels.
Let us consider the below example tree.

         1
        /  \
       2    3
     /  \     \
    4    5     8 
              /  \
             6    7
For the above tree,
width of level 1 is 1,
width of level 2 is 2,
width of level 3 is 3
width of level 4 is 2.

So the maximum width of the tree is 3.

*****  Method 1 (Using Level Order Traversal) ***** 
This method mainly involves two functions. One is to count nodes at a given level (getWidth), and other is to get the maximum width
of the tree(getMaxWidth). getMaxWidth() makes use of getWidth() to get the width of all levels starting from root.

	*Function to print level order traversal of tree*
	getMaxWidth(tree)
	maxWdth = 0
	for i = 1 to height(tree)
	  width =   getWidth(tree, i);
	  if(width > maxWdth) 
	      maxWdth  = width
	return maxWidth

	*Function to get width of a given level *
	getWidth(tree, level)
	if tree is NULL then return 0;
	if level is 1, then return 1;  
	else if level greater than 1, then
	    return getWidth(tree->left, level-1) + 
	    getWidth(tree->right, level-1);
	
Time Complexity: O(n^2) in the worst case.
We can use Queue based level order traversal to optimize the time complexity of this method. The Queue based level order traversal
will take O(n) time in worst case.	

 
***** Method 2 (Using Level Order Traversal with Queue)  ***** 
In this method we store all the child nodes at the current level in the queue and then count the total number of nodes after the level
order traversal for a particular level is completed. Since the queue now contains all the nodes of the next level, we can easily find out
the total number of nodes in the next level by finding the size of queue. We then follow the same procedure for the successive levels.
 We store and update the maximum number of nodes found at each level.


 */
public class _35_Maximum_width_of_BT {

	
	Node root; 
	   
    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node node)  
    { 
        int maxWidth = 0; 
        int width; 
        int h = height(node); 
        int i; 
   
        /* Get width of each level and compare  
           the width with maximum width so far */
        for (i = 1; i <= h; i++)  
        { 
            width = getWidth(node, i); 
            if (width > maxWidth) 
                maxWidth = width; 
        } 
   
        return maxWidth; 
    } 
   
    /* Get width of a given level */
    int getWidth(Node node, int level)  
    { 
        if (node == null) 
            return 0; 
   
        if (level == 1) 
            return 1; 
        else if (level > 1) 
            return getWidth(node.left, level - 1) + getWidth(node.right, level - 1); 
        return 0; 
    } 
   
    /* UTILITY FUNCTIONS */
      
    /* Compute the "height" of a tree -- the number of 
     nodes along the longest path from the root node 
     down to the farthest leaf node.*/
    int height(Node node)  
    { 
        if (node == null) 
            return 0; 
        else
        { 
            /* compute the height of each subtree */
            int lHeight = height(node.left); 
            int rHeight = height(node.right); 
               
            /* use the larger one */
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1); 
        } 
    } 
   
    /* Driver program to test above functions */
    public static void main(String args[])  
    { 
    	_35_Maximum_width_of_BT tree = new _35_Maximum_width_of_BT(); 
          
        /* 
        Constructed bunary tree is: 
              1 
            /  \ 
           2    3 
         /  \    \ 
        4   5     8  
                 /  \ 
                6   7 
         */
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.left.left= new Node(9);
        tree.root.left.left.right= new Node(10);
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(8); 
        tree.root.right.right.left = new Node(6); 
        tree.root.right.right.right = new Node(7); 
   
        System.out.println("Maximum width is " + tree.getMaxWidth(tree.root)); 
        System.out.println("Maximum width is " + tree.maxwidth(tree.root)); 
    } 
	
	// Function to find the maximum width of  
    // the tree using level order traversal 
    static int maxwidth(Node root)  
    { 
        // Base case 
        if (root == null) 
            return 0; 
          
        // Initialize result 
        int maxwidth = 0; 
          
        // Do Level order traversal keeping  
        // track of number of nodes at every level 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(root); 
        while (!q.isEmpty())  
        { 
            // Get the size of queue when the level order 
            // traversal for one level finishes 
            int count = q.size(); 
              
            // Update the maximum node count value 
            maxwidth = Math.max(maxwidth, count); 
              
            // Iterate for all the nodes in the queue currently 
            while (count-- > 0)  
            { 
                // Dequeue an node from queue 
                Node temp = q.remove(); 
              
                // Enqueue left and right children  
                // of dequeued node 
                if (temp.left != null)  
                { 
                    q.add(temp.left); 
                } 
                if (temp.right != null)  
                { 
                    q.add(temp.right); 
                } 
            } 
        } 
        return maxwidth; 
    } 
  
}
