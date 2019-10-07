package Array;

/*
 88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

Practice Tags : Zoho,Microsoft,Snapdeal,Goldman Sachs,Amdocs,Brocade,Juniper Networks,Linkedin,Quikr,Synopsys,Arrays,Mathematical,SortingMerge Sort


 */
public class _128_Merge_TwoSorted_Arrays {

	public static void main(String[] args) {
		
		int[] arr1 = {1, 3, 5, 7}; 
        int n1 = arr1.length; 
      
        int[] arr2 = {2, 4, 6, 8}; 
        int n2 = arr2.length; 
      
        int[] arr3 = new int[n1+n2]; 
          
        mergeArrays(arr1, arr2, n1, n2, arr3); 
      
        System.out.println("Array after merging"); 
        for (int i=0; i < n1+n2; i++) 
            System.out.print(arr3[i] + " "); 
    
       int [] arr4= {1,2,3,0,0,0};
       int [] arr5= {2,5,6};
        merge(arr4,3,arr5,arr5.length);
        
        System.out.println("Array after merging"); 
        for (int i=0; i < arr4.length; i++) 
            System.out.print(arr4[i] + " ");

	}
	
	// Merge arr1[0..n1-1] and arr2[0..n2-1]  
    // into arr3[0..n1+n2-1] 
    public static void mergeArrays(int[] arr1, int[] arr2, int n1, 
                                int n2, int[] arr3) 
    { 
        int i = 0, j = 0, k = 0; 
      
        // Traverse both array 
        while (i<n1 && j <n2) 
        { 
            // Check if current element of first 
            // array is smaller than current element 
            // of second array. If yes, store first 
            // array element and increment first array 
            // index. Otherwise do same with second array 
            if (arr1[i] < arr2[j]) 
                arr3[k++] = arr1[i++]; 
            else
                arr3[k++] = arr2[j++]; 
        } 
      
        // Store remaining elements of first array 
        while (i < n1) 
            arr3[k++] = arr1[i++]; 
      
        // Store remaining elements of second array 
        while (j < n2) 
            arr3[k++] = arr2[j++]; 
    } 

    // Fill array in reverse order and first array length not equal to actual array length, its element length in array
   static public void merge(int A[], int m, int B[], int n) 
    { 	 
       while(m > 0 && n > 0)
        {
            if(A[m-1] > B[n-1])
            {
                A[m+n-1] = A[m-1];
                m--;
            }else
            {
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        while(n > 0)
        {
            A[m+n-1] = B[n-1];
            n--;
        }
    }
   
   
   /*
    https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
    
    Merge two sorted arrays with O(1) extra space
    We are given two sorted array. We need to merge these two arrays such that the initial numbers (after complete sorting) are
    in the first array and the remaining numbers are in the second array. Extra space allowed in O(1).


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
   
   
   
}
