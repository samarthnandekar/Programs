package Array;

/*  Shortest Subarray with Sum at Least K
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
If there is no non-empty subarray with sum at least K, return -1.
Input: A = [1], K = 1           Output: 1  
Input: A = [1,2], K = 4         Output: -1   */

public class _115_SmallestSubarrayWithAtleastKSum {

	public int shortestSubarray(int[] A, int K) {
        int[] skip = new int[A.length];

        int sum = 0;
        int start = A.length - 1;
        skip[A.length - 1] = 1;
        for (int i = A.length - 1; i > 0; i--) {
            skip[i - 1] = 1;
            sum += A[i];
            if (sum <= 0) {
                skip[i - 1] = start - i + 1;
            } else {
                start = i;
                sum = 0;
            }
        }

        start = 0;
        int end = 0;
        sum = 0;
        int min = Integer.MAX_VALUE;
        while (end < A.length) {
            sum += A[end++];
            while (start <= end && sum >= K) {
                min = Math.min(end - start, min);
                for (int j = start; j < start + skip[start]; j++) {
                    sum -= A[j];
                }
                start = start + skip[start];
            }
            if (sum <= 0) {
                start = end;
                sum = 0;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
	 public  static void main(String[] args) {
	        int[] input = {1, 3, -1, -4, -2, 3, 4, -5, -1, 8};
	        _115_SmallestSubarrayWithAtleastKSum ss = new _115_SmallestSubarrayWithAtleastKSum();
	        ss.shortestSubarray(input, 8);
	    }
	}

