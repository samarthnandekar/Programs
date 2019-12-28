package Array;

import java.util.Arrays;

public class _68_CountInversionsInArray {

	/* Given input array find number of inversions where i < j < k and input[i] > input[j] > input[k]
     * http://www.geeksforgeeks.org/count-inversions-of-size-three-in-a-give-array/
     * Time complexity of this method is O(n^2)
     * Space complexity is O(1)
     */
    public int findInversions(int input[]) {
        int inversion = 0;
        for (int i = 1; i < input.length - 1 ; i++) {
            int larger = 0;
            for (int k = 0; k < i; k++) {
                if (input[k] > input[i]) {
                    larger++;
                }
            }
            int smaller = 0;
            for (int k = i+1; k < input.length; k++) {
                if (input[k] < input[i]) {
                    smaller++;
                }
            }
            inversion += smaller*larger;
        }
        return inversion;
    }

    public static void main(String args[]) {
        int input[] = {9, 6, 4, 5, 8};
        _68_CountInversionsInArray ci = new _68_CountInversionsInArray();
        System.out.println(ci.findInversions(input));
        
        //--------------------------------------------------
        int[] arr = { 1, 20, 6, 4, 5 };         
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1)); 
    }
    
    /*
     * Count Inversions in an array
     * https://www.geeksforgeeks.org/counting-inversions/
     * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
        Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

      Example: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
         
     */
    // Time Complexity: O(n^2)
    static int getInvCount(int n, int []arr) 
      { 
      int inv_count = 0; 
      for (int i = 0; i < n - 1; i++) 
          for (int j = i + 1; j < n; j++) 
              if (arr[i] > arr[j]) 
                  inv_count++; 

      return inv_count; 
    } 
    
    
    /*
     Time Complexity: O(N log N)
     Algorithmic Paradigm: Divide and Conquer
     Note that above code modifies (or sorts) the input array. If we want to count only inversions then we need to create a copy of original array 
     and call mergeSort() on copy.
     */
    // Function to count the number of inversions during the merge process 
    private static int mergeAndCount(int[] arr, int l, int m, int r) 
    { 
  
        // Left subarray 
        int[] left = Arrays.copyOfRange(arr, l, m + 1); 
  
        // Right subarray 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1); 
  
        int i = 0, j = 0, k = l, swaps = 0; 
  
        while (i < left.length && j < right.length) { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
  
        // Fill from the rest of the left subarray 
        while (i < left.length) 
            arr[k++] = left[i++]; 
  
        // Fill from the rest of the right subarray 
        while (j < right.length) 
            arr[k++] = right[j++]; 
  
        return swaps; 
    } 
  
    // Merge sort function 
    private static int mergeSortAndCount(int[] arr, int l, int r) 
    { 
  
        // Keeps track of the inversion count at a particular node of the recursion tree 
        int count = 0;  
        if (l < r) { 
            int m = (l + r) / 2; 
  
            // Total inversion count = left subarray count + right subarray count + merge count  
            // Left subarray count 
            count += mergeSortAndCount(arr, l, m); 
  
            // Right subarray count 
            count += mergeSortAndCount(arr, m + 1, r); 
  
            // Merge count 
            count += mergeAndCount(arr, l, m, r); 
        }   
        return count; 
    }
}
