package Trie;

public class Boggle {

	static int M,N;
	
	
	 public static void main(String args[]) 
	    { 
	        // Let the given dictionary be following 
	        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"}; 
	       
	        // root Node of trie 
	        TrieNode root = new TrieNode(); 
	       
	        // insert all words of dictionary into trie 
	        int n = dictionary.length; 
	        for (int i=0; i<n; i++) 
	            insert(root, dictionary[i]); 
	       
	        char boggle[][] = {{'G','I','Z'}, 
	                           {'U','E','K'}, 
	                           {'Q','S','E'} 
	        }; 
	       M=boggle.length;
	       N=boggle[0].length;
	        findWords(boggle, root); 
	               
	    } 
	 
	 static void findWords(char boggle[][], TrieNode root) 
	    { 
	        // Mark all characters as not visited 
	        boolean[][] visited = new boolean[M][N]; 
	        TrieNode pChild = root ; 
	       
	        String str = ""; 
	       
	        // traverse all matrix elements 
	        for (int i = 0 ; i < M; i++) 
	        { 
	            for (int j = 0 ; j < N ; j++) 
	            { 
	                // we start searching for word in dictionary 
	                // if we found a character which is child 
	                // of Trie root 
	                if (pChild.children[(boggle[i][j]) - 'A'] != null) 
	                { 
	                    str = str+boggle[i][j]; 
	                    searchWord(pChild.children[(boggle[i][j]) - 'A'], 
	                               boggle, i, j, visited, str); 
	                    str = ""; 
	                } 
	            } 
	        } 
	    } 
	 
	 static void insert(TrieNode root, String Key) 
	 { 
	        int n = Key.length(); 
	        TrieNode pChild = root; 
	       
	        for (int i=0; i<n; i++) 
	        { 
	            int index = Key.charAt(i) - 'A'; 
	       
	            if (pChild.children[index] == null) 
	                pChild.children[index] = new TrieNode(); 
	       
	            pChild = pChild.children[index]; 
	        } 
	       
	        // make last node as leaf node 
	        pChild.isEndOfWord = true; 
	    } 
	       
	    // function to check that current location 
	    // (i and j) is in matrix range 
	    static boolean isSafe(int i, int j, boolean visited[][]) 
	    { 
	        return (i >=0 && i < M && j >=0 && j < N && !visited[i][j]); 
	    } 
	       
	    // A recursive function to print all words present on boggle 
	    static void searchWord(TrieNode root, char boggle[][], int i, int j, boolean visited[][], String str) 
	    { 
	        // if we found word in trie / dictionary 
	        if (root.isEndOfWord == true) 
	           System.out.println(str); 
	          
	        // If both I and j in  range and we visited that element of matrix first time 
	        if (isSafe(i, j, visited)) 
	        { 
	            // make it visited 
	            visited[i][j] = true; 
	       
	            // traverse all child of current root 
	            for (int K =0; K < 26; K++) 
	            { 
	                if (root.children[K] != null) 
	                { 
	                    // current character 
	                    char ch = (char) (K + 'A') ; 
	       
	                    // Recursively search reaming character of word in trie for all 8 adjacent cells of boggle[i][j]         
	                    for (int row=-1; row<=1; row++) 
	                    {
	              	      for (int col=-1; col<=1; col++) 
	              	      {
	              	    	if (isSafe(i+row,j+col,visited) && boggle[i+row][j+col] == ch)
	              	        	searchWord(root.children[K],boggle,i+row,j+col,visited,str+ch);
	              	      }
	                    }
	                } 
	            } 
	       
	            // make current element unvisited 
	            visited[i][j] = false; 
	        } 
	    } 
}
