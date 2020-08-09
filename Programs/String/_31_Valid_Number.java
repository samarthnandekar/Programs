package String;

/*
 https://leetcode.com/problems/valid-number/
 
65. Valid Number
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.
 */
public class _31_Valid_Number {

	/*
	 Thought process:
There are several rules to enforce:
1. There must be at least one number.
2. e must come after some number and be followed by some number.
3. Point cannot come after e.
4. + and - can only appear in two positions: at the start of the string or right after e.
5. There cannot be characters other than digits, e, point, + or -, or space.
	 */
	
	 public static boolean isNumber(String s) {
	        s = s.trim();
	        boolean eSeen = false;
	        boolean numberSeen = false;
	        boolean pointSeen = false;
	        boolean numberAfterE = false;
	        
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (Character.isDigit(c)) {
	                numberSeen = true;
	                numberAfterE = true;
	            } else if (c == 'e') {
	                if (eSeen || !numberSeen) {
	                    return false;
	                }
	                eSeen = true;
	                numberAfterE = false;
	            } else if (c == '.') {
	                if (eSeen || pointSeen) {
	                    return false;
	                }
	                pointSeen = true;
	            } else if (c == '+' || c == '-') {
	                if (i != 0 && s.charAt(i - 1) != 'e') {
	                    return false;
	                }
	            } else {
	                return false;
	            }
	        }
	        
	        return numberSeen && numberAfterE;
	    }
	 
	 public static void main(String args[])
	 {
		 System.out.println("1 a  ->"+isNumber("1 a"));
		 System.out.println("2e10  ->"+isNumber("2e10"));
		 System.out.println("0.1  ->"+isNumber("0.1"));
	 }
}
