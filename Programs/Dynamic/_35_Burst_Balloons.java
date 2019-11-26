package Dynamic;

/*
 312. Burst Balloons
 
 Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:- You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
       0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:- Input: [3,1,5,8]  Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 
 Time complexity O(n^3)
 Space complexity O(n^2)

*/

public class _35_Burst_Balloons {

	public int maxCoinsBottomUpDp(int[] nums) {

        int T[][] = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    //leftValue/rightValue is initially 1. If there is element on left/right of k then left/right value will take that value.
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i-1];
                    }
                    if (j != nums.length -1) {
                        rightValue = nums[j+1];
                    }

                    //before is initially 0. If k is i then before will stay 0 otherwise it gets value T[i][k-1]
                    //after is similarly 0 initially. if k is j then after will stay 0 other will get value T[k+1][j]
                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = T[i][k-1];
                    }
                    if (j != k) {
                        after = T[k+1][j];
                    }
                    T[i][j] = Math.max(leftValue * nums[k] * rightValue + before + after,T[i][j]);
                }
            }
        }
        return T[0][nums.length - 1];
    }

    public static void main(String args[]) {
    	_35_Burst_Balloons bb = new _35_Burst_Balloons();
        int input[] = {2, 4, 3, 5};
        System.out.println(bb.maxCoinsBottomUpDp(input));
        
        int input1[] = {3, 1, 5, 8};
        System.out.println(bb.maxCoinsBottomUpDp(input1));
    }
}
