package Dynamic.Dynamic;

/*
Find if string is K-Palindrome or not | Set 1
Given a string, find out if the string is K-Palindrome or not. A k-palindrome string transforms into a palindrome on removing at most k characters from it.

Examples :

Input : String - abcdecba, k = 1
Output : Yes
String can become palindrome by remo-
-ving 1 character i.e. either d or e)


Input  : String - abcdeca, K = 2
Output : Yes
Can become palindrome by removing
2 characters b and e.

Input : String - acdcb, K = 1
Output : No
String can not become palindrome by
removing only one character.
*/

public class K_Palindrome_or_not {

	 public static void main(String args[]){
		
		 String str = "acdcb"; 
		 int k = 2; 
		 System.out.println(isKPal(str, k)); 
	 }
	 
	 /*  The time complexity of above solution is exponential. In worst case, we may end up doing O(2n) operations.
	 The worst case happens string contains all distinct characters. */
	 
	// find if given string is K-Palindrome or not 
	 static int isKPalRec(String str1, String str2, int m, int n) 
	 { 
	     // If first string is empty, the only option is to 
	     // remove all characters of second string 
	     if (m == 0) return n; 
	   
	     // If second string is empty, the only option is to 
	     // remove all characters of first string 
	     if (n == 0) return m; 
	   
	     // If last characters of two strings are same, ignore 
	     // last characters and get count for remaining strings. 
	     if (str1.charAt(m-1) == str2.charAt(n-1)) 
	         return isKPalRec(str1, str2, m-1, n-1); 
	   
	     // If last characters are not same, 
	     // 1. Remove last char from str1 and recur for m-1 and n 
	     // 2. Remove last char from str2 and recur for m and n-1 
	     // Take minimum of above two operations 
	     return 1 + Math.min(isKPalRec(str1, str2, m-1, n), // Remove from str1 
	                    isKPalRec(str1, str2, m, n-1)); // Remove from str2 
	 }
	 
	// Returns true if str is k palindrome. 
	 static boolean isKPal(String str, int k) 
	 { 
	     String revStr = new StringBuilder(str).reverse().toString(); 
	    
	     int len = str.length(); 
	   
	     return (isKPalRec(str, revStr, len, len) <= k*2); 
	     //return (isKPalDP(str, revStr, len, len) <= k*2);
	    //return (lcs(str, revStr, len, len) <= k*2);
	 } 
	  
	 // find if given string is K-Palindrome or not 
	static int isKPalDP(String str1, String str2, int m, int n) 
	 { 
	     // Create a table to store results of subproblems 
	     int dp[][]= new int[m + 1][n + 1]; 
	   
	     // Fill dp[][] in bottom up manner 
	     for (int i = 0; i <= m; i++) 
	     { 
	         for (int j = 0; j <= n; j++) 
	         { 
	             // If first string is empty, only option is to 
	             // remove all characters of second string 
	             if (i == 0) 
	                 dp[i][j] = j; // Min. operations = j 
	   
	             // If second string is empty, only option is to 
	             // remove all characters of first string 
	             else if (j == 0) 
	                 dp[i][j] = i; // Min. operations = i 
	   
	             // If last characters are same, ignore last character 
	             // and recur for remaining string 
	             else if (str1.charAt(i - 1) == str2.charAt(j - 1)) 
	                 dp[i][j] = dp[i - 1][j - 1]; 
	   
	             // If last character are different, remove it 
	             // and find minimum 
	             else
	              dp[i][j] = 1 + Math.min(dp[i - 1][j], // Remove from str1 
	                              dp[i][j - 1]); // Remove from str2 
	         } 
	     } 
	   
	     return dp[m][n]; 
	 } 
	/* Time complexity of above solution is O(m x n). We can improve time complexity by making,
	   use of the fact that only k deletions are allowed. Auxiliary space used is O(m x n).    */
	
	// DP second approach
	/*The idea is to find the longest palindromic subsequence of the given string. If the difference between longest palindromic subsequence and the original string is less than equal to k,
	 * then the string is k-palindrome else it is not k-palindrome.
	Forexample, longest palindromic subsequence of string abcdeca is acdca(or aceca). The characters which do not contribute
	to longest palindromic subsequence of the string should be removed in order to make the string palindrome.
	So on removing b and d (or e) from abcdeca, string will transform into a palindrome.
	Longest palindromic subsequence of a string can easily be found using LCS. Following is the two step solution for finding longest palindromic subsequence that uses LCS.

	Reverse the given sequence and store the reverse in another array say rev[0..n-1]
	LCS of the given sequence and rev[] will be the longest palindromic sequence.	*/
	
	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcs( String X, String Y, int m, int n ) 
	{ 
	    int L[][] = new int [m + 1][n + 1]; 
	  
	    /* Following steps build L[m+1][n+1] in bottom up 
	        fashion. Note that L[i][j] contains length of 
	        LCS of X[0..i-1] and Y[0..j-1] */
	    for (int i = 0; i <= m; i++) 
	    { 
	        for (int j = 0; j <= n; j++) 
	        { 
	            if (i == 0 || j == 0) 
	                L[i][j] = 0; 
	            else if (X.charAt(i - 1) == Y.charAt(j - 1)) 
	                L[i][j] = L[i - 1][j - 1] + 1; 
	            else
	                L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]); 
	        } 
	    } 
	    // L[m][n] contains length of LCS for X and Y 
	    return L[m][n]; 
	}
}




