package Array;

/*
 245 LeetCode Java: Shortest Word Distance III – Medium

Problem:
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.

For example, Assume that words = [“practice”, “makes”, “perfect”, “coding”, “makes”].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = “makes”, word2 = “makes”, return 3.

Note: You may assume word1 and word2 are both in the list.

Thoughts:- This problem can be easily solved using the solution we used in the Shortest Word Distance I version. Just add a boolean
flag to indicate if they are the same, if they are the same, update both index for last appearance.
Since this problem doesn’t have the constructor, so I think the assumption is that this function is not called multiple times 
as it is in the version II.

If it’s version II, we can also modify the version II to make it work for this problem. We just need to calculate the intervals in one
ArrayList if two Strings are the same

 */
public class _85_Shortest_Word_Distance3 {

	public static void main(String[] args) {
		

	}
	
	 public int shortestWordDistance(String[] words, String word1, String word2) {
	        int index1 = -1;
	        int index2 = -1;
	        int min = Integer.MAX_VALUE;
	        boolean same = false;
	        if (word1.equals(word2)) {
	            same = true;
	        }
	        for (int i = 0; i < words.length; i ++) {
	            if (words[i].equals(word1)) {
	                if (index2 != -1) {
	                    min = Math.min(i - index2, min);
	                }
	                index1 = i;
	                if (same) {
	                    index2 = i;
	                }
	                continue;
	            }
	            if (words[i].equals(word2)) {
	                if (index1 != -1) {
	                    min = Math.min(i - index1, min);
	                }
	                index2 = i;
	                if (same) {
	                    index1 = i;
	                }
	                continue;
	            }
	        }
	        return min;
	    }
	 
	/*  folloing is a better solution. you use l and r to track:
		 if word1 == word2, then l is current index, and r will be previous index.
		 if not equal, then l and r is for differnt word  */
	 
		    public int shortestWordDistance2(String[] words, String word1, String word2) {
		         int l=-1, r= -1;
		         int s = Integer.MAX_VALUE;
		         for(int i=0; i< words.length; i++){
		             if(word1.equals(words[i])){
		                 l = i;
		                 if( l >=0 && r >=0){
		                     //if word1 == word2, then r is the last index, and l is current index;
		                     s = l ==r ? s : Math.min(s, Math.abs(l-r)); 
		                 }
		             }
		             if(word2.equals(words[i])){
		                 r = i;
		                 if(l >=0 && r >=0){
		                     s = l ==r ? s : Math.min(s, Math.abs(l-r));
		                 }
		             }
		         }

		         return s;		     
       }
}