package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 254. Factor Combinations
 
 Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
= 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:- You may assume that n is always positive. Factors should be greater than 1 and less than n.

Example 1:
Input: 1
Output: []

Example 2:
Input: 37
Output:[]

Example 3:
Output: 12
[[2, 6],
 [2, 2, 3],
 [3, 4]]
 
 */
public class _13_Factor_Combinations {

	public static void main(String[] args) {
		_13_Factor_Combinations obj= new _13_Factor_Combinations();
		List<List<Integer>> ans=obj.getFactors(12);
		
		System.out.println(ans);
	}
	 public List<List<Integer>> getFactors(int n) {
	        List<List<Integer>> res = new ArrayList<>();
	        helper(n, 2, new ArrayList<Integer>(), res);
	        return res;
	    }
	    private void helper(int n, int factor, List<Integer> temp, List<List<Integer>> res) {
	        if (n <= 1) {
	            if (temp.size() > 1) res.add(new ArrayList<>(temp));
	            return;
	        }
	        for (int i = factor; i <= n; i++) {
	            if (n % i == 0) {
	                temp.add(i);
	                helper(n/i, i, temp, res);
	                temp.remove(temp.size()-1);
	            }
	        }
	    }
	    
}
