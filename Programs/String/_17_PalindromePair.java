package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 Link:- https://leetcode.com/problems/palindrome-pairs/
 
 336. Palindrome Pairs

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, 
i.e. words[i] + words[j] is a palindrome.

Example 1:
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]

 */

/*
  * Solution -
 * First keep mapping of word and its index.
 * Then iterate through every word and split it into every possible 2 substring. Then if first substring is palindrome
 * and reverse of second substring is in map means you can form a palindrome by combing this word with the word
 * in the map.
 *
 * Time complexity is O(n*k*k)
 * 
 */
public class _17_PalindromePair {

	
	public static void main(String args[]) {
		_17_PalindromePair palindromePair = new _17_PalindromePair();
        String[] words = {"bat", "tab"};
        List<List<Integer>> result = palindromePair.palindromePairs(words);
        System.out.println(result);
        
        result = palindromePair.palindromePairs_1(words);
        System.out.println(result);
        System.out.println("=============================");
        
        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        result = palindromePair.palindromePairs(words1);
        System.out.println(result);
        result = palindromePair.palindromePairs_1(words1);
        System.out.println(result);
        
        System.out.println("=============================");
        String[] words2 = {"", "abcd", "abba"};
        result = palindromePair.palindromePairs(words2);
        System.out.println(result);
        
        System.out.println("=============================");
        String[] words3 = {"a","abc","aba",""};
        result = palindromePair.palindromePairs(words3);
        System.out.println(result);
        System.out.println("=============================");
        String[] words4 = {"abcd","dcba","lls","s","sssll"};
        result = palindromePair.palindromePairs(words4);
        System.out.println(result);
    }
	
	
	
	public List<List<Integer>> palindromePairs_1(String[] words) 
	{
		 if (words == null || words.length < 2) {
	            return null;
	        }
		 Map<String, Integer> wordMap = new HashMap<>();
	     List<List<Integer>> result = new ArrayList<>();

	     
	     for (int i = 0; i < words.length; i++) {
	            wordMap.put(words[i], i);
	        }
	     
	     Set<String> wordList= new HashSet<>();
	     for (int i = 0; i < words.length; i++) 
	        {
	            for (int j = 1; j < words.length; j++) 
	            {
	            	if(i==j)
	            		continue;
	            
	            	String newStrCombination=words[i]+words[j];
	            	boolean a=isPalindrome(newStrCombination);
	            	if(a && !wordList.contains(newStrCombination))
	            	{
	            		 List<Integer> r = new ArrayList<>();
	            		r.add(i);
	            		r.add(j);
	            		result.add(r);
	            		wordList.add(newStrCombination);
	            	}
	            	
	            	String newStr2=words[j]+words[i];
	            	boolean b=isPalindrome(newStr2);
	            	if(b && !wordList.contains(newStr2))
	            	{
	            		 List<Integer> r = new ArrayList<>();
	            		r.add(j);
	            		r.add(i);
	            		result.add(r);
	            		wordList.add(newStr2);
	            	}
	            	
	            }
	        }
	     return result;
	}	
	
	
	
	
	
	public List<List<Integer>> palindromePairs(String[] words) 
	{
        if (words == null || words.length < 2) {
            return null;
        }
        Map<String, Integer> wordMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) 
        {
            for (int j = 0; j < words[i].length(); j++) 
            {
                String str1 = words[i].substring(0, j + 1);
                String str2 = words[i].substring(j + 1, words[i].length());
                if (isPalindrome(str2)) {
                    String revStr1 = new StringBuilder(str1).reverse().toString();
                    Integer index = wordMap.get(revStr1);
                    if (index != null) {
                        createList(i, wordMap.get(revStr1), result);
                    }
                }
                if (isPalindrome(str1)) {
                    String revStr2 = new StringBuilder(str2).reverse().toString();
                    Integer index = wordMap.get(revStr2);
                    if (index != null) {
                        createList(wordMap.get(revStr2), i, result);
                        if (revStr2.equals("")) {
                            createList(i, wordMap.get(revStr2), result);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void createList(int i1, int i2, List<List<Integer>> result) {
        if (i1 == i2) {
            return;
        }
        List<Integer> r = new ArrayList<>();
        r.add(i1);
        r.add(i2);
        result.add(r);
    }

}
