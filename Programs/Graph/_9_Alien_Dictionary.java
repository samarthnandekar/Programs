 package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 
 269 Alien Dictionary
 
 There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
Example 1:
Given the following words in dictionary,
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
Example 2:
Given the following words in dictionary,
[
  "z",
  "x"
]
The correct order is: "zx".
Example 3:
Given the following words in dictionary,
[
  "z",
  "x",
  "z"
]

Input:  words[] = {"caa", "aaa", "aab"}
Output: Order of characters is 'c', 'a', 'b'
 
 
 Time Complexity: The first step to create a graph takes O(n + alhpa) time where n is number of given words and alpha is number of characters in given alphabet. 
 The second step is also topological sorting. Note that there would be alpha vertices and at-most (n-1) edges in the graph. The time complexity of topological 
 sorting is O(V+E) which is O(n + aplha) here. So overall time complexity is O(n + aplha) + O(n + aplha) which is O(n + aplha).
 
 */
public class _9_Alien_Dictionary {

	 public static void main(String[] args) 
	    { 
	        String[] words = {"caa", "aaa", "aab"}; 
	        String ans=printOrder(words); 
	        System.out.println(ans);
	        
	        String[] words1 = {"wrt","wrf","er", "ett","rftt"};
	        String ans1=printOrder(words1); 
	        System.out.println(ans1);
	    } 
	 
	 
	 private static String printOrder(String[] words) 
	    { 
	        // Create a graph with 'aplha' edges 
		 Map<Integer, List<Integer>> graph = new HashMap<>();
		 
		 for (String word : words) {
	            for (int c : word.toCharArray()) {
	                graph.put(c- 'a', new ArrayList<Integer>());
	            }
	        }
		 
	        for (int i = 0; i < words.length - 1; i++) 
	        { 
	            // Take the current two words and find the first mismatching character 
	            String word1 = words[i]; 
	            String word2 = words[i+1]; 
	            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) 
	            { 
	            	int parent = word1.charAt(j) - 'a';
	                int child = word2.charAt(j) - 'a';
	                // If we find a mismatching character, then add an edge from character of word1 to that of word2 
	                if (parent != child) 
	                {   	
	                	if (!graph.get(parent).contains(child)) {
	                		graph.get(parent).add(child);
	                	}
	                    break; 
	                } 
	            } 
	        }    
	        String ansStr=topologicalSort(graph);
	        return ansStr;
	    } 
	 
	 static String  topologicalSort( Map<Integer,List<Integer>> graph) 
	    { 
	        Stack<Integer> stack = new Stack<>(); 
	  
	        // Mark all the vertices as not visited 
	        int NoOfVertices=graph.size();
	        boolean[] visited = new boolean[26]; 
	  
	        // Call the recursive helper function to store Topological Sort starting from all vertices one by one 
	        for (int i : graph.keySet())
	        { 
	            if (!visited[i]) 
	            { 
	                topologicalSortUtil(i, visited, stack,graph); 
	            } 
	        } 
	  
	        // Print contents of stack 
	        String ansStr="";
	        while (!stack.isEmpty()) 
	        { 
	            ansStr=ansStr+(char)('a' + stack.pop()) + " "; 
	        } 
	        return ansStr;
	    } 
	 
	 // A recursive function used by topologicalSort 
	    static private void topologicalSortUtil(int currentVertex, boolean[] visited, Stack<Integer> stack,Map<Integer, List<Integer>> graph) 
	    { 
	        // Mark the current node as visited. 
	        visited[currentVertex] = true; 
	  
	        // Recur for all the vertices adjacent to this vertex      
	        List<Integer> adjacentVertexes= graph.get(currentVertex); 	
	        	for (Integer adjacentVertex : adjacentVertexes)
		        { 
		            if (!visited[adjacentVertex]) 
		            { 
		                topologicalSortUtil(adjacentVertex, visited, stack,graph); 
		            } 
		        } 
	                
	        // Push current vertex to stack which stores result 
	        stack.push(currentVertex); 
	    } 
}
