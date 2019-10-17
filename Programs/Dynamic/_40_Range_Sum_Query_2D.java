package Dynamic;

/*
 304. Range Sum Query 2D - Immutable
 
 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
public class _40_Range_Sum_Query_2D {

	private int[][] T;

    public _40_Range_Sum_Query_2D(int[][] matrix) {
        int row = 0;
        int col = 0;
        if (matrix.length != 0) {
            row = matrix.length;
            col = matrix[0].length;
        }
        T = new int[row + 1][col + 1];
        for (int i = 1; i < T.length; i++)
        {
            for (int j = 1; j < T[0].length; j++) 
            {
                T[i][j] = T[i - 1][j] + T[i][j - 1] + matrix[i - 1][j - 1] - T[i - 1][j - 1];
            }
        }
   }

    public int sumQuery(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return T[row2][col2] - T[row1 - 1][col2] - T[row2][col1 - 1] + T[row1 - 1][col1 - 1];
    }

    public static void main(String args[]) {
        int[][] input = {{3, 0, 1, 4, 2},
                        {5, 6, 3, 2, 1},
                        {1, 2, 0, 1, 5},
                        {4, 1, 0, 1, 7},
                        {1, 0, 3, 0, 5}};

        int[][] input1 = {{2,0,-3,4},
        		          {6, 3, 2, -1},
        		          {5, 4, 7, 3},
        		          {2, -6, 8, 1}};
        
        _40_Range_Sum_Query_2D isr = new _40_Range_Sum_Query_2D(input1);
        System.out.println(isr.sumQuery(1, 1, 2, 2));
    }
}
