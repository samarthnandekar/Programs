package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Description:- This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will
be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and
return the shortest distance between these two words in the list.

For example, Assume that words = [“practice”, “makes”, “perfect”, “coding”, “makes”].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = “makes”, word2 = “coding”, return 1.

Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 */
public class _85_Shortest_Word_Distance2 {

	 public HashMap<String, List<Integer>> hm;
	    public _85_Shortest_Word_Distance2(String[] words) 
	    {
	    	hm = new HashMap<>();
	    	for (int i=0; i<words.length; i++) { // O(n^2)
	            if (hm.containsKey(words[i])) {
	                hm.get(words[i]).add(i);
	            } else {
	                List<Integer> tmpList = new ArrayList<Integer>();
	                tmpList.add(i);
	                hm.put(words[i], tmpList);
	            }
	            
	        }
	    }
	    
	    public int shortest(String word1, String word2) {
	        List<Integer> leftList = hm.get(word1);
	        List<Integer> rightList = hm.get(word2);
	        int i=0, j=0, ret=Integer.MAX_VALUE;
	        while (i<leftList.size() && j<rightList.size()) { // O(n+m) like merge step of MergeSort algorithm
	            int n = leftList.get(i), m = rightList.get(j);
	            if (n < m) {
	                ret = Math.min(ret, m-n);
	                i++;
	            } else {
	                ret = Math.min(ret, n-m);
	                j++;
	            }
	        }
	        return ret;
	    }
	    
	public static void main(String[] args) {

		
	}

}
