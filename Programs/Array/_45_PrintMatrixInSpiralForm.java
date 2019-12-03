package Array;

/*
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 
 Print a given matrix in spiral form
Given a 2D array, print it in spiral form. See the following examples.
Examples:

Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 


Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output: 
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

Approach: The above problem can be solved using four for loops which prints all the elements. 
Every for loop defines a single direction movement  along with the matrix. The first for loop 
represents the movement from left to right, whereas the second crawl represents the movement 
from top to bottom, the third represents the movement from the right to left, and the fourth 
represents the movement from bottom to up. The four variable along with their use is given below.

k - starting row index 
m - ending row index 
l - starting column index 
n - ending column index 


 */
public class _45_PrintMatrixInSpiralForm {

	public static void main(String[] args) {

	     int a[][] = {{1, 2, 3, 4},
	    		      {5, 6, 7, 8},
	                  {9,10,11,12}, 
	                  {13,14,15,16}}; 
	     int R = a.length; 
	     int C = a[0].length; 
	        spiralPrint(R, C, a); 

	}
	
	 static void spiralPrint(int m, int n, int a[][]) 
	    { 
	        int i, k = 0, l = 0; 
	        /*  k - starting row index 
	        m - ending row index 
	        l - starting column index 
	        n - ending column index 
	        i - iterator 
	        */
	  
	        while (k < m && l < n) { 
	            // Print the first row from the remaining rows 
	            for (i = l; i < n; ++i) { 
	                System.out.print(a[k][i] + " "); 
	            } 
	            k++; 
	  
	            // Print the last column from the remaining columns 
	            for (i = k; i < m; ++i) { 
	                System.out.print(a[i][n - 1] + " "); 
	            } 
	            n--; 
	  
	            // Print the last row from the remaining rows */ 
	            if (k < m) { 
	                for (i = n - 1; i >= l; --i) { 
	                    System.out.print(a[m - 1][i] + " "); 
	                } 
	                m--; 
	            } 
	  
	            // Print the first column from the remaining columns */ 
	            if (l < n) { 
	                for (i = m - 1; i >= k; --i) { 
	                    System.out.print(a[i][l] + " "); 
	                } 
	                l++; 
	            } 
	        } 
	    } 

}
