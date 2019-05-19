package String;

/*
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *
 * Reference
 * https://leetcode.com/problems/one-edit-distance/
 * 

) Check if edit distance between two strings is one An edit between two strings is one of the following changes.

Add a character
Delete a character
Change a character

Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit. Expected time complexity is O(m+n) where m and n
 are lengths of two strings.

Examples:

Input:  s1 = "geeks", s2 = "geek"
Output: yes
Number of edits is 1

Input:  s1 = "geeks", s2 = "geeks"
Output: no
Number of edits is 0

Input:  s1 = "geaks", s2 = "geeks"
Output: yes
Number of edits is 1

Input:  s1 = "peaks", s2 = "geeks"
Output: no
Number of edits is 2


A Simple Solution is to find Edit Distance using Dynamic programming. If distance is 1, then return true, else return false.
Time complexity of this solution is O(n2)


 */
public class OneEditApart {

	public boolean isOneEditDistance(String s, String t) {
        String larger, smaller;
        if (s.length() < t.length()) {
            larger = t;
            smaller = s;
        } else {
            larger = s;
            smaller = t;
        }

        if (Math.abs(larger.length() - smaller.length()) > 1) {
            return false;
        }

        boolean diffFound = false;
        int j = 0;
        for (int i = 0; i < smaller.length();) 
        {
            if (smaller.charAt(i) == larger.charAt(j)) {
                i++;
                j++;
            } 
            else 
            {
                if (diffFound) {
                    return false;
                } else
                {
                    diffFound = true;
                    if (smaller.length() == larger.length()) 
                    {
                        i++; j++;
                    } else
                    {
                        j++;
                    }
                }
            }
        }
        return diffFound || j < larger.length();
    }

    public static void main(String args[]){
        OneEditApart oea = new OneEditApart();
        System.out.println(oea.isOneEditDistance("dat", "cdat"));  // line no 77 to 83, required to handle this condition
        System.out.println(oea.isOneEditDistance("cat", "cats"));
        System.out.println(oea.isOneEditDistance("cat", "cut"));
        System.out.println(oea.isOneEditDistance("cats", "casts"));
        System.out.println(oea.isOneEditDistance("catsts", "casts"));
    }
}
