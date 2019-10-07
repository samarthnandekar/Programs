package Array;

/*
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells
of ith row and jth column as 1.

Example 1
The matrix
1 0
0 0
should be changed to following
1 1
1 0

Example 2
The matrix
0 0 0
0 0 1
should be changed to following
0 0 1
1 1 1

Example 3
The matrix
1 0 0 1
0 0 1 0
0 0 0 0
should be changed to following
1 1 1 1
1 1 1 1
1 0 1 1

 */
public class Boolean_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[][] = {{0,0,1,0,0,0},
				         {0,0,0,0,0,0},
				         {1,0,0,0,0,0}};
		
		Boolean_Matrix fd = new Boolean_Matrix();
		fd.fill(input);
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}

	}

	public void fill(int input[][]){
		boolean row[] = new boolean[input.length];
		boolean col[] = new boolean[input[0].length];
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				if(input[i][j] == 1){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				if(row[i] || col[j]){
					input[i][j] = 1;
				}
			}
		}
	}
}
