package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 
 266. Palindrome Permutation
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
public class _266_Palindrome_Permutation {

	public static void main(String[] args) {
		String str1="code";
		System.out.println(canPermutePalindrome(str1));
		System.out.println(canPermutePalindrome_2(str1));
		
		String str2="aab";
		System.out.println(canPermutePalindrome(str2));
		System.out.println(canPermutePalindrome_2(str2));
		
		String str3="carerac";
		System.out.println(canPermutePalindrome(str3));
		System.out.println(canPermutePalindrome_2(str3));
		
	}

	/*
	 Complexity Analysis

      Time complexity : O(n)O(n). We traverse over the given string ss with nn characters once. We also traverse over the map
      which can grow upto a size of nn in case all characters in ss are distinct.

      Space complexity : O(n)O(n). The hashmap can grow upto a size of nn, in case all the characters in s are distinct.
	 */
	public static boolean canPermutePalindrome(String s) {
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
	
	/*
	 Complexity Analysis
     Time complexity : O(n)O(n). We traverse over the string ss of length nn once only.
      Space complexity : O(n)O(n). The setset can grow upto a maximum size of nn in case of all distinct elements.
	 */
	 public static boolean canPermutePalindrome_2(String s) {
	        Set< Character > set = new HashSet<>();
	        for (int i = 0; i < s.length(); i++) {
	            if (!set.add(s.charAt(i)))
	                set.remove(s.charAt(i));
	        }
	        return set.size() <= 1;
	    }
}
