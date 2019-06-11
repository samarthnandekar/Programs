package String;

import java.util.HashMap;

/*

Link:- https://www.geeksforgeeks.org/find-all-strings-that-match-specific-pattern-in-a-dictionary/

Find all strings that match specific pattern in a dictionary
Given a dictionary of words, find all strings that matches the given pattern where every character in the pattern is uniquely mapped to a character in the dictionary.

Examples:-

Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "foo"
Output: [xyy abb]
Explanation: 
xyy and abb have same character at index 1 and 2 like the pattern

Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pat = "mno"
Output: [abc xyz]
Explanation: 
abc and xyz have all distinct characters, similar to the pattern

Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "aba"
Output: [] 
Explanation: 
Pattern has same character at index 0 and 2. 
No word in dictionary follows the pattern.

Input:  
dict = ["abab", "aba", "xyz", "xyx"];
pattern = "aba"
Output: [aba xyx]
Explanation: 
aba and xyx have same character at index 0 and 2 like the pattern


Practice Tags : Microsoft, Amazon, Hash, Strings

*/

public class _9_StringsMatchSpecificPattern 
   {
	public static void main(String[] args) {
        String[] dict = { "abb", "abc", "xyz", "xyy" }; 
        String pattern = "foo"; 

        findMatchedWords(dict, pattern); 

	}
	
	 // Function to print all the strings that match the given pattern where every character in the pattern is 
    // uniquely mapped to a character in the dictionary 
    static void findMatchedWords(String[] dict, String pattern) 
    { 
           // len is length of the pattern 
           int len = pattern.length(); 
             
           // encode the string 
           String hash = encodeString(pattern); 

           // for each word in the dictionary array 
           for (String word : dict) 
           { 
             // If size of pattern is same as size of current 
             // dictionary word and both pattern and the word has same hash, print the word 
             if (word.length() == len && encodeString(word).equals(hash)) 
                 System.out.print(word + " "); 
           } 
    } 
    
	// Function to encode given string 
    static String encodeString(String str) 
    { 
           HashMap<Character, Integer> map = new HashMap<>(); 
           String res = ""; 
           int i = 0; 
             
           // for each character in given string 
           char ch; 
           for (int j = 0; j < str.length(); j++)  
           { 
                ch = str.charAt(j); 

                // If the character is occurring for the first time, assign next unique number to that char 
                if(!map.containsKey(ch))  
                   map.put(ch, i++); 

                // append the number associated with current character into the output string 
                res += map.get(ch); 
           } 

           return res; 
    } 

}
