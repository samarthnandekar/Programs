package Array;

import java.util.HashMap;
import java.util.TreeSet;

/*

Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:- The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Input : arr[] = { 10, 5, 2, 7, 1, 9 },  k = 15
Output : 4
The sub-array is {5, 2, 7, 1}.

https://www.geeksforgeeks.org/longest-sub-array-sum-k/


 */
public class _133_MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr={ 10, 5, 2, 7, 1, 9 };
		int k=15;
		System.out.println(maxSubArrayLen(arr,k));

	}
	
	/*
	   Naive Approach: Consider the sum of all the sub-arrays and return the length of the longest sub-array having sum ‘k’.
	   Time Complexity is of O(n^2).
	 */
	
	
	/*
	 * Approach 2:- 
	   Time Complexity: O(n)
       Auxiliary Space: O(n)       */
	
	static public int maxSubArrayLen(int[] nums, int k) {
	    HashMap<Integer, Integer> map = new HashMap<>();
	    map.put(0, -1);
	    int result = 0;
	    int sum = 0;
	 
	    for(int i=0; i<nums.length; i++){
	        sum += nums[i];
	        if(map.containsKey(sum - k)){
	            result = Math.max(result, i - map.get(sum - k));
	        }
	        map.putIfAbsent(sum, i);
	    }
	 
	    return result;
	}
	
	
	/*  its the different question.   https://www.programcreek.com/2016/08/maximum-sum-of-subarray-close-to-k/
	 *  Given an array, find the maximum sum of subarray close to k but not larger than k.
	 */
	public int getLargestSumCloseToK(int[] arr, int k){
	    int sum=0;
	    TreeSet<Integer> set = new TreeSet<Integer>();
	    int result=Integer.MIN_VALUE;
	    set.add(0);
	 
	    for(int i=0; i<arr.length; i++){
	        sum=sum+arr[i];
	 
	        Integer ceiling = set.ceiling(sum-k);
	        if(ceiling!=null){
	            result = Math.max(result, sum-ceiling);        
	        }
	 
	        set.add(sum);
	    }
	 
	    return result;
	}

}
