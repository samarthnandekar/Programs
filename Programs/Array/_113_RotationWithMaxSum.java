package Array;

/*
Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed
Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want. Return the maximum possbile 
of summation of i*arr[i].

Input: arr[] = {1, 20, 2, 10}
Output: 72
We can 72 by rotating array twice.
{2, 10, 1, 20}
20*3 + 1*2 + 10*1 + 2*0 = 72

 */
public class _113_RotationWithMaxSum {

	/* A Simple Solution is to find all rotations one by one, check sum of every rotation and return the maximum sum.
	  Time complexity of this solution is O(n2). */
	
	// Efficient solution Time complexity - O(n)  and Space complexity - O(1)
	int maxSum(int input[]) {
        int arrSum = 0;
        int rotationSum = 0;
        for (int i =0; i < input.length; i++) {
            arrSum += input[i];
            rotationSum += i*input[i];
        }

        int maxRotationSum = rotationSum;

        for (int i = 1; i < input.length; i++) {
            rotationSum += input.length*input[i - 1] - arrSum;
            maxRotationSum = Math.max(maxRotationSum, rotationSum);
        }
        return maxRotationSum;
    }

    public static void main(String args[]) {
        int input[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        _113_RotationWithMaxSum rms = new _113_RotationWithMaxSum();
        System.out.print(rms.maxSum(input));
    }
}
