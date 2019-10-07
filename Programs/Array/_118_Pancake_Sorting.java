package Array;

import java.util.ArrayList;
import java.util.List;

/*
 Given an an unsorted array, sort the given array. You are allowed to do only following operation on array.

flip(arr, i): Reverse array from 0 to i 
Unlike a traditional sorting algorithm, which attempts to sort with the fewest comparisons possible, the goal is to sort the sequence 
in as few reversals as possible.

The idea is to do something similar to Selection Sort. We one by one place maximum element at the end and reduce the size of current array by one.

Following are the detailed steps. Let given array be arr[] and size of array be n.
1) Start from current size equal to n and reduce current size by one while it’s greater than 1. Let the current size be curr_size. Do following 
for every curr_size
……a) Find index of the maximum element in arr[0..curr_szie-1]. Let the index be ‘mi’
……b) Call flip(arr, mi)
……c) Call flip(arr, curr_size-1)

 */
public class _118_Pancake_Sorting {
	
	/* Reverses arr[0..i] */
	static void flip(int arr[], int i) 
	{ 
	    int temp, start = 0; 
	    while (start < i) 
	    { 
	        temp = arr[start]; 
	        arr[start] = arr[i]; 
	        arr[i] = temp; 
	        start++; 
	        i--; 
	    } 
	} 
	
	// Returns index of the maximum element in arr[0..n-1]  
	static int findMax(int arr[], int n) 
	{ 
	int mi, i; 
	for (mi = 0, i = 0; i < n; ++i) 
	    if (arr[i] > arr[mi]) 
	            mi = i; 
	return mi; 
	}
	 
	static void pancakeSort(int [] arr, int n) 
	{ 
	    // Start from the complete array and one by one  
	    // reduce current size by one 
	    for (int curr_size = n; curr_size > 1; --curr_size) 
	    { 
	        // Find index of the maximum element in arr[0..curr_size-1] 
	        int mi = findMax(arr, curr_size); 
	  
	        // Move the maximum element to end of  current array if 
	        // it's not already at the end 
	        if (mi != curr_size-1) 
	        { 
	            // To move at the end, first move maximum number to beginning  
	            flip(arr, mi); 
	  
	            // Now move the maximum  number to end by reversing current array 
	            flip(arr, curr_size-1); 
	        } 
	    } 
	} 
	  
	static void printArray(int arr[], int n) 
	{ 
	    for (int i = 0; i < n; ++i) 
	        System.out.print(arr[i] +"  "); 
	} 

	public static void main(String [] args)
	{
		int arr[] = {3,2,4,1}; 
		pancakeSort(arr, arr.length);
		printArray(arr,arr.length);
		int arr1[] = {3,2,4,1};
		System.out.println("");
		List<Integer> ans=pancakeSort(arr1);
		for(Integer val:ans)
		{
			System.out.print(val + "   ");
		}
	}
	
	// https://medium.com/@poitevinpm/solution-to-leetcode-problem-969-pancake-sorting-52a697b142fc
	// Second method
	static public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        int curr = A.length;
        while (curr > 0) {
            int ind = indexOf(curr, A);
            if (ind < curr - 1) {
                // put curr at index 0
                flip(ind + 1, A);
                res.add(ind + 1);
                // put curr at index curr - 1
                flip(curr, A);
                res.add(curr);
            }
            curr--;
        }
        return res;
    }
    
    public static int indexOf(int v, int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == v) {
                return i;
            }
        }
        return -1;
    }
    
    public static void flip(int k, int[] A) {
        int p = 0;
        while (k - 1 - p > p) {
            swap(p, k - 1 - p, A);
            p++;
        }
    }
    
    public static void swap(int a, int b, int[] A) {
        int x = A[a];
        A[a] = A[b];
        A[b] = x;
    }
}
