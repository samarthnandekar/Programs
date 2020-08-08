package Recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 291: Word Pattern II
Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true. pattern = "aaaa", str = "asdasdasdasd" should return true. 
pattern = "aabb", str = "xyzabcxzyabc" should return false.

Notes:You may assume both pattern and str contains only lowercase letters.

 */
public class _27_Word_Pattern_2 
{
	public static void main(String args[])
	{
        String pattern = "abcbc";
        String str = "bcdgflgfl";
        _27_Word_Pattern_2 wp = new _27_Word_Pattern_2();
        //System.out.println(wp.wordPatternMatch(pattern, str));
        
        String s1="redblueredblue";
        String p1="abab";
        System.out.println(wp.wordPatternMatch(p1, s1));
    }

	 public boolean wordPatternMatch(String pattern, String str) 
	 {
	        Map<Character, String> map = new HashMap<>();
	        Set<String> set = new HashSet<>();
	        return wordPatternMatch(pattern, str, 0, 0, map, set);
	    }

	    public boolean wordPatternMatch(String pattern, String str, int pos1, int pos2, Map<Character, String> map, Set<String> set) {
	        
	    	if (pos1 == pattern.length()) {
	            return pos2 == str.length();
	        }

	        char ch = pattern.charAt(pos1);
	        String val = map.get(ch);
	        if (val != null)
	        {
	        	// to check, after adding val length is equal or smaller str length
	        	boolean withinStrLength=pos2 + val.length() <= str.length();
	        	boolean isPatternMatching=val.equals(str.substring(pos2, pos2 + val.length()));
	        	
	            return  withinStrLength && isPatternMatching && wordPatternMatch(pattern, str, pos1 + 1, pos2 + val.length(), map, set);
	        } else 
	        {
	            for (int i = pos2; i < str.length() - (pattern.length() - pos1 - 1); i++) 
	            {
	                String newStr = str.substring(pos2, i + 1);
	                if (set.contains(newStr)) {
	                    continue;
	                }
	                set.add(newStr);
	                map.put(ch, newStr);
	                if (wordPatternMatch(pattern, str, pos1 + 1, i + 1, map, set)) 
	                {
	                    return true;
	                }
	                set.remove(newStr);
	            }
	            map.remove(ch);
	        }
	        return false;
	    }
}
