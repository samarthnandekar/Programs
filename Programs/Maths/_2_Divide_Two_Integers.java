package Maths;

/*
 https://leetcode.com/problems/divide-two-integers/
 
 29. Divide Two Integers
 
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
Return the quotient after dividing dividend by divisor.

Example 1: Input: dividend = 10, divisor = 3
           Output: 3
           Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2: Input: dividend = 7, divisor = -3
           Output: -2
           Explanation: 7/-3 = truncate(-2.33333..) = -2.
 
 */
public class _2_Divide_Two_Integers {

	public static void main(String[] args) {
		    int a = 10; 
	        int b = 3; 
	          
	        System.out.println(divide(a, b)); 
	          
	        a = 43; 
	        b = -8; 
	          
	        System.out.println(divide(a, b)); 
	}

	 // Function to divide a by b and return floor value it 
    static int divide(int dividend, int divisor)  
    { 
          
        // Calculate sign of divisor i.e., sign will be negative only if 
        // either one of them is negative otherwise it will be positive 
        int sign = ((dividend < 0) || (divisor < 0)) ? -1 : 1; 
      
        // Update both divisor and dividend positive 
        dividend = Math.abs(dividend); 
        divisor = Math.abs(divisor); 
      
        // Initialize the quotient 
        int quotient = 0; 
          
        while (dividend >= divisor) 
        { 
            dividend -= divisor; 
            ++quotient; 
        }       
        return sign * quotient; 
    }  
}
