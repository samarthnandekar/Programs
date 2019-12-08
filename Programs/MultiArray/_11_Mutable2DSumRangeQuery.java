package MultiArray;

/*
 304. Range Sum Query 2D - Immutable
 Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and 
 lower right corner (row2, col2).
 
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
public class _11_Mutable2DSumRangeQuery 
{

	private int[][] prefixSum;
    private int rows;
    private int cols;
    private int[][] matrix;

    public _11_Mutable2DSumRangeQuery(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        prefixSum = new int[matrix.length][matrix[0].length + 1];
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = col + 1; i <= cols; i++) {
            prefixSum[row][i] += delta;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += prefixSum[i][col2 + 1] - prefixSum[i][col1];
        }
        return sum;
    }
    
    public static void main(String args[])
    {
    	int [][] matrix = {{3, 0, 1, 4, 2},
    	                  {5, 6, 3, 2, 1},
    	                  {1, 2, 0, 1, 5},
    	                  {4, 1, 0, 1, 7},
    	                  {1, 0, 3, 0, 5}};
    	
    	_11_Mutable2DSumRangeQuery obj= new _11_Mutable2DSumRangeQuery(matrix);
    	int ans=obj.sumRegion(2, 1, 4, 3);
    	
    	System.out.println(ans);
    }
}
