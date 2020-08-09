/** 
@Author  - sn656
Creation - Date Dec 2, 2018 12:50:51 PM

*/

package Microsoft;

/**
	Check if binary representation of a number is palindrome
	
	Given an integer ‘x’, write a C function that returns true if binary representation of x is palindrome else return false.
	For example a numbers with binary representation as 10..01 is palindrome and number with binary representation as 10..00 is not palindrome.
	
	The idea is similar to checking a string is palindrome or not. We start from leftmost and rightmost bits and compare bits one by one. 
	If we find a mismatch, then return false.



 */
public class Binary_Representation_Of_Number_IsPalindrome 
{

	static boolean isPalindrome(String str)
	{
	    for(int i=0;i<str.length();i++)
	    {
	        if(str.charAt(i)!=str.charAt(str.length()-1-i))
	            return false;
	    }
	    return true;
	}

	 static String DecimalToBinary(int n)
	{
	    String output = "";
	    while(n!=0)
	    {
	        int rem = n%2;
	        output = rem+output;
	        n = n/2;
	    }
	    System.out.println(output);
	    return output;
	}

	public static void main(String []args)
	{
	    System.out.println(isPalindrome(DecimalToBinary(7)));
	}
	
}

