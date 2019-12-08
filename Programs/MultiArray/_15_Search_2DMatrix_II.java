package MultiArray;

/*
 https://leetcode.com/problems/search-a-2d-matrix-ii/
 240. Search a 2D Matrix II
 https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example:-
Consider the following matrix:
 [[1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],   
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]]
  
Given target = 5, return true.
Given target = 20, return false. */

public class _15_Search_2DMatrix_II {

	public static void main(String[] args) {
		
		int [][] arr= {{1,   4,  7, 11, 15},
		               {2,   5,  8, 12, 19},
		               {3,   6,  9, 16, 22},
		               {10, 13, 14, 17, 24},
		               {18, 21, 23, 26, 30}};
		_15_Search_2DMatrix_II obj= new _15_Search_2DMatrix_II();
		int input=5;
		boolean isPresent=obj.searchMatrix(arr,input);
		System.out.println(input+" is Present "+isPresent);
		
		 input=20;
		 isPresent=obj.searchMatrix(arr,input);
		System.out.println(input+" is Present "+isPresent);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row - 1;
        int y = 0;
        
        while (x >= 0 && y < col) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {//matrix[x][y] == target
                return true;
            }
        }
        return false;
    }
}
