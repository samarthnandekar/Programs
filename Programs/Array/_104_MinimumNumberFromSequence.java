package Array;

import java.util.Arrays;
import java.util.Stack;

/*
Form minimum number from given sequence
Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print
the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.
Examples:
   Input: D        Output: 21
   Input: I        Output: 12
   Input: DD       Output: 321
   Input: II       Output: 123
   Input: DIDI     Output: 21435
   Input: IIDDD    Output: 126543
   Input: DDIDDIID Output: 321654798 
 */
public class _104_MinimumNumberFromSequence {

	static void PrintMinNumberForPattern(String seq) { 
         
        String result = "";  
        Stack<Integer> stk = new Stack<Integer>(); 
  
        // run n+1 times where n is length of input sequence 
        for (int i = 0; i <= seq.length(); i++) { 
            // push number i+1 into the stack 
            stk.push(i + 1); 
  
            // if all characters of the input sequence are  processed or current character is 'I' (increasing) 
            if (i == seq.length() || seq.charAt(i) == 'I') { 
                // run till stack is empty 
                while (!stk.empty()) { 
                    // remove top element from the stack and add it to solution 
                    result += String.valueOf(stk.peek()); 
                    result += " "; 
                    stk.pop(); 
                } 
            } 
        } 
  
        System.out.println(result); 
    } 

    public static void main(String[] args) { 
       // PrintMinNumberForPattern("IDID"); 
        PrintMinNumberForPattern("D"); 
        //PrintMinNumberForPattern("DD"); 
      //  PrintMinNumberForPattern("II"); 
       // PrintMinNumberForPattern("DIDI"); 
        //PrintMinNumberForPattern("IIDDD"); 
        //PrintMinNumberForPattern("DDIDDIID"); 
        int output[] = find("D".toCharArray());
        System.out.println(Arrays.toString(output));
    } 
    
    public static int[] find(char[] input) {
        int[] output = new int[input.length + 1];
        output[0] = 1;
        int low = 0;
        int start = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 'D') {
                output[i + 1] = output[i] - 1;
                if (output[i+1] == low) {
                    for (int j = start; j <= i + 1; j++) {
                        output[j] = output[j] + 1;
                    }
                }
            } else {
                low = output[start];
                output[i + 1] = low + 1;
                start = i + 1;
            }
        }
        return output;
    }
}
