package Queue;

import java.util.Deque;
import java.util.LinkedList;

/*
 https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
 
 
Sliding Window Maximum (Maximum of all subarrays of size k)
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
Examples :

Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
Output: 3 3 4 5 5 5 6

Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
Output: 10 10 10 15 15 90 90


 */

/*
Method 1 (Simple)
Run two loops. In the outer loop, take all subarrays of size K. In the inner loop, get the maximum of the current subarray.
Time Complexity : The outer loop runs n-k+1 times and the inner loop runs k times for every iteration of outer loop. 
So time complexity is O((n-k+1)*k) which can also be written as O(N * K).

Method 2:- (A O(n) method: use Deque) We create a Deque, Qi of capacity k, that stores only useful elements of current window 
of k elements. An element is useful if it is in current window and is greater than all other elements on left side of it in
current window. We process all array elements one by one and maintain Qi to contain useful elements of current window and
these useful elements are maintained in sorted order. The element at front of the Qi is the largest and element at rear of
Qi is the smallest of current window. Thanks to Aashish for suggesting this method.


 */
public class _2_Sliding_Window_Maximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void printKMax_1(int arr[], int n, int k) 
    { 
        int j, max; 
  
        for (int i = 0; i <= n - k; i++) { 
  
            max = arr[i]; 
  
            for (j = 1; j < k; j++) { 
                if (arr[i + j] > max) 
                    max = arr[i + j]; 
            } 
            System.out.print(max + " "); 
        } 
    } 
	
	// A Dequeue (Double ended queue) based method for printing maximum element of all subarrays of size k 
    static void printMax(int arr[], int n, int k) 
    { 
        // Create a Double Ended Queue, Qi that will store indexes of array elements The queue will store indexes of useful elements in every window and it will 
        // maintain decreasing order of values from front to rear in Qi, i.e., arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order 
        Deque<Integer> Qi = new LinkedList<Integer>(); 
  
        /* Process first k (or first window) elements of array */
        int i; 
        for (i = 0; i < k; ++i) { 
            // For every element, the previous smaller elements are useless so remove them from Qi 
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) 
                Qi.removeLast(); // Remove from rear 
  
            // Add new element at rear of queue 
            Qi.addLast(i); 
        } 
  
        // Process rest of the elements, i.e., from arr[k] to arr[n-1] 
        for (; i < n; ++i) { 
            // The element at the front of the queue is the largest element of previous window, so print it 
            System.out.print(arr[Qi.peek()] + " "); 
  
            // Remove the elements which are out of this window 
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k) 
                Qi.removeFirst(); 
  
            // Remove all elements smaller than the currently being added element (remove useless elements) 
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) 
                Qi.removeLast(); 
  
            // Add current element at the rear of Qi 
            Qi.addLast(i); 
        } 
  
        // Print the maximum element of last window 
        System.out.print(arr[Qi.peek()]); 
    } 
}
