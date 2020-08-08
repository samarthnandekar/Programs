package Recursion;

import java.util.HashMap;

import Dynamic.Word_Break;

/*
  290. Word Pattern
  Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 */
public class _34_Word_Pattern_1 {

	
	public static void main(String args[])
	{
		String pattern="abba";
		String str="dog dog dog dog";
		_34_Word_Pattern_1 obj= new _34_Word_Pattern_1();
		System.out.println(obj.wordPattern(pattern, str));
	}
	
	public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strarr = str.split(" ");
        if (strarr.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String value=strarr[i];
            if (map.containsKey(key)) {
            	 if(!map.get(key).equals(value)){
                     return false;
                 }
            }
            else 
            {
            	map.put(key,value);
            }
        }
        return true;
	}
}
