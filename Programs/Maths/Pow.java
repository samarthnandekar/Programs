package Maths;

/*
Implement pow(x, n), which calculates x raised to the power n (xn).

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

 */
public class Pow {

	// Time complexity: O(logn)
	static int power(int x,int y)
	{
		int res=1;
		for(int i=0;i<y;i++)
		{
			res=res*x;
		}
		return res;
	}
	
	//Time Complexity of optimized solution: O(logn)
	static int power1(int x, int y) 
	{ 
	    int temp; 
	    if( y == 0) 
	        return 1; 
	    temp = power1(x, y/2); 
	    if (y%2 == 0) 
	        return temp*temp; 
	    else
	        return x*temp*temp; 
	} 
	
	/* Iterative Function to calculate (x^y) in O(logy) */
	static int power2(int x, int y) 
	{ 
	    // Initialize result 
	    int res = 1;  
	    while (y > 0)  
	    { 
	        // If y is odd, multiply x with result 
	        if ((y%2) == 1) 
	            res = res * x; 
	  
	        // n must be even now 
	        y = y/2; // y = y/2 
	        x = x * x; // Change x to x^2 
	    } 
	    return res; 
	} 
	public static void main(String[] args) 
    { 
        int x = 2; 
        int y = 5; 
  
        System.out.println(power(x, y)); 
        System.out.println(power1(x, y)); 
        System.out.println(power2(x, y)); 
    } 
	
}
