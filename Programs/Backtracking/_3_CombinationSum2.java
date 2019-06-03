package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 
Link:- https://leetcode.com/problems/combination-sum-ii/
 
Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.
Note:- All numbers (including target) will be positive integers.
       The solution set must not contain duplicate combinations.

"This problem is an extension of Combination Sum. The difference is one number in the array can only be used ONCE."


Example 1:-
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[[1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]]

Example 2:-
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[[1,2,2],
  [5]]
 
 */
public class _3_CombinationSum2 {

	public static void main(String [] args)
	{
		int target=8;
		int [] arr= {10,1,2,7,6,1,5};
		_3_CombinationSum2 comSum= new _3_CombinationSum2();
		List<List<Integer>> result=comSum.combinationSum2(arr,target);
	
		result.forEach(item->System.out.println(item));
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    List<Integer> curr = new ArrayList<Integer>();
	    Arrays.sort(candidates);
	    helper(result, curr, 0, target, candidates);
	    return result;
	}
	 
	public void helper(List<List<Integer>> result, List<Integer> curr, int start, int target, int[] candidates){
	    if(target==0){
	        result.add(new ArrayList<Integer>(curr));
	        return;
	    }
	    if(target<0){
	        return;
	    }
	 
	    int prev=-1;
	    for(int i=start; i<candidates.length; i++){
	        if(prev!=candidates[i]){ // each time start from different element
	            curr.add(candidates[i]);
	            helper(result, curr, i+1, target-candidates[i], candidates); // and use next element only
	            curr.remove(curr.size()-1);
	            prev=candidates[i];
	        }
	    }
	}
	
}
