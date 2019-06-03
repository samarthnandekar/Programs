package Backtracking;
/*
 https://www.geeksforgeeks.org/generate-all-the-binary-strings-of-n-bits/
  
 Generate all the binary strings of N bits
Given a positive integer number N. The task is to generate all the binary strings of N bits. These binary strings should be in ascending order.

Examples:

Input: 2
Output:
0 0
0 1
1 0
1 1

Input: 3
Output:
0 0 0
0 0 1
0 1 0
0 1 1
1 0 0
1 0 1
1 1 0
1 1 1

Approach: The idea is to try every permutation. For every position, there are 2 options, either ‘0’ or ‘1’. 
Backtracking is used in this approach to try every possibility/permutation.

*/
public class _2_Binary_Strings_Of_N_Bits 
{

	static void printTheArray(int arr[], int n) 
	{ 
	    for (int i = 0; i < n; i++)  
	    { 
	        System.out.print(arr[i]+" "); 
	    } 
	    System.out.println(); 
	} 
	  
	// Function to generate all binary strings 
	static void generateAllBinaryStrings(int n, int arr[], int i) 
	{ 
	    if (i == n)  
	    { 
	        printTheArray(arr, n); 
	        return; 
	    } 
	  
	    // First assign "0" at ith position and try for all other permutations for remaining positions 
	    arr[i] = 0; 
	    generateAllBinaryStrings(n, arr, i + 1); 
	  
	    // And then assign "1" at ith position and try for all other permutations for remaining positions 
	    arr[i] = 1; 
	    generateAllBinaryStrings(n, arr, i + 1); 
	} 
	  
	// Driver Code 
	public static void main(String args[]) 
	{ 
	    int n = 2; 
	  
	    int[] arr = new int[n]; 
	  
	    // Print all binary strings 
	    generateAllBinaryStrings(n, arr, 0); 
	} 
}
