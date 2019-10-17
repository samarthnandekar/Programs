package Dynamic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* Word Break Problem :- Given an input string and a dictionary of words, find out if the input 
string can be segmented into a space-separated sequence of dictionary words. See following examples for more details.
This is a famous Google interview question, also being asked by many other companies now a days.

Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes 
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" 
or "i like sam sung".


https://www.programcreek.com/2012/12/leetcode-solution-word-break/
 */

public class Word_Break {
		
	// to simple check String can make by word dictionary.
	 public boolean wordBreakBottomUp(String s, Set<String> set) {
	        boolean[] T = new boolean[s.length() + 1];
	      
	        T[0] = true;
	        for (int i = 1; i <= s.length(); i++) {
	            for (int j = 0; j < i; j++) {
	            	String temp=s.substring(j, i);
	                if(T[j] && set.contains(temp)) {
	                    T[i] = true;
	                    break;
	                }
	            }
	        }
	        return T[s.length()];
	    }
	 

	 public static void main(String args[]){
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("apple");
        dictionary.add("pen");
       // dictionary.add("a");
        dictionary.add("Boy");
        /*
        dictionary.add("like");
        dictionary.add("had");
        dictionary.add("play");
        dictionary.add("to");
        String str = "Ihadliketoplay"; */
        
        String str="applepenapple";
        System.out.println(Collections.singletonList(""));
        Word_Break bmw = new Word_Break();
       // String result1 = bmw.breakWordDP(str, dictionary);
        
       // System.out.print(bmw.wordBreakBottomUp(str,dictionary));
        System.out.println("=============================");
        Set<String> dictionary1 = new HashSet<String>();
        dictionary1.add("cat");
        dictionary1.add("cats");
        dictionary1.add("and");
        dictionary1.add("sand");
        dictionary1.add("dog");
        String str1="catsanddog";
        
        List<String> strlist=bmw.wordBreakTopDown(str1,dictionary1);
        strlist.forEach(item->System.out.println(item));
    }
	
	 /**
     * Dynamic programming version for breaking word problem.
     * It returns null string if string cannot be broken into multipe words
     * such that each word is in dictionary.
     * Gives preference to longer words over splits
     * e.g peanutbutter with dict{pea nut butter peanut} it would result in
     * peanut butter instead of pea nut butter.
     */
    public String breakWordDP(String word, Set<String> dict){
       
    	int T[][] = new int[word.length()][word.length()];
        
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }
        //fill up the matrix in bottom up manner
       // l=1, means considering one char at a time, therefore l start with 1.
        for(int l = 1; l <= word.length(); l++){
            for(int i=0; i < word.length() -l + 1 ; i++){
                int j = i + l-1;
                String str = word.substring(i,j+1);  
                //if string between i to j is in dictionary T[i][j] is true
                if(dict.contains(str)){
                    T[i][j] = i;
                    continue;
                }
                //find a k between i+1 to j such that T[i][k-1] && T[k][j] are both true 
                for(int k=i+1; k <= j; k++){
                    if(T[i][k-1] != -1 && T[k][j] != -1){
                        T[i][j] = k;
                        break;
                    }
                }
            }
        }
        if(T[0][word.length()-1] == -1){
            return null;
        }
        
        //create space separate word from string is possible
        StringBuffer buffer = new StringBuffer();
        int i = 0; int j = word.length() -1;
        while(i < j){
            int k = T[i][j];
            if(i == k){
                buffer.append(word.substring(i, j+1));
                break;
            }
            buffer.append(word.substring(i,k) + " ");
            i = k;
        }
        
        return buffer.toString();
    }
    
    
    
    /**
     * Prints all the words possible instead of just one combination.
     * Reference
     * https://leetcode.com/problems/word-break-ii/
     */
    public List<String> wordBreakTopDown(String s, Set<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
        int max = 0;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        return wordBreakUtil(s, wordDict, dp, 0, max);
    }

    private List<String> wordBreakUtil(String s, Set<String> dict, Map<Integer, List<String>> dp, int start, int max) {
        
    	if (start == s.length()) {
            return Collections.singletonList("");
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<String> words = new ArrayList<String>();
        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            List<String> result = wordBreakUtil(s, dict, dp, i + 1, max);
            for (String word : result) {
                String extraSpace = word.length() == 0 ? "" : " ";
                words.add(newWord + extraSpace + word);
            }
        }
        dp.put(start, words);
        return words;
    }
	
    /*
    In Solution 2, if the size of the dictionary is very large, the time is bad. Instead we can solve the problem in O(n^2) time
     (n is the length of the string).
    */
    public boolean wordBreak(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];
     
        Arrays.fill(pos, -1);
     
        pos[0]=0;
     
        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++)
                {
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub))
                    {
                        pos[j]=i;
                    }
                } 
            }
        }
     
        return pos[s.length()]!=-1;
    }
}




