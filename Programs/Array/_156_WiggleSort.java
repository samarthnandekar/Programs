package Array;

import java.util.Arrays;

/*
  * Convert an unsorted array into an array of form num[0] < num[1] > nums[2] < num[3]....
 * 
 * Time complexity O(n) - This depends on KthElementInArray time
 * Space complexity O(1)
 *
 * https://leetcode.com/problems/wiggle-sort/
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 
324. Wiggle Sort II
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:  Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].

Example 2: Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].

Note:You may assume all input has valid answer.
Follow Up:Can you do it in O(n) time and/or in-place with O(1) extra space?

*/

public class _156_WiggleSort {
	 //looking for nums[0] < nums[1] > nums[2] < nums[3] and so on.
    public void wiggleSort2(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int k = arr.length/2;
        _89_KthElementInArray kthElementInArray = new _89_KthElementInArray();
        kthElementInArray.kthElement(arr, k);

        int mid = arr[k];
        int n = arr.length;
        int i = 0, j = 0;
        k = n - 1;
        while (j <= k) {
            if (arr[next(j, n)] > mid) {
                swap(arr, next(i++, n), next(j++, n));
            }
            else if (arr[next(j, n)] < mid) {
                swap(arr, next(j, n), next(k--, n));
            }
            else {
                j++;
            }
        }
    }

    //in this version we are looking for nums[0] <= nums[1] >= nums[2] <= nums[3] and so on.
    public void wiggleSort1(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (flag) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
            flag = !flag;
        }
    }

    private int next(int index, int n) {
        return (2*index + 1) % (n | 1);
    }

    private void swap(int arr[],int low,int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

    public static void main(String args[]) {
    	_156_WiggleSort ws = new _156_WiggleSort();
        int input[] =  {6, 2, 1, 6, 8, 9, 6};
        ws.wiggleSort2(input);
        System.out.print(Arrays.toString(input));
    }
}
