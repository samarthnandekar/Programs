package Recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _27_Word_Pattern_1 
{
	public static void main(String args[])
	{
        String pattern = "abcbc";
        String str = "bcdgflgfl";
        _27_Word_Pattern_1 wp = new _27_Word_Pattern_1();
        //System.out.println(wp.wordPatternMatch(pattern, str));
        
        String s1="sabsab";
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
