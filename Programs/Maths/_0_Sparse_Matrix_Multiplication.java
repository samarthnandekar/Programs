package Maths;

/*
311. Sparse Matrix Multiplication

Given two sparse matrices A and B, return the result of AB.
You may assume that A's column number is equal to B's row number.
Example:
A = [[ 1, 0, 0],
     [-1, 0, 3]]

B = [[ 7, 0, 0 ],
     [ 0, 0, 0 ],
     [ 0, 0, 1 ]]

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |

 */
public class _0_Sparse_Matrix_Multiplication {

	public static void main(String[] args) {
		int [][] arr1= {{1,0,0},
				        {-1,0,3}};
		
		int [][] arr2= {{7,0,0},
		                {0,0,0},
		                {0,0,1}};

		_0_Sparse_Matrix_Multiplication obj= new _0_Sparse_Matrix_Multiplication();
		int ans[][] = obj.multiply(arr1, arr2);
		
		for(int i=0;i<ans.length;i++)
		{
			for(int j=0;j<ans[0].length;j++)
			{
				System.out.print(ans[i][j]+ "  ");
			}
			System.out.println();
		}
	}

	/*
	 How do I use the information that the matrices are sparse? Instead of iterating through the product matrix, 
	 I can iterate through A, and add the contribution of each number to the result matrix. If A[i][j] == 0, I 
	 can just skip the calculation.
	 */
	 public int[][] multiply(int[][] A, int[][] B) {
	        int ARow = A.length;
	        int AColumn = A[0].length;
	        int BRow = B.length;
	        int BColumn = B[0].length;
	        
	        int[][] product = new int[ARow][BColumn];
	        for (int i = 0; i < ARow; i++) {
	            for (int j = 0; j < AColumn; j++) {
	                if (A[i][j] == 0) {
	                    continue;
	                }
	                for (int k = 0; k < BColumn; k++) {
	                    product[i][k] += A[i][j] * B[j][k];
	                }
	            }
	        }
	        return product;
	    }
}
