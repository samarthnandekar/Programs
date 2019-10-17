package Dynamic;

public class MinimumSum_Path_inTriangle {


              
		// Util function to find minimum sum for a path 
		static int minSumPath(int [][] arr) 
		{ 
		// For storing the result  in a 1-D array, and  
		// simultaneously updating the result. 
		int []memo = new int[arr.length]; 
		int n = arr.length - 1; 
		
		// For the bottom row 
		for (int i = 0; i < arr[n].length; i++)  
		    memo[i] = arr[n][i]; 
		
		// Calculation of the remaining rows, in bottom up manner. 
		for (int i = arr.length - 2;  i >= 0; i--)  
		   for (int j = 0; j < arr[i + 1].length - 1; j++)  
		        memo[j] = arr[i][j] +  Math.min(memo[j],  memo[j + 1]); 
		
		// return the top element 
		return memo[0]; 
		} 
		
		// Driver Code 
		public static void main(String args[]) 
		{ 
			 int arr[][] = {{2},  
		                    {3, 9},  
		                    {1, 6, 7}}; 
		System.out.print(minSumPath(arr)); 
		} 
}

