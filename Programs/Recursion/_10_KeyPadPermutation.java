package Recursion;
/*
 https://www.geeksforgeeks.org/find-possible-words-phone-digits/
 Before advent of QWERTY keyboards, texts and numbers were placed on the same key. For example 2 has “ABC” if we wanted to write 
 anything starting with ‘A’ we need to type key 2 once. If we wanted to type ‘B’, press key 2 twice and thrice for typing ‘C’. 
 below is picture of such keypad.
 
 for example number is 23 then possible words can be form dg, dh ,di,eg,eh,ei,fg,fh,fi

 
 */
public class _10_KeyPadPermutation {

	public void permute(int input[]) {
        char result[] = new char[input.length];
        permute(input,0,result);
    }

    private void permute(int input[], int pos, char result[]) 
    {
        if (pos == input.length) {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
            return;
        }

        char[] str = getCharSetForNumber(input[pos]);
        for (char ch : str) {
            result[pos] = ch;
            permute(input, pos+1, result);
        }
    }

    private char[] getCharSetForNumber(int num) {
        switch(num){
            case 1 : return "abc".toCharArray();
            case 2 : return "def".toCharArray();
            case 3: return "ghi".toCharArray();
            case 4: return "jkl".toCharArray();
            case 5: return "mno".toCharArray();
            case 6: return "pqrs".toCharArray();
            case 8: return "tuv".toCharArray();
            case 9: return "wxyz".toCharArray();
        }
        throw new IllegalArgumentException();
    }
    
    public static void main(String args[]){
        int input[] = {2,3};
        _10_KeyPadPermutation kpp = new _10_KeyPadPermutation();
        kpp.permute(input);
    }
}
