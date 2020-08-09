/** 
@Author  - sn656
Creation - Date Dec 14, 2018 12:38:22 AM

*/

package Maths;

/**
 * @author sn656
 * Amazon
 */
public class check_Prime_Number 
{
	
	/* Method 1:- 
	 
	 Time complexity :O(n)
	 */
	// function check whether a number  is prime or not 
    static boolean isPrime(int n) 
    { 
        // Corner case 
        if (n <= 1) 
            return false; 
       
        // Check from 2 to n-1 
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
       
        return true; 
    } 
      
    /* Driver program  */
    public static void main(String[] args)  
    { 
         if(isPrime(11))  
         System.out.println(" true") ; 
          
         else 
         System.out.println(" false"); 
           
    } 
} 



