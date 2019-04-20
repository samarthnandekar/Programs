package Array;

import java.util.Arrays;

public class _111_RearrangeArrayPerIndex {

	/*A Simple Solution is to create a temporary array and one by one copy ‘i’ to ‘temp[arr[i]]’ where i varies from 0 to n-1.*/
	void rearrangeNaive(int arr[], int n)  
    { 
        // Create an auxiliary array of same size 
        int temp[] = new int[n]; 
        int i; 
  
        // Store result in temp[] 
        for (i = 0; i < n; i++) 
            temp[arr[i]] = i; 
  
        // Copy temp back to arr[] 
        for (i = 0; i < n; i++) 
            arr[i] = temp[i]; 
    }

	public void rearrange(int input[]) {

        for (int i = 0; i < input.length; i++) {
            input[i]++;
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                rearrangeUtil(input, i);
            }
        }

        for (int i = 0; i < input.length; i++) {
            input[i] = -input[i] - 1;
        }
    }

    private void rearrangeUtil(int input[], int start) {
        int i = start + 1;
        int v = input[start];
        while (v > 0) {
            int t = input[v - 1];
            input[v - 1] = -i;
            i = v;
            v = t;
        }
    }

    public static void main(String args[]) {
    	_111_RearrangeArrayPerIndex rai = new _111_RearrangeArrayPerIndex();
        int input[] = {1, 2, 0, 5, 3, 4};
        rai.rearrange(input);
        Arrays.stream(input).forEach(i -> System.out.print(i + " "));
    }
}
