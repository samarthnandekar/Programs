package Dynamic;

/*
Find the longest path in a matrix with given constraints
Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) such that all cells along the path are in increasing order with a difference of 1.

We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.

Example:
Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9. 

https://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/

 */
public class _5_Longest_Path_InMatrix {

	public static void main(String[] args) {
		int mat[][] = {{1,2,9},
			           {5,3,8},
				       {4,6,7}};
	

		int res=findLongestOverAll(mat);
		System.out.println(res);
	}

	
	static int findLongestOverAll(int [][]mat)
	{
		int result=1;
		int n=mat.length;
		int[][] dp=new int [n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				dp[i][j]=-1;
			}
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(dp[i][j]==-1)
				{
					dp[i][j]=findLongestFromAcell(i,j,mat,dp);
					result=Math.max(result, dp[i][j]);
				}
			}
		}
		return result;
	}
	
	static int findLongestFromAcell(int r,int c,int mat[][], int [][] dp)
	{
		int n=mat.length;
		// base case
		if(r<0 || r>=n || c<0 || c>=n)
			return 0;
		
		
		if(dp[r][c]!=-1)
			return dp[r][c];
		
		int [] row= {0,0,-1,1};
		int [] col= {1,-1,0,0};
		
		for(int index=0;index<col.length;index++)
		{
              int nextRow=r+row[index];
              int nextCol=c+col[index];
              
              if(isSafe(nextCol, nextRow, n) && mat[r][c]+1==mat[nextRow][nextCol])
              {
            	  dp[r][c]=1+findLongestFromAcell(nextRow,nextCol,mat,dp);
            			  return dp[r][c];
              }
		}
		return dp[r][c]=1;
	}
	
	static boolean isSafe(int col,int row,int size)
	{
	   return col>=0 && col<size && row<size && row>=0;	
	}
}
