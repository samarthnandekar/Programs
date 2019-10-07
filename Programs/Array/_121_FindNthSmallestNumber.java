package Array;

import java.util.Arrays;

public class _121_FindNthSmallestNumber {

public static void main(String[] args) {
		
  int[] arr= {10,2,5,6,11,3,15};
	  
	    System.out.println(kthSmallest(arr, 0, arr.length-1, 1));  
	}
	
//This function returns k'th smallest element in arr[l..r] 
// using QuickSort based method.  ASSUMPTION: ALL ELEMENTS 
// IN ARR[] ARE DISTINCT 
static int kthSmallest(int arr[], int l, int r, int k) 
{ 
    // If k is smaller than number of elements in array 
    if (k > 0 && k <= r - l + 1) 
    { 
        // Partition the array around a random element and 
        // get position of pivot element in sorted array 
        int pos = randomPartition(arr, l, r); 

        // If position is same as k 
        if (pos-l == k-1) 
            return arr[pos]; 

        // If position is more, recur for left subarray 
        if (pos-l > k-1) 
            return kthSmallest(arr, l, pos-1, k); 

        // Else recur for right subarray 
        return kthSmallest(arr, pos+1, r, k-pos+l-1); 
    } 

    // If k is more than number of elements in array 
    return Integer.MAX_VALUE; 
} 

// Utility method to swap arr[i] and arr[j] 
static  void swap(int arr[], int i, int j) 
{ 
    int temp = arr[i]; 
    arr[i] = arr[j]; 
    arr[j] = temp; 
} 

// Standard partition process of QuickSort().  It considers 
// the last element as pivot and moves all smaller element  
// to left of it and greater elements to right. This function 
// is used by randomPartition() 
static  int partition(int arr[], int l, int r) 
{ 
    int x = arr[r], i = l; 
    for (int j = l; j <= r - 1; j++) 
    { 
        if (arr[j] <= x) 
        { 
            swap(arr, i, j); 
            i++; 
        } 
    } 
    swap(arr, i, r); 
    return i; 
} 

// Picks a random pivot element between l and r and  
// partitions arr[l..r] arount the randomly picked  
// element using partition() 
static int randomPartition(int arr[], int l, int r) 
{ 
    int n = r-l+1; 
    int pivot = (int)(Math.random()) * (n-1); 
    swap(arr, l + pivot, r); 
    return partition(arr, l, r); 
} 




/*

	
	public static int nthSmallest(int [] arr, int m)
	{
		int start=0;
		int end=arr.length-2;
		int index=0;
		
		int [] newArray= new int[arr.length-1];
		
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<arr[index])
			{
				newArray[start]=arr[i];
				start++;
			}
			else
			{
				newArray[end]=arr[i];
				end--;
			}
		}
		
		System.out.println(Arrays.toString(newArray));
		if(m>start)
		{
			return nthSmallest(Arrays.copyOfRange(newArray, start+1, newArray.length),m-start);
		}
		else if(m<start)
		{
			return nthSmallest(Arrays.copyOfRange(newArray, 0, start),m);
		}
		else
		{
			return arr[start];
		}
		
	}
 
 */
}
