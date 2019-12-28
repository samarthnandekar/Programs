package Array;

/*
 https://leetcode.com/problems/increasing-triplet-subsequence/
 
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

334. Increasing Triplet Subsequence

Formally the function should:

Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
 
 */

public class _87_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int T[] = new int[3];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < len; j++) {
                if (T[j] >= nums[i]) {
                    T[j] = nums[i];
                    found = true;
                    break;
                }
            }
            if (!found) {
                T[len++] = nums[i];
            }
            if (len == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
    	_87_IncreasingTripletSubsequence tripletSubsequence = new _87_IncreasingTripletSubsequence();
        int input[] = {9, 10, 8, 6, 7,5,6,2,4};
        System.out.print(tripletSubsequence.increasingTriplet(input));
    }
}