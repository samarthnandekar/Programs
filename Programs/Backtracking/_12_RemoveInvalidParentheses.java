package Backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 Link :- https://leetcode.com/problems/remove-invalid-parentheses/
 Link :- https://www.geeksforgeeks.org/remove-invalid-parentheses/
***** Remove Invalid Parentheses ***** 

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
Note: The input string may contain letters other than the parentheses ( and ).

Example 1:   Input: "()())()"
             Output: ["()()()", "(())()"]

Example 2:- Input: "(a)())()"
		    Output: ["(a)()()", "(a())()"]

Example 3:- Input: ")("
            Output: [""]

 */

/*
 As we need to generate all possible output we will backtrack among all states by removing one opening or closing bracket and check if 
 they are valid if invalid then add the removed bracket back and go for next state. We will use BFS for moving through states, use of 
 BFS will assure removal of minimal number of brackets because we traverse into states level by level and each level corresponds to one
 extra bracket removal. Other than this BFS involve no recursion so overhead of passing parameters is also saved.
 
 */
public class _12_RemoveInvalidParentheses {

	public static void main(String[] args) {
		String input1=")(";
		String input2="(a)())()";
		String input3="(r(()()(";
		//removeInvalidParenthesis(input1);
		removeInvalidParenthesis(input2);
		
	}

	//  method checks if character is parenthesis(open or closed) 
	static boolean isParenthesis(char c) 
	{ 
	    return ((c == '(') || (c == ')')); 
	} 
	  
	//  method returns true if string contains valid parenthesis 
	static boolean isValidString(String str) 
	{ 
	    int cnt = 0; 
	    for (int i = 0; i < str.length(); i++) 
	    { 
	        if (str.charAt(i) == '(') 
	            cnt++; 
	        else if (str.charAt(i) == ')') 
	            cnt--; 
	        if (cnt < 0) 
	            return false; 
	    } 
	    return (cnt == 0); 
	}

//  method to remove invalid parenthesis 
	static  void removeInvalidParenthesis(String str) 
{ 
    if (str==null || str.isEmpty()) 
        return ; 
  
    //  visit set to ignore already visited string 
    Set<String> visit= new HashSet<>(); 
  
    //  queue to maintain BFS 
    Queue<String> q= new LinkedList<>(); 
    String temp; 
    boolean level=false; 
  
    //  pushing given string as starting node into queue 
    q.add(str); 
    visit.add(str); 
    while (!q.isEmpty()) 
    { 
        str = q.poll(); 
        if (isValidString(str)) 
        { 
            System.out.println(str); 
            // If answer is found, make level true so that valid string of only that level are processed. 
            level = true; 
        } 
        if (level) 
            continue; 
        for (int i = 0; i < str.length(); i++) 
        { 
            if (!isParenthesis(str.charAt(i))) 
                continue; 
  
            // Removing parenthesis from str and  pushing into queue,if not visited already 
            temp = str.substring(0, i) + str.substring(i + 1); 
            if (!visit.contains(temp)) 
            { 
                q.add(temp); 
                visit.add(temp); 
            } 
        } 
    } 
} 
}
