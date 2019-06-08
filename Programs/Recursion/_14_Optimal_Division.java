package Recursion;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/*
   553. Optimal Division

   Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.
	
   However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how 
   to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT 
   contain redundant parenthesis.
	
	Example:
	Input: [1000,100,10,2]
	Output: "1000/(100/10/2)"
	Explanation:
	1000/(100/10/2) = 1000/((100/10)/2) = 200
	However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
	since they don't influence the operation priority. So you should return "1000/(100/10/2)". 
	
	Other cases:
	1000/(100/10)/2 = 50
	1000/(100/(10/2)) = 50
	1000/100/10/2 = 0.5
	1000/100/(10/2) = 2
	Note:
	
	The length of the input array is [1, 10].
	Elements in the given array will be in range [2, 1000].
	There is only one optimal division for each test case.

 */


/*
 1) https://medium.com/@roger35972134/leetcode-553-optimal-division-9aeedf5e8827
 
 Solution:- It’s a math question, with the question case

If we don’t add any special priority to the formula:

1000/100/10/2 equal to 1000/100*10*2 = 0.5
We can make sure that the first element will be the dividends and we want the final divisor as small as possible.

So if we add a priority to the second element

1000/(100/10/2) equal to 1000/(100/10*2) = 200
If we can divide the second large value, we can make the result biggest.


2) https://www.cnblogs.com/grandyang/p/6886673.html
This question gives us an array, let us determine the order of the division, so that the order of the largest value of the operation,
and can not add extra brackets. At first, the blogger didn't read the question. He thought that to return the maximum value,
he wrote a recursive method of violent search. The result was that he wanted to return the parenthesized string. Trying to modify it, 
it feels very troublesome. So I gave up the resistance directly, and I went to the Internet to refer to the solution of the great gods. 
The result was shocked. This question can still be solved in this way. It is completely mathematical knowledge, too tricky. n numbers in
 the array, if not bracketed:

X1 / x2 / x3 / ... / xn

So how do we add parentheses to maximize their value, then turn the divisor after x2 into a multiplier, such as the case of only three
digits a / b / c, if we add parentheses a / after the last two numbers (b / c) is actually a / b * c. And b can only be a divisor, and a
 can only be a divisor. Similarly, x1 can only be a divisor, x2 can only be a divisor, but the number after x3, as long as we turn it into 
 a multiplier, then the value obtained is definitely the largest, so there is only one way to add parentheses. which is:

X1 / (x2 / x3 / ... / xn)

In this case, there is no need to recurse at all. This question becomes a simple problem of string manipulation. This idea is taken by 
the blogger. See the code below:
	
 */
public class _14_Optimal_Division {

	 public static void main(String args[])
	 {
	        //int[] nums = {100, 10, 10, 2};
	        int[] nums = {100,10,2};
	        _14_Optimal_Division od = new _14_Optimal_Division();
	        System.out.println(od.optimalDivision(nums));
	        
	       String ans= optimalDivision_1(nums);
	       System.out.println(ans);
	  }

public String optimalDivision(int[] nums) {
    Result r = optimalDivison(nums, 0, nums.length - 1, true);
    System.out.println(r.val);
    return r.str;
}

private Result optimalDivison(int[] nums, int start, int end, boolean maximize)
{
    if (start == end) {
        return new Result(nums[start], String.valueOf(nums[start]));
    }

    double maxResult = 0;
    double minResult = Double.MAX_VALUE;
    String result = "";
    int cutI = start;
    String part1 = "";
    String part2 = "";
    for (int i = start; i < end; i++)
    {
        Result d1 = optimalDivison(nums, start, i, maximize);
        Result d2 = optimalDivison(nums, i + 1, end, !maximize);
        double val = d1.val / d2.val;
        if (maximize) 
        {
            if (maxResult < val) 
            {
                maxResult = val;
                part1 = d1.str;
                part2 = d2.str;
                cutI = i;
           }
        } else 
        {
            if (minResult > val) {
                minResult = val;
                part1 = d1.str;
                part2 = d2.str;
                cutI = i;
            }
        }
    }
    if (cutI < end - 1) {
        result = part1 + "/(" + part2 + ")";
    } else {
        result = part1 + "/" + part2;
    }
    return maximize ? new Result(maxResult, result) : new Result(minResult, result);
}

static String optimalDivision_1(int[] nums) 
{
    if (nums.length==0)
    	return  "" ;
    
    String res = nums[0]+"";
    if (nums.length == 1 ) 
    	return res;
    if (nums.length == 2 ) 
    	return res + " / " + nums[1];
   
    res += "/(" + nums[1];
    for ( int i = 2 ; i < nums.length; ++ i) {
       res += "/" + nums[i];
   }
   return res + ")" ;
}



	@Test
	public void validateInput()
	{
		int[] nums = {6,12,2};
		String ans=optimalDivision_1(nums);
		String expAns="6/(12/2)";
		Assert.assertEquals(ans, expAns);
	}

	@Test
	public void validateInput2()
	{
		int[] nums = {1000,100,10,2};
		String ans=optimalDivision_1(nums);
		String expAns="1000/(100/10/2)";
		Assert.assertEquals(ans, expAns);
	}
}

class Result
{
    double val;
    String str;
    
    Result(double val, String str)
    {
        this.val = val;
        this.str = str;
    }
}


