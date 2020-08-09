package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/articles/palindrome-permutation/
 
 Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
 
 
 */
public class _Palindrome_Permutation {

	public boolean canPermutePalindromeMap(String s) {
	     HashMap < Character, Integer > map = new HashMap < > ();
	     for (int i = 0; i < s.length(); i++) {
	         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
	     }
	     int count = 0;
	     for (char key: map.keySet()) {
	         count += map.get(key) % 2;
	     }
	     return count <= 1;
	 }
	
	public boolean canPermutePalindromeSet(String s) {
        Set < Character > set = new HashSet < > ();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
	
	public static void main(String args[])
	{
		_Palindrome_Permutation pp= new _Palindrome_Permutation();
		System.out.println(pp.canPermutePalindromeMap("code"));
		System.out.println(pp.canPermutePalindromeSet("code"));
		
		System.out.println(pp.canPermutePalindromeMap("aab"));
		System.out.println(pp.canPermutePalindromeSet("aab"));
		
		System.out.println(pp.canPermutePalindromeMap("carerac"));
		System.out.println(pp.canPermutePalindromeSet("carerac"));
	}
}
