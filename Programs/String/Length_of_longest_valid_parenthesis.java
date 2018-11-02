package String;

import java.util.Stack;

/* Length of the longest valid substring
Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(())

Ask in :Google
A Simple Approach is to find all the substrings of given string. For every string, check if it is a valid string or not.
 If valid and length is more than maximum length so far, then update maximum length. We can check whether a substring is
  valid or not in linear time using a stack (See this for details). Time complexity of this solution is O(n2).
 */

public class Length_of_longest_valid_parenthesis {

	 static int findMaxLen(String str) 
	    { 
	        int n = str.length(); 
	       
	        // Create a stack and push -1 as initial index to it. 
	        Stack<Integer> stk = new Stack<Integer>(); 
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
	                if (!stk.empty()) 
	                    result = Math.max(result, i - stk.peek()); 
	       
	                // If stack is empty. push current index as base for next valid substring (if any) 
	                else stk.push(i); 
	            } 
	        } 
	        return result; 
	    } 
	      
	    // Driver method 
	    public static void main(String[] args)  
	    { 
	        String str = ")))()()"; 
	        System.out.println(findMaxLen(str)); 
	       
	        str = "()(()))))"; 
	        System.out.println(findMaxLen(str)); 
	       
	    } 
	
}
