package Array;

import java.util.Arrays;

/*
 Count triplets with sum smaller than a given value
Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3) 

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 12
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
               (1, 4, 5)
               
 */
public class _155_TripletSumLessThanTotal {

	/* 
	   Simple approach, Time complexity of above solution is O(n3). An Efficient Solution can count triplets in O(n2) by sorting the array first, and then using method 1 of this post in a loop.
	 */
	 static int countTriplets(int n, int sum,int []arr) 
	    { 
	        // Initialize result 
	        int ans = 0; 
	       
	        // Fix the first element as A[i] 
	        for (int i = 0; i < n-2; i++) 
	        { 
	           // Fix the second element as A[j] 
	           for (int j = i+1; j < n-1; j++) 
	           { 
	               // Now look for the third number 
	               for (int k = j+1; k < n; k++) 
	                   if (arr[i] + arr[j] + arr[k] < sum) 
	                       ans++; 
	           } 
	        } 
	       
	        return ans; 
	    } 
	 
	 // Time complexity O(n2)
	public int findAllTriplets(int input[], int total) {
        Arrays.sort(input);
        int result = 0;
        for (int i = 0; i < input.length - 2; i++) {
            int j = i + 1;
            int k = input.length - 1;

            while (j < k) {
                if (input[i] + input[j] + input[k] >= total) {
                    k--;
                } else {
                    result += k - j;
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int input[] = {5, 1, 3, 4, 7};
        _155_TripletSumLessThanTotal tt = new _155_TripletSumLessThanTotal();
        System.out.print(tt.findAllTriplets(input, 12));
    }

}
