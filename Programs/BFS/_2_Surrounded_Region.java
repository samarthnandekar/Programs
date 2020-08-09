package BFS;

import java.util.LinkedList;

public class _2_Surrounded_Region {

	
	public static void main(String args[])
	{
		char [] [] inputArr= {{'O','O','O','O','O','O','O'},
				             {'O','X','O','O','O','X','O'},
				             {'O','X','X','X','X','X','O'},
				             {'O','X','O','O','O','X','O'},
				             {'O','X','O','O','O','X','O'},
				             {'O','X','O','O','O','X','O'},
				             {'O','O','X','O','X','O','O'},
				             {'O','O','O','X','O','O','O'},
				             {'O','O','O','O','O','O','O'}};
		
		char [][] inputArrs= {{'X','X','X','X'},
							 {'X','O','O','X'},
							 {'X','X','O','X'},
							 {'X','O','X','X'}};
		
		
		solve(inputArr);
		
		for(int i=0;i<inputArr.length;i++)
		{
			for(int j=0;j<inputArr[0].length;j++)
			{
				System.out.print(inputArr[i][j] +"  ");
			}
			System.out.println();
		}
	}
	
	static public void solve(char[][] board) {
	    if(board==null || board.length==0 || board[0].length==0)
	        return;
	 
	    int m=board.length;
	    int n=board[0].length;
	 
	 
	    for(int j=0; j<n; j++){
	        if(board[0][j]=='O'){
	            bfs(board, 0, j);
	        }
	    }
	 
	    for(int j=0; j<n; j++){
	        if(board[m-1][j]=='O'){
	            bfs(board, m-1, j);
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        if(board[i][0]=='O'){
	            bfs(board, i, 0);
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        if(board[i][n-1]=='O'){
	            bfs(board, i, n-1);
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(board[i][j]=='O'){
	                board[i][j]='X';
	            }
	            if(board[i][j]=='1'){
	                board[i][j]='O';
	            }
	        }
	    }
	}
	 
	static public void bfs(char[][] board, int o, int p){
	    int m=board.length;
	    int n=board[0].length;
	 
	    //int index = o*n+p;
	    Index index= new Index(o, p);
	    LinkedList<Index> queue = new LinkedList<Index>();
	    queue.offer(index);
	    board[o][p]='1';
	 
	    while(!queue.isEmpty()){
	        Index top = queue.poll();
	        int i=top.x;
	        int j=top.y;
	 
	        if(i-1>=0 && board[i-1][j]=='O'){
	            board[i-1][j]='1';
	            Index nextIndex=new Index(i-1,j);
	            queue.offer(nextIndex);
	        }
	        if(i+1<m && board[i+1][j]=='O'){
	            board[i+1][j]='1';
	            Index nextIndex=new Index(i+1,j);
	            queue.offer(nextIndex);
	        }
	        if(j-1>=0 && board[i][j-1]=='O'){
	            board[i][j-1]='1';
	            Index nextIndex=new Index(i,j-1);
	            queue.offer(nextIndex);
	        }
	        if(j+1<n && board[i][j+1]=='O'){
	            board[i][j+1]='1';
	            Index nextIndex=new Index(i,j+1);
	            queue.offer(nextIndex);
	        }
	    }
	}
}

