package Array;

import java.util.Arrays;
import java.util.Stack;

/*
https://leetcode.com/problems/create-maximum-number/

321. Create Maximum Number
Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two.
The relative order of the digits from the same array must be preserved. Return an array of the k digits.
Note: You should try to optimize your time and space complexity.

Example 1:
Input:  nums1 = [3, 4, 6, 5]
        nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output: [9, 8, 6, 5, 3]

Example 2:
Input:nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
Output:[6, 7, 6, 0, 4]

Example 3:
Input:nums1 = [3, 9]
      nums2 = [8, 9]
k = 3
Output: [9, 8, 9]
 
 

 */
public class _142_Create_Maximum_Number {

	public static void main(String[] args) {
	
		int []nums1 = {3, 4, 6, 5};
		int []nums2 = {9, 1, 2, 5, 8, 3};
		_142_Create_Maximum_Number obj= new _142_Create_Maximum_Number();
		int [] ans=obj.maxNumber(nums1,nums2,nums2.length-1);
		
		for(int i=0;i<ans.length;i++)
		{
			System.out.print(ans[i]+ " ");
		}
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // edge cases

        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] maxArray = new int[k];
        for (int i = Math.max(0, k-n2); i <= k && i <= n1; i++)
        {
            int[] arr1 = selectK(nums1, i);
            int[] arr2 = selectK(nums2, k-i);
            int[] mergeArr = merge(arr1, arr2);
            if (isGreater(mergeArr, 0, maxArray, 0)) {
                maxArray = mergeArr;
            }
        }

        return maxArray;
    }
    private int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1+n2];
        int i = 0, i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            res[i++] = isGreater(nums1, i1, nums2, i2) ? nums1[i1++] : nums2[i2++];
        }
        while (i1 < n1) res[i++] = nums1[i1++];
        while (i2 < n2) res[i++] = nums2[i2++];
        return res;
    }
    private boolean isGreater(int[] nums1, int i1, int[] nums2, int i2) {
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] > nums2[i2]) return true;
            if (nums1[i1] < nums2[i2]) return false;
            i1++; i2++;
        }
        if (i1 < nums1.length) return true;
        else return false;
    }
    private int[] selectK(int[] nums, int k) {
        int[] res = new int[k];
        Stack<Integer> stack = new Stack<>();
        int i = 0, delete = nums.length - k;
        for (int j = 0; j < nums.length; j++) {
            while (i > 0 && nums[j] > res[i-1] && nums.length - j + i > k) i--;
            if (i < res.length) res[i++] = nums[j];
        }
        return res;
    }

}
