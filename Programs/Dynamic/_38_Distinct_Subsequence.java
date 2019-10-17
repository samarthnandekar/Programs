package Dynamic;


/*
 Count distinct occurrences as a subsequence
Given a two strings S and T, find count of distinct occurrences of T in S as a subsequence.

Examples:

Input  : S = banana, T = ban
Output : 3
T appears in S as below three subsequences.
[ban], [ba  n], [b   an]

Input  : S = geeksforgeeks, T = ge
Output : 6
T appears in S as below three subsequences.
[ge], [     ge], [g e], [g    e] [g     e] and [     g e]      

https://www.geeksforgeeks.org/count-distinct-occurrences-as-a-subsequence/

-------------------
https://leetcode.com/problems/distinct-subsequences/

115. Distinct Subsequences
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^

Time complexity O(n^2)
Space complexity O(n^2)
 */
public class _38_Distinct_Subsequence {

	public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        int[][] T = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < T[0].length; i++) {
            T[0][i] = 1;
        }
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    T[i][j] = T[i-1][j-1] + T[i][j-1];
                } else {
                    T[i][j] = T[i][j-1];
                }
            }
        }
        return T[t.length()][s.length()];
    }

    public static void main(String args[]) {
    	_38_Distinct_Subsequence ds = new _38_Distinct_Subsequence();
        //System.out.println(ds.numDistinct("abdacgblc", "abc"));
        System.out.println(ds.numDistinct("abacb", " "));
    }

}
