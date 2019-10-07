package Array;

/*

90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.
Example: Input: [1,2,2]

Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

Asked in:- Microsoft

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _123_SubSet2 {

	public static void main(String[] args) {
	
		int [] arr= {1,2,2,2};
		List<List<Integer>> list=subsetsWithDup(arr);
		list.forEach(item->System.out.println(item));
	}
	
	static public List<List<Integer>> subsetsWithDup(int[] nums) {
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
        results.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            
            subset.add(nums[i]);
            toFindAllSubsets(nums, results, subset, i + 1);
            subset.remove(subset.size() - 1);            
        }
    }

}
