package Backtracking;

public class _8_NQueenProblem {

	void printSolution(int board[][]) 
	{ 
		int N=board.length;
		for (int i = 0; i < N; i++) 
		{ 
			for (int j = 0; j < N; j++) 
				System.out.print(" " + board[i][j] 
								+ " "); 
			System.out.println(); 
			
		} 
		System.out.println("============================");
	} 

	/* A utility function to check if a queen can 
	be placed on board[row][col]. Note that this 
	function is called when "col" queens are already 
	placeed in columns from 0 to col -1. So we need 
	to check only left side for attacking queens */
	boolean isSafe(int board[][], int row, int col, int N) 
	{ 
		int i, j; 

		/* Check this row on left side */
		for (i = 0; i < col; i++) 
			if (board[row][i] == 1) 
				return false; 

		/* Check upper diagonal on left side */
		for (i=row, j=col; i>=0 && j>=0; i--, j--) 
			if (board[i][j] == 1) 
				return false; 

		/* Check lower diagonal on left side 
		for (i=row, j=col; j>=0 && i<N; i++, j--) 
			if (board[i][j] == 1) 
				return false; 
				*/

		return true; 
	} 

	/* A recursive utility function to solve N 
	Queen problem */
	boolean solveNQUtil(int board[][], int col, int N) 
	{ 
		/* base case: If all queens are placed then return true */
		if (col >= N) 
		{
			printSolution(board);
			return true; 	
		}
			
		/* Consider this column and try placing this queen in all rows one by one */
		boolean res=false;
		for (int i = 0; i < N; i++) 
		{ 
			/* Check if the queen can be placed on board[i][col] */
			if (isSafe(board, i, col,N)) 
			{ 
				/* Place this queen in board[i][col] */
				board[i][col] = 1; 

				/* recur to place rest of the queens */
				res= solveNQUtil(board, col + 1,N) || res; 

				/* If placing queen in board[i][col] doesn't lead to a solution then 
				remove queen from board[i][col] */
				board[i][col] = 0; // BACKTRACK 
			} 
		} 

		/* If the queen can not be placed in any row in this colum, then return false */
		return res; 
	} 

	/*  It mainly uses solveNQUtil () to 
	solve the problem. It returns false if queens 
	cannot be placed, otherwise, return true and 
	prints placement of queens in the form of 1s. 
	Please note that there may be more than one 
	solutions, this function prints one of the 
	feasible solutions.*/
	boolean solveNQ(int nQueen) 
	{ 
		int board[][] = new int [nQueen][nQueen];

		if (solveNQUtil(board, 0,nQueen) == false) 
		{ 
			System.out.print("Solution does not exist"); 
			return false; 
		} 

		//printSolution(board); 
		return true; 
	} 

	// driver program to test above function 
	public static void main(String args[]) 
	{ 
		_8_NQueenProblem Queen = new _8_NQueenProblem(); 
		Queen.solveNQ(4); 
	} 
}
