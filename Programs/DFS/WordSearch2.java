package DFS;

import java.util.ArrayList;
import java.util.List;

/*
 https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
 
Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells
are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example, given words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
 */
public class WordSearch2 {

	public static void main(String[] args) {
		char [][]board = {{'o','a','a','n'},
				          {'e','t','a','e'},
				          {'i','h','k','r'},
	                      {'i','f','l','v'}};

		String []words = {"oath","pea","eat","rain"};
		List<String> ans=findWords(board,words);
		ans.forEach(item->System.out.println(item));
	}
	
	public static List<String> findWords(char[][] board, String[] words) {
		ArrayList<String> result = new ArrayList<String>();
	 
		int m = board.length;
		int n = board[0].length;
	
		
		for (String word : words) {
			boolean flag = false;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
				{
					if (dfs(board, word, i, j, 0)) 
					{
						flag=true;
						break;
					}	
				}
				if(flag)
					break;
			}
			if(flag)
				result.add(word);
		}
		return result;
	}
	
	public static boolean dfs(char[][] board, String word, int i, int j, int k){
	    if(board[i][j]!=word.charAt(k)){
	        return false;
	    }
	 
	    if(k==word.length()-1){
	        return true;
	    }
	 
	    int[] di={-1,0,1,0};
	    int[] dj={0,1,0,-1};
	 
	    char t = board[i][j];
	    board[i][j]='#';
	 
	    for(int m=0; m<4; m++){
	        int pi=i+di[m];
	        int pj=j+dj[m];
	        if(isSafe(pi, pj,board,word,k)){
	            if(dfs(board,word,pi,pj,k+1)){
	            	board[i][j]=t;
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	// create new function here
	static boolean isSafe(int pi,int pj,char[][]board, String word, int k)
	{
		 if(pi>=0&&pi<board.length&&pj>=0&&pj<board[0].length&&board[pi][pj]==word.charAt(k+1)){
			 return true;
		 }
		
		return false;
	}
}
