package Backtracking;

import java.util.Arrays;

/*
 https://www.geeksforgeeks.org/powet-set-lexicographic-order/
 
Input : abc
Output : a ab abc ac b bc c

The idea is to sort array first. After sorting, one by one fix characters and recursively generates all subsets starting from them.
 After every recursive call, we remove last character so that next permutation can be generated.


 */
public class _9_PowerSet_InLexicographicOrder {

	static void permuteRec(String str, int n, int index, String curr) 
	{ 
	    // base case 
	    if (index == n)  
	        return; 
	  
	    System.out.println(curr); 
	    for (int i = index + 1; i < n; i++) { 
	  
	        curr += str.charAt(i); 
	        permuteRec(str, n, i, curr); 
	   
	        // backtracking 
	        curr = curr.substring(0,curr.length() - 1);  
	    } 
	    return; 
	} 
	
	// Generates power set in lexicographic order. 
	static void powerSet(String str) 
	{ 
		char [] strArray=str.toCharArray();
		Arrays.sort(strArray);
	    String sortString=new String(strArray);
	    permuteRec(sortString, sortString.length(),-1,"");
	} 
	
	public static void main(String []args)
	{
		powerSet("cab");
	}
}
