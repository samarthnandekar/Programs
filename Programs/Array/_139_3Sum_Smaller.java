package Array;

import java.util.Arrays;
import java.util.*;
/*
 https://leetcode.com/problems/3sum/
 
 15. 3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:- The solution set must not contain duplicate triplets.
Example:- Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
 [[-1, 0, 1],
  [-1, -1, 2]]
--------------------------------------
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
For example, given nums = [-2, 0, 1, 3], and target = 2.
Return 2. Because there are two triplets which sums are less than 2:
[-2, 0, 1]
[-2, 0, 3]

Follow up: Could you solve it in O(n^2) runtime?

*/
public class _139_3Sum_Smaller {

	public static void main(String[] args) {
		
		_139_3Sum_Smaller obj= new _139_3Sum_Smaller();
		int [] nums= {-2, 0, 1, 3};
		int ans=obj.threeSumSmaller(nums,2);
		System.out.println(ans);
	}
	
	
		public int threeSumSmaller(int[] nums, int target) {
		    int L = nums.length;
		    Arrays.sort(nums);
		    int count = 0;
		    for(int i=0; i<L-2; i++) {
		        int lo = i+1;
		        int hi = L-1;
		        while(lo<hi) {
		            if(nums[i] + nums[lo] + nums[hi] < target) {
		                count += hi-lo;
		                lo++;
		            }
		            else
		                hi--;
		        }
		    }
		    return count;
		}
		
		/**
	     * https://leetcode.com/problems/3sum/
	     */
		public List<List<Integer>> threeSum(int[] nums) {
	        Arrays.sort(nums);
	        List<List<Integer>> result = new ArrayList<>();
	        for (int i = 0; i < nums.length - 2; i++) {
	            if (i != 0 && nums[i] == nums[i-1]) {
	                continue;
	            }
	            int start = i + 1;
	            int end = nums.length - 1;
	            while (start < end) {
	                if (nums[i] + nums[start] + nums[end] == 0) {
	                    List<Integer> r = new ArrayList<>();
	                    r.add(nums[i]);
	                    r.add(nums[start]);
	                    r.add(nums[end]);
	                    result.add(r);
	                    start++;
	                    end--;
	                    while(start < nums.length && nums[start] == nums[start - 1]) {
	                        start++;
	                    }
	                    while(end >= 0 && nums[end] == nums[end+1]) {
	                        end--;
	                    }
	                } else if (nums[i] + nums[start] + nums[end] < 0) {
	                    start++;
	                } else {
	                    end--;
	                }
	            }
	        }
	        return result;
	    }
	
}
