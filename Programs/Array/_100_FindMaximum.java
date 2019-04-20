package Array;

/*
 Asked in: Amazon, Google, VMWare
Given an array arr[], find the maximum j – i such that arr[j] > arr[i]

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
 */

public class _100_FindMaximum {
	
	/* Method 1 (Simple but Inefficient)   Time Complexity : O(n^2)
       Run two loops. In the outer loop, pick elements one by one from left. In the inner loop, compare the picked element with the elements
       starting from right side. Stop the inner loop when you see an element greater than the picked element and keep updating the maximum j-i so far.*/
	// For a given array arr[], returns the maximum j-i such that arr[j] > arr[i] */
    int maxIndexDiff_1(int arr[], int n)  
    { 
     int maxDiff = -1; 
     int i, j; 

      for (i = 0; i < n; ++i)  
      { 
         for (j = n - 1; j > i; --j)  
         { 
             if (arr[j] > arr[i] && maxDiff < (j - i)) 
                 maxDiff = j - i; 
         } 
      } 
     return maxDiff; 
    } 

    /* Method 2 (Efficient)
     To solve this problem, we need to get two optimum indexes of arr[]: left index i and right index j. For an element arr[i], 
     we do not need to consider arr[i] for left index if there is an element smaller than arr[i] on left side of arr[i]. Similarly,
     if there is a greater element on right side of arr[j] then we do not need to consider this j for right index. So we construct 
     two auxiliary arrays LMin[] and RMax[] such that LMin[i] holds the smallest element on left side of arr[i] including arr[i],
     and RMax[j] holds the greatest element on right side of arr[j] including arr[j]. After constructing these two auxiliary arrays,
     we traverse both of these arrays from left to right. While traversing LMin[] and RMa[] if we see that LMin[i] is greater than RMax[j],
     then we must move ahead in LMin[] (or do i++) because all elements on left of LMin[i] are greater than or equal to LMin[i].
     Otherwise we must move ahead in RMax[j] to look for a greater j – i value.
     */
    
    int max(int x, int y)  
    { 
        return x > y ? x : y; 
    } 
  
    int min(int x, int y)  
    { 
        return x < y ? x : y; 
    } 
  
    /* For a given array arr[], returns the maximum j-i such that arr[j] > arr[i] */
    int maxIndexDiff_2(int arr[], int n)  
    { 
        int maxDiff; 
        int i, j; 
  
        int RMax[] = new int[n]; 
        int LMin[] = new int[n]; 
  
        /* Construct LMin[] such that LMin[i] stores the minimum value from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0]; 
        for (i = 1; i < n; ++i) 
            LMin[i] = min(arr[i], LMin[i - 1]); 
  
        /* Construct RMax[] such that RMax[j] stores the maximum value from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1]; 
        for (j = n - 2; j >= 0; --j) 
            RMax[j] = max(arr[j], RMax[j + 1]); 
  
        /* Traverse both arrays from left to right to find optimum j - i This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = -1; 
        while (j < n && i < n)  
        { 
            if (LMin[i] < RMax[j])  
            { 
                maxDiff = max(maxDiff, j - i); 
                j = j + 1; 
            }  
            else 
                i = i + 1; 
        } 
        return maxDiff; 
    } 
    
 public static void main(String[] args)  
 { 
     _100_FindMaximum max = new _100_FindMaximum(); 
     int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}; 
     int n = arr.length; 
     int maxDiff = max.maxIndexDiff_1(arr, n); 
     System.out.println(maxDiff); 
     System.out.println(max.maxIndexDiff_2(arr, n));
     System.out.println(max.maximumGeeks(arr));
 } 
 
 class Node{
     int index;
     int size;
 }
 
 public int maximumGeeks(int input[]){
     int lhs[] = new int[input.length];
     int rhs[] = new int[input.length];
     lhs[0] = 0;
     for(int i=1; i < lhs.length; i++){
         if(input[lhs[i-1]] < input[i]){
             lhs[i] = lhs[i-1];
         }else{
             lhs[i] = i;
         }
     }
     rhs[input.length-1] = input.length-1;
     for(int i=input.length-2; i >= 0; i--){
         if(input[rhs[i+1]] > input[i]){
             rhs[i] = rhs[i+1];
         }else{
             rhs[i] = i;
         }
     }
     
     int i=0;
     int j=0;
     int max = 0;
     for(;j < input.length;){
         if(input[lhs[i]] < input[rhs[j]]){
             max = Math.max(max, j-i);
             j++;
         }else{
             i++;
         }
     }
     return max;
 }
 

}
