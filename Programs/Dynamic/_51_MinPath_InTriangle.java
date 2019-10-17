package Dynamic;

import java.util.ArrayList;
import java.util.List;

/*
 120. Triangle
 
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle

[[2],
 [3,4],
 [6,5,7],
 [4,1,8,3]]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:- Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.   

https://leetcode.com/problems/triangle/        */

public class _51_MinPath_InTriangle {

	public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
	
	public static void main(String []args)
	{
		List<List<Integer>> triangle= new ArrayList<List<Integer>>();
		List<Integer>f1= new ArrayList<>();
		f1.add(2);
		triangle.add(f1);
		List<Integer>f2= new ArrayList<>();
		f2.add(3);
		f2.add(4);
		triangle.add(f2);
		List<Integer>f3= new ArrayList<>();
		f3.add(6);
		f3.add(5);
		f3.add(7);
		triangle.add(f3);
		List<Integer>f4= new ArrayList<>();
		f4.add(4);
		f4.add(1);
		f4.add(8);
		f4.add(3);
		triangle.add(f4);
		
		_51_MinPath_InTriangle obj=new _51_MinPath_InTriangle();
		int minSum=obj.minimumTotal(triangle);
		
	}
}
