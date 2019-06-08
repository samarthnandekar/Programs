package Recursion;

import java.util.Arrays;

/*
  http://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/

  Print all possible paths from top left to bottom right of a mXn matrix
  The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell 
  you can either move only to right or down.

Examples :
Input : 1 2 3
        4 5 6

Output : 1 4 5 6
         1 2 5 6
         1 2 3 6

Input : 1 2 
        3 4

Output : 1 2 4
         1 3 4
 
 */


public class _15_PrintAllPathFromTopLeftToBottomRight {

	public static void main(String args[]){
		_15_PrintAllPathFromTopLeftToBottomRight pam = new _15_PrintAllPathFromTopLeftToBottomRight();
        int arr[][] = {{1,2,3,4},
        		       {5,6,7,8},
        		       {9,10,11,12}};
        int result[] = new int[arr.length + arr[0].length-1];
        pam.print(arr, 0, 0, result,0);
    }
	
	public void print(int arr[][],int row, int col,int result[],int pos)
	{
        if(row == arr.length-1 && col == arr[0].length-1)
        {
            result[pos] = arr[row][col];
            System.out.println(Arrays.toString(result));
            return;
        }
        if(row >= arr.length || col >= arr[0].length){
            return;
        }
        
        result[pos] = arr[row][col];
        print(arr,row,col+1,result,pos+1);
        print(arr,row+1,col,result,pos+1);
    }
}
