package Dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 Minimum number of squares whose sum equals to given number n
A number can always be represented as a sum of squares of other numbers. Note that 1 is a square and we can always break a number as (1*1 + 1*1 + 1*1 + …). 
Given a number n, find the minimum number of squares that sum to X.

Examples :
Input:  n = 100
Output: 1
100 can be written as 102. Note that 100 can also be written as 52 + 52 + 52 + 52, but this
representation requires 4 squares.

Input:  n = 6
Output: 3

------------------------------
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 * Solution 1 - Using DP similar to coin change problem with infinite supply
 * Solution 2 - Using a BFS. Put all perfect squares in queue. Then considering each as a node try adding
 * another perfect square and see if we can get n. Keep doing this in BFS fashion till you hit the number.

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.


Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

 */
public class _50_MinimumNumberOfPerfectSquares {

	public int numSquaresUsingDP(int n) {
        int count = (int)Math.ceil(Math.sqrt(n));

        int[] T = new int[n + 1];

        T[0] = 0;

        for (int i = 1; i < T.length; i++) {
            T[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= count; j++) {
                if (i < j*j) {
                    break;
                }
                T[i] = Math.min(T[i], T[i - j*j] + 1);
            }
        }
        return T[n];
    }
	
	public int numSquaresUsingBFS(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        int i = 1;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        while (true) {
            int square = i * i;
            if (square == n) {
                return 1;
            }
            if (square > n) {
                break;
            }
            perfectSquares.add(square);
            queue.offer(square);
            visited.add(square);
            i++;
        }
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int j = 0; j < size; j++) {
                int node = queue.poll();
                for (int square : perfectSquares) {
                    int sum = node + square;
                    if (sum == n) {
                        return distance;
                    } else if (!visited.contains(sum)) {
                        visited.add(sum);
                        queue.add(sum);
                    } else if (sum > n) {
                        break;
                    }
                }
            }
        }
        return distance;
    }
	
	public static void main(String []args)
	{
		_50_MinimumNumberOfPerfectSquares obj= new _50_MinimumNumberOfPerfectSquares();
		int ans=obj.numSquaresUsingDP(9);
		System.out.println(ans);
		System.out.println("-------------------------");
		 ans=obj.numSquaresUsingBFS(12);
		System.out.println(ans);
	}
}
