package String;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.Assert;

/*
 
 Link:-https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 
 Find the smallest window in a string containing all characters of another string, Given two strings string1 and string2,
 the task is to find the smallest substring in string1 containing all characters of string2 efficiently.

Examples:- Input: string = “this is a test string”, pattern = “tist”
		   Output: Minimum window is “t stri”

Explanation: “t stri” contains all the characters of pattern.

Input: string = “geeksforgeeks”, pattern = “ork”
Output: Minimum window is “ksfor”

76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/


/*
  Solution:-
  
  Method  ( Efficient Solution )

1) First check if the length of string is less than the length of the given pattern, if yes then “no such window can exist “.
2) Store the occurrence of characters of the given pattern in a hash_pat[].
3) Start matching the characters of pattern with the characters of string i.e. increment count if a character matches.
4) Check if (count == length of pattern ) this means a window is found.
5) If such window found, try to minimize it by removing extra characters from the beginning of the current window.
6) Update min_length.
7) Print the minimum length window.

Asked:- amazon

 */

public class _23_SmallestWindowInStringContainingAllChar {

	public static void main(String[] args) {
		
		String str = "Tsuaosyogrlmnsluuorjkoruost";
        String subString = "soor";
        _23_SmallestWindowInStringContainingAllChar swcac = new _23_SmallestWindowInStringContainingAllChar();
        String result = swcac.minWindow(str, subString);
        System.out.println(result);
	}
	
	public String minWindow(String s, String subStr)
	{
		 int len1 = s.length(); 
	        int len2 = subStr.length(); 
	      
	        // check if string's length is less than pattern's length. If yes then no such window can exist 
	        if (len1 < len2) 
	        { 
	            System.out.println("No such window exists"); 
	            return ""; 
	        } 
	        
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : subStr.toCharArray()) 
        {
            Integer val = countMap.get(ch);
            if (val == null) {
                val = 0;
            }
            countMap.put(ch, val + 1);
        }
        
        int start = 0;
        int currLen = subStr.length();
        int minWindow = Integer.MAX_VALUE;
        int minStart = 0;
        int i = 0;
        while (i < s.length())
        {
            Integer val = countMap.get(s.charAt(i));
            if (val == null) 
            {
                i++;
                continue;
            }
            if (val > 0)
            {
                currLen--;
            }
            val--;
            countMap.put(s.charAt(i), val);
            while (currLen == 0)
            {
                if (minWindow > i - start + 1)
                {
                    minWindow = i - start + 1;
                    minStart = start;
                }
                Integer val1 = countMap.get(s.charAt(start));
                if (val1 != null)
                {
                    if (val1 == 0)
                    {
                        break;
                    }
                    else
                    {
                        val1++;
                        countMap.put(s.charAt(start), val1);
                    }
                }
                start++;
            }
            i++;
        }
        return minWindow != Integer.MAX_VALUE ? s.substring(minStart, minStart + minWindow) : "";
    }

   
    
    @Test
	public void test1()
	{
		String str = "this is a test string"; 
        String pat = "tist";
        String exp="t stri";
        String actual=minWindow(str,pat);
		Assert.assertEquals(exp, actual);
	}
    
    @Test
	public void test2()
	{
		String str = "Tsuaosyogrlmnsluuorjkoruost"; 
        String pat = "soor";
        String exp="oruos";
        String actual=minWindow(str,pat);
		Assert.assertEquals(exp, actual);
	}
}
