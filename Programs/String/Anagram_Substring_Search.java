/** 
@Author  - sn656
Creation - Date Nov 24, 2018 8:42:32 PM

*/

package Microsoft;

/**
 Link :- https://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

Anagram Substring Search (Or Search for all permutations)
Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume that n > m. 
Expected time complexity is O(n)

Examples:

1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
   Output:   Found at Index 0
             Found at Index 5
             Found at Index 6
             
             
2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
   Output:   Found at Index 0
             Found at Index 1
             Found at Index 4
 
 We can achieve O(n) time complexity under the assumption that alphabet size is fixed which is typically
 true as we have maximum 256 possible characters in ASCII. The idea is to use two count arrays:

1) The first count array store frequencies of characters in pattern.
2) The second count array stores frequencies of characters in current window of text.

The important thing to note is, time complexity to compare two count arrays is O(1) as the number of elements in them are fixed (independent of pattern and text sizes). Following are steps of this algorithm.
1) Store counts of frequencies of pattern in first count array countP[]. Also store counts of frequencies of characters in first window of text in array countTW[].

2) Now run a loop from i = M to N-1. Do following in loop.
…..a) If the two count arrays are identical, we found an occurrence.
…..b) Increment count of current character of text in countTW[]
…..c) Decrement count of first character in previous window in countWT[]

3) The last window is not checked by above loop, so explicitly check it.

Following is the implementation of above algorithm.
             

 */


public class Anagram_Substring_Search 
{

	static final int MAX = 256; 
    
    // This function returns true if contents of arr1[] and arr2[] are same, otherwise false. 
    static boolean compare(char arr1[], char arr2[]) 
    { 
        for (int i = 0; i < MAX; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    } 
     
    static boolean compare(int arr1[], int arr2[]) 
    { 
        for (int i = 0; i < MAX; i++) 
            if (arr1[i] != arr2[i]) 
                return false; 
        return true; 
    }
    
    /* countP[pat.charAt(i)]++;  can't assign any value here like as  countP[pat.charAt(i)]='f'.. 
    because at position 1 and position 5 there are A. and if we try to use technique to assign f, then 
    it will be wrong...
    
    */
    
    // This function search for all permutations of pat[] in txt[] 
    static void search(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        // countP[]:  Store count of all  characters of pattern 
        // countTW[]: Store count of current window of text 
        char[] countP = new char[MAX]; 
        char[] countTW = new char[MAX]; 
        for (int i = 0; i < M; i++) 
        { 
            countP[pat.charAt(i)]++;  
            countTW[txt.charAt(i)]++; 
        } 
  
        // Traverse through remaining characters of pattern 
        for (int i = M; i < N; i++) 
        { 
            // Compare counts of current window of text with counts of pattern[] 
            if (compare(countP, countTW)) 
                System.out.println("Found at Index " + (i - M)); 
              
            // Add current character to current window 
            countTW[txt.charAt(i)]++; 
  
            // Remove the first character of previous window 
            countTW[txt.charAt(i-M)]--; 
        } 
  
        // Check for the last window in text 
        if (compare(countP, countTW)) 
            System.out.println("Found at Index " +  (N - M)); 
    } 
  
    /* Driver program to test above function */
    public static void main(String args[]) 
    { 
        String txt = "BACDGABCDA"; 
        String pat = "ABCD"; 
       // search(pat, txt);
        searchUSingIntArray(pat,txt);
        
       /* char [] test= new char[5];
        for(int i=0;i<4;i++)
        {
        	System.out.println("sam"+((test[i])++)+"sam");
        }
        */
    }
    
 // This function search for all permutations of pat[] in txt[] 
    static void searchUSingIntArray(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        // countP[]:  Store count of all  characters of pattern 
        // countTW[]: Store count of current window of text 
        int[] countP = new int[MAX]; 
        int[] countTW = new int[MAX]; 
        for (int i = 0; i < M; i++) 
        { 
            countP[pat.charAt(i)]++;  
            countTW[txt.charAt(i)]++; 
        } 
  
        // Traverse through remaining characters of pattern 
        for (int i = M; i < N; i++) 
        { 
            // Compare counts of current window of text with counts of pattern[] 
            if (compare(countP, countTW)) 
                System.out.println("Found at Index " + (i - M)); 
              
            // Add current character to current window 
            countTW[txt.charAt(i)]++; 
  
            // Remove the first character of previous window 
            countTW[txt.charAt(i-M)]--; 
        } 
  
        // Check for the last window in text 
        if (compare(countP, countTW)) 
            System.out.println("Found at Index " +  (N - M)); 
    }
}



