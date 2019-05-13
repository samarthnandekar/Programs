/** 
@Author  - sn656
Creation - Date Dec 12, 2018 2:09:47 AM

*/
package Maths;
//package Microsoft;

/**
 
 Factorial of a non-negative integer, is multiplication of all integers smaller than or equal to n. For example factorial of 6 is 6*5*4*3*2*1 which
 is 720.

Factorial of 100 has 158 digits. It is not possible to store these many digits even if we use long long int.

Examples : Input : 100
Output : 933262154439441526816992388562667004907159682643816214685929638952175999-
         932299156089414639761565182862536979208272237582511852109168640000000000-
         00000000000000
         
Input :50
Output : 30414093201713378043612608166064768844377641568960512000000000000

Following is a simple solution where we use an array to store individual digits of the result. The idea is to use basic mathematics 
for multiplication.


 */
public class Factorial_Of_Large_Number
{

	// This function finds factorial of large numbers and prints them 
    static void factorial(int n) 
    { 
        int res[] = new int[5]; 
  
        // Initialize result 
        res[0] = 1; 
        int res_size = 1; 
  
        // Apply simple factorial formula  
        // n! = 1 * 2 * 3 * 4...*n 
        for (int x = 2; x <= n; x++) 
            res_size = multiply(x, res, res_size); 
  
        System.out.println("Factorial of given number is "); 
        for (int i = res_size - 1; i >= 0; i--) 
            System.out.print(res[i]); 
    } 
      
    // This function multiplies x with the number 
    // represented by res[]. res_size is size of res[] or  
    // number of digits in the number represented by res[]. 
    // This function uses simple school mathematics for  
    // multiplication. This function may value of res_size 
    // and returns the new value of res_size 
    static int multiply(int x, int res[], int res_size) 
    { 
        int carry = 0; // Initialize carry 
  
        // One by one multiply n with individual  
        // digits of res[] 
        for (int i = 0; i < res_size; i++) 
        { 
            int prod = res[i] * x + carry; 
            res[i] = prod % 10; // Store last digit of 'prod' in res[] 
            carry = prod/10; // Put rest in carry 
        } 
  
        // Put carry in res and increase result size 
        while (carry!=0) 
        { 
            res[res_size] = carry % 10; 
            carry = carry / 10; 
            res_size++; 
        } 
        return res_size; 
    } 
  
    // Driver program 
    public static void main(String args[]) 
    { 
        factorial(5); 
    }
}

