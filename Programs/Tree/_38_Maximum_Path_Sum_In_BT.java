package Tree;

/*
 * https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 
Maximum Path Sum in a Binary Tree
Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6

See below diagram for another example. 1+2+3

For each node there can be four ways that the max path goes through the node:
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child

The idea is to keep trace of four paths and pick up the max one in the end. An important thing to note is, root of every subtree need to
 return maximum path sum such that at most one child of root is involved. This is needed for parent function call. In below code, this sum 
 is stored in ‘max_single’ and returned by the recursive function.

 */
public class _38_Maximum_Path_Sum_In_BT {

	
	Node root;
	// This function returns overall maximum path sum in 'res' 
    // And returns max path sum going through root. 
    int findMaxUtil(Node node, Res res) 
    { 
  
        // Base Case 
        if (node == null) 
            return 0; 
  
        // l and r store maximum path sum going through left and 
        // right child of root respectively 
        int l = findMaxUtil(node.left, res); 
        int r = findMaxUtil(node.right, res); 
  
        // Max path for parent call of root. This path must 
        // include at-most one child of root 
        int max_single = Math.max(Math.max(l, r) + node.key, node.key); 
  
  
        // Max Top represents the sum when the Node under 
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
        int max_top = Math.max(max_single, l + r + node.key); 
  
        // Store the Maximum Result. 
        res.val = Math.max(res.val, max_top); 
  
        return max_single; 
    } 
  
    int findMaxSum() { 
        return findMaxSum(root); 
    } 
  
    // Returns maximum path sum in tree with given root 
    int findMaxSum(Node node) { 
  
        // Initialize result 
        // int res2 = Integer.MIN_VALUE; 
        Res res = new Res(); 
        res.val = Integer.MIN_VALUE; 
  
        // Compute and return result 
        findMaxUtil(node, res); 
        return res.val; 
    }
  
    //Driver program to test above functions 
    public static void main(String args[]) { 
    	_38_Maximum_Path_Sum_In_BT tree = new _38_Maximum_Path_Sum_In_BT(); 
    	
    	
    	tree.root = new Node(10); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(10); 
        tree.root.left.left = new Node(20); 
        tree.root.left.right = new Node(1); 
        tree.root.right.right = new Node(-25); 
        tree.root.right.right.left = new Node(3); 
        tree.root.right.right.right = new Node(4); 
        
    	/*
        tree.root = new Node(-15); 
        tree.root.left = new Node(5); 
        tree.root.right = new Node(6); 
        tree.root.left.left = new Node(-8); 
        tree.root.left.right = new Node(1); 
        tree.root.left.left.left = new Node(2); 
        tree.root.left.left.right = new Node(6); 
        tree.root.right.left = new Node(3); 
        tree.root.right.right = new Node(9); 
        tree.root.right.right.right = new Node(0); 
        tree.root.right.right.right.left = new Node(4); 
        tree.root.right.right.right.right = new Node(-1); 
        tree.root.right.right.right.right.left = new Node(10); 
        */
        System.out.println("Max pathSum of the given binary tree is "+ tree.findMaxSum()); 
    } 
	
}

//An object of Res is passed around so that the 
//same value can be used by multiple recursive calls. 
class Res { 
 int val; 
} 
