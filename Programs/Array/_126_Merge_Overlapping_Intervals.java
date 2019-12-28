package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/merging-intervals/
 
 * 
 Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually 
 exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 

For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other,
 so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}

* https://leetcode.com/problems/merge-intervals/

56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Asked in :Amazon, Google

 */


	
/*
 Method 1:- A simple approach is to start from the first interval and compare it with all other intervals for overlapping, if it overlaps with
            any other interval, then remove the other interval from list and merge the other into the first interval. Repeat the same steps for
            remaining intervals after first. This approach cannot be implemented in better than O(n^2) time.
 
 Method 2:- An efficient approach is to first sort the intervals according to starting time. Once we have the sorted intervals, we can combine 
            all intervals in a linear traversal. The idea is, in sorted array of intervals, if interval[i] doesn’t overlap with interval[i-1], 
            then interval[i+1] cannot overlap with interval[i-1] because starting time of interval[i+1] must be greater than or equal to interval[i].
            Following is the detailed step by step algorithm.

			1. Sort the intervals based on increasing order of 
			    starting time.
			2. Push the first interval on to a stack.
			3. For each interval do the following
			   a. If the current interval does not overlap with the stack top, push it.
			   b. If the current interval overlaps with stack top and ending time of current interval is more than that of stack top, 
			       update stack top with the ending  time of current interval.
			4. At the end stack contains the merged intervals.

complexity :- Time complexity of the method is O(nLogn) which is for sorting. Once the array of intervals is sorted, merging takes linear time.
			  solution requires O(n) extra space for stack.

Method 3:-  We can avoid use of extra space by doing merge operations in-place. Below are detailed steps.

			1) Sort all intervals in decreasing order of start time.
			2) Traverse sorted intervals starting from first interval, 
			   do following for every interval.
			      a) If current interval is not first interval and it 
			         overlaps with previous interval, then merge it with
			         previous interval. Keep doing it while the interval
			         overlaps with the previous one.         
			      b) Else add current interval to output list of intervals.
			      
Note:-  That if intervals are sorted by decreasing order of start times, we can quickly check if intervals overlap or not by comparing
 start time of previous interval with end time of current interval.
 */


public class _126_Merge_Overlapping_Intervals {

	public static void main(String[] args) {
		 Interval arr[]=new Interval[4]; 
	        arr[0]=new Interval(6,8); 
	        arr[1]=new Interval(1,9); 
	        arr[2]=new Interval(2,4); 
	        arr[3]=new Interval(4,7); 
	        mergeIntervals(arr);
	        mergeIntervals_3(arr);
	        
	        System.out.println();
	        Interval arr1[]=new Interval[4];
	        arr1[0]= new Interval(1, 3);
	        arr1[1]= new Interval(2, 6);
	        arr1[2]= new Interval(8,10);
	        arr1[3]= new Interval(15, 18);
	        
	        mergeIntervals(arr1);
	        mergeIntervals_3(arr1);
	}

	// The main function that takes a set of intervals, merges  overlapping intervals and prints the result  
    public static void mergeIntervals(Interval arr[])  
    {  
        // Test if the given set has at least one interval  
        if (arr.length <= 0)  
            return;  
    
        // Create an empty stack of intervals  
        Stack<Interval> stack=new Stack<>(); 
    
        // sort the intervals in increasing order of start time  
        Arrays.sort(arr,new Comparator<Interval>(){ 
            public int compare(Interval i1,Interval i2) 
            { 
                return i1.start-i2.start; 
            } 
        }); 
    
        // push the first interval to stack  
        stack.push(arr[0]);  
    
        // Start from the next interval and merge if necessary  
        for (int i = 1 ; i < arr.length; i++)  
        {  
            // get interval from stack top  
            Interval top = stack.peek();  
    
            // if current interval is not overlapping with stack top, push it to the stack  
            if (top.end < arr[i].start)  
                stack.push(arr[i]);  
    
            // Otherwise update the ending time of top if ending of current interval is more  
            else if (top.end < arr[i].end)  
            {  
                top.end = arr[i].end;  
                stack.pop();  
                stack.push(top);  
            }  
        }  
    
        // Print contents of stack  
        System.out.print("The Merged Intervals are: "); 
        while (!stack.isEmpty())  
        {  
            Interval t = stack.pop();  
            System.out.print("["+t.start+","+t.end+"] "); 
        }   
    }
    
    public static void mergeIntervals_3(Interval arr[])  
    {  
        // Sort Intervals in decreasing order of start time  
        Arrays.sort(arr,new Comparator<Interval>(){ 
            public int compare(Interval i1,Interval i2) 
            { 
                return i1.start-i2.start; 
            } 
        }); 
    
        int index = 0; // Stores index of last element  
        // in output array (modified arr[])  
    
        // Traverse all input Intervals  
        for (int i=0; i<arr.length; i++)  
        {  
            // If this is not first Interval and overlaps with the previous one  
            if (index != 0 && arr[index-1].start <= arr[i].end) 
            {  
                while (index != 0 && arr[index-1].start <= arr[i].end)  
                {  
                    // Merge previous and current Intervals  
                    arr[index-1].end = Math.max(arr[index-1].end, arr[i].end);  
                    arr[index-1].start = Math.min(arr[index-1].start, arr[i].start);  
                    index--;  
                }  
            }  
            else // Doesn't overlap with previous, add to solution  
                arr[index] = arr[i];  
            index++;  
        } 
    
        // Now arr[0..index-1] stores the merged Intervals  
        System.out.print("The Merged Intervals are: "); 
        for (int i = 0; i < index; i++)  
            System.out.print("["+arr[i].start+","+arr[i].end+"]");  
    }
}
class Interval 
{ 
    int start,end; 
    Interval(int start, int end) 
    { 
        this.start=start; 
        this.end=end; 
    } 
}
