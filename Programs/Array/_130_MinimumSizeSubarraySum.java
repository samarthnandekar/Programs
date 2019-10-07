package Array;

/*
 
 Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of 
 which the sum ≥ s. If there isn't one, return 0 instead.

Example: 
Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2

Explanation: the subarray [4,3] has the minimal length under the problem constraint.

Follow up:If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

facebook;

 */

public class _130_MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int arr1[] = {1, 4, 45, 6, 10, 19}; 
        int x = 51; 
        int n1 = arr1.length; 
        int res1 = smallestSubWithSum(arr1, n1, x); 
        if (res1 == n1+1) 
            System.out.println("Not Possible"); 
         else
            System.out.println(res1);

        int res2 = smallestSubWithSum_2(arr1, n1, x);
        System.out.println(res2);
        
        int arr2[] = {3,2,3,1,2,4,3};
        int res3 = smallestSubWithSum_2(arr2, arr2.length, 9);
        System.out.println(res3);
        
	}
	
	/*
	 A simple solution is to use two nested loops. The outer loop picks a starting element, the inner loop considers all elements
	 (on right side of current start) as ending element. Whenever sum of elements between current start and end becomes more than
	 the given number, update the result if current length is smaller than the smallest length so far. 
	 Following is the implementation of simple approach.
	 Time Complexity: Time complexity of the above approach is clearly O(n2).

	 */
	
	// Returns length of smallest subarray with sum greater than x. If there is no subarray with given sum, then returns n+1 
    static int smallestSubWithSum(int arr[], int n, int x) 
    { 
        //  Initilize length of smallest subarray as n+1 
        int min_len = n + 1; 
  
        // Pick every element as starting point 
        for (int start = 0; start < n; start++) 
        { 
            // Initialize sum starting with current start 
            int curr_sum = arr[start]; 
  
            // If first element itself is greater 
            if (curr_sum > x) 
                return 1; 
  
            // Try different ending points for curremt start 
            for (int end = start + 1; end < n; end++) 
            { 
                // add last element to current sum 
                curr_sum += arr[end]; 
  
                // If sum becomes more than x and length of 
                // this subarray is smaller than current smallest 
                // length, update the smallest length (or result) 
                if (curr_sum >= x && (end - start + 1) < min_len) 
                    min_len = (end - start + 1); 
            } 
        } 
        return min_len; 
    } 

    /*
     Efficient Solution: This problem can be solved in O(n) time using the idea used in this post.
 
     */

    // Returns length of smallest subarray with sum greater than x. If there is no subarray with given sum, then returns n+1 
    static int smallestSubWithSum_2(int arr[], int n, int x)  
    { 
        // Initialize current sum and minimum length 
        int curr_sum = 0, min_len = n + 1; 
  
        // Initialize starting and ending indexes 
        int start = 0, end = 0; 
        while (end < n)  
        { 
            // Keep adding array elements while current sum is smaller than x 
            while (curr_sum <= x && end < n) 
                curr_sum += arr[end++]; 
  
            // If current sum becomes greater than x. 
            while (curr_sum >= x && start < n)  
            { 
                // Update minimum length if needed 
                if (end - start < min_len) 
                    min_len = end - start; 
  
                // remove starting elements 
                curr_sum -= arr[start++]; 
            } 
        } 
        return min_len; 
    } 

    /*
     How to handle negative numbers?
     The above solution may not work if input array contains negative numbers. For example arr[] = {- 8, 1, 4, 2, -6}. 
     To handle negative numbers, add a condition to ignore subarrays with negative sums.
     */

 // Returns length of smallest subarray with sum greater  
 // than x. If there is no subarray with given sum, then returns n+1 
 static int smallestSubWithSum_3(int arr[], int n, int x) 
 { 
     // Initialize current sum and minimum length 
     int curr_sum = 0, min_len = n + 1; 
   
     // Initialize starting and ending indexes 
     int start = 0, end = 0; 
     while (end < n) 
     { 
         // Keep adding array elements while current sum is smaller than x 
         while (curr_sum <= x && end < n) 
         { 
             // Ignore subarrays with negative sum if x is positive. 
             if (curr_sum <= 0 && x > 0) 
             { 
                 start = end; 
                 curr_sum = 0; 
             } 
             curr_sum += arr[end++]; 
         } 
   
         // If current sum becomes greater than x. 
         while (curr_sum > x && start < n) 
         { 
             // Update minimum length if needed 
             if (end - start < min_len) 
                 min_len = end - start; 
   
             // remove starting elements 
             curr_sum -= arr[start++]; 
         } 
     } 
     return min_len; 
   }
 
}
