package String;

/*
 125. Valid Palindrome:- Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

Link:- https://leetcode.com/problems/valid-palindrome/
 
 */

public class _20_ValidPalindrome {

	public static void main(String args[]){
		_20_ValidPalindrome obj= new _20_ValidPalindrome();
		boolean ans= obj.isPalindrome("A man, a plan, a canal: Panama");
	    System.out.println(ans);
	}
	
	public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isAlphaNum(s.charAt(start))) {
                start++;
            } else if (!isAlphaNum(s.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(s.charAt(start++)) != Character.toLowerCase(s.charAt(end--))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isAlphaNum(char ch) {
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        return false;
    }
}
