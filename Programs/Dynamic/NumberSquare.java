package Dynamic;

import java.util.Arrays;

public class NumberSquare {

	public static void main(String args[]){
	
		System.out.println(getMinSquares(4));
	}
	

	
	static public int numSquaresdp(int n) {
        if (n <= 1) {
            return n;
        }
         
        int[] res = new int[n + 1];
        
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                res[i + j * j] = Math.min(res[i] + 1, res[i + j * j]);
            }
        }
         
        return res[n];
    }
	
	static int getMinSquares(int n) 
    { 
        // Create a dynamic programming table 
        // to store sq 
        int dp[] = new int[n+1]; 
       
        // getMinSquares table for base case entries 
        dp[0] = 0; 
        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 3; 
       
        // getMinSquares rest of the table using recursive 
        // formula 
        for (int i = 4; i <= n; i++) 
        { 
            // max value is i as i can always be represented 
            // as 1*1 + 1*1 + ... 
            dp[i] = i; 
       
            // Go through all smaller numbers to 
            // to recursively find minimum 
            for (int x = 1; x <= i; x++) { 
                int temp = x*x; 
                if (temp > i) 
                    break; 
                else dp[i] = Math.min(dp[i], 1+dp[i-temp]); 
            } 
        } 
       
        // Store result and free dp[] 
        int res = dp[n]; 
       
        return res; 
    } 
}
