package Array;

import java.util.Arrays;

/*
 https://leetcode.com/problems/maximum-product-of-word-lengths/
 
  318. Maximum Product of Word Lengths
  
  Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. 
  You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16 
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4 
Explanation: The two words can be "ab", "cd".

Example 3:
Input: ["a","aa","aaa","aaaa"]
Output: 0 
Explanation: No such pair of words.


 * Space complexity O(n)
 * Time complexity O(n^2)
 */
public class _141_Maximum_ProductofWordLengths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String arr[]= {"abcw","baz","foo","bar","xtfn","abcdef"};
      _141_Maximum_ProductofWordLengths obj= new _141_Maximum_ProductofWordLengths();
      System.out.println(obj.maxProduct(arr));
	}

	public int maxProduct(String[] words) {
        int n = words.length;
        int[] elements = new int[n];
        for (int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((elements[i] & elements[j]) == 0)
                    ans = Math.max(ans,words[i].length() * words[j].length());
            }
        }
        return ans;
    }
	
	
	// From mission peace
	 public int maxProduct_2(String[] words) {
	        int max = 0;

	        Arrays.sort(words, (a, b) -> b.length() - a.length());

	        int[] masks = new int[words.length]; // alphabet masks

	        for(int i = 0; i < masks.length; i++){
	            for(char c: words[i].toCharArray()){
	                masks[i] |= 1 << (c - 'a');
	            }
	        }

	        for(int i = 0; i < masks.length; i++){
	            if(words[i].length() * words[i].length() <= max) {
	                break; //prunning
	            }
	            for(int j = i + 1; j < masks.length; j++){
	                if((masks[i] & masks[j]) == 0){
	                    max = Math.max(max, words[i].length() * words[j].length());
	                    break; //prunning
	                }
	            }
	        }

	        return max;
	    }
}
