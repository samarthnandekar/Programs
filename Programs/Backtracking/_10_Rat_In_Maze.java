package Backtracking;

public class _10_Rat_In_Maze {

	void printSolution(int sol[][]) 
    { 
		int N=sol.length;
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
                System.out.print(" " + sol[i][j] + 
                                 " "); 
            System.out.println(); 
        } 
    } 
  
    /* A utility function to check if x,y is valid index for N*N maze */
    boolean isSafe(int maze[][], int x, int y) 
    { 
    	int N=maze.length;
        // if (x,y outside maze) return false 
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1); 
    }
    
 
    boolean solveMaze(int maze[][]) 
    { 
        int sol[][] = {{0, 0, 0, 0}, 
            {0, 0, 0, 0}, 
            {0, 0, 0, 0}, 
            {0, 0, 0, 0} 
        }; 
        int [] xmove= {0,1};
        int [] ymove= {1,0};
        
        sol[0][0]=1;
        if (solveMazeUtil(maze, 0, 0,xmove,ymove,sol) == false) 
        { 
            System.out.print("Solution doesn't exist"); 
            return false; 
        } 
        printSolution(sol); 
        return true; 
    } 
    
    boolean solveMazeUtil(int maze[][], int x, int y,int []xmove, int []ymove,int [][] sol) 
      { 
    		// if (x,y is goal) return true 
    	int N=maze.length;
		if (x == N - 1 && y == N - 1) 
		{ 
		return true; 
		} 
		boolean pathFound=false;
		
		for(int i=0;i<xmove.length;i++)
		{
		int nextX=x+xmove[i];
		int nexY=y+ymove[i];
		
		if(isSafe(maze, nextX, nexY))
		{
			sol[nextX][nexY]=1;
			pathFound=solveMazeUtil(maze, nextX, nexY, xmove, ymove,sol);
			if(pathFound)
			{
				return true;
			}
			else
			{
				sol[nextX][nexY]=-1;
			}
		  }
		}
       return false; 
    } 
    
    public static void main(String args[]) 
    { 
    	_10_Rat_In_Maze rat = new _10_Rat_In_Maze(); 
        int maze[][] = {{1, 0, 0, 0}, 
            {1, 1, 0, 1}, 
            {0, 1, 0, 0}, 
            {1, 1, 1, 1} 
        }; 
        rat.solveMaze(maze); 
    }
    
}
