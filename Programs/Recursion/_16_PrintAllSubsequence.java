package Recursion;

import java.math.BigInteger;

/*
 *
 * Print all subsequence of a given array.
 *
 * Time complexity is exponential
 * Space complexity is O(n)
 *
 */

public class _16_PrintAllSubsequence {

	public static void main(String[] args)
	{
		_16_PrintAllSubsequence ps = new _16_PrintAllSubsequence();
        int[] input = {1, 2, 3, 4};
        ps.print(input);
        System.out.println("========");
        ps.printAllSubSequences(input);
	}

	public void print(int[] input) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            output[0] = input[i];
            print(input, output, 1, i + 1, true);
        }
    }

    private void print(int[] input, int[] output, int len, int current, boolean print)
    {
        if (print) {
            for (int i = 0; i < len; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
        }
        if (current == input.length) {
            return;
        }
        output[len] = input[current];
        print(input, output, len + 1, current + 1, true);
        print(input, output, len, current + 1, false);
    }
    
    // Complexity- O(n^3) */           // Approach 2
    static void subArray( int [] arr,int n) 
    { 
        for (int i=0; i <n; i++) 
        { 
            // Pick ending point 
            for (int j=i; j<n; j++) 
            { 
                // Print subarray between current starting and ending points 
                for (int k=i; k<=j; k++) 
                    System.out.print(arr[k]+" "); 
            } 
        } 
    }
    
    // Approach 3
    static void printSubsequences(int [] arr,int n) 
    { 
        /* Number of subsequences is (2**n -1)*/
        int opsize = (int)Math.pow(2, n); 
       
        /* Run from counter 000..1 to 111..1*/
        for (int counter = 1; counter < opsize; counter++) 
        { 
            for (int j = 0; j < n; j++) 
            { 
                /* Check if jth bit in the counter is set If set then print jth element from arr[] */
                if (BigInteger.valueOf(counter).testBit(j)) 
                    System.out.print(arr[j]+" "); 
            } 
            System.out.println(); 
        } 
    } 
    
    // Approach 4
    public void printAllSubSequences(int [] arrInput){
        int [] temp = new int[arrInput.length];
        int index = 0;
        solve(arrInput, index, temp);
    }

    private void solve(int [] arrInput, int index, int [] temp){
        if(index==arrInput.length){
            print(arrInput,temp);
            return;
        }
        //set the current index bit and solve it recursively
        temp[index] = 1;
        solve(arrInput,index+1,temp);
        //unset the current index bit and solve it recursively
        temp[index] = 0;
        solve(arrInput,index+1,temp);
    }

    private void print(int [] arrInput, int [] temp){
        String result = "";
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]==1)
                result += arrInput[i]+" ";
        }
        if(result=="")
            result = "{Empty Set}";
        System.out.println(result);
    }
}
