package Stack;

import java.util.Stack;

/*
 * 
 Link:- https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 
Length of the longest valid substring
Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

Examples:Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(())

Asked: google
*/

/*
 A Simple Approach is to find all the substrings of given string. For every string, check if it is a valid string or not. 
 If valid and length is more than maximum length so far, then update maximum length. We can check whether a substring is valid
 or not in linear time using a stack (See this for details). Time complexity of this solution is O(n2.
 
 
 Second:- 
 An Efficient Solution can solve this problem in O(n) time. The idea is to store indexes of previous starting brackets in a stack. 
 The first element of stack is a special element that provides index before beginning of valid substring (base for next valid string).


1) Create an empty stack and push -1 to it. The first element
   of stack is used to provide base for next valid string. 

2) Initialize result as 0.

3) If the character is '(' i.e. str[i] == '('), push index 
   'i' to the stack. 
   
2) Else (if the character is ')')
   a) Pop an item from stack (Most of the time an opening bracket)
   b) If stack is not empty, then find length of current valid
      substring by taking difference between current index and
      top of the stack. If current length is more than result,
      then update the result.
   c) If stack is empty, push current index as base for next
      valid substring.

3) Return result.


 */


public class _1_longestValidSubstring {

	 public static void main(String[] args)  
	    { 
	        String str = "((()()"; 
	        System.out.println(findMaxLen(str)); 
	       
	        str = "()(()))))"; 
	        System.out.println(findMaxLen(str)); 
	       
	    } 
	 
	 static int findMaxLen(String str) 
	    { 
	        int n = str.length(); 
	       
	        // Create a stack and push -1 as initial index to it. 
	        Stack<Integer> stk = new Stack<>(); 
	        stk.push(-1); 
	       
	        // Initialize result 
	        int result = 0; 
	       
	        // Traverse all characters of given string 
	        for (int i=0; i<n; i++) 
	        { 
	            // If opening bracket, push index of it 
	            if (str.charAt(i) == '(') 
	              stk.push(i); 
	       
	            else // If closing bracket, i.e.,str[i] = ')' 
	            { 
	                // Pop the previous opening bracket's index 
	                stk.pop(); 
	       
	                // Check if this length formed with base of current valid substring is more than max  
	                // so far 
	                if (!stk.empty()) 
	                    result = Math.max(result, i - stk.peek()); 
	       
	                // If stack is empty. push current index as  
	                // base for next valid substring (if any) 
	                else
	                 stk.push(i); 
	            } 
	        } 
	       
	        return result; 
	    } 

	
}
