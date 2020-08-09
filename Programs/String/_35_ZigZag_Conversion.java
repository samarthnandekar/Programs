package String;

import java.util.Arrays;

/*
 * 
 https://leetcode.com/problems/zigzag-conversion/
 https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/
 
 
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

Solution:-

1) Create an array of n strings, arr[n]
2) Initialize direction as "down" and row as 0. The 
   direction indicates whether we need to move up or 
   down in rows. 
3) Traverse the input string, do following for every
   character.
   a) Append current character to string of current row.
   b) If row number is n-1, then change direction to 'up'
   c) If row number is 0, then change direction to 'down'
   d) If direction is 'down', do row++.  Else do row--.
4) One by one print all strings of arr[].

  
 */
public class _35_ZigZag_Conversion {

	// Prints concatenation of all rows of str's Zig-Zag fasion 
    static void printZigZagConcat(String str, int n)  
    {  
        // Corner Case (Only one row) 
        if (n == 1)  
        { 
            System.out.print(str); 
            return; 
        } 
        char[] str1 = str.toCharArray(); 
  
        // Find length of string 
        int len = str.length(); 
  
        // Create an array of strings for all n rows 
        String[] arr = new String[n]; 
        Arrays.fill(arr, ""); 
  
        // Initialize index for array of strings arr[] 
        int row = 0; 
        boolean down = true; // True if we are moving down in rows, else false 
  
        // Travers through  given string 
        for (int i = 0; i < len; ++i)  
        { 
            // append current character to current row 
            arr[row] += (str1[i]); 
  
            // If last row is reached,  change direction to 'up' 
            if (row == n - 1)  
            { 
                down = false; 
            }  
              
            // If 1st row is reached, change direction to 'down' 
            else if (row == 0)  
            { 
                down = true; 
            } 
  
            // If direction is down, increment, else decrement 
            if (down) 
            { 
                row++; 
            }  
            else 
            { 
                row--; 
            } 
        } 
  
        // Print concatenation of all rows 
        for (int i = 0; i < n; ++i)  
        { 
            System.out.print(arr[i]); 
        } 
    } 
  
    // Driver Code 
    public static void main(String[] args) 
    { 
        String str = "GEEKSFORGEEKS"; 
        String str1 = "abcdef"; 
        int n = 3; 
        printZigZagConcat(str1, n); 
    } 
} 


