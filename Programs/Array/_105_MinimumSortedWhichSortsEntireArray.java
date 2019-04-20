package Array;
/*
 Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted

Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted.

Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to find that the subarray lies between the indexes 3 and 8.
2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find that the subarray lies between the indexes 2 and 5.

Solution:
1) Find the candidate unsorted subarray 
a) Scan from left to right and find the first element which is greater than the next element. 
   Let s be the index of such an element. In the above example 1, s is 3 (index of 30).
b) Scan from right to left and find the first element (first in right to left order) which is smaller than
   the next element (next in right to left order). Let e be the index of such an element. In the above example 1, e is 7 (index of 31).

2) Check whether sorting the candidate unsorted subarray makes the complete array sorted or not. If not, then include more elements in the subarray.
a) Find the minimum and maximum values in arr[s..e]. Let minimum and maximum values be min and max. min 
   and max for [30, 25, 40, 32, 31] are 25 and 40 respectively.
b) Find the first element (if there is any) in arr[0..s-1] which is greater than min, change s to index of this element.
   There is no such element in above example 1.
c) Find the last element (if there is any) in arr[e+1..n-1] which is smaller than max, change e to index of this element. 
   In the above example 1, e is changed to 8 (index of 35)

3) Print s and e.
 */

public class _105_MinimumSortedWhichSortsEntireArray {

	    public int minLength(int arr[]){
	        int  i=0;
	        while(i < arr.length -1 && arr[i] < arr[i+1]){
	            i++;
	        }
	        if(i == arr.length-1){
	            return 0;
	        }
	        int j = arr.length-1;
	        while(j > 0 && arr[j] > arr[j-1]){
	            j--;
	        }
	        
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;
	        for(int k = i; k <= j; k++){
	            if(max < arr[k]){
	                max = arr[k];
	            }
	            if(min > arr[k]){
	                min = arr[k];
	            }
	        }
	        int x = i-1;
	        while(x >=0){
	            if(min > arr[x]){
	                break;
	            }
	            x--;
	        }
	        
	        int y = j +1;
	        while(y < arr.length){
	            if(max < arr[y]){
	                break;
	            }
	            y++;
	        }
	        return y -x -2 + 1;
	    }
	    
	    public static void main(String args[]){
	        int arr[] = {4,5,10,21,18,23,7,8,19,34,38};
	        int arr1[] = {4,5,6,12,11,15};
	        int arr2[] = {4,5,6,10,11,15};
	        _105_MinimumSortedWhichSortsEntireArray msw = new _105_MinimumSortedWhichSortsEntireArray();
	        System.out.println(msw.minLength(arr1));
	    }   
}
