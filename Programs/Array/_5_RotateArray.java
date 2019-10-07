package Array;

/*
Link:- https://leetcode.com/problems/rotate-array/
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Note:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

 */

/*

*****  METHOD 1 (Using temp array) ***** 

Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
1) Store d elements in a temp array
   temp[] = [1, 2]
2) Shift rest of the arr[]
   arr[] = [3, 4, 5, 6, 7, 6, 7]
   
3) Store back the d elements
   arr[] = [3, 4, 5, 6, 7, 1, 2]
   
Time complexity : O(n)
Auxiliary Space : O(d)


*****  METHOD 2 (Rotate one by one) *****
leftRotate(arr[], d, n)
start
  For i = 0 to i < d
    Left rotate all elements of arr[] by one`
end

Time complexity : O(n * d)
Auxiliary Space : O(1)

*****  METHOD 3 (A Juggling Algorithm) *****
This is an extension of method 2. Instead of moving one by one, divide the array in different sets
where number of sets is equal to GCD of n and d and move the elements within sets.
If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only, we just start with
temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.

Time complexity : O(n)
Auxiliary Space : O(1)

*/
public class _5_RotateArray {

	public static void main(String[] args) {
		_5_RotateArray rotate = new _5_RotateArray(); 
		 int arr[] = { 1, 2, 3, 4, 5, 6, 7 }; 
	        rotate.leftRotate(arr, 2, arr.length); 
	        rotate.printArray(arr, arr.length); 
	      
	}
	
	/*   METHOD 2 (Rotate one by one) --> Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n) 
    { 
        for (int i = 0; i < d; i++) 
            leftRotatebyOne(arr, n); 
    } 
  
    void leftRotatebyOne(int arr[], int n) 
    { 
        int i, temp; 
        temp = arr[0]; 
        for (i = 0; i < n - 1; i++) 
            arr[i] = arr[i + 1]; 
        arr[i] = temp; 
    } 
  
    /* utility function to print an array */
    void printArray(int arr[], int n) 
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
    } 
    
    
}
