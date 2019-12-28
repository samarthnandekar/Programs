package Array;

import java.util.HashSet;

/*
 https://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 
Check if a given array contains duplicate elements within k distance from each other
Given an unsorted array that may contain duplicates. Also given a number k which is smaller than size of array. Write a function that returns true if array contains duplicates within k distance.
Examples:

Input: k = 3, arr[] = {1, 2, 3, 4, 1, 2, 3, 4}
Output: false
All duplicates are more than k distance away.

Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Solution:-
A Simple Solution is to run two loops. The outer loop picks every element ‘arr[i]’ as a starting element, 
the inner loop compares all elements which are within k distance of ‘arr[i]’. The time complexity of this solution is O(kn).

We can solve this problem in Θ(n) time using Hashing. The idea is to one by add elements to hash. 
We also remove elements which are at more than k distance from current element. Following is detailed algorithm.

1) Create an empty hashtable.
2) Traverse all elements from left from right. Let the current element be ‘arr[i]’
….a) If current element ‘arr[i]’ is present in hashtable, then return true.
….b) Else add arr[i] to hash and remove arr[i-k] from hash if i is greater than or equal to k
 */
public class _67_ContainsDuplicateInKDistance {

	static boolean checkDuplicatesWithinK(int arr[], int k) 
    { 
        // Creates an empty hashset 
        HashSet<Integer> set = new HashSet<>(); 
  
        // Traverse the input array 
        for (int i=0; i<arr.length; i++) 
        { 
            // If already present n hash, then we found a duplicate within k distance 
            if (set.contains(arr[i])) 
               return true; 
  
            // Add this item to hashset 
            set.add(arr[i]); 
  
            // Remove the k+1 distant item 
            if (i >= k) 
              set.remove(arr[i-k]); 
        } 
        return false; 
    } 
  
    // Driver method to test above method 
    public static void main (String[] args) 
    { 
        int arr[] = {10, 5, 3, 4, 3, 5, 6}; 
        if (checkDuplicatesWithinK(arr, 3)) 
           System.out.println("Yes"); 
        else
           System.out.println("No"); 
    }     
}
