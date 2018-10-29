package Array;
/* Given an array of distinct elements. The task is to find triplets in array whose sum is zero.
   Examples : Input : arr[] = {0, -1, 2, -3, 1}
		  Output : 0 -1 1
			       2 -3 1
			       
Input : arr[] = {1, -2, 1, 0, 5}
Output : 1 -2  1   */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Find_all_triplets_with_zero_sum {
	

/* Method 1 (Simple : O(n3))
The naive approach is that run three loops and check one by one that sum of three elements is 
zero or not if sum of three elements is zero then print elements other wise print not found. */	
	static void findTriplets(int[] arr, int n) 
	{ 
	    boolean found = true; 
	    for (int i=0; i<n-2; i++) 
	    { 
	        for (int j=i+1; j<n-1; j++) 
	        { 
	            for (int k=j+1; k<n; k++) 
	            { 
	                if (arr[i]+arr[j]+arr[k] == 0) 
	                { 
	                    System.out.print(arr[i]); 
	                    System.out.print(" "); 
	                    System.out.print(arr[j]); 
	                    System.out.print(" "); 
	                    System.out.print(arr[k]); 
	                    System.out.print("\n"); 
	                    found = true; 
	                } 
	            } 
	        } 
	    } 
	    // If no triplet with 0 sum found in array 
	    if (found == false) 
	        System.out.println(" not exist "); 
	  
	}
	/* 0 -1 1
	   2 -3 1
	Time Complexity : O(n3)
	Auxiliary Space : O(1)   */
	
	
/*
 Method 2 (Hashing : O(n2)) We iterate through every element. For every element arr[i],we find a pair 
 with sum “-arr[i]”.This problem reduces to pairs sum and can be solved in O(n) time using hashing.

Run a loop from i=0 to n-2
  Create an empty hash table
  Run inner loop from j=i+1 to n-1
      If -(arr[i] + arr[j]) is present in hash table
         print arr[i], arr[j] and -(arr[i]+arr[j])
      Else
         Insert arr[j] in hash table.	
         
 Time Complexity : O(n2)
Auxiliary Space : O(n)        
 */
	
	/* this will for find sum == 0 */
	static void findTripletsUsingHashMap(int arr[], int n,int sum) 
	{
		boolean found=false;
		HashSet num= new HashSet();
		
		for (int i=0; i<n-1; i++) 
	    { 
	        for (int j=i+1; j<n; j++) 
	        { 
	        	int reqNum=sum-(arr[i]+arr[j]);
	        	if(num.contains(reqNum))
	        	{
	        		System.out.println(reqNum + "  "+ arr[i]+  "  "+ arr[j]);
	        		found=true;
	        	}
	        	else
	        	{
	        		num.add(reqNum);
	        	}
	        }
	    }
		if (found == false) 
			System.out.println("No Triplet Found");	
	}
	
/*
 Method 3 (Sorting : O(n2))
The above method requires extra space. We can solve in O(1) extra space. 
The idea is based on method 2 of this post.
1. Sort all element of array
2. Run loop from i=0 to n-2.
     Initialize two index variables l=i+1 and r=n-1
4. while (l < r) 
     Check sum of arr[i], arr[l], arr[r] is
     zero or not if sum is zero then print the
     triplet and do l++ and r--.
5. If sum is less than zero then l++
6. If sum is greater than zero then r--
7. If not exist in array then print not found.	
 */
	
	
	static void findTripletsWithSorting(int arr[], int n,int sum) 
	{ 
	    boolean found = false; 
	  
	    // sort array elements 
	    Arrays.sort(arr); 
	  
	    for (int i=0; i<n-1; i++) 
	    { 
	        // initialize left and right 
	        int l = i + 1; 
	        int r = n - 1; 
	        int x = arr[i]; 
	        while (l < r) 
	        { 
	            if (x + arr[l] + arr[r] == sum) 
	            { 
	                // print elements if it's sum is zero 
	            	System.out.println(x+" "+ arr[l]+" "+arr[r]); 
	                l++; 
	                r--; 
	                found = true; 
	            } 
	  
	            // If sum of three elements is less 
	            // than zero then increment in left 
	            else if (x + arr[l] + arr[r] < sum) 
	                l++; 
	  
	            // if sum is greater than zero than 
	            // decrement in right side 
	            else
	                r--; 
	        } 
	    } 
	  
	    if (found == false) 
	        System.out.println("not found"); 
	}
	
	public static void main(String[] args) 
	{ 
	    int arr[] = {0, -2, 2, -3, 1}; 
	    int n =arr.length; 
	    findTripletsWithSorting(arr,n,-1);
	    //findTriplets(arr, n); 
	    findTripletsUsingHashMap(arr,n,-1);
	  
	} 

}
