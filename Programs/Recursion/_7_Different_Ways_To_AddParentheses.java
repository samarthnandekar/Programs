package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 
241. Different Ways to Add Parentheses

Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
The valid operators are +, - and *.

Example 1:
Input: "2-1-1"
Output: [0, 2]
Explanation: 
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10


Samarth:-not covered
 */


public class _7_Different_Ways_To_AddParentheses {

	public static void main(String[] args) {
		_7_Different_Ways_To_AddParentheses df = new _7_Different_Ways_To_AddParentheses();
        List<Integer> result = df.diffWaysToCompute("2-1-1");
        result.forEach(s -> System.out.println(s));


	}
	
	public List<Integer> diffWaysToCompute(String str) {
        List<Integer> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*')
            {
                operands.add(Integer.parseInt(str.substring(prev + 1, i)));
                operators.add(str.charAt(i));
                prev = i;
            }
        }
        operands.add(Integer.parseInt(str.substring(prev + 1, str.length())));
        return diffWaysToComputeUtil(operands, operators, 0, operators.size() - 1);
    }

    private List<Integer> diffWaysToComputeUtil(List<Integer> operands, List<Character> operators, int start, int end) {
        if (start > end) {
            if (start >= 0) {
                return Collections.singletonList(operands.get(start));
            } else {
                return Collections.singletonList(operands.get(end));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<Integer> leftResult = diffWaysToComputeUtil(operands, operators, start, i - 1);
            List<Integer> rightResult = diffWaysToComputeUtil(operands, operators, i + 1, end);

            for (int left : leftResult) {
                for (int right : rightResult) {
                    result.add((int)operate(left, right, operators.get(i)));
                }
            }
        }
        return result;
     }

    private long operate(int val1, int val2, char op) {
        switch (op) {
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
        }
        throw new IllegalArgumentException();
    }

}
