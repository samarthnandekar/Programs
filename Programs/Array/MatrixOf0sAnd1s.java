package Array;

public class MatrixOf0sAnd1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MatrixOf0sAnd1s mos = new MatrixOf0sAnd1s();
		char matrix[][] = mos.create(10, 7);
		for(int i=0; i < matrix.length; i++){
			for(int j=0; j < matrix[i].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public char[][] create(int n,int m)
	{
		
		char[][] matrix = new char[n][m];
		
		int r = 0;
		char ch = 'X';
		int high = Math.min(n, m);
		//high is min of n and m. If high is odd then high is ceiling of high/2
		//else high is high/2. e.g high is 5 then high becomes 3 if high is 4
		//high becomes 2
		high = (int)Math.ceil(high*1.0/2);
		while(r < high){
			
			//buttom row
			for(int i=r; i < m-r ; i++){
				matrix[r][i] = ch;
			}
			
			// right column
			for(int i = r; i < n-r; i++ ){
				matrix[i][m-r-1] = ch;
			}
			
             // upper row
			for(int i = m-r-1; i >= r; i-- ){
				matrix[n-r-1][i] = ch;
			}
            
			// left column
			for(int i = n-r-1; i >= r; i-- ){
				matrix[i][r] = ch;
			}
			
			if(ch =='X'){
				ch = 'O';
			}else{
				ch = 'X';
			}
			r++;
		}
		return matrix;
	}
}
