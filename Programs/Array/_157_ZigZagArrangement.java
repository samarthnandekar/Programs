package Array;

import java.util.Arrays;

/*
 http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 
 Convert array into Zig-Zag fashion
Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time.
The converted array should be in form a < b > c < d > e < f.

Example:
Input: arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input: arr[] = {1, 4, 3, 2}
Output: arr[] = {1, 4, 2, 3}

 */
public class _157_ZigZagArrangement {

	 public void rearrange(int input[]) {
	        boolean isLess = true;
	        for (int i = 0; i < input.length - 1; i++) {
	            if(isLess) {
	                if (input[i] > input[i+1]) {
	                    swap(input, i, i+1);
	                }
	            } else {
	                if (input[i] < input[i+1]) {
	                    swap(input, i, i+1);
	                }
	            }
	            isLess = !isLess;
	        }
	    }

	    private void swap(int input[], int i, int j) {
	        int t = input[i];
	        input[i] = input[j];
	        input[j] = t;
	    }

	    public static void main(String args[]) {
	        int input[] = {4, 3, 2, 6, 7, 1, 9};
	        _157_ZigZagArrangement zza = new _157_ZigZagArrangement();
	        zza.rearrange(input);
	        Arrays.stream(input).forEach(i -> System.out.print(i + " "));
	    }
}
