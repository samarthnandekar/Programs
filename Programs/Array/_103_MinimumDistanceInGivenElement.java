package Array;

/*
 * Find the minimum distance between two numbers
Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[]. The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.
 */
public class _103_MinimumDistanceInGivenElement {

	/* Method 1 (Simple)     Time Complexity: O(n^2)
     Use two loops: The outer loop picks all the elements of arr[] one by one.The inner loop picks all the elements after the element picked by outer loop. 
     If the elements picked by outer and inner loops have same values as x or y then if needed update the minimum distance calculated so far.
	 */
	int minDist1(int arr[], int n, int x, int y)  
    { 
        int i, j; 
        int min_dist = Integer.MAX_VALUE; 
        for (i = 0; i < n; i++)  
        { 
            for (j = i + 1; j < n; j++)  
            { 
                if ((x == arr[i] && y == arr[j] 
                    || y == arr[i] && x == arr[j]) 
                    && min_dist > Math.abs(i - j))  
                    min_dist = Math.abs(i - j); 
            } 
        } 
        return min_dist; 
    }
	
	/*	Method 2 (Tricky)
	1) Traverse array from left side and stop if either x or y is found. Store index of this first occurrence in a variable say prev
	2) Now traverse arr[] after the index prev. If the element at current index i matches with either x or y then check if it is different from arr[prev]. 
	If it is different then update the minimum distance if needed. If it is same then update prev i.e., make prev = i.
	*/
	int minDist2(int arr[], int n, int x, int y)  
    { 
        int i = 0; 
        int min_dist = Integer.MAX_VALUE; 
        int prev=0; 
  
        // Find the first occurence of any of the two numbers (x or y) 
        // and store the index of this occurence in prev 
        for (i = 0; i < n; i++)  
        { 
            if (arr[i] == x || arr[i] == y)  
            { 
                prev = i; 
                break; 
            } 
        } 
  
        // Traverse after the first occurence 
        for (; i < n; i++)  
        { 
            if (arr[i] == x || arr[i] == y)  
            { 
                // If the current element matches with any of the two then 
                // check if current element and prev element are different 
                // Also check if this value is smaller than minimum distance  
                // so far 
                if (arr[prev] != arr[i] && (i - prev) < min_dist)  
                { 
                    min_dist = i - prev; 
                    prev = i; 
                }  
                else
                    prev = i; 
            } 
        } 
  
        return min_dist; 
    } 
	public static void main(String[] args) { 
		_103_MinimumDistanceInGivenElement min = new _103_MinimumDistanceInGivenElement(); 
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3}; 
        int n = arr.length; 
        int x = 3; 
        int y = 6; 
        System.out.println("Minimum distance between " + x + " and " + y 
                + " is " + min.minDist2(arr, n, x, y)); 
        System.out.println(min.minDistance3(arr,x,y));
    } 
	
	public int minDistance3(int input[],int x, int y){
        int prev = -1;
        int prevFound = -1;
        int min = 10000;
        for(int i=0; i < input.length; i++){
            if(input[i] == x){
                if(prevFound == -1){
                    prevFound = x;
                    prev = i;
                }else if(prevFound == x){
                    prev = i;
                }else{
                    min = min > i - prev ? i -prev : min;
                    prev = i;
                    prevFound = x;
                }
            }else if(input[i] == y){
                if(prevFound == -1){
                    prevFound = y;
                    prev = i;
                }else if(prevFound == y){
                    prev =i;
                }else{
                    min = min > i - prev ? i -prev : min;
                    prevFound = y;
                    prev = i;
                }
            }
        }
        return min;
    }
}
