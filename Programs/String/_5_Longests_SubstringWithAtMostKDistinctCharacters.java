package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 Given a string, find the length of the longest substring T that contains at most k distinct characters.

	For example, Given s = “eceba”and k = 2,
	T is "ece" which its length is 3.

Source: Google Interview Question.

https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
*/

/*
 
Method 1 (Brute Force) :- If the length of string is n, then there can be n*(n+1)/2 possible substrings. A simple way is to generate all 
                         the substring and check each one whether it has exactly k unique characters or not. If we apply this brute force,
                         it would take O(n2) to generate all substrings and O(n) to do a check on each one. Thus overall it would go O(n3).


Method 2:- We can further improve this solution by creating a hash table and while generating the substrings, check the number of unique characters 
           using that hash table. Thus it would improve up to O(n2).

Method 3:-
 * Time complexity O(n)
 * Space complexity O(n)
 * 

method 4:- Check for aabbc and aabbcc output value. it's not consistent.



Asked: Google
*/
public class _5_Longests_SubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		int no=lengthOfLongestSubstringKDistinct("aabbc",2);
		System.out.println(no);
		kUniques("abbcc",2);
	}

	// method 3
	 static public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        if (k == 0 || s.length() == 0) {
	            return 0;
	        }
	        int[] ascii = new int[256];
	        int count = 0;
	        int start = 0;
	        int max = 0;
	        for (int i = 0; i < s.length(); i++) 
	        {
	            int ch = s.charAt(i);
	            if (count < k) {
	                if (ascii[ch] == 0) {
	                    count++;
	                }
	            } else if (ascii[ch] == 0){
	                while (start < i) {
	                    char ch1 = s.charAt(start++);
	                    ascii[ch1]--;
	                    if (ascii[ch1] == 0) {
	                        break;
	                    }
	                }
	            }
	            ascii[ch]++;
	            max = Math.max(max, i - start + 1);
	        }
	        return max;
	    }

		// method 3
	 static public int lengthOfLongestSubstringKDistinctUsingMap(String s, int k) {
	        if (k == 0 || s.length() == 0) {
	            return 0;
	        }
	        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
	        int max = 0;
	        int start = 0;
	        for (int i = 0; i < s.length(); i++) 
	        {
	            char ch = s.charAt(i);
	            if (!countMap.containsKey(ch) && countMap.size() >= k) 
	            {
	                while (start < i) {
	                    countMap.compute(s.charAt(start), (key, val) -> {
	                        if (val == 1) {
	                            return null;
	                        } else {
	                            return val - 1;
	                        }
	                    });
	                    start++;
	                    if (countMap.size() < k) {
	                        break;
	                    }
	                }
	            }
	            countMap.compute(ch, (key, val) -> {
	                if (val == null) {
	                    return 1;
	                } else {
	                    return val + 1;
	                }
	            });
	            max = Math.max(max, i - start + 1);
	        }
	        return max;
	    }
	 
	    // method 4
	 
	    // This function calculates number of unique characters using a associative array count[]. Returns true if 
	    // no. of characters are less than required else returns false. 
	    final static int MAX_CHARS = 26; 

	    static boolean isValid(int count[], int k) { 
	        int val = 0; 
	        for (int i = 0; i < MAX_CHARS; i++) { 
	            if (count[i] > 0) { 
	                val++; 
	            } 
	        } 
	        // Return true if k is greater than or equal to val 
	        return (k >= val); 
	    } 
	  
	       // Finds the maximum substring with exactly k unique chars 
	    static void kUniques(String s, int k) { 
	        int u = 0; // number of unique characters 
	        int n = s.length(); 
	  
	        // Associative array to store the count of characters 
	        int count[] = new int[MAX_CHARS]; 
	      
	        // Traverse the string, Fills the associative array count[] and count number of unique characters 
	        for (int i = 0; i < n; i++) { 
	            if (count[s.charAt(i) - 'a'] == 0) { 
	                u++; 
	            } 
	            count[s.charAt(i) - 'a']++; 
	        } 
	  
	        // If there are not enough unique characters, show an error message. 
	        if (u < k) { 
	            System.out.print("Not enough unique characters"); 
	            return; 
	        } 
	  
	        // Otherwise take a window with first element in it. start and end variables. 
	        int curr_start = 0, curr_end = 0; 
	  
	        // Also initialize values for result longest window 
	        int max_window_size = 1, max_window_start = 0; 
	  
	        // Initialize associative array count[] with zero 
	        Arrays.fill(count, 0); 
	  
	        count[s.charAt(0) - 'a']++;  // put the first character 
	  
	        // Start from the second character and add characters in window according to above explanation 
	        for (int i = 1; i < n; i++) { 
	            // Add the character 's[i]' to current window 
	            count[s.charAt(i) - 'a']++; 
	            curr_end++; 
	  
	            // If there are more than k unique characters in current window, remove from left side 
	            while (!isValid(count, k)) { 
	                count[s.charAt(curr_start) - 'a']--; 
	                curr_start++; 
	            } 
	  
	            // Update the max window size if required 
	            if (curr_end - curr_start + 1 > max_window_size) { 
	                max_window_size = curr_end - curr_start + 1; 
	                max_window_start = curr_start; 
	            } 
	        } 
	  
	        System.out.println("Max sustring is : "+ s.substring(max_window_start, max_window_size) + " with length " + max_window_size); 
	    } 
}
