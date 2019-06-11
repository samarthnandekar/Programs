package String;

/*
 Longest Palindromic Substring
 
Given a string, find the longest substring which is palindrome. For example, if the given string is “forgeeksskeegfor”, the output 
should be “geeksskeeg”.

Method 1 ( Brute Force ) 
The simple approach is to check each substring whether the substring is a palindrome or not. We can run three loops, the outer two loops
pick all substrings one by one by fixing the corner characters, the inner loop checks whether the picked substring is palindrome or not.

Time complexity: O ( n^3 )
Auxiliary complexity: O ( 1 )
*/

/*
 Method 2:- dynamic programming solution.
 Time complexity: O ( n^2)
 Auxiliary complexity: O ( n^2 )
 
 Method 3:- The time complexity of the Dynamic Programming based solution is O(n^2) and it requires O(n^2) extra space. We can find the
 longest palindrome substring in (n^2) time with O(1) extra space. The idea is to generate all even length and odd length palindromes and
 keep track of the longest palindrome seen so far.

 Step to generate odd length palindrome:
 Fix a centre and expand in both directions for longer palindromes.

 Step to generate even length palindrome
 Fix two centre ( low and high ) and expand in both directions for longer palindromes.
 Time complexity: O ( n^2 ) where n is the length of input string.
 Auxiliary Space: O ( 1 )

 Method 4:- Linear time Manacher's algorithm to find longest palindromic substring.
   
   There are 4 cases to handle
   Case 1 : Right side palindrome is totally contained under current palindrome. In this case do not consider this as center.
   Case 2 : Current palindrome is proper suffix of input. Terminate the loop in this case. No better palindrom will be found on right.
   Case 3 : Right side palindrome is proper suffix and its corresponding left side palindrome is proper prefix of current palindrome. 
            Make largest such point as next center.
   Case 4 : Right side palindrome is proper suffix but its left corresponding palindrome is be beyond current palindrome. Do not consider this
   as center because it will not extend at all.
 
   To handle even size palindromes replace input string with one containing $ between every input character and in start and end.
 */
public class _4_LongestPalindromeSubstring {

	public static void main(String args[]) {
		_4_LongestPalindromeSubstring lps = new _4_LongestPalindromeSubstring();
        System.out.println(lps.longestPalindromicSubstringLinear("abba".toCharArray()));
        System.out.println(lps.longestPalindromicSubstringLinear("abbababba".toCharArray()));
        System.out.println(lps.longestPalindromicSubstringLinear("babcbaabcbaccba".toCharArray()));
        System.out.println(lps.longestPalindromicSubstringLinear("cdbabcbabdab".toCharArray()));
    }
	
	// method 1
	public int longestPalindrome_1(char [] str)
	{
		return 0;
	}
	
	// method 2
	public int longestPalindromeDynamic(char []str){
        boolean T[][] = new boolean[str.length][str.length];
        
        for(int i=0; i < T.length; i++){
            T[i][i] = true;
        }
        
        int max = 1;
        for(int l = 2; l <= str.length; l++){
            int len = 0;
            for(int i=0; i < str.length-l+1; i++){
                int j = i + l-1;
                len = 0;
                if(l == 2){
                    if(str[i] == str[j]){
                        T[i][j] = true;
                        len = 2;
                    }
                }else{
                    if(str[i] == str[j] && T[i+1][j-1]){
                        T[i][j] = true;
                        len = j -i + 1;
                    }
                }
                if(len > max){
                    max = len;
                }
            }
        }
        return max;
    }
	
	// method 3
	public int longestPalindromeSubstringEasy(char arr[]) {

        int longest_substring = 1;
        for (int i = 0; i < arr.length; i++) {

            int x, y;
            int palindrome;
            x = i;
            y = i + 1;
            palindrome = 0;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longest_substring = Math.max(longest_substring, palindrome);
            
            x = i - 1;
            y = i + 1;
            palindrome = 1;
            while (x >= 0 && y < arr.length && arr[x] == arr[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            longest_substring = Math.max(longest_substring, palindrome);
        }
        return longest_substring;
    }
	
	// method 4
	public int longestPalindromicSubstringLinear(char input[]) {
        int index = 0;
        //preprocess the input to convert it into type abc -> $a$b$c$ to handle even length case.
        //Total size will be 2*n + 1 of this new array.
        char newInput[] = new char[2*input.length + 1];
        for(int i=0; i < newInput.length; i++) {
            if(i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '$';
            }
        }

        //create temporary array for holding largest palindrome at every point. There are 2*n + 1 such points.
        int T[] = new int[newInput.length];
        int start = 0;
        int end = 0;
        //here i is the center.
        for(int i=0; i < newInput.length; ) {
            //expand around i. See how far we can go.
            while(start >0 && end < newInput.length-1 && newInput[start-1] == newInput[end+1]) {
                start--;
                end++;
            }
            //set the longest value of palindrome around center i at T[i]
            T[i] = end - start + 1;

            //this is case 2. Current palindrome is proper suffix of input. No need to proceed. Just break out of loop.
            if(end == T.length -1) {
                break;
            }
            //Mark newCenter to be either end or end + 1 depending on if we dealing with even or old number input.
            int newCenter = end + (i%2 ==0 ? 1 : 0);

            for(int j = i + 1; j <= end; j++) {

                //i - (j - i) is left mirror. Its possible left mirror might go beyond current center palindrome. So take minimum
                //of either left side palindrome or distance of j to end.
                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                //Only proceed if we get case 3. This check is to make sure we do not pick j as new center for case 1 or case 4
                //As soon as we find a center lets break out of this inner while loop.
                if(j + T[i - (j - i)]/2 == end) {
                    newCenter = j;
                    break;
                }
            }
            //make i as newCenter. Set right and left to atleast the value we already know should be matching based of left side palindrome.
            i = newCenter;
            end = i + T[i]/2;
            start = i - T[i]/2;
        }

        //find the max palindrome in T and return it.
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < T.length; i++) {
            int val;
            val = T[i]/2;
            if(max < val) {
                max = val;
            }
        }
        return max;
    }

}
