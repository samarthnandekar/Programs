package Stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
 *227. Basic Calculator II
 
Implement a basic calculator to evaluate a simple expression string.
The expression string contains only non-negative integers, +, -, *, / operators 
and empty spaces . The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
Accepted
 
 */
public class _1_Calculator {

	public float calculate(String s) {
        Stack<Float> operand = new Stack<>();
        float current = 0;
        char prevOperator = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                current = current * 10 + ch - '0';
            }
            //if its not a digit or space then go in this block.
            //also if it is last character then go in this block and finish up last operation.
            if (i == s.length() - 1 || (ch != ' ' && !Character.isDigit(ch))) {
                if (prevOperator == '+') {
                    operand.push(current);
                } else if (prevOperator == '-') {
                    operand.push(-current);
                } else if (prevOperator == '/') {
                    operand.push(operand.pop() / current);
                } else {
                    operand.push(operand.pop() * current);
                }
                prevOperator = ch;
                current = 0;
            }
        }
        float result = 0;
        while (!operand.isEmpty()) {
            result += operand.pop();
        }
        return result;
    }
	
	public static void main(String [] args)
	{
		_1_Calculator obj= new _1_Calculator();
		float out=obj.calculate("3+5/2");
		System.out.println(out);
	}
	
	 @Test
	 public void testDifferentCases() {
		   _1_Calculator basicCalculator = new _1_Calculator();
		   float ans=basicCalculator.calculate("0");
		   System.out.println(ans==0.0);

	    }
	 
}
