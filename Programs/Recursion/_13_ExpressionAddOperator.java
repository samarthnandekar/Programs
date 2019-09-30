package Recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/*

282. Expression Add Operators
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the 
digits so they evaluate to the target value.

Example 1:
Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 

Example 2:
Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]

Example 3:
Input: num = "105", target = 5
Output: ["1*0+5","10-5"]

Example 4:
Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]

Example 5:
Input: num = "3456237490", target = 9191
Output: []

 */
public class _13_ExpressionAddOperator 
{
	public static void main(String args[]) {
		_13_ExpressionAddOperator p = new _13_ExpressionAddOperator();
		String inputStr="434";
		int target=-8;
		List<String> res= addOperators(inputStr,target);
		printResult(res);
		System.out.println("**********************");
		
		inputStr="123";
		target=6;
		res= addOperators(inputStr,target);
		printResult(res);
		System.out.println("**********************");
		
		inputStr="232";
		target=8;
		res= addOperators(inputStr,target);
		printResult(res);
		System.out.println("**********************");
		
		inputStr="105";
		target=5;
		res= addOperators(inputStr,target);
		printResult(res);
		System.out.println("**********************");
		
		inputStr="909";
		target=18;
		res= addOperators(inputStr,target);
		printResult(res);
		System.out.println("**********************");
		
		inputStr="3456237490";
		target=9191;
		res= addOperators(inputStr,target);
		printResult(res);
		System.out.println("**********************");
    }
	
	static public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() <= 1)
            return rst;
        getResult(num, target, rst, "", 0, 0, 0);
        return rst;
    }
 
    static private void getResult(String num, int target, List<String> rst, String curr,int start, long sum, long lastNum) {
        if (start == num.length()) {
            if (sum == target) {
                rst.add(curr);
            }
            return;
        }
        for (int i = start + 1; i <= num.length(); i++) {
            String curNumString = num.substring(start, i);
       
            //As we need a number between 0 to 9(single digit number only).
            if (curNumString.length() > 1 && curNumString.charAt(0) == '0') 
            {
            	System.out.println("Inside break loop");
                break;
            }
            long currNum = Long.parseLong(curNumString);
            if (start == 0) {
                getResult(num, target, rst, curr + currNum, i, currNum, currNum);
            } else {
                getResult(num, target, rst, curr + "+" + currNum, i, sum + currNum, currNum);
                getResult(num, target, rst, curr + "-" + currNum, i, sum - currNum, -currNum);
                getResult(num, target, rst, curr + "*" + currNum, i, sum - lastNum + lastNum * currNum, currNum);
            }
        }
 
    }
	 /*
	   ***** 5star:-At first I thought this is good, but the problem is multiply, it failed on OJ, e.g. for input “232”, with target=8.
	                the output is: [2+3 * 2], it missed [2 * 3+2]. the value compute by this solution is 2 * (3+2)=10, not 8.

                   Now we can focus on how to deal with order of operations, for example, we need covert 2 * (3+2) to 2 * 3+2. when the 
                   sub-problem “32” return, the sum(recorded in node.v) is 5(3+2). we need convert it to 2 * (5-X) + X. what is the value of X? 
                   it is 2, the value of previous sub-proble.

                   It works for subtraction as well, e.g. [2 * 3-2] will get result 1[2 * (3-2)], but we need turn it to 4[(2 * 3)-2].
                   current sum is 1(3-2), previous sum is -2. 2 * (1-(-2))+(-2) = 4 
	  */
	  
	// method to print result 
	static void printResult(List<String> res) 
	{ 
	    for (int i = 0; i < res.size(); i++) 
	        System.out.println(res.get(i));
	    
	} 
	
	@Test
	public void test1()
	{
		String inputStr="434";
		int target=-8;
		List<String> res= addOperators(inputStr,target);
		Assert.assertEquals(res.size(), 1);
		String outVal="4-3*4";
		Assert.assertTrue(res.contains(outVal));	
	}
	
	@Test
	public void test2()
	{
		String inputStr="123";
		int target=6;
		String res1="1+2+3",res2="1*2*3";
		List<String> res= addOperators(inputStr,target);
		Assert.assertTrue(res.contains(res1));
		Assert.assertTrue(res.contains(res2));
		Assert.assertEquals(res.size(),2);
	}
	
	@Test
	public void test3()
	{
		String inputStr="232";
		int target=8;
		List<String> res= addOperators(inputStr,target);
		String res1="2*3+2",res2="2+3*2";
		Assert.assertTrue(res.contains(res1));
		Assert.assertTrue(res.contains(res2));
		Assert.assertEquals(res.size(),2);
	}
	
	@Test
	public void test4()
	{
		String inputStr="105";
		int target=5;
		List<String> res= addOperators(inputStr,target);
		String res1="1*0+5",res2="10-5";
		Assert.assertTrue(res.contains(res1));
		Assert.assertTrue(res.contains(res2));
		Assert.assertEquals(res.size(),2);
	}
	
	@Test
	public void test5()
	{
		String inputStr="00";
		int target=0;
		List<String>res= addOperators(inputStr,target);
		String res1="0+0",res2="0-0",res3="0*0";
		Assert.assertTrue(res.contains(res1));
		Assert.assertTrue(res.contains(res2));
		Assert.assertTrue(res.contains(res3));
		Assert.assertEquals(res.size(),3);
	}

	@Test
	public void test6()
	{
	String inputStr="3456237490";
	int target=9191;
	List<String>res= addOperators(inputStr,target);
	Assert.assertTrue(res.isEmpty());
	}
	
	
}
