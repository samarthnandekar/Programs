package Array;

/*
 Remove Duplicates from Sorted Array
https://leetcode.com/problems/remove-duplicates-from-sorted-array/


Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.

Clarification:
Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/

public class _124_RemoveDuplicates_From_Sorted_Array {

	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5,5}; 
        int n = arr.length; 
          
        n = removeDuplicates_2(arr, n); 
   
        // Print updated array 
        for (int i=0; i<n; i++) 
           System.out.print(arr[i]+" "); 

	}

	
	/*method 1
	Method 1: (Using extra space)

	Create an auxiliary array temp[] to store unique elements.
	Traverse input array and one by one copy unique elements of arr[] to temp[]. Also keep track of count of unique elements. Let this count be j.
	Copy j elements from temp[] to arr[] and return j
	*/
	// Function to remove duplicate elements This function returns new size of modified array. 
    static int removeDuplicates(int arr[], int n) 
    { 
        // Return, if array is empty or contains a single element 
        if (n==0 || n==1) 
            return n; 
       
        int[] temp = new int[n]; 
          
        // Start traversing elements 
        int j = 0; 
        for (int i=0; i<n-1; i++) 
            // If current element is not equal to next element then store that current element 
            if (arr[i] != arr[i+1]) 
                temp[j++] = arr[i]; 
          
        // Store the last element as whether it is unique or repeated, it hasn't stored previously 
        temp[j++] = arr[n-1];    
          
        // Modify original array 
        for (int i=0; i<j; i++) 
            arr[i] = temp[i]; 
       
        return j; 
    }
    /*
     * Method 2: (Constant extra space)
     Function to remove duplicate elements, This function returns new size of modified array. 
     
     Time Complexity : O(n)
     Auxiliary Space : O(1)
     */

    static int removeDuplicates_2(int arr[], int n) 
    { 
        if (n == 0 || n == 1) 
            return n; 
       
        // To store index of next unique element 
        int j = 0; 
       
        // Doing same as done in Method 1 Just maintaining another updated index i.e. j 
        for (int i = 0; i < n-1; i++) 
            if (arr[i] != arr[i+1]) 
                arr[j++] = arr[i]; 
       
        arr[j++] = arr[n-1]; 
       
        return j; 
    }
}
