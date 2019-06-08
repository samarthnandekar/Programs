package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 https://www.geeksforgeeks.org/program-generate-possible-valid-ip-addresses-given-string/
 
Program to generate all possible valid IP addresses from given string
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers from 0-255. The numbers cannot be 0 prefixed
unless they are 0.

Examples :-
Input : 25525511135
Output : [“255.255.11.135”, “255.255.111.35”]
Explanation: 
These are the only valid possibleIP addresses.

Input : "25505011535"
Output : []
Explanation : 
We cannot generate a valid IP address with this string. 
First, we will place 3 dots in the given string and then Try out all the possible combinations for the 3 dots.

Corner case for validity : For string "25011255255"

25.011.255.255 is not valid as 011 is not valid.
25.11.255.255 is not valid either as you are not allowed to change the string.
250.11.255.255 is valid.

*/

public class _20_RestoreIPAddresses {

	public static void main(String[] args) {
     
		String inputStr="25525511135";
		_20_RestoreIPAddresses res= new _20_RestoreIPAddresses();
		List<String> result=res.restoreIpAddresses(inputStr);
		
	//	List<String> res1 = res.restoreIpAddresses_1(inputStr);
   
		result.forEach(items->System.out.println(items));
		System.out.println("====================");
		//res1.forEach(items->System.out.println(items));
	}
	
	public List<String> restoreIpAddresses(String s) {
		
		List<String> result = new ArrayList<>();
		  if (s == null || s.length() == 0) {
	            return result;
	        }
	        if (s.length() < 4 || s.length() > 12) {
	        	return result;
	        }
	       
        List<String> current = new ArrayList<>();
        restoreIpAddressesUtilImproved(s, 0, result, current);
        return result;
    }

	private void restoreIpAddressesUtil(String s, int start, List<String> result, List<String> current)
	{
        if (start == s.length() && current.size() == 4) 
        {
            StringBuffer stringBuffer = new StringBuffer(current.get(0));
            for (int i = 1; i < current.size(); i++) 
            {
                stringBuffer.append(".").append(current.get(i));
            }
            result.add(stringBuffer.toString());
            return;
        }
        else if (start == s.length() || current.size() == 4) 
        {
            return;
        }
        
        //run for loop 3 times: one IP spot has at most 3 digits
        int end = start + 3;
        
        for (int i = start; i < s.length() && i < end; i++) 
        {
            if (i != start && s.charAt(start) == '0') 
            {
                break;
            }
            String ip = s.substring(start, i + 1);
            if (Integer.valueOf(ip) > 255) 
            {
                continue;
            }
            current.add(ip);
            restoreIpAddressesUtil(s, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
	
	
	private void restoreIpAddressesUtilImproved(String s, int start, List<String> result, List<String> current)
	{
        if (start == s.length() && current.size() == 4) 
        {
            StringBuffer stringBuffer = new StringBuffer(current.get(0));
            for (int i = 1; i < current.size(); i++) 
            {
                stringBuffer.append(".").append(current.get(i));
            }
            result.add(stringBuffer.toString());
            return;
        }
        else if (start == s.length() || current.size() == 4) 
        {
            return;
        }
        
        //run for loop 3 times: one IP spot has at most 3 digits
        int end = start + 3;
        String sb= new String();
        for (int i = start; i < s.length() && i < end; i++) 
        {
        	sb=sb.concat(s.charAt(i)+"");
            int remainLength = (s.length() - i - 1);
            boolean remainValid = remainLength > 0 && remainLength <= (4 - current.size() - 1) * 3;
        	if (isValid(sb) && remainValid) 
        	{
        		current.add(sb);
                restoreIpAddressesUtil(s, i + 1, result, current);
                current.remove(current.size() - 1);	
        	}
            
        }
    }
	
	/*
	 * 
	  Implemented simple method above
	  
	public List<String> restoreIpAddresses_1(String s) {
        List<String> rst = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        if (s.length() < 4 || s.length() > 12) {
        	return rst;
        }
        List<String> list = new ArrayList<>();
        helper(rst, list, 0, s.toCharArray());

        return rst;
    }

    public void helper(List<String> rst, List<String>list, int index, char[] arr) 
    {
        if (list.size() == 3) 
        {
            StringBuffer sb = new StringBuffer();
            for (int i = index; i < arr.length; i++) 
            {
                sb.append(arr[i]);
            }
            
            if (!isValid(sb.toString())) 
            {
                return;
            }
            
            list.add(sb.toString());
            sb = new StringBuffer();
            for (String str: list) {
                sb.append(str + ".");
            }
            rst.add(sb.substring(0, sb.length() - 1).toString());
            list.remove(list.size() - 1);
            return;
        }
        
        //run for loop 3 times: one IP spot has at most 3 digits
        int end = index + 3;
        StringBuffer sb = new StringBuffer();
        for (int i = index; i < end && i < arr.length; i++) 
        {
        	sb.append(arr[i]);
            int remainLength = (arr.length - i - 1);
            boolean remainValid = remainLength > 0 && remainLength <= (4 - list.size() - 1) * 3;
        	if (isValid(sb.toString()) && remainValid) 
        	{
	            list.add(sb.toString());
	            helper(rst, list, i + 1, arr);
	            list.remove(list.size() - 1);
            }
        }
    }
*/
    //Valid the IP [0,255]; cannot start with 0 if it's not 0
    public boolean isValid(String str) {
    	if (str.charAt(0) == '0') {
    		return str.equals("0");
    	}
    	int num = Integer.parseInt(str);
    	return num <= 255 && num >= 0;
    }
}
