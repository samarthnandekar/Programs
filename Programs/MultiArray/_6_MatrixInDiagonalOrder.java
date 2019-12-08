package MultiArray;

// http://www.geeksforgeeks.org/print-matrix-diagonally/

public class _6_MatrixInDiagonalOrder {

	public void printMatrix(int [][]matrix){
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
	
	public static void main(String args[]){
		int arr[][] = {{1,2,3,4},
				       {5,6,7,8},
				       {9,10,11,12},
				       {13,14,15,16}};
		_6_MatrixInDiagonalOrder mdo = new _6_MatrixInDiagonalOrder();
		mdo.printMatrix(arr);
	}
	
}
