package MultiArray;

import java.awt.geom.GeneralPath;

/*
 https://leetcode.com/problems/spiral-matrix-ii/
 59. Spiral Matrix II
 Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

public class _21_Spiral_Matrix2 {

	public static void main(String[] args) {

		_21_Spiral_Matrix2 obj = new _21_Spiral_Matrix2();
		int[][] ans = obj.generateMatrix(4);
		obj.print(ans);
	}

	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		if (n == 0) {
			return result;
		}

		int start = 1;
		int row = 0;
		int col = 0;

		while (n > 0) {
			if (n == 1) {
				result[row][col] = start;
				break;
			}

			// Move right
			for (int i = 0; i < n - 1; i++) {
				result[row][col++] = start++;
			}

			// Move down
			for (int i = 0; i < n - 1; i++) {
				result[row++][col] = start++;
			}

			// Move left
			for (int i = 0; i < n - 1; i++) {
				result[row][col--] = start++;
			}

			// Move up
			for (int i = 0; i < n - 1; i++) {
				result[row--][col] = start++;
			}

			row++;
			col++;
			n -= 2;
		}

		return result;
	}

	void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) { // Loop through all elements of current row
			for (int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println("");
		}
	}
}
