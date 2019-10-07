/** 
@Author  - sn656
Creation - Date Dec 14, 2018 1:18:24 AM

*/

package Array;

/**
 
Search in a row wise and column wise sorted matrix
Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it. Otherwise, print “Not Found”. 
In the given matrix, every row and column is sorted in increasing order. The designed algorithm should have linear time complexity.

Example :
Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output : Found at (2, 1)

Input : mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 100
Output : Element not found

A simple solution is to search one by one. Time complexity of this solution is O(n2).

A better solution is to use Divide and Conquer to find the element. Time complexity of this solution is O(n1.58). 
Please refer this article for details.

Below is an efficient solution that works in O(n) time.


Let x = element we're trying to search for in the matrix,
    e = current element we're processing in the array.
1) Start with top right element.
2) Loop: compare this element e with x
...i) if e = x, then return position of e, since we found x in the given matrix.
...ii) if e > x then move left to check elements smaller than e (if out of bound of matrix, then break and return false)
...iii) if e < x then move below to check elements greater than e (if out of bound of matrix, then break and return false)
3) repeat the i), ii) and iii) until you find the element or return false


 **/

public class Search_Row_Column_Sorted_Matrix 
{
	/* Searches the element x in mat[][]. If the element is found, then prints its position  
	and returns true, otherwise prints "not found" and returns false */
	    private static void search(int[][] mat, int n, int x) { 
	          
	        int i = 0, j = n-1; //set indexes for top right element 
	  
	        while ( i < n && j >= 0 ) 
	        { 
	            if ( mat[i][j] == x ) 
	            { 
	                System.out.print("n Found at "+ i + " " + j); 
	                return; 
	            } 
	            if ( mat[i][j] > x ) 
	                j--; 
	            else // if mat[i][j] < x 
	                i++; 
	        } 
	          
	        System.out.print("n Element not found"); 
	        return; // if ( i==n || j== -1 ) 
	          
	    } 
	        // driver program to test above function 
	        public static void main(String[] args) 
	        { 
	        int mat[][] = { {10, 20, 30, 40}, 
	                        {15, 25, 35, 45}, 
	                        {27, 29, 37, 48}, 
	                        {32, 33, 39, 50} }; 
	              
	        search(mat, 4, 29); 
	        } 
	          
} 


