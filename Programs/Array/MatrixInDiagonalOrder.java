package Array;

/* https://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/

Zigzag (or diagonal) traversal of Matrix
Given a 2D matrix, print all elements of the given matrix in diagonal order. For example, consider the following 5 X 4 input matrix.

    1     2     3     4
    5     6     7     8
    9    10    11    12
   13    14    15    16
   17    18    19    20
   
   
Diagonal printing of the above matrix is

    1
    5     2
    9     6     3
   13    10     7     4
   17    14    11     8
   18    15    12
   19    16
   20

 */

public class MatrixInDiagonalOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[][] = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16},
                       {17, 18, 19, 20}};
		
		MatrixInDiagonalOrder mdo = new MatrixInDiagonalOrder();
		mdo.printMatrix(arr);

	}
	
	public void printMatrix(int [][]matrix){
		
		// for loop to print diagonal below part
		for(int i=0; i < matrix.length; i++){
			int start =i;
			int end =0;
			while(start >= 0 && end < matrix[0].length){
				System.out.print(matrix[start][end] + " ");
				start--;
				end++;
			}
			System.out.print("\n");
		}
		
		// for loop to print diagonal upper part
		for(int i=1; i < matrix[0].length; i++){
			int start = matrix.length-1;
			int end =i;
			while(start >= 0 && end < matrix[0].length){
				System.out.print(matrix[start][end] + " ");
				start--;
				end++;
			}
			System.out.print("\n");
		}
		
	}
}
