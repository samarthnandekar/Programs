package Dynamic;


/* Link :- https://www.geeksforgeeks.org/partition-problem-dp-18/
  
 Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 Examples

 arr[] = {1, 5, 11, 5}
 Output: true 
 The array can be partitioned as {1, 5, 5} and {11}

 arr[] = {1, 5, 3}
 Output: false 
 The array cannot be partitioned into equal sum sets.
  
  
  Following are the two main steps to solve this problem:
  1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
  2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.

  The first step is simple. The second step is crucial, it can be solved either using recursion or Dynamic Programming.


  ******
  Can we do it using sorting and start adding from front and back.

 */
public class Partition_Problem {
	
	static boolean findPartition (int arr[], int n) 
    { 
        int sum = 0; 
        int i, j; 
  
        // Caculcate sun of all elements 
        for (i = 0; i < n; i++) 
            sum += arr[i]; 
  
        if (sum%2 != 0) 
            return false; 
        
        int a=sum/2+1;
        
        boolean part[][]=new boolean[sum/2+1][n+1]; 
  
        // initialize top row as true 
        for (i = 0; i <= n; i++) 
            part[0][i] = true; 
  
        // initialize leftmost column, except part[0][0], as 0 
        for (i = 1; i <= sum/2; i++) 
            part[i][0] = false; 
  
        // Fill the partition table in botton up manner 
        for (i = 1; i <= sum/2; i++) 
        { 
            for (j = 1; j <= n; j++) 
            { 
                part[i][j] = part[i][j-1]; 
                if (i >= arr[j-1]) 
                    part[i][j] = part[i][j] || part[i - arr[j-1]][j-1]; 
            } 
        } 
  
         // uncomment this part to print table 
        for (i = 0; i <= sum/2; i++) 
        { 
            for (j = 0; j <= n; j++) 
            	System.out.print("  " + part[i][j]); 
            System.out.println(""); 
        } 
  
        return part[sum/2][n]; 
    } 
  
    /*Driver function to check for above function*/
    public static void main (String[] args) 
    { 
        //int arr[] = {3, 1, 1, 2, 2,1};
        int arr[] = {3, 1, 2};
        int n = arr.length; 
        if (findPartition(arr, n) == true) 
            System.out.println("Can be divided into two subsets of equal sum"); 
        else
            System.out.println("Can not be divided into two subsets of equal sum"); 
  
    } 

}
