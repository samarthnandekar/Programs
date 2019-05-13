/** 
@Author  - sn656
Creation - Date Dec 2, 2018 1:08:20 AM

*/
package Maths;
//package Microsoft;

/**  https://www.geeksforgeeks.org/square-root-of-an-integer/

Square root of an integer
Given an integer x, find square root of it. If x is not a perfect square, then return floor(√x).

Examples :

Input: x = 4
Output: 2

Input: x = 11
Output: 3

A Simple Solution to find floor of square root is to try all numbers starting from 1. For every tried number i, if i*i is smaller than x, 
then increment i. We stop when i*i becomes more than or equal to x. Below is the implementation of above idea.

Second :-
Algorithm:
1) Start with ‘start’ = 0, end = ‘x’,
2) Do following while ‘start’ is smaller than or equal to ‘end’.
      a) Compute ‘mid’ as (start + end)/2
      b) compare mid*mid with x.
      c) If x is equal to mid*mid, return mid.
      d) If x is greater, do binary search between mid+1 and end. In this case, we also update ans (Note that we need floor).
      e) If x is smaller, do binary search between start and mid
      
 */
public class Square_Root_Of_Integer {

	public static int floorSqrtImp(int x) 
    { 
        // Base Cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Do Binary Search for floor(sqrt(x)) 
        int start = 1, end = x, ans=0; 
        while (start <= end) 
        { 
            int mid = (start + end) / 2; 
  
            // If x is a perfect square 
            if (mid*mid == x) 
                return mid; 
  
            // Since we need floor, we update answer when mid*mid is 
            // smaller than x, and move closer to sqrt(x) 
            if (mid*mid < x) 
            { 
                start = mid + 1; 
                ans = mid; 
            } 
            else   // If mid*mid is greater than x 
                end = mid-1; 
        } 
        return ans; 
    } 
	//Time Complexity: O(Log x)


	
  
    // Driver Method 
    public static void main(String args[]) 
    { 
        int x = 11; 
        System.out.println(floorSqrt(x)); 
    } 
	
	// Returns floor of square root of x 
    static int floorSqrt(int x) 
    { 
        // Base cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Staring from 1, try all numbers until i*i is greater than or equal to x. 
        int i = 1, result = 1; 
          
        while (result <= x) { 
            i++; 
            result = i * i; 
        } 
        return i - 1; 
    } 
}

