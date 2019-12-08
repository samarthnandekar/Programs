package MultiArray;
/*
 A Boolean Matrix Question
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and
 jth column as 1.

Example 1:- The matrix
1 0
0 0

should be changed to following
1 1
1 0

Example 2:- The matrix
0 0 0
0 0 1

should be changed to following
0 0 1
1 1 1

Example 3:- The matrix
1 0 0 1
0 0 1 0
0 0 0 0

should be changed to following
1 1 1 1
1 1 1 1
1 0 1 1

*/
public class _2_Fill2DMatrixWith1 
{
	
	 public static void main(String args[])
	 {
        int [][]arr= {{0,0,1},
        		      {0,1,0},
        		      {0,0,0}};
        
        
        setOne(arr);
        
        print(arr);
	 }
	
	static public void setOne(int [][] matrix)
	{
		boolean []row= new boolean[matrix.length];
		boolean []col= new boolean[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				if(matrix[i][j]==1)
				{
					row[i]=true;
					col[j]=true;
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				
				if(row[i] || col[j])
				{
					matrix[i][j]=1;
				}
			}
		}
		
				
	}
	
	
	static void print(int [][]matrix)
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
			
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println("");
		}
	}
	
}
