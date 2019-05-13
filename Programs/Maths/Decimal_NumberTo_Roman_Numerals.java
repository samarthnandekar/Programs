/** 
@Author  - sn656
Creation - Date Dec 7, 2018 2:12:18 PM

*/

package Maths;
//package Microsoft;

/**
 https://www.geeksforgeeks.org/converting-decimal-number-lying-between-1-to-3999-to-roman-numerals/
 
 Converting Decimal Number lying between 1 to 3999 to Roman Numerals. Given a number, find its corresponding Roman numeral.
 
	Example:
	Input : 9
	Output : IX
	
	Input : 40
	Output : XL
	
	Input :  1904
	Output : MCMIV

Following is the list of Roman symbols which include subtractive cases also:

	SYMBOL       VALUE
	I             1
	IV            4
	V             5
	IX            9
	X             10
	XL            40
	L             50
	XC            90
	C             100
	CD            400
	D             500
	CM            900 
	M             1000
	
	Method 1 :- CTC me hai..
	
	Method 2 :- Discussed here

 *
 */
public class Decimal_NumberTo_Roman_Numerals 
{
	static String intToRoman(int num)  
    {  
        // storing roman values of digits from 0-9  
        // when placed at different places 
        String m[] = {"", "M", "MM", "MMM"}; 
        
                         //
        String c[] = {"", "C", "CC", "CCC", "CD", "D","DC", "DCC", "DCCC", "CM"}; 
                         //10, 20,    30 ,   40,  50,  60,   70,   80,     90 
        String x[] = {"", "X", "XX", "XXX", "XL", "L","LX", "LXX", "LXXX", "XC"}; 
        String i[] = {"", "I", "II", "III", "IV", "V","VI", "VII", "VIII", "IX"}; 
              
        // Converting to roman 
        String thousands = m[num/1000]; 
        String hundereds = c[(num%1000)/100]; 
        String tens = x[(num%100)/10]; 
        String ones = i[num%10]; 
              
        String ans = thousands + hundereds + tens + ones; 
              
        return ans; 
    } 
      
    // Driver program to test above function 
    public static void main(String []args) 
    { 
        int number = 33; 
        System.out.println(intToRoman(number)); 
          
    } 
}

