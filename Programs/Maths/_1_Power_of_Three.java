package Maths;

/*
 * 
 326. Power of Three
 Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
  
  
 */
public class _1_Power_of_Three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

/*
Notice that we need a guard to check that n != 0, otherwise the while loop will never finish. For negative numbers,
the algorithm does not make sense, so we will include this guard as well.

Complexity Analysis:-
Time complexity : O(logb(n)). In our case that is O(\log_3n)O(log3n). The number of divisions is given by that logarithm.
Space complexity : O(1)O(1). We are not using any additional memory.

*/
	public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
	
	public boolean isPowerOfThree_rec(int n) {
	    if(n==0) 
	        return false;
	 
	    if(n==1) 
	        return true;
	 
	    if(n>1) 
	        return n%3==0 && isPowerOfThree(n/3);
	    else
	        return false;
	}
	
	public boolean isPowerOfThree_math(int n) {
	    if(n==0) return false;
	   long val=Math.round(Math.log(n)/Math.log(3)); 
	    return n == Math.pow(3, val);
	}
	
}
