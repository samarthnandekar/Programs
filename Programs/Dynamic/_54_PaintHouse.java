package Dynamic;
/*


 There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses
 have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting
house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

https://www.programcreek.com/2014/05/leetcode-paint-house-java/

https://www.cnblogs.com/grandyang/p/5319384.html
https://www.cnblogs.com/grandyang/p/5322870.html

https://www.programcreek.com/2014/05/leetcode-paint-house-ii-java/
https://yeqiuquan.blogspot.com/2017/06/265-paint-house-ii.html
 */
public class _54_PaintHouse {


	public int minCostBottomUpPaintHouse2(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }

        for (int i = 1; i < costs.length; i++) {
            Pair p = findMinSecondMin(dp[i - 1]);
            for (int j = 0; j < costs[0].length; j++) {
                dp[i][j] = costs[i][j];
                if (j == p.minIndex) {
                    dp[i][j] += dp[i-1][p.secondMinIndex];
                } else {
                    dp[i][j] += dp[i-1][p.minIndex];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }

	class Pair {
        int minIndex;
        int secondMinIndex;
    }

    private Pair findMinSecondMin(int[] input) {
        int minIndex;
        int secondMinIndex;
        if (input[0] < input[1]) {
            minIndex = 0;
            secondMinIndex = 1;
        } else {
            minIndex = 1;
            secondMinIndex = 0;
        }
        for (int i = 2; i < input.length; i++) {
            if (input[i] < input[minIndex]) {
                secondMinIndex = minIndex;
                minIndex = i;
            } else if (input[i] < input[secondMinIndex]) {
                secondMinIndex = i;
            }
        }
        Pair p = new Pair();
        p.minIndex = minIndex;
        p.secondMinIndex = secondMinIndex;
        return p;
    }

    public static void main(String args[]) {
    	_54_PaintHouse ph = new _54_PaintHouse();
        int[][] input = {{1, 2, 1}, 
        		        {1, 4, 5},
        		        {2, 6, 1}, 
        		        {3, 3, 2}};
        System.out.println(ph.minCostBottomUpPaintHouse2(input));
    }
}
