/** 
@Author  - sn656
Creation - Date Dec 12, 2018 12:58:18 AM

*/

// Microsoft;
package Recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  Find all distinct subsets of a given set **

Given a set of positive integers, find all its subsets. The set can contain duplicate elements, so any repeated subset should be considered only 
once in the output.

Examples:-
Input:  S = {1, 2, 2}
Output:  {}, {1}, {2}, {1, 2}, {2, 2}, {1, 2, 2}

Explanation:- The total subsets of given set are - {}, {1}, {2}, {2}, {1, 2}, {1, 2}, {2, 2}, {1, 2, 2}
Here {2} and {1, 2} are repeated twice so they are considered only once in the output

 */
public class _31_All_Distinct_Subsets_Of_Given_Set 
{
		// Recursive function to print all distinct subsets of S
		// S	--> input set
		// out  --> list to store subset
		// i	--> index of next element in set S to be processed
		public static void findPowerSet(int[] S, List<Integer> out, int i)
		{
			// if all elements are processed, print the current subset
			if (i < 0) {
				System.out.println(out);
				return;
			}

			// include current element in the current subset and recurse
			out.add(S[i]);
			findPowerSet(S, out, i - 1);

			// exclude current element in the current subset
			out.remove(out.size() - 1); // backtrack

			// remove adjacent duplicate elements
			while (i > 0 && S[i] == S[i - 1]) {
				i--;
			}

			// exclude current element in the current subset and recurse
			findPowerSet(S, out, i - 1);
		}

		public static void main(String[] args)
		{
			int[] S = { 1, 3, 1 };
			int[] S1 = { 1, 2, 2 };

			// sort the set
			Arrays.sort(S1);

			// create an empty list to store elements of a subset
			List<Integer> out = new ArrayList<>();
			findPowerSet(S1, out, S1.length - 1);
		}
	
}

