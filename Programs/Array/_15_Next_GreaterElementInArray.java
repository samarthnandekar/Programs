package Array;

import java.util.Deque;
import java.util.LinkedList;

/*
 https://www.geeksforgeeks.org/next-greater-element/
 Next Greater Element
Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the 
first greater element on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:

For any array, rightmost element always has next greater element as -1.
For an array which is sorted in decreasing order, all elements have next greater element as -1.
For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.



  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12      -->     -1
 */
public class _15_Next_GreaterElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* Method 1 (Simple)
	   Use two loops: The outer loop picks all the elements one by one. The inner loop looks for the first greater element for the element
	    picked by the outer loop. If a greater element is found then that element is printed as next, otherwise -1 is printed. 
	      Time Complexity: O(n^2). The worst case occurs when all elements are sorted in decreasing order. */
		/* prints element and NGE pair for all elements of arr[] of size n */
	   static void printNGE(int arr[], int n) 
	   { 
	       int next, i, j; 
	       for (i=0; i<n; i++) 
	       { 
	           next = -1; 
	           for (j = i+1; j<n; j++) 
	           { 
	               if (arr[i] < arr[j]) 
	               { 
	                   next = arr[j]; 
	                   break; 
	               } 
	           } 
	           System.out.println(arr[i]+" -- "+next); 
	       } 
	   } 

	  /*  Method 2 (Using Stack)

	   Push the first element to stack.
	   Pick rest of the elements one by one and follow the following steps in loop.
	   Mark the current element as next.
	   If stack is not empty, compare top element of stack with next.
	   If next is greater than the top element,Pop element from stack. next is the next greater element for the popped element.
	   Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements
	   Finally, push the next in the stack.
	   After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.  */
	   
	   
	   
	   /* Another approach */
	   public int[] larger(int input[]){
	        Deque<Integer> stack = new LinkedList<Integer>();
	        int result[] = new int[input.length];
	        for(int i=0; i < result.length; i++){
	            result[i] = -1;
	        }
	        
	        stack.offerFirst(0);
	        for(int i=1; i < input.length; i++){
	            while(stack.size() > 0){
	                int t = stack.peekFirst();
	                if(input[t] < input[i]){
	                    result[t] = i;
	                    stack.pollFirst();
	                }else{
	                    break;
	                }
	            }
	            stack.offerFirst(i);
	        }
	        return result;
	    }
}
