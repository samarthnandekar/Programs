package Array;

/*
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Example:- Input: [0,1,0,3,12]
          Output: [1,3,12,0,0]

Note:- You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 */

public class _120_Move_Zeroes {

	    // Function which pushes all zeros to end of an array. 
	    static void pushZerosToEnd(int arr[], int n) 
	    { 
	        int count = 0;  // Count of non-zero elements 
	  
	        // Traverse the array. If element encountered is 
	        // non-zero, then replace the element at index 'count' with this element 
	        for (int i = 0; i < n; i++) 
	            if (arr[i] != 0) 
	                arr[count++] = arr[i]; // here count is incremented 
	  
	        // Now all non-zero elements have been shifted to 
	        // front and 'count' is set as index of first 0. Make all elements 0 from count to end. 
	        while (count < n) 
	            arr[count++] = 0; 
	    } 
	
	    public static void main(String[] args) 
	    { 
	        int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9}; 
	        int n = arr.length; 
	       // pushZerosToEnd(arr, n); 
	        System.out.println("Array after pushing zeros to the back: "); 
	        for (int i=0; i<n; i++) 
	            System.out.print(arr[i]+" "); 
	        
	        moveZeroes(arr);
	    } 
	    
	    /*
		Output:- Array after pushing all zeros to end of array :
		1 9 8 4 2 7 6 9 0 0 0 0
		Time Complexity: O(n) where n is number of elements in input array.  */
	    
	    
	    static public void moveZeroes(int[] nums) {
	        int i=0;
	        int j=0;
	     
	        while(j<nums.length){
	            if(nums[j]==0){
	                j++;
	            }else{
	                nums[i]=nums[j];
	                i++;
	                j++;
	            }
	        }
	     
	        while(i<nums.length){
	            nums[i]=0;
	            i++;
	        }
	    }
	} 





