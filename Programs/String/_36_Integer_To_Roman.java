package String;

/*
 
 https://leetcode.com/problems/integer-to-roman/
 
 12. Integer to Roman
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000


Example 1:  Input: 3
			Output: "III"

Example 2:  Input: 4
			Output: "IV"

Example 3:  Input: 9
            Output: "IX"

Example 4:  Input: 58
			Output: "LVIII"

Explanation: L = 50, V = 5, III = 3.


 */
public class _36_Integer_To_Roman {

	public static void main(String[] args) {
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(10));
	
	}
	static public String intToRoman(int num) {
        int[] base = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX", "V", "IV", "I"};
        //expand the "base" char to make sure that the roman numeric can be only the 1 - 3 appearance of the characters above
        String result = "";
        for (int i = 0; i < base.length; i ++) {
           
        	if (num / base[i] > 0) {
                for (int j = 0; j < num/base[i]; j ++) {
                    result = result + chars[i];
                }
                num = num - (num / base[i]) * base[i];
            }
        }
        return result;
    }
}
