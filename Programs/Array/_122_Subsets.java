package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 
78. Subsets

Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.

Example:-
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Time complexity:- n * 2 power on n.
 
*/
public class _122_Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1,2,3};
		List<List<Integer>> list=subsets(arr);
		list.forEach(item->System.out.println(item));	
	}
	
	static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        Arrays.sort(nums);
        
        List<Integer> subset = new ArrayList<>();
        toFindAllSubsets(nums, results, subset, 0);                
        
        return results;
    }
    
	static private void toFindAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {
        
		if(subset.size()>0)
		{
			results.add(new ArrayList<>(subset));	
		}
        
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            toFindAllSubsets(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);            
        }        
    }
}
