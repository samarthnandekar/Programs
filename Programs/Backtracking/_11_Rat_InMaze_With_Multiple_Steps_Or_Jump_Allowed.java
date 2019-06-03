package Backtracking;

/*
 https://www.geeksforgeeks.org/rat-in-a-maze-with-multiple-steps-jump-allowed/
 
 A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. The rat can move only in two directions: forward and down.
In the maze matrix, 0 means the block is dead end and non-zero number means the block can be used in the path from source to destination. The non-zero value of mat[i][j] indicates number of maximum jumps rat can make from cell mat[i][j].

In this variation, Rat is allowed to jump multiple steps at a time instead of 1.

Examples:
Input : {{2, 1, 0, 0},
         {3, 0, 0, 1},
         {0, 1, 0, 1},
         {0, 0, 0, 1}}

Output : {{1, 0, 0, 0},
           {1, 0, 0, 1},
           {0, 0, 0, 1},
           {0, 0, 0, 1}}

Explanation :- Rat started with M[0][0] and can jump upto 2 steps right/down. 
               Let's try in horizontal direction - 
		       M[0][1] won't lead to solution and M[0][2] is 0 which is dead end. 
			   So, backtrack and try in down direction. 
			   Rat jump down to M[1][0] which eventually leads to solution.  

Input : {{2, 1, 0, 0},
         {2, 0, 0, 1},
         {0, 1, 0, 1},
         {0, 0, 0, 1}}

Output : Solution doesn't exist    

If destination is reached
    print the solution matrix
Else
   a) Mark current cell in solution matrix as 1. 
   b) Move forward/jump (for each valid steps) in horizontal direction 
      and recursively check if this move leads to a solution. 
   c) If the move chosen in the above step doesn't lead to a solution
       then move down and check if this move leads to a solution. 
   d) If none of the above solutions work then unmark this cell as 0 
       (BACKTRACK) and return false.
 */

public class _11_Rat_InMaze_With_Multiple_Steps_Or_Jump_Allowed {

	public static void main(String[] args) {
		int maze[][] =   {{ 2, 1, 0, 0 }, 
                          { 3, 0, 0, 1 }, 
                          { 0, 1, 0, 1 }, 
                          { 0, 0, 0, 1 }}; 
         solveMaze(maze);
	}
	
	/* A utility function to check if x, y is valid index for N*N maze */
	static boolean isSafe(int maze[][], int x, int y) 
	{ 
		int N=maze.length;
	    // if (x, y outside maze) return false 
	    if (x >= 0 && x < N && y >= 0 &&  y < N && maze[x][y] != 0) 
	        return true; 
	  
	    return false; 
	} 
	  
	/* This function solves the Maze problem using Backtracking. It mainly uses solveMazeUtil() to  
	solve the problem. It returns false if no path is possible, otherwise return true and prints  
	the path in the form of 1s. Please note that there may be more than one solutions,  
	this function prints one of the feasible solutions.*/
	static boolean solveMaze(int maze[][]) 
	{ 
	    int sol[][] = {{0, 0, 0, 0 }, 
	                   { 0, 0, 0, 0 }, 
	                   { 0, 0, 0, 0 }, 
	                   { 0, 0, 0, 0 }}; 
	  
	    if (!solveMazeUtil(maze, 0, 0, sol)) { 
	        System.out.println("Solution doesn't exist"); 
	        return false; 
	    }
	    printSolution(sol); 
	    return true; 
	}
	
	static void printSolution(int sol[][]) 
	{ 
		int N=sol.length;
	    for (int i = 0; i < N; i++) { 
	        for (int j = 0; j < N; j++) 
	            System.out.print( sol[i][j]); 
	        System.out.println(""); 
	    } 
	} 
	
	/* A recursive utility function to solve Maze problem */
	static boolean solveMazeUtil(int maze[][], int x, int y,  int sol[][]) 
	{ 
	    // if (x, y is goal) return true 
		int N=maze.length;
	    if (x == N - 1 && y == N - 1) 
	    { 
	        sol[x][y] = 1; 
	        return true; 
	    } 
	    // Check if maze[x][y] is valid 
	    if (isSafe(maze, x, y) == true) { 
	  
	        // mark x, y as part of solution path 
	        sol[x][y] = 1; 
	  
	        /* Move forward in x direction */
	        for (int i = 1; i <= maze[x][y] && i < N; i++) { 
	  
	            /* Move forward in x direction */
	            if (solveMazeUtil(maze, x + i, y, sol) == true) 
	                return true; 
	  
	            /* If moving in x direction doesn't give solution then Move down in y direction */
	            if (solveMazeUtil(maze, x, y + i, sol) == true) 
	                return true; 
	        } 
	        /* If none of the above movements work then BACKTRACK: unmark x, y as part of solution path */
	        sol[x][y] = 0; 
	        return false; 
	    } 
	    return false; 
	} 

}
