package Recursion;

/*
 * https://leetcode.com/problems/generate-parentheses/
 
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

Google
 */
public class _32_Generate_Parentheses {

	public static void main(String args[]) { 
		int n = 2;
		String str = "";
		int left = n;
		int right = n;
		PrintBrackets(str,left,right);
	}
	
	private static void PrintBrackets(String str, int left, int right) {
		if(left == 0 && right == 0) {
			System.out.println(str);
			return;
		}
		
		if(left > 0) {
			PrintBrackets(str+"(",left-1,right);
		}
		if(left < right) {
			PrintBrackets(str + ")" ,left, right-1);
		}
		return;
	} 
}
