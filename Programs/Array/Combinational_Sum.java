/** 
@Author  - sn656
Creation - Date Dec 12, 2018 1:15:46 AM

*/

package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** 
 Link :- https://www.geeksforgeeks.org/combinational-sum/
 
** Combinational Sum **
	Given an array of positive integers arr[] and a sum x, find all unique combinations in arr[] where the sum is equal to x. The same repeated 
	number may be chosen from arr[] unlimited number of times. Elements in a combination (a1, a2, …, ak) must be printed in non-descending order. 
	(ie, a1 <= a2 <= … <= ak).The combinations themselves must be sorted in ascending order, i.e., the combination with smallest first element 
	should be printed first. If there is no combination possible the print "Empty" (without quotes).

Examples: Input : arr[] = 2, 4, 6, 8 and x = 8
Output : [2, 2, 2, 2]
         [2, 2, 4]
         [2, 6]
         [4, 4]
         [8]

 Solution:- Since the problem is to get all the possible results, not the best or the number of result, thus we don’t need to consider 
            DP(dynamic programming), recursion is needed to handle it.

 1. Sort the array(non-decreasing).
2. First remove all the duplicates from array.
3. Then use recursion and backtracking to solve 
   the problem.
   (A) If at any time sub-problem sum == 0 then 
       add that array to the result (vector of 
       vectors).
   (B) Else if sum if negative then ignore that 
       sub-problem.
   (C) Else insert the present array in that 
       index to the current vector and call 
       the function with sum = sum-ar[index] and
       index = index, then pop that element from 
       current index (backtrack) and call the 
       function with sum = sum and index = index+1
       
       
 *
 */
public class Combinational_Sum 
{

	
	// Returns all combinations of ar[] that have given sum. 
	static List<ArrayList<Integer> > combinationSum(int [] ar, int sum) 
	{ 
		
		if(ar == null || ar.length == 0) 
			return null;
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>();
	    Arrays.sort(ar);
	    
	    combinationSum(ar, sum, 0, current, result);
	    
	    return result;
	}
	
	static public void combinationSum(int[] candidates, int target, int j, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result)
	{
		   if(target == 0){
		       ArrayList<Integer> temp = new ArrayList<Integer>(curr);
		       result.add(temp);
		       return;
		   }
		 
		   for(int i=j; i<candidates.length; i++){
		       if(target < candidates[i]) 
		            return;
		 
		       curr.add(candidates[i]);
		       combinationSum(candidates, target - candidates[i], i, curr, result);
		       curr.remove(curr.size()-1); 
		   }
	  }
	
	public static void main(String[] args)  
    {
		int arr[] = {2, 4, 6, 8};
		int sum=8;
		List res=combinationSum(arr,sum);
		System.out.println(res);
    }
}

