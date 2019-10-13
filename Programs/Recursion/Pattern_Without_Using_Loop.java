/** 
@Author  - sn656
Creation - Date Dec 2, 2018 1:20:43 AM

*/

package Recursion;

/**
https://www.geeksforgeeks.org/print-a-pattern-without-using-any-loop/

Print a pattern without using any loop, Given a number n, print following pattern without using any loop.

Examples :-

Input: n = 16
Output: 16, 11, 6, 1, -4, 1, 6, 11, 16

Input: n = 10
Output: 10, 5, 0, 5, 10

We basically first reduce 5 one by one until we reach a negative or 0. After we reach 0 or negative, we one add 5 until we reach n.
 */

public class Pattern_Without_Using_Loop
{
	static void printPattern(int n) 
    { 
        // Base case (When n becomes 0 or negative) 
        if (n == 0 || n < 0) {              
            System.out.print(n + " ");               
            return; 
        } 
  
        // First print decreasing order 
        System.out.print(n + " ");           
        printPattern(n - 5); 
  
        // Then print increasing order 
        System.out.print(n + " "); 
    } 
  
    public static void main(String[] args) 
    {      
        int n = 16;     
        printPattern(n); 
    } 
}

