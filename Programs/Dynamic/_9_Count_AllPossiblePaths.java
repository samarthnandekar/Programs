package Dynamic;
/*
 
 https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 
 Count all possible paths from top left to bottom right of a mXn matrix
The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down

Examples :

Input :  m = 2, n = 2;
Output : 2
There are two paths
(0, 0) -> (0, 1) -> (1, 1)
(0, 0) -> (1, 0) -> (1, 1)

Input :  m = 2, n = 3;
Output : 3
There are three paths
(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)


https://leetcode.com/problems/unique-paths/
62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Example 1:  Input: m = 3, n = 2
Output: 3
Explanation:- From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28

 */
public class _9_Count_AllPossiblePaths {

	 public int countPathsRecursive(int n, int m){
	        if(n == 1 || m == 1){
	            return 1;
	        }
	        return countPathsRecursive(n-1, m) + countPathsRecursive(n, m-1);
	    }
	    
	    public int countPaths(int n,int m){
	        int T[][] = new int[n][m];
	        for(int i=0; i < n; i++){
	            T[i][0] = 1;
	        }
	        
	        for(int i=0; i < m; i++){
	            T[0][i] = 1;
	        }
	        for(int i=1; i < n; i++){
	            for(int j=1; j < m; j++){
	                T[i][j] = T[i-1][j] + T[i][j-1];
	            }
	        }
	        return T[n-1][m-1];
	    }
	    
	    public static void main(String args[]){
	    	_9_Count_AllPossiblePaths nop = new _9_Count_AllPossiblePaths();
	        System.out.println(nop.countPathsRecursive(3,3));
	        System.out.println(nop.countPathsRecursive(3,2));
	        System.out.println(nop.countPathsRecursive(7,3));
	    }

}
