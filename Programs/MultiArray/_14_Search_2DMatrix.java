package MultiArray;

/*
 https://www.programcreek.com/2013/01/leetcode-search-a-2d-matrix-java/
 
LeetCode – Search a 2D Matrix (Java)
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has properties:

1) Integers in each row are sorted from left to right. 2) The first integer of each row is greater than the last integer of the previous row.
For example, consider the following matrix:

[[1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]]
  
Given target = 3, return true.

******* if it difficult to understand, then can use solution of _15_search_2DMatrix_ll. 
 */


public class _14_Search_2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) 
	{
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int start = 0;
        int end = m*n-1;
 
        while(start<=end){
            int mid=(start+end)/2;
            int midX=mid/n;
            int midY=mid%n;
 
            if(matrix[midX][midY]==target) 
                return true;
 
            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
	
	 public static void main(String args[]) {
	       
	        int[][] image =   {{1,3,5,7}, 
	        		          {10,11,16,20},
	        		          {23,30,34,50}};
	        _14_Search_2DMatrix sbp = new _14_Search_2DMatrix();
	        System.out.print(sbp.searchMatrix(image, 3));
	    }
}
