package Optimized;

import java.util.Arrays;

/*
For each element in 1st array count elements less than or equal to it in 2nd array | Set 2
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

Examples:

Input : arr1[] = [1, 2, 3, 4, 7, 9]
        arr2[] = [0, 1, 2, 1, 1, 4]
Output : [4, 5, 5, 6, 6, 6]

Input : arr1[] = [5, 10, 2, 6, 1, 8, 6, 12]
        arr2[] = [6, 5, 11, 4, 2, 3, 7]
Output : [4, 6, 1, 5, 0, 6, 5, 7]


Naive Approach: Using two loops, outer loop for elements of array arr1[] and inner loop for elements of array arr2[]. 
                Then for each element of arr1[], count elements less than or equal to it in arr2[].
Time complexity: O(m * n), considering arr1[] and arr2[] are of sizes m and n respectively.

Efficient Approach: Sort the elements of 2nd array, i.e., array arr2[]. Then perform a modified binary search on array arr2[]. 
                    For each element x of array arr1[], find the last index of the largest element smaller than or equal to x
                    in sorted array arr2[].
Time Complexity: O(mlogn + nlogn), considering arr1[] and arr2[] are of sizes m and n respectively.                    

 */
public class _1_Ele_in_1st_array_count_ele_less_than {
	
	
	// method returns the index of largest element  
    // smaller than equal to 'x' in 'arr'. For duplicates 
    // it returns the last index of occurrence of required 
    // element. If no such element exits then it returns -1.  
    static int binary_search(int arr[], int l, int h, int x) 
    { 
        while (l <= h) 
        { 
            int mid = (l+h) / 2; 
       
            // if 'x' is greater than or equal to arr[mid], then search in arr[mid+1...h] 
            if (arr[mid] <= x) 
                l = mid + 1; 
       
            // else search in arr[l...mid-1]     
            else
                h = mid - 1;     
        } 
           
        // required index 
        return h; 
    } 
       
    // method to count for each element in 1st array, elements less than or equal to it in 2nd array 
    static void countEleLessThanOrEqual(int arr1[], int arr2[],  
                                 int m, int n) 
    { 
        // sort the 2nd array 
        Arrays.sort(arr2); 
           
        // for each element of 1st array 
        for (int i=0; i<m; i++) 
        { 
            // last index of largest element smaller than or equal to x 
            int index = binary_search(arr2, 0, n-1, arr1[i]); 
               
            // required count for the element arr1[i] 
            System.out.print((index+1) + " "); 
        } 
    } 
	
	public static void main(String[] args) 
    { 
        int arr1[] = {-1,1, 2, 3, 4, 7, 9}; 
        int arr2[] = {0, 1, 2, 1, 1,3, 4}; 
          
        countEleLessThanOrEqual(arr1, arr2, arr1.length, arr2.length); 
    } 

}
