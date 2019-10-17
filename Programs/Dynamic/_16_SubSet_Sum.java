package Dynamic;

import java.util.HashSet;

/*
 Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
 
 */
public class _16_SubSet_Sum {

	public static void main(String [] args)
	{
		
	}
	
	boolean isSubsetPresent(int [] arr, int key)
	{
		boolean isSubsetPresent=false;
		HashSet<Integer> hashSet= new HashSet<>();
		
		for(int i=0;i<arr.length;i++)
		{
			hashSet.add(arr[i]);
			
		}
		return isSubsetPresent;
	}
}
