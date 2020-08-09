package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 https://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 
Check if a given array can represent Preorder Traversal of Binary Search Tree
Given an array of numbers, return true if given array can represent preorder traversal of a Binary Search Tree, else return false. Expected time complexity is O(n).

Examples:-
Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal of below tree
    2
     \
      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal of below tree
     40
   /   
 30    80 
        
  35     100 


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false
Given array cannot represent preorder traversal of a Binary Search Tree.


Solution:-

A Simple Solution is to do following for every node pre[i] starting from first one.



1) Find the first greater value on right side of current node. 
   Let the index of this node be j. Return true if following 
   conditions hold. Else return false
    (i)  All values after the above found greater value are 
         greater than current node.
    (ii) Recursive calls for the subarrays pre[i+1..j-1] and 
         pre[j+1..n-1] also return true. 
Time Complexity of the above solution is O(n2)

        
 */
public class _64_VerifyPreorderSequenceIn_BST {

	public static void main(String[] args) {
		_64_VerifyPreorderSequenceIn_BST bst = new _64_VerifyPreorderSequenceIn_BST(); 
        int[] pre1 = new int[]{40, 30, 35, 80, 100}; 
        int n = pre1.length; 
        if (bst.canRepresentBST(pre1, n) == true) { 
            System.out.println("true"); 
        } else { 
            System.out.println("false"); 
        } 
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100}; 
        int n1 = pre2.length; 
        if (bst.canRepresentBST(pre2, n) == true) { 
            System.out.println("true"); 
        } else { 
            System.out.println("false"); 
        } 

        
        int[] input = {10, 3, -1, 4, 13, 11, 12, 10};
        System.out.println(bst.verifyPreorder(input));
        System.out.println(bst.verifyPreorderConstantSpace(input));
        
        // Check for below array. *** very important 
        //int[] input = {9,3,4,#,#,1,#,#,2,#,6,#,#};
	}

	/*
	 An Efficient Solution can solve this problem in O(n) time. The idea is to use a stack. This problem is similar to Next (or closest) Greater Element problem.
     Here we find the next greater element and after finding next greater, if we find a smaller element, then return false.

1) Create an empty stack.
2) Initialize root as INT_MIN.
3) Do following for every element pre[i]
     a) If pre[i] is smaller than current root, return false.
     b) Keep removing elements from stack while pre[i] is greater
        then stack top. Make the last removed item as new root (to
        be compared next).
        At this point, pre[i] is greater than the removed root
        (That is why if we see a smaller element in step a), we 
        return false)
     c) push pre[i] to stack (All elements in stack are in decreasing order) 
	 */
	 boolean canRepresentBST(int pre[], int n) { 
	        // Create an empty stack 
	        Stack<Integer> s = new Stack<Integer>(); 
	  
	        // Initialize current root as minimum possible value 
	        int root = Integer.MIN_VALUE; 
	  
	        // Traverse given array 
	        for (int i = 0; i < n; i++) { 
	            // If we find a node who is on right side and smaller than root, return false 
	            if (pre[i] < root) { 
	                return false; 
	            } 
	  
	            // If pre[i] is in right subtree of stack top,  Keep removing items smaller than pre[i] 
	            //and make the last removed item as new root. 
	            while (!s.empty() && s.peek() < pre[i]) { 
	                root = s.peek(); 
	                s.pop(); 
	            } 
	  
	            // At this point either stack is empty or pre[i] is smaller than root, push pre[i] 
	            s.push(pre[i]); 
	        } 
	        return true; 
	    } 
	 
	 public boolean verifyPreorder(int pre[]) {
	        Deque<Integer> deque = new LinkedList<>();
	        int minAcceptable = Integer.MIN_VALUE;
	        deque.addFirst(pre[0]);
	        for(int i = 1; i < pre.length; i++) {
	            if(pre[i] < minAcceptable) {
	                return false;
	            }
	            while(!deque.isEmpty() && deque.peekFirst() < pre[i]) {
	                minAcceptable = deque.pollFirst();
	            }
	            deque.addFirst(pre[i]);
	        }
	        return true;
	    }

	    public boolean verifyPreorderConstantSpace(int[] preorder) {
	        int start = 0;
	        int min = Integer.MIN_VALUE;
	        for (int i = 1; i < preorder.length; i++) {
	            if (preorder[i] < min) {
	                return false;
	            }
	            if (preorder[i] > preorder[i - 1]) {
	                int index = binarySearch(preorder, start, i - 1, preorder[i]);
	                min = preorder[index];
	                start = i;
	            }
	        }
	        return true;
	    }

	    int binarySearch(int[] preorder, int start, int end, int val) {
	        int s = start;
	        int e = end;
	        while (s <= e) {
	            int middle = (s + e)/2;
	            if (preorder[middle] < val && (start == middle || preorder[middle - 1] > val)) {
	                return middle;
	            } else if (preorder[middle] < val) {
	                e = middle - 1;
	            } else {
	                s = middle + 1;
	            }
	        }
	        return -1;
	    }
}
