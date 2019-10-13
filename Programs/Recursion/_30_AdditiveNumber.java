package Recursion;

/*

Additive number is a string whose digits can form additive sequence.
A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must 
be the sum of the preceding two.
Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:
Input: "112358"
Output: true 
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8


Example 2:
Input: "199100199"
Output: true 
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
             
 */

import java.math.BigInteger;

public class _30_AdditiveNumber {

	public static void main(String[] args) {
	
		String number="1123";
		boolean isAdditive=isAdditiveNumber(number);
		System.out.println("is "+ number+" AdditiveNumber "+isAdditive);
    
		number="199100199";
		isAdditive=isAdditiveNumber(number);
		System.out.println("is "+ number+" AdditiveNumber "+isAdditive);
		
		number="1121325"; // 1 12 13 25
		isAdditive=isAdditiveNumber(number);
		System.out.println("is "+ number+" AdditiveNumber "+isAdditive);
		
		number="112134"; // 1 12 13 4(not sum of 12 and 13, it will not add 1 3 to make 4
		isAdditive=isAdditiveNumber(number);
		System.out.println("is "+ number+" AdditiveNumber "+isAdditive);
	}

	public static boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 0; i <= num.length()/2; i++) {
            if (num.charAt(0) == '0' && i > 0) {
                break;
            }
            BigInteger x1 = new BigInteger(num.substring(0, i + 1));
            //make sure remaining size is at least size of first and second integer.
            for (int j = i + 1; Math.max(i, j - (i + 1)) + 1 <= num.length() - j - 1 ; j++) {
                if (num.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }
                BigInteger x2 = new BigInteger(num.substring(i + 1, j + 1));
                if (isValid(num, j + 1, x1, x2)) {
                    return true;
                }
            }
        }
        return false;
    }
	
	private static boolean isValid(String num, int start, BigInteger x1, BigInteger x2) {
        if (start == num.length()) {
            return true;
        }
        BigInteger x3 = x1.add(x2);
        //if num starts with x3 from offset start means x3 is found. So look for next number.
        return num.startsWith(x3.toString(), start) && isValid(num, start + x3.toString().length(), x2, x3);
    }
}
