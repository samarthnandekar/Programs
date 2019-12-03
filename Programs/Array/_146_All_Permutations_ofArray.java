package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * 46. Permutations
 Given a collection of distinct integers, return all possible permutations.

Example:
Input: [1,2,3]

Output:
[[1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]]
  
 https://java2blog.com/permutations-array-java/
 */
public class _146_All_Permutations_ofArray {

	public static void main(String[] args) {
		int [] arr= {1,2,3};
		_146_All_Permutations_ofArray obj= new _146_All_Permutations_ofArray();
		List<List<Integer>> permutation=obj.permuteUsingStack(arr);

		permutation.forEach(perm->System.out.println(perm));
		System.out.println("-----------------");
		permutation=obj.permuteUsingList(arr);
		permutation.forEach(perm->System.out.println(perm));
		
	}
	
	// Using stack.
	 public List<List<Integer>> permuteUsingStack(int[] nums) {
	        List<List<Integer>> result = new LinkedList<>();
	        permute(result, new Stack<Integer>(), nums);
	        return result;
	    }
	 
	 private void permute(List<List<Integer>> result, Stack<Integer> tempList, int[] nums) {
	        if (tempList.size() == nums.length) {
	            result.add(new ArrayList<>(tempList));
	            return;
	        }

	        for (int i = 0; i < nums.length; i++) {
	            if (tempList.contains(nums[i])) {
	                continue;
	            }
	            tempList.push(nums[i]);
	            permute(result, tempList, nums);
	            tempList.pop();
	        }
	    }
	 
	 //
	 public List<List<Integer>> permuteUsingList(int[] arr) {
			List<List<Integer>> list = new ArrayList<>();
			permuteHelper(list, new ArrayList<>(), arr);
			return list;
		}
	 
		private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr){
	 
			// Base case
			if(resultList.size() == arr.length){
				list.add(new ArrayList<>(resultList));
				return;
			} 
			
				for(int i = 0; i < arr.length; i++){ 
	 
					if(resultList.contains(arr[i])) 
					{
						// If element already exists in the list then skip
						continue; 
					}
					// Choose element
					resultList.add(arr[i]);
					// Explore
					permuteHelper(list, resultList, arr);
					// Unchoose element
					resultList.remove(resultList.size() - 1);
				}
		}
		
		/*
		 47. Permutations II
		 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

        Example:
       Input: [1,1,2]
       Output:
            {[1,1,2],
             [1,2,1],
             [2,1,1]]
		 */
		
		public List<List<Integer>> permute(int[] arr) {
			List<List<Integer>> list = new ArrayList<>();
			Arrays.sort(arr);
			permuteHelper(list, new ArrayList<>(), arr,new boolean[arr.length]);
			return list;
		}
	 
		private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr, boolean [] used){
			
			// Base case
			if(resultList.size() == arr.length){
		        list.add(new ArrayList<>(resultList));
		        return;
		    } 
			
		        for(int i = 0; i < arr.length; i++){
		            if(used[i] || i > 0 && arr[i] == arr[i-1] && !used[i - 1]) 
		            {   
		            	    // If element is already used
		            		continue;
		            }
		            // choose element
		            used[i] = true; 
		            resultList.add(arr[i]);
		            
		            // Explore
		            permuteHelper(list, resultList, arr, used);
		            
		            // Unchoose element
		            used[i] = false; 
		            resultList.remove(resultList.size() - 1);
		        }
		    }
}
