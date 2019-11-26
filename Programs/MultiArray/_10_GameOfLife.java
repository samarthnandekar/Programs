package MultiArray;

/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician
John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, 
vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the
above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:
Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:- Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then 
use their updated values to update other cells. In this question, we represent the board using a 2D array. In principle, the board is infinite,
 which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 
 */

public class _10_GameOfLife {
	
	public static void main(String[] args) {
		
		int [][] arr={{0,1,0},
			          {0,0,1},
			          {1,1,1},
			          {0,0,0}};

		gameOfLife(arr);
		  print(arr);       
	}
	
	static void print(int [][]a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        int[] prevRow = new int[m];
        int[] currentRow = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                currentRow[j] = doesLive(i, j, board) ? 1 : 0;
            }
            if (i != 0) {
                copyRow(prevRow, board[i - 1]);
            }
            if (i != n - 1) {
                copyRow(currentRow, prevRow);
            }
        }
        copyRow(currentRow, board[n - 1]);
    }

    private  static void copyRow(int[] source, int[] dest) {
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
    }

    private static boolean doesLive(int x, int y, int[][] board) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (x == i && y == j) {
                    continue;
                }
                if (i < 0 || i >= board.length) {
                    break;
                }
                if (j < 0 || j >= board[0].length) {
                    continue;
                }
                count += board[i][j];
            }
        }
        if (board[x][y] == 1) {
            return count == 2 || count == 3;
        } else {
            return count == 3;
        }
    }

}
