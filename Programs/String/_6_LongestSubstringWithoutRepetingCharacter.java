package String;

import java.util.HashSet;
import java.util.Set;

/*
 https://leetcode.com/problems/longest-substring-without-repeating-characters/
 
 Longest Substring Without Repeating Characters:- Given a string, find the length of the longest substring without repeating characters.

	Example 1:-
	Input: "abcabcbb"        Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
	
	Example 2:
	Input: "bbbbb"           Output: 1
	Explanation: The answer is "b", with the length of 1.
	
	Example 3:
	Input: "pwwkew"          Output: 3
	Explanation: The answer is "wke", with the length of 3. 
	
	Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 
*****  https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/  *****

Given a string, find the length of the longest substring without repeating characters. For example, the longest substrings without repeating 
characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6. For “BBBB” the longest substring is “B”, with length 1. For “GEEKSFORGEEKS”, 
there are two longest substrings shown in the below diagrams, with length 7.

 The desired time complexity is O(n) where n is the length of the string.

Microsot, Amazon

*/

/*
 Method 1 (Simple)
 We can consider all substrings one by one and check for each substring whether it contains all unique characters or not. There will be n*(n+1)/2 
 substrings. Whether a substirng contains all unique characters or not can be checked in linear time by scanning it from left to right and keeping 
 a map of visited characters. Time complexity of this solution would be O(n^3).


*/



public class _6_LongestSubstringWithoutRepetingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_6_LongestSubstringWithoutRepetingCharacter lsw= new _6_LongestSubstringWithoutRepetingCharacter();
        System.out.println(lsw.lengthOfLongestSubstring("ABCDECAMNCZB"));
	}
	
	public int lengthOfLongestSubstring(String s) {
        Set<Character> uniqueSet = new HashSet<>();
        int maxSize = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!uniqueSet.contains(s.charAt(i))) {
                uniqueSet.add(s.charAt(i));
                if(uniqueSet.size() > maxSize) {
                    maxSize = uniqueSet.size();
                }
            } else {
                while (s.charAt(start) != s.charAt(i)) {
                    uniqueSet.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return maxSize;
    }

}
