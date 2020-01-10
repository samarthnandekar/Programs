package Array;

import java.util.Arrays;

/*
360. Sort Transformed Array
Given a sorted array of integers nums and integer values a, b and c. Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
Result: [-23, -5, 1, 7]

*/

public class _153_SortTransformedArray {

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[nums.length];
        int index = (a >= 0 ? nums.length - 1 : 0);
        while (start <= end) {
            int x = apply(nums[start], a, b, c);
            int y = apply(nums[end], a, b, c);
            boolean condition = (a >= 0 ? x >= y : x <= y);
            if (condition) {
                result[index] = x;
                start++;
            } else {
                result[index] = y;
                end--;
            }
            index = index + (a >= 0 ? -1 : 1);
        }
        return result;
    }

    private int apply(int x, int a, int b, int c) {
        return a*x*x + b * x + c;
    }
    
	public static void main(String[] args) {
	
		int [] nums = {-4, -2, 2, 4};
		int a = 1, b = 3, c = 5;
		_153_SortTransformedArray obj= new _153_SortTransformedArray();
		int ans[]=obj.sortTransformedArray(nums,a,b,c);
		Arrays.stream(ans).forEach(System.out::println);
	}

}
