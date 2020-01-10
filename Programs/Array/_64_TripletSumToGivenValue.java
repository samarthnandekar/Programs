package Array;

import java.util.Arrays;
import java.util.HashSet;

/*
 https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 
 Find a triplet that sum to a given value
Given an array and a value, find if there is a triplet in array whose sum is equal to the given value. If there is such a triplet present in array, 
then print the triplet and return true. Else return false. For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24, then there 
is a triplet (12, 3 and 9) present in array whose sum is 24.
 
 */


public class _64_TripletSumToGivenValue {

	/*
	 Method 1 (Naive)
     A simple method is to generate all possible triplets and compare the sum of every triplet with the given value.
     The following code implements this simple method using three nested loops.
     Time Complexity : O(n^3)
	 */
	
	// returns true if there is triplet with sum equal to 'sum' present in A[]. Also, prints the triplet 
    boolean find3Numbers_1(int A[], int arr_size, int sum) 
    { 
        int l, r;  
        // Fix the first element as A[i] 
        for (int i = 0; i < arr_size - 2; i++) { 
  
            // Fix the second element as A[j] 
            for (int j = i + 1; j < arr_size - 1; j++) { 
  
                // Now look for the third number 
                for (int k = j + 1; k < arr_size; k++) { 
                    if (A[i] + A[j] + A[k] == sum) { 
                        System.out.print("Triplet is " + A[i] + ", " + A[j] + ", " + A[k]); 
                        return true; 
                    } 
                } 
            } 
        }   
        // If we reach here, then no triplet was found 
        return false; 
    } 
    
    /*
     Method 2 (Use Sorting)
		Time complexity of the method 1 is O(n^3). The complexity can be reduced to O(n^2) by sorting the array first, and then using method 1 
		of this post in a loop.
		1) Sort the input array.
		2) Fix the first element as A[i] where i is from 0 to array size – 2. After fixing the first element of triplet, find the other two 
		elements using method 1 of this post.
     */
    
    boolean find3Numbers_2(int A[], int arr_size, int sum) 
    { 
        int l, r; 
  
        /* Sort the elements */
        //quickSort(A, 0, arr_size - 1); 
        Arrays.sort(A);
        /* Now fix the first element one by one and find the 
           other two elements */
        for (int i = 0; i < arr_size - 2; i++) { 
  
            // To find the other two elements, start two index variables 
            // from two corners of the array and move them toward each 
            // other 
            l = i + 1; // index of the first element in the remaining elements 
            r = arr_size - 1; // index of the last element 
            while (l < r) { 
                if (A[i] + A[l] + A[r] == sum) { 
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]); 
                    return true; 
                } 
                else if (A[i] + A[l] + A[r] < sum) 
                    l++; 
  
                else // A[i] + A[l] + A[r] > sum 
                    r--; 
            } 
        } 
  
        // If we reach here, then no triplet was found 
        return false; 
    } 
    
    /*
    Method 3 (Hashing Based Solution)   
    */
    // returns true if there is triplet with sum equal to 'sum' present in A[]. Also, prints the triplet 
    static boolean find3Numbers(int A[], 
                                int arr_size, int sum) 
    { 
        // Fix the first element as A[i] 
        for (int i = 0; i < arr_size - 2; i++) { 
  
            // Find pair in subarray A[i+1..n-1] with sum equal to sum - A[i] 
            HashSet<Integer> s = new HashSet<Integer>(); 
            int curr_sum = sum - A[i]; 
            for (int j = i + 1; j < arr_size; j++) { 
                if (s.contains(curr_sum - A[j]) && curr_sum - A[j] != (int)s.toArray()[s.size() - 1]) { 
                    System.out.printf("Triplet is %d, %d, %d", A[i], A[j], curr_sum - A[j]); 
                    return true; 
                } 
                s.add(A[j]); 
            } 
        }   
        // If we reach here, then no triplet was found 
        return false; 
    } 
  
}
