/** 
@Author  - sn656
Creation - Date Dec 2, 2018 1:16:28 AM

*/

package Maths;

import java.util.ArrayList;
import java.util.List;

//Microsoft
/**   https://www.geeksforgeeks.org/binary-representation-of-a-given-number/ 
 
 How to convert number to binary:- devide by 2 and check remainder.
 
        Remainder
 2)_19    1       
 2)_9     1
 2)_4     0 
 2)_2     0
 2)_1     1
 
 so binary representation of 9 will be 10011.
 *  */

public class Binary_Of_Given_Number
{
	
	// recursive 
	static void bin1(int n) 
	{ 
	    /* step 1 */
	    if (n > 1) 
	        bin1(n/2); 
	  
	    /* step 2 */
	    System.out.print(n % 2); 
	} 
	
	//iterative method
	static void bin2(int n) 
	{
	 List<Integer> binRep=new ArrayList<Integer>();	
	 
	 for(int i=0;n>0;i++)
	 {
		 binRep.add(i, n%2);
		 n=n/2;
	 }
	 
	 for(int i=binRep.size()-1;i>=0;i--)
	 {
		 System.out.print(binRep.get(i));
	 }
	 
	}
	  
	//Driver code 
	public static void main(String[] args)  
	{ 
	    bin1(19); 
	    System.out.println(); 
	    bin2(19);      
	} 
}

