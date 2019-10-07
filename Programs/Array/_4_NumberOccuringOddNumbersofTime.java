package Array;
/*
 https://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 
Find the Number Occurring Odd Number of Times
Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. 
Find the number in O(n) time & constant space.

Examples :
Input : arr = {1, 2, 3, 2, 3, 1, 3}
Output : 3

Input : arr = {5, 7, 2, 7, 5, 2, 5}
Output : 5

 */

/*
 Solution 1:-
 A Simple Solution is to run two nested loops. The outer loop picks all elements one by one and inner loop counts number of occurrences
 of the element picked by outer loop. Time complexity of this solution is O(n2).
 
 Solution 2:-
 A Better Solution is to use Hashing. Use array elements as key and their counts as value. Create an empty hash table. 
 One by one traverse the given array elements and store counts. Time complexity of this solution is O(n). But it requires
 extra space for hashing.


 */
public class _4_NumberOccuringOddNumbersofTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
