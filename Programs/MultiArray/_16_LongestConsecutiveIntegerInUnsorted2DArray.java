package MultiArray;

/**
 * Find the length of the longest chain of consecutive integers in an unsorted 2D square array (non-diagonal)
 
 Not working check on it. 
 */

public class _16_LongestConsecutiveIntegerInUnsorted2DArray {

	public int longestConsecutiveInteger(int input[][]){
		
		boolean visited[][] = new boolean[input.length][input[0].length];
		int max = 1;
		for(int i=0; i < input.length; i++){
			for(int j=0; j < input[i].length; j++){
				int r = DFS(input,i,j,visited,-10000);
				if(r > max){
					max = r;
				}
			}
		}
		return max;
	}
	
	private int DFS(int input[][],int i,int j,boolean visited[][],int lastNum){
		if(i >= input.length || i < 0 || j < 0 || j >= input[0].length){
			return 0;
		}
		if(visited[i][j]){
			return 0;
		}
		if(lastNum != -10000 && input[i][j] + 1 != lastNum){
			return 0;
		}
		visited[i][j] = true;
		
		int r1 = DFS(input,i+1,j,visited,input[i][j]);
		int r2 = DFS(input,i-1,j,visited,input[i][j]);
		int r3 = DFS(input,i,j+1,visited,input[i][j]);
		int r4 = DFS(input,i,j-1,visited,input[i][j]);
		visited[i][j] = false;
		return Math.max(Math.max(r1, r2), Math.max(r3,r4)) + 1;
	}
	
	public static void main(String args[]){
		_16_LongestConsecutiveIntegerInUnsorted2DArray lci = new _16_LongestConsecutiveIntegerInUnsorted2DArray();
		int input[][] = {{3,2,5,10,12,15},
				         {4,1,4,10,12,15},
						 {5,6,5,10,12,15},
						 {5,6,6,10,12,15},
						 {5,6,7,8,10,16}};
		int input1[][] = {{3,2,5},
		                 {4,1,4},
				         {5,6,5}};
		System.out.println(lci.longestConsecutiveInteger(input1));
	}
	
}
