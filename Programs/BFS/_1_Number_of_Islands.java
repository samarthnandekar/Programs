package BFS;

import java.util.LinkedList;

public class _1_Number_of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char [][] inputArrs= {{'O','O','O','O'},
							  {'O','1','1','O'},
		                      {'O','O','O','O'},
		                      {'O','1','O','O'}};
		
		_1_Number_of_Islands obj= new _1_Number_of_Islands();
		int count=obj.numIslands_BFS(inputArrs);
		System.out.println(count);
		
		int [][] inputArrs1= {{0,0,0,0},
				              {0,1,1,0},
                              {0,0,0,0},
                              {0,1,0,0}};
		int count2=obj.countIslands(inputArrs1);
		System.out.println(count2);
	}
	
	public int numIslands_BFS(char[][] grid) {
	    int count=0;
	    for(int i=0;i<grid.length;i++)
	        for(int j=0;j<grid[0].length;j++){
	            if(grid[i][j]=='1'){
	                bfsFill(grid,i,j);
	                count++;
	            }
	        }
	    return count;
	}
	
	private void bfsFill(char[][] grid,int x, int y){
	    grid[x][y]='0';
	    int n = grid.length;
	    int m = grid[0].length;
	    LinkedList<Integer> queue = new LinkedList<Integer>();  
	    
	    // in place of this, we can use Index class to get values 
	    int code = x*m+y;
	    
	    //******************** use Index call where int col and row..
	    
	    queue.offer(code);  
	    while(!queue.isEmpty())  
	    {  
	        code = queue.poll();  
	        int i = code/m;  
	        int j = code%m;  
	        if(i>0 && grid[i-1][j]=='1')    //search upward and mark adjacent '1's as '0'.
	        {  
	            queue.offer((i-1)*m+j);  
	            grid[i-1][j]='0';  
	        }  
	        if(i<n-1 && grid[i+1][j]=='1')  //down
	        {  
	            queue.offer((i+1)*m+j);  
	            grid[i+1][j]='0';  
	        }  
	        if(j>0 && grid[i][j-1]=='1')  //left
	        {  
	            queue.offer(i*m+j-1);  
	            grid[i][j-1]='0';  
	        }  
	        if(j<m-1 && grid[i][j+1]=='1')  //right
	        {  
	            queue.offer(i*m+j+1);  
	            grid[i][j+1]='0';  
	        }
	    } 
	}
	
	// A function to check if a given cell (row, col) can be included in DFS 
    boolean isSafe(int M[][], int row, int col, boolean visited[][]) 
    { 
        // row number is in range, column number is in range and value is 1 and not yet visited
    	int ROW=M.length;
    	int COL=M[0].length;
    	
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col]==1 && !visited[row][col]); 
    } 
  
    // A utility function to do DFS for a 2D boolean matrix. It only considers the 8 neighbors as adjacent vertices 
    void DFS(int M[][], int row, int col, boolean visited[][]) 
    { 
        // These arrays are used to get row and column numbers of 8 neighbors of a given cell 
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1}; 
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1}; 
  
        // Mark this cell as visited 
        visited[row][col] = true; 
  
        // Recur for all connected neighbours 
        for (int k = 0; k < 8; ++k) 
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) ) 
                DFS(M, row + rowNbr[k], col + colNbr[k], visited); 
    } 
  
    // The main function that returns count of islands in a given boolean 2D matrix 
    int countIslands(int M[][]) 
    { 
        // Make a bool array to mark visited cells. Initially all cells are unvisited 
    	int row=M.length;
    	int col=M[0].length;
        boolean visited[][] = new boolean[row][col]; 
  
  
        // Initialize count as 0 and travese through the all cells of given matrix 
        int count = 0; 
        for (int i = 0; i < row; ++i) 
            for (int j = 0; j < col; ++j) 
                if (M[i][j]==1 && !visited[i][j]) // If a cell with 
                {                                 // value 1 is not 
                    // visited yet, then new island found, Visit all 
                    // cells in this island and increment island count 
                    DFS(M, i, j, visited); 
                    ++count; 
                } 
  
        return count; 
    } 


}



