package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 
 Link:- https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
 
 Smallest window that contains all characters of string itself

Given a string, find the smallest window length with all distinct characters of the given string. For eg. str = “aabcbcdbca”, 
then the result would be 4 as of the smallest window will be “dbca” .

Examples:- Input  : aabcbcdbca
		   Output : dcba
Explanation : dbca of length 4 is the smallest window with highest number of distinct characters.         

Input : aaab
Output : ab
Explanation :- ab of length 2 is the smallest window with highest number of distinct characters.
 
 
 
 Asked: Microsoft, Amazon
 */
public class _25_SmallestWindowContainsAllChar {

	public static void main(String[] args) {
		String str="aaab";
		String out=findSubString(str);
		System.out.println(out);
	}

	 static String findSubString(String str) 
	    { 
	        int n = str.length(); 
	       
	        // Count all distinct characters. 
	        int dist_count = 0; 
	        Set te=new HashSet<String>();
	     
	        for (int i=0; i<n; i++) 
	        { 
	            if (te.contains(str.charAt(i)) == false) 
	            { 
	                te.add(str.charAt(i));     
	                dist_count++; 
	            } 
	        } 
	       
	        // Now follow the algorithm discussed in below post. We basically maintain a window of characters 
	        // that contains all characters of given string. 
	        // https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/  
	        int start = 0, start_index = -1; 
	        int min_len = Integer.MAX_VALUE; 
	       
	        int count = 0;
	        HashMap <Character, Integer> charAndcount=  new HashMap<Character,Integer>();
	        
	        for (int j=0; j<n; j++) 
	        { 
	            // Count occurrence of characters of string 
	            Character ch=str.charAt(j);
	            Integer val = charAndcount.get(ch);
	            if (val == null) {
	                val = 0;
	            }
	            charAndcount.put(ch, val + 1);
	       
	            // If any distinct character matched, then increment count 
	            val=(int) charAndcount.get(ch);
	            if ( val == 1 ) 
	                count++; 
	       
	            // if all the characters are matched 
	            if (count == dist_count) 
	            { 
	                // Try to minimize the window i.e., check if any character is occurring more no. of times 
	                // than its occurrence in pattern, if yes then remove it from starting and also remove 
	                // the useless characters. 
	            	int value=charAndcount.get(str.charAt(start));	            	
	                while ( value> 1) 
	                { 
	                	charAndcount.put(str.charAt(start),value--);
	                    start++; 
	                } 
	                  
	                // Update window size 
	                int len_window = j - start + 1; 
	                if (min_len > len_window) 
	                { 
	                    min_len = len_window; 
	                    start_index = start; 
	                } 
	            } 
	        } 
	        // Return substring starting from start_index and length min_len 
	        return str.substring(start_index, start_index+min_len); 
	    } 
	 
	 
	 @Test
	 public void test1()
	 {
		String str="aabcbcdbca";
		String exp="dbca";
		String actual=findSubString(str);
		Assert.assertEquals(exp, actual); 
		 
	 }
	 
	 @Test
	 public void test2()
	 {
		String str="aaab";
		String exp="ab";
		String actual=findSubString(str);
		Assert.assertEquals(exp, actual); 
		 
	 }
}
