
package Tree;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * https://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 
 Print a Binary Tree in Vertical Order | Set 2 (Map based Method)
Given a binary tree, print it vertically. The following example illustrates vertical order traversal.
           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9

 The idea is to traverse the tree once and get the minimum and maximum horizontal distance with respect to root. For the tree shown above, minimum distance is -2 (for node with value 4) and maximum distance is 3 (For node with value 9).
Once we have maximum and minimum distances from root, we iterate for each vertical line at distance minimum to maximum from root, and for each vertical line traverse the tree and print the nodes which lie on that vertical line.

Algorithm:

// min --> Minimum horizontal distance from root
// max --> Maximum horizontal distance from root
// hd  --> Horizontal distance of current node from root 
findMinMax(tree, min, max, hd)
     if tree is NULL then return;
 
     if hd is less than min then
           min = hd;
     else if hd is greater than max then
          *max = hd;
 
     findMinMax(tree->left, min, max, hd-1);
     findMinMax(tree->right, min, max, hd+1);

 
printVerticalLine(tree, line_no, hd)
     if tree is NULL then return;
 
     if hd is equal to line_no, then
           print(tree->data);
     printVerticalLine(tree->left, line_no, hd-1);
     printVerticalLine(tree->right, line_no, hd+1); 
  
  
  Time Complexity: Time complexity of above algorithm is O(w*n) where w is width of Binary Tree and n is number of nodes in Binary Tree.
   In worst case, the value of w can be O(n) (consider a complete tree for example) and time complexity can become O(n2).
*/

public class _52_Print_BT_Vertical_Order {
	
	Node root; 
    Values val = new Values(); 
   
    // A utility function to find min and max distances with respect 
    // to root. 
    void findMinMax(Node node, Values min, Values max, int hd)  
    { 
        // Base case 
        if (node == null)  
            return; 
   
        // Update min and max 
        if (hd < min.min)  
            min.min = hd; 
        else if (hd > max.max)  
            max.max = hd; 
   
        // Recur for left and right subtrees 
        findMinMax(node.left, min, max, hd - 1); 
        findMinMax(node.right, min, max, hd + 1); 
    } 
   
    // A utility function to print all nodes on a given line_no. 
    // hd is horizontal distance of current node with respect to root. 
    void printVerticalLine(Node node, int line_no, int hd)  
    { 
        // Base case 
        if (node == null)  
            return; 
   
        // If this node is on the given line number 
        if (hd == line_no)  
            System.out.print(node.key + " ");         
   
        // Recur for left and right subtrees 
        printVerticalLine(node.left, line_no, hd - 1); 
        printVerticalLine(node.right, line_no, hd + 1); 
    } 
   
    // The main function that prints a given binary tree in 
    // vertical order 
    void verticalOrder(Node node)  
    { 
        // Find min and max distances with resepect to root 
        findMinMax(node, val, val, 0); 
   
        // Iterate through all possible vertical lines starting 
        // from the leftmost line and print nodes line by line 
        for (int line_no = val.min; line_no <= val.max; line_no++)  
        { 
            printVerticalLine(node, line_no, 0); 
            System.out.println(""); 
        } 
    } 
   
    // Driver program to test the above functions 
    public static void main(String args[])  
    { 
    	_52_Print_BT_Vertical_Order tree = new _52_Print_BT_Vertical_Order(); 
   
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
        tree.root.right.right.right = new Node(9); 
   
        System.out.println("vertical order traversal is :"); 
        tree.verticalOrder(tree.root); 
    } 

}

class Values  
{ 
    int max, min; 
} 


