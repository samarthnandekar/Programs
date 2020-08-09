/** 
@Author  - sn656
Creation - Date Dec 4, 2018 2:45:48 PM

*/

package String;

/**
 
Write your own atoi()
The atoi() function takes a string (which represents an integer) as an argument and returns its value.
 
 https://www.geeksforgeeks.org/write-your-own-atoi/
 
 convert string to integer.
 
 Example:- String s1= "123".. outPut:- 123
 
 https://leetcode.com/problems/string-to-integer-atoi/
 
 Example 1:  Input: "42"
             Output: 42
 
 Example 2: Input: "   -42"
            Output: -42

 Example 3: Input: "4193 with words"
            Output: 4193
            
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

 */

public class _12_Atoi
{

	public static void main(String[] args) {
        // TODO code application logic here
        
        int a=converStrToNumber("12345");
        System.out.println(a);
        
        System.out.println(converStrToNumber("12345"));
        System.out.println(converStrToNumber("-12345"));
        System.out.println(converStrToNumber("12345   "));
        
    }
     
     static int converStrToNumber(String inputStr)
     {
         int number=0;
         
    	 if(inputStr !=null && inputStr.trim().length()>0) {
    		 inputStr=inputStr.trim();
    		 
    		 int startIndex = 0;
    		 boolean isNegative = false;
    		 
    		 if(inputStr.charAt(0) == '+' || inputStr.charAt(0) == '-') {
    	            ++startIndex;
    	        }
    	        
    	        if(inputStr.charAt(0) == '-') {
    	            isNegative = true;
    	        }
    	        
    		 for(int i=startIndex;i<inputStr.length();i++)
             {
    			 //handle for non numeric characters
    	          if(inputStr.charAt(i) < '0' || inputStr.charAt(i) > '9') { //checking if ascii value is below or above 0 or 9
    	                break;
    	          }
                 char c=inputStr.charAt(i);
                 number=number*10+ (c-'0');                 
             }   
    		 //toggle result in case of negative is true
    		 if(isNegative) {
    			 number = -number;
             }
    	 }
    	 
         return number;
     }
     
}

