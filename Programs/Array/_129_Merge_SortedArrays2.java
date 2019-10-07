package Array;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/

Merge two sorted arrays with O(1) extra space

We are given two sorted array. We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first 
array and the remaining numbers are in the second array. Extra space allowed in O(1).

Example:
Input: ar1[] = {10};
       ar2[] = {2, 3};
Output: ar1[] = {2}
        ar2[] = {3, 10}  

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20} 
        
*/

/*
This task is simple and O(m+n) if we are allowed to use extra space. But it becomes really complicated when extra space is not allowed and doesn’t 
 look possible in less than O(m*n) worst case time.

The idea is to begin from last element of ar2[] and search it in ar1[]. If there is a greater element in ar1[], then we move last element of ar1[]
to ar2[]. To keep ar1[] and ar2[] sorted, we need to place last element of ar2[] at correct place in ar1[]. We can use Insertion Sort type of
insertion for this. Below is algorithm:

1) Iterate through every element of ar2[] starting from last 
   element. Do following for every element ar2[i]
    a) Store last element of ar1[i]: last = ar1[i]
    b) Loop from last element of ar1[] while element ar1[j] is 
       smaller than ar2[i].
          ar1[j+1] = ar1[j] // Move element one position ahead
          j--
    c) If any element of ar1[] was moved or (j != m-1)
          ar1[j+1] = ar2[i] 
          ar2[i] = last  

In above loop, elements in ar1[] and ar2[] are always kept sorted. 

*****
Time Complexity: The worst case time complexity of code/algorithm is O(m*n). The worst case occurs when all elements of ar1[] are greater
than all elements of ar2[].

*****
Practice Tags : Zoho,Microsoft,Snapdeal,Goldman Sachs,Amdocs,Brocade,Juniper Networks,Linkedin,Quikr,Synopsys
*/
public class _129_Merge_SortedArrays2 {

	public static void main(String[] args)
	{
	    int arr1[] = new int[]{1, 5, 9, 10, 15, 20}; 
	 	int arr2[] = new int[]{2, 3, 8, 13};
	 	
		merge(arr1,arr1.length,arr2,arr2.length); 
        System.out.print("After Merging nFirst Array: "); 
        System.out.println(Arrays.toString(arr1)); 
        System.out.print("Second Array:  ");
        System.out.println(Arrays.toString(arr2)); 
	}
	
	 static void merge(int [] arr1,int m,int [] arr2, int n) 
	    { 
	        // Iterate through all elements of ar2[] starting from 
	        // the last element 
	        for (int i=n-1; i>=0; i--) 
	        { 
	            /* Find the smallest element greater than ar2[i]. Move all elements one position ahead till the smallest greater 
	               element is not found */
	            int j, last = arr1[m-1]; 
	            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--) 
	                arr1[j+1] = arr1[j]; 
	       
	            // If there was a greater element 
	            if (j != m-2 || last > arr2[i]) 
	            { 
	                arr1[j+1] = arr2[i]; 
	                arr2[i] = last; 
	            } 
	        } 
	    } 

}
