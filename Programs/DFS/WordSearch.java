package DFS;

/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
For example, given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

ABCC

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Time of DFS:

A -> B -> C -> E
|
S -> F -> C -> S

A    D    E    E

DFS is called m.n
Therefore, overall time complexity is o(m.n. 4 pow of k)
K is length of target word.
 */
public class WordSearch {

	public static void main(String[] args) {
		
		char[][] board= {{'A','B','C','E'},
				         {'S','F','C','S'},
				         {'A','D','E','E'}};
		
		WordSearch ws= new WordSearch();
		boolean isPresent=ws.exist(board, "ABFDAS");
		System.out.println("->"+isPresent);
		
	}
	
	public boolean exist(char[][] board, String word) {
	    for(int i=0; i<board.length; i++){
	        for(int j=0; j<board[0].length; j++){
	            if(dfs(board, word, i, j, 0)){
	                return true;
	            }
	        } 
	    }
	    return false;
	}
	 
	public boolean dfs(char[][] board, String word, int i, int j, int k){
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
	                return true;
	            }
	        }
	    }
	    board[i][j]=t;
	    return false;
	}
	
	// create new function here
	boolean isSafe(int pi,int pj,char[][]board, String word, int k)
	{
		
		 if(pi>=0&&pi<board.length&&pj>=0&&pj<board[0].length&&board[pi][pj]==word.charAt(k+1)){
			 return true;
		 }
		
		return false;
	}
}
