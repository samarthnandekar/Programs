package Array;

/*
Link:- https://www.geeksforgeeks.org/find-the-missing-number/

Find the Missing Number
You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in the list. 
One of the integers is missing in the list. Write an efficient code to find the missing integer.

Example :
Input: arr[] = {1, 2, 4,, 6, 3, 7, 8}
Output: 5

Input: arr[] = {1, 2, 3, 5}
Output: 4

*/


/*

METHOD 1(Use sum formula)
Algorithm:-
1. Get the sum of numbers which is total = n*(n+1)/2
2. Subtract all the numbers from sum and
   you will get the missing number
   Time Complexity: O(n)

 */
public class _3_MissingNumber {

	 /* program to test above function */
    public static void main(String args[]) 
    { 
        int a[] = { 1, 2, 4, 5, 6 }; 
        int miss = getMissingNo(a, 5); 
        System.out.println(miss); 
    } 
	static int getMissingNo(int a[], int n) 
    { 
        int i, total; 
        total = (n + 1) * (n + 2) / 2; 
        for (i = 0; i < n; i++) 
            total -= a[i]; 
        return total; 
    } 
  
   
}
