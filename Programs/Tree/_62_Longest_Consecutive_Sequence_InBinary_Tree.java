package Tree;

import java.util.LinkedList;

/*
 
 https://www.geeksforgeeks.org/longest-consecutive-sequence-binary-tree/
 
Longest consecutive sequence in Binary tree
Given a Binary Tree find the length of the longest path which comprises of nodes with consecutive values in increasing order. Every node is considered as a path of length 1.

In below diagram binary tree with longest consecutive path(LCP) are shown :

    6                                 1 
     \                              /   \
      9                            2     4
    /  \                          /     /  \
   7   10                        3     5    6 
         \                                 /
         11                               7 
         
 LCP :9,10,11  Length:3        LCP : 1,2,3   Length:3   
 
 
 The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
 The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
  2    4
        \
         5
Longest consecutive sequence path is  3-4-5, so return  3.

   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is  2-3, not 3-2-1, so return  2.


 */
public class _62_Longest_Consecutive_Sequence_InBinary_Tree {

	public static void main(String[] args) {
	
		Node root= new Node(1);
		root.left= new Node(3);
		root.right= new Node(3);
		root.left.left= new Node(4);
		root.left.left.left= new Node(5);
	
		_62_Longest_Consecutive_Sequence_InBinary_Tree obj= new _62_Longest_Consecutive_Sequence_InBinary_Tree();
		
	  int ans1=obj.longestConsecutive(root);
	  int ans2= obj.longestConsecutive_2(root);
	  
	  System.out.println(ans1);
	  System.out.println("---------------------");
	  System.out.println(ans2);
		
	}
	
	// method returns length of longest consecutive  sequence rooted at node root  
    int longestConsecutive(Node root) 
    { 
        if (root == null) 
            return 0; 
  
        Result res = new Result(); 
          
        // call utility method with current length 0  
        longestConsecutiveUtil(root, 0, root.key, res); 
          
        return res.res; 
    } 
  
    // Utility method to return length of longest consecutive sequence of tree  
    private void longestConsecutiveUtil(Node root, int curlength, int expected, Result res) 
    { 
        if (root == null) 
            return; 
  
        // if root data has one more than its parent then increase current length  
        if (root.key == expected) 
            curlength++; 
        else
            curlength = 1; 
  
        // update the maximum by current length  
        res.res = Math.max(res.res, curlength); 
  
        // recursively call left and right subtree with  
        // expected value 1 more than root data  
        longestConsecutiveUtil(root.left, curlength, root.key + 1, res); 
        longestConsecutiveUtil(root.right, curlength, root.key + 1, res); 
    } 

    //https://www.programcreek.com/2014/04/leetcode-binary-tree-longest-consecutive-sequence-java/
    //Java Solution 1 - BFS
    public int longestConsecutive_2(Node root) {
        if(root==null)
            return 0;
     
        LinkedList<Node> nodeQueue = new LinkedList<Node>();
        LinkedList<Integer> sizeQueue = new LinkedList<Integer>();
     
        nodeQueue.offer(root);
        sizeQueue.offer(1);
        int max=1;
     
        while(!nodeQueue.isEmpty()){
            Node head = nodeQueue.poll();
            int size = sizeQueue.poll();
     
            if(head.left!=null){
                int leftSize=size;
                if(head.key==head.left.key-1){
                    leftSize++;
                    max = Math.max(max, leftSize);
                }else{
                    leftSize=1;
                }
     
                nodeQueue.offer(head.left);
                sizeQueue.offer(leftSize);
            }
     
            if(head.right!=null){
                int rightSize=size;
                if(head.key==head.right.key-1){
                    rightSize++;
                    max = Math.max(max, rightSize);
                }else{
                    rightSize=1;
                }
     
                nodeQueue.offer(head.right);
                sizeQueue.offer(rightSize);
            }
        }
        return max;
    }
}

class Result 
{ 
	int res = 0; 
} 