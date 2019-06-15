package String;

/*
 https://www.geeksforgeeks.org/generate-all-permutations-of-a-string-that-follow-given-constraints/
 
 Generate all permutations of a string that follow given constraints
Given a string, generate all permutations of it that do not contain ‘B’ after ‘A’, i.e., the string should not contain “AB” as a substring.

Input : str = “ABC”
Output : ACB, BAC, BCA, CBA
Out of 6 permutations of “ABC”, 4 follow the given constraint and 2 (“ABC” and “CAB”) do not follow.

Input : str = “BCD”
Output : BCD, BDC, CDB, CBD, DCB, DBC


An efficient solution is to use Backtracking. We cut down the recursion tree whenever we see that substring “AB” is formed.
 */
public class StringPermutations {

	public static void main(String[] args) {
		

	}

}
