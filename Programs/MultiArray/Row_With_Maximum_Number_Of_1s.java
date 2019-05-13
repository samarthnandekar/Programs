/** 
@Author  - sn656
Creation - Date Dec 1, 2018 8:56:01 PM

*/
package MultiArray;
///package Microsoft;

/**
	link :- https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
	
	Find the row with maximum number of 1s
	Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
	
	Example
	Input matrix
	0 1 1 1
	0 0 1 1
	1 1 1 1  // this row has maximum 1s
	0 0 0 0
	
	Output: 2


 Method 1:- A simple method is to do a row wise traversal of the matrix, count the number of 1s in each row and compare the count with max. 
 Finally, return the index of row with maximum 1s. The time complexity of this method is O(m*n) where m is number of rows and n is
 number of columns in matrix.

 Method 2:-We can do better. Since each row is sorted, we can use Binary Search to count of 1s in each row. We find the index of first instance
           of 1 in each row. The count of 1s will be equal to total number of columns minus the index of first 1.
           
           Time Complexity: O(mLogn) where m is number of rows and n is number of columns in matrix.

           
 */
public class Row_With_Maximum_Number_Of_1s 
{

	//Time Complexity: O(mLogn) where m is number of rows and n is number of columns in matrix.
	static int first(int arr[], int low, int high) 
    { 
        if (high >= low)
        { 
            // Get the middle index 
            int mid = low + high  / 2; 
  
            // Check if the element at middle index is first 1 
            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1) 
                return mid; 
  
            // If the element is 0, recur for right side 
            else if (arr[mid] == 0) 
                return first(arr, (mid + 1), high); 
                  
            // If element is not first 1, recur for left side 
            else 
                return first(arr, low, (mid - 1)); 
        } 
        return -1; 
    } 
  
    // Function that returns index of row with maximum number of 1s. 
    static int rowWithMax1s(int mat[][]) 
    { 
        // Initialize max values 
        int max_row_index = 0, max = -1,row=mat.length,col=mat[0].length;  
  
        // Traverse for each row and count number of 1s by finding the index of first 1 
        int i, index; 
        for (i = 0; i < row; i++)
        { 
            index = first(mat[i], 0, col - 1); 
            if (index != -1 && col - index > max)
            { 
                max = col - index; 
                max_row_index = i; 
            } 
        } 
        return max_row_index; 
    }
    
	
	 public static void main(String args[]) 
	    { 
		 
		 int mat[][] = {{ 0, 0, 0, 1 }, 
		                 { 0, 1, 1, 1 }, 
		                 { 1, 1, 1, 1 }, 
		                 { 0, 0, 0, 0 }}; 
		 System.out.println("Index of row with maximum 1s is " + rowWithMax1sForLoop(mat));
		 
		 System.out.println("Index of row with maximum 1s is " + rowWithMax1s(mat));
	    }
	 
	 
	 // Time complexity = O(m*n)
	static int rowWithMax1sForLoop(int arr[][])
	 {
		 int maxOnes=0,row=0;
		 
		 int arrLen=arr.length;
		 
		 for(int i=0;i<arrLen;i++)
		 {
			  int onceCountinRow=0;
			 for(int j=0;j<arrLen;j++)
			 {
				 if(arr[i][j]==1)
				 {
					 onceCountinRow++;
					 if(maxOnes<onceCountinRow)
						 {
						 maxOnes=onceCountinRow;
						 row=i;
						 }
				 }
			 }
		 }
		 
		 return row;
	 }
}


