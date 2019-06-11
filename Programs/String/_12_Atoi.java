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
 
 
 */

public class _12_Atoi
{

	public static void main(String[] args) {
        // TODO code application logic here
        
        int a=converStrToNumber("12345");
        System.out.println(a);
    }
     
     static int converStrToNumber(String inputStr)
     {
         int number=0;
         for(int i=0;i<inputStr.length();i++)
         {
             char c=inputStr.charAt(i);
             number=number*10+ (c-'0');
             
         }
        
         return number;
     }
     
}

