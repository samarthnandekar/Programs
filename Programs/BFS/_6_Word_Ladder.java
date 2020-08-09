package BFS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://www.programcreek.com/2012/12/leetcode-word-ladder/

/*

https://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/

Word Ladder (Length of shortest chain to reach a target word)

Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). Find length of the smallest chain from ‘start’ to ‘target’ if
it exists, such that adjacent words in the chain only differ by one character and each word in the chain is a valid word i.e., it exists in 
the dictionary. It may be assumed that the ‘target’ word exists in dictionary and length of all dictionary words is same.

Example:
Input:  Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
             start = TOON
             target = PLEA
Output: 7
Explanation: TOON - POON - POIN - POIE - PLIE - PLEE - PLEA

The idea is to use BFS. We start from the given start word, traverse all words that adjacent (differ by one character) to it and keep doing 
so until we find the target word or we have traversed all words.

*/

public class _6_Word_Ladder {

	public static void main(String[] args) {
		HashSet<String> d= new HashSet<>(); 
		
	    d.add("poon"); 
	    d.add("plee"); 
	    d.add("same"); 
	    d.add("poie"); 
	    d.add("plie"); 
	    d.add("poin"); 
	    d.add("plea"); 
	    
	    String start = "toon"; 
	    String target = "plea"; 
	    
	    System.out.println(shortestChainLen(start, target, d));  
	    
	    HashSet<String> d2= new HashSet<>(); 
	    String start2 = "hit";
	    String target2 = "cog";
	    
	    d2.add("hot");
	    d2.add("dot");
	    d2.add("dog");
	    d2.add("lot");
	    d2.add("log");
	    d2.add("cog");
	    System.out.println(shortestChainLen(start2, target2, d2));
	}

	
	// Returns length of shortest chain to reach 'target' from 'start' 
	// using minimum number of adjacent moves.  d is dictionary 
	static int shortestChainLen(String start, String target, HashSet<String> d) 
	{ 
	    // Create a queue for BFS and insert 'start' as source vertex 
	    Queue<Qitems> Q=new LinkedList<>(); 
	    Qitems item = new Qitems(start, 1);  // Chain length for start word is 1 
	    
	    Q.add(item); 
	  
	    // While queue is not empty 
	    while (!Q.isEmpty()) 
	    { 
	        // Take the front word 
	        Qitems curr = Q.poll(); 
	  
	        // Go through all words of dictionary 
	        Iterator<String> it= d.iterator();
	        
	       while(it.hasNext())
	        { 
	            // Process a dictionary word if it is adjacent to current word (or vertex) of BFS 
	            String temp =it.next() ; 
	            if (isadjacent(curr.word, temp)) 
	            { 
	                // Add the dictionary word to Q 
	                item.word = temp; 
	                item.len = curr.len + 1; 
	                Q.add(item); 
	  
	                // Remove from dictionary so that this word is not 
	                // processed again.  This is like marking visited 
	                it.remove();
	                // If we reached target 
	                if (temp == target) 
	                  return item.len; 
	            } 
	        } 
	    } 
	    return 0; 
	} 
	
	static boolean isadjacent(String a, String b) 
	{ 
	    int count = 0;  // to store count of differences 
	    int n = a.length(); 
	  
	    // Iterate through all characters and return false 
	    // if there are more than one mismatching characters 
	    for (int i = 0; i < n; i++) 
	    { 
	        if (a.charAt(i) != b.charAt(i)) 
	        	count++; 
	        if (count > 1) 
	        	return false; 
	    } 
	    return count == 1 ? true : false; 
	} 
}


