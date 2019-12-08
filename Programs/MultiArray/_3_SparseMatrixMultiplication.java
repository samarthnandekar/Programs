package MultiArray;

/*
 Given two sparse matrices A and B, return the result of AB. You may assume that A's column number is equal to B's row number.
 
A =  [[ 1, 0, 0],
      [-1, 0, 3]]

B = [[ 7, 0, 0 ],
     [ 0, 0, 0 ],
     [ 0, 0, 1 ]]

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
                  
*/
public class _3_SparseMatrixMultiplication {

	public static void main(String[] args) {
		int [][]A =  {{1, 0, 0},
		              {-1, 0, 3}};

		int [][]B = {{7,0,0},
                     {0,0,0},
                     {0,0,1}};
		  
		int [] [] res=multiply(A,B);
		    print(res);
		    System.out.println("--------------");
		    
		int [] [] res1=multiply_2(A,B);
		    print(res1);
	}

	static void print(int [][]a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
			System.out.print(a[i][j] + "  ");	
			}
			System.out.println("");
		}
	}
	
	/* 1. Naive Method
	   Time complexity is O(n^3).
	   Time complexity: O(A's row * B's column * A's column (which is the same as B's row)). This solution exceeds the time limit. */
	
	static public int[][] multiply(int[][] A, int[][] B) {
	    //validity check
	 
	    int[][] C = new int[A.length][B[0].length];
	 
	    for(int i=0; i<C.length; i++){
	        for(int j=0; j<C[0].length; j++){
	            int sum=0;
	            for(int k=0; k<A[0].length; k++){
	                sum += A[i][k]*B[k][j];
	            }
	            C[i][j] = sum;
	        }
	    }
	    return C;
	}
	
	/*
	 *How do I use the information that the matrices are sparse? Instead of iterating through the product matrix, I can iterate through A,
	 * and add the contribution of each number to the result matrix. If A[i][j] == 0, I can just skip the calculation. 
	 */
	static public int[][] multiply_2(int[][] A, int[][] B) {
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
