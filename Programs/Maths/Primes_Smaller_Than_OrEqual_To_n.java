/** 
@Author  - sn656
Creation - Date Dec 14, 2018 1:10:00 AM

*/

package Maths;
// Amazon;

/**
 * @author sn656
 *
 */
public class Primes_Smaller_Than_OrEqual_To_n 
{
	void sieveOfEratosthenes(int n) 
    { 
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) 
            { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
          
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) 
        { 
            if(prime[i] == true) 
                System.out.print(i + " "); 
        } 
    } 
      
    // Driver Program to test above function 
    public static void main(String args[]) 
    { 
        int n = 30; 
        System.out.print("Following are the prime numbers "); 
        System.out.println("smaller than or equal to " + n); 
        Primes_Smaller_Than_OrEqual_To_n g = new Primes_Smaller_Than_OrEqual_To_n(); 
        g.sieveOfEratosthenes(n); 
    } 
}

