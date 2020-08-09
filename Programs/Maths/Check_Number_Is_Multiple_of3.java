/** 
@Author  - sn656
Creation - Date Dec 12, 2018 3:01:42 PM

*/

//package Microsoft;
package Maths;
/**
 
 https://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
 
 *****  Write an Efficient Method to Check if a Number is Multiple of 3  *****
 
 The very first solution that comes to our mind is the one that we learned in school. If sum of digits in a number is multiple of 3 
 then number is multiple of 3 e.g., for 612 sum of digits is 9 so it’s a multiple of 3. But this solution is not efficient. You have to
 get all decimal digits one by one, add them and then check if sum is multiple of 3.
 
 Samarth:- not covered
 */
public class Check_Number_Is_Multiple_of3 
{

	static int isMultipleOf3(int n) 
    { 
        int odd_count = 0; 
        int even_count = 0; 
  
        /* Make no positive if +n is multiple of 3 then is -n.
          We are doing this to avoid stack overflow in recursion*/
        
        if (n < 0) 
            n = -n; 
        if (n == 0) 
            return 1; 
        if (n == 1) 
            return 0; 
  
        while (n != 0) { 
            /* If odd bit is set then increment odd counter */
            if ((n & 1) != 0) 
                odd_count++; 
  
            /* If even bit is set then increment even counter */
            if ((n & 2) != 0) 
                even_count++; 

            n = n >> 2; 
        } 
        return isMultipleOf3(Math.abs(odd_count - even_count)); 
    } 
  
    /* Program to test function isMultipleOf3 */
    public static void main(String[] args) 
    { 
        int num = 24; 
        if (isMultipleOf3(num) != 0) 
            System.out.println(num + " is multiple of 3"); 
        else
            System.out.println(num + " is not a multiple of 3"); 
    } 
}

