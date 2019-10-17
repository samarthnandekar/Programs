/** 
@Author  - sn656
Creation - Date Dec 6, 2018 3:52:55 PM

*/

package Dynamic;

/**
Link :-https://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/

Longest Even Length Substring such that Sum of First and Second Half is same
Given a string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the substring is 2k digits and 
sum of left k digits is equal to the sum of right k digits.

Examples :-
Input: str = "123123"
Output: 6
The complete string is of even length and sum of first and second half digits is same

Input: str = "1538023"
Output: 4
The longest substring with same first and second half sum is "5380"



Solutions:-

1) Simple Solution [ O(n3) ]
A Simple Solution is to check every substring of even length. The following is the implementation of simple approach.


2) Dynamic Programming [ O(n2) and O(n2) extra space]
The above solution can be optimized to work in O(n2) using Dynamic Programming. The idea is to build a 2D table that stores sums of substrings.
The following is the implementation of Dynamic Programming approach.


 */
public class Longest_Even_Length_Substr_Sum_Of_FSIsSame 
{
	
	static int findLength(String str) 
	{ 
	    int n = str.length(); 
	    int maxlen = 0; // Initialize result 
	  
	    // Choose starting point of every  
	    // substring 
	    for (int i = 0; i < n; i++) 
	    { 
	        // Choose ending point of even  
	        // length substring 
	        for (int j = i + 1; j < n; j += 2) 
	        {    
	            // Find length of current substr 
	            int length = j - i + 1; 
	  
	            // Calculate left & right sums 
	            // for current substr 
	            int leftsum = 0, rightsum = 0; 
	            for (int k = 0; k < length/2; k++) 
	            { 
	                leftsum += (str.charAt(i + k) - '0'); 
	                rightsum += (str.charAt(i + k + length/2) - '0'); 
	            } 
	  
	            // Update result if needed 
	            if (leftsum == rightsum && maxlen < length) 
	                    maxlen = length; 
	        } 
	    } 
	    return maxlen; 
	} 
	// Output:	Length of the substring is 4

	static int findLengthDp(String str) 
	{ 
	    int n = str.length(); 
	    int maxlen = 0; // Initialize result 
	  
	    // A 2D table where sum[i][j] stores  
	    // sum of digits from str[i] to str[j].  
	    // Only filled entries are the entries 
	    // where j >= i 
	    int sum[][] = new int[n][n]; 
	  
	    // Fill the diagonal values for  
	    // substrings of length 1 
	    for (int i = 0; i < n; i++) 
	        sum[i][i] = str.charAt(i) - '0'; 
	  
	    // Fill entries for substrings of 
	    // length 2 to n 
	    for (int len = 2; len <= n; len++) 
	    { 
	        // Pick i and j for current substring 
	        for (int i = 0; i < n - len + 1; i++) 
	        { 
	            int j = i + len - 1; 
	            int k = len/2; 
	  
	            // Calculate value of sum[i][j] 
	            sum[i][j] = sum[i][j-k] +  sum[j-k+1][j]; 
	  
	            // Update result if 'len' is even, 
	            // left and right sums are same 
	            // and len is more than maxlen 
	            if (len % 2 == 0 && sum[i][j-k] ==  
	                sum[(j-k+1)][j] && len > maxlen) 
	                maxlen = len; 
	        } 
	    } 
	    return maxlen; 
	} 

	public static void main(String[] args) 
	{ 
	    String str = "1538023"; 
	    System.out.println("Length of the substring is " + findLength(str)); 
	    
	    int length= findLengthDp(str);
	    System.out.print(length);
	    
	}
	
}

