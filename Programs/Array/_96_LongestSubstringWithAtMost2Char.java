package Array;

import java.util.HashMap;

/*
 * asked by Google.
   Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", 
   the longest substring that contains 2 unique character is "bcbbbbcccb".
 
 
 */

public class _96_LongestSubstringWithAtMost2Char 
{
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        int count1 = 0;
        int count2 = 0;
        char c1 = 0;
        char c2 = 0;
        int start = 0;
        int current = 0;
        int max = 0;
        for (char ch: s.toCharArray()) {
            if (ch == c1 || ch == c2) {
                if (ch == c1) {
                    count1++;
                } else {
                    count2++;
                }
            } else {
                if (count1 != 0 && count2 != 0) {
                    while (start < current) {
                        if (s.charAt(start) == c1) {
                            count1--;
                        } else if (s.charAt(start) == c2) {
                            count2--;
                        }
                        start++;
                        if (count1 == 0 || count2 == 0) {
                            break;
                        }
                    }
                }
                if (count1 == 0) {
                    c1 = ch;
                    count1 = 1;
                } else {
                    c2 = ch;
                    count2 = 1;
                }
            }
            max = Math.max(max, current - start + 1);
            current++;
        }
        return max;
    }

    public static void main(String args[]) {
        _96_LongestSubstringWithAtMost2Char lc = new _96_LongestSubstringWithAtMost2Char();
        System.out.print(lc.lengthOfLongestSubstringTwoDistinct("abcbbbbcccbdddadacb"));
    }
    
    /*
     1. Longest Substring Which Contains 2 Unique Characters
     In this solution, a hashmap is used to track the unique elements in the map. When a third character is added to the map, the left pointer needs 
     to move right.
     */
    public int lengthOfLongestSubstringTwoDistinct_1(String s) {
        int max=0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int start=0;
     
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
     
            if(map.size()>2){
                max = Math.max(max, i-start);
     
                while(map.size()>2){
                    char t = s.charAt(start);
                    int count = map.get(t);
                    if(count>1){
                        map.put(t, count-1);
                    }else{
                        map.remove(t);
                    }
                    start++;
                }
            }
        }
     
        max = Math.max(max, s.length()-start);
     
        return max;
    }
    /*
     * 2. Solution for K Unique Characters
       The following solution is corrected. Given "abcadcacacaca" and 3, it returns "cadcacacaca".
     */
    public int lengthOfLongestSubstringKDistinct_2(String s, int k) {
        int result = 0;
        int i=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
     
        for(int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
     
            if(map.size()<=k){
                result = Math.max(result, j-i+1);
            }else{
                while(map.size()>k){
                    char l = s.charAt(i);
                    int count = map.get(l);
                    if(count==1){
                        map.remove(l);
                    }else{
                        map.put(l, map.get(l)-1);
                    }
                    i++;
                }
            }
     
        }
        return result;
    }
}
