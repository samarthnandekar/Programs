package Stack;

import java.util.Stack;

/*
 https://leetcode.com/problems/evaluate-reverse-polish-notation/
 
 150. Evaluate Reverse Polish Notation
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:- Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

Example 1:
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

 */
public class _1_EvaluateReversePolishNotation {

	public static void main(String[] args) {
		String [] exp= {"2", "1", "+", "3", "*"};
		_1_EvaluateReversePolishNotation obj= new _1_EvaluateReversePolishNotation();
		int ans=obj.evaluateRPN(exp);
         System.out.println(ans);
	}
	
	int evaluateRPN(String [] input)
	{
		Stack<String> stack= new Stack<>();
		int returnValue = 0;
		String operators = "+-*/";
		
		for(String str:input)
		{
			if (!operators.contains(str)) { //push to stack if it is a number
				stack.push(str);
			}
				else
				{
					int a = Integer.valueOf(stack.pop());
					int b = Integer.valueOf(stack.pop());
					
					switch (str) {
					case "+":
						stack.push(String.valueOf(a + b));
						break;
					case "-":
						stack.push(String.valueOf(b - a));
						break;
					case "*":
						stack.push(String.valueOf(a * b));
						break;
					case "/":
						stack.push(String.valueOf(b / a));
						break;
				}			
		}				
	}
		returnValue = Integer.valueOf(stack.pop());
		return returnValue;
}
}
	