package Maths;
import java.util.HashMap;

/**
 Microsoft
 
 https://www.geeksforgeeks.org/find-recurring-sequence-fraction/
 
Find Recurring Sequence in a Fraction
Given a fraction, find recurring sequence of digits if exists, otherwise print “No recurring sequence”.

Examples:

Input  : Numerator = 8, Denominator = 3
Output : Recurring sequence is 6 
Explanation : 8/3 = 2.66666666.......  

Input : Numerator = 50, Denominator = 22
Output : Recurring sequence is 27
Explanation : 50/22 = 2.272727272..... 

Input : Numerator = 11, Denominator = 2
Output : No recurring sequence
Explanation : 11/2 = 5.5 

Solution:-
When does the fractional part repeat ?

Let us simulate the process of converting fraction to decimal. Let us look at the part where we have already figured out the integer part
which is floor(numerator/denominator). Now we are left with ( remainder = numerator%denominator ) / denominator. If you remember the process 
of converting to decimal, at each step we do the following :

1. Multiply the remainder by 10.
2. Append remainder / denominator to result.
3. Remainder = remainder % denominator.

At any moment, if remainder becomes 0, we are done. However, when there is a recurring sequence, remainder never becomes 0.
For example if you look at 1/3, the remainder never becomes 0.

Below is one important observation :
If we start with remainder ‘rem’ and if the remainder repeats at any point of time, the digits between the two occurrence of ‘rem’ keep repeating.

So the idea is to store seen remainders in a map. Whenever a remainder repeats, we return the sequence before the next occurrence.

 */
public class Recurring_Sequence_In_Fraction
{

	// This function returns repeating sequence of a fraction.  If repeating sequence doesn't exits, then returns empty string 
	static String fractionToDecimal(int numr, int denr) 
	{ 
	    String res=""; // Initialize result 
	  
	    // Create a map to store already seen remainders remainder is used as key and its position in 
	    // result is stored as value. Note that we need position for cases like 1/6.  In this case, 
	    // the recurring sequence doesn't start from first remainder. 
	    HashMap <Integer, Integer> mp= new HashMap<Integer, Integer>();  
	  
	    // Find first remainder 
	    int rem = numr%denr; 
	  
	    // Keep finding remainder until either remainder becomes 0 or repeats 
	    while ( (rem!=0) && (!mp.containsKey(rem))) 
	    { 
	        // Store this remainder 
	        mp.put(rem, res.length()); 
	  
	        // Multiply remainder with 10 
	        rem = rem*10; 
	  
	        // Append rem / denr to result 
	        int res_part = rem / denr; 
	        res += res_part; 
	  
	        // Update remainder 
	        rem = rem % denr; 
	    } 
	  
	    return (rem == 0)? "" : res.substring(mp.get(rem)); 
	} 
	
	public static void main(String[] args)  
    { 
		System.out.println(fractionToDecimal(50, 27)); 
    } 
	
	
}

