package Recursion;

import java.util.HashSet;
import java.util.Set;

/*
 
 97. Interleaving String
 
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:- Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
			Output: true

Example 2: Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
		   Output: false
		   
We can use dynamic programming, if we have to check, can we make third string from string1 and string2.
	   

 */
public class _22_Interleaving_String {

	public static void main(String args[]){
	        
		  _22_Interleaving_String si = new _22_Interleaving_String();
	        String str1 ="AB";
	        String str2 = "CD";
	        char[] result = new char[str1.length() + str2.length()];
	        
	        Set<String> strSet= new HashSet<>();
	        
	        si.interleaving(str1.toCharArray(), str2.toCharArray(), 0, 0, 0, result,strSet);
	        
	        for(String str:strSet)
	        {
	        	System.out.println(str);
	        }
	    }

static public void interleaving(char[] str1,char[] str2,int len1,int len2,int current, char []result,Set<String> strSet){
        
        if(current == result.length){
        	strSet.add(new String(result));
            return;
        }

        if(len1 < str1.length){
            result[current] = str1[len1];
            interleaving(str1, str2, len1+1, len2, current+1, result,strSet);
        }
        if(len2 < str2.length){
            result[current] = str2[len2];
            interleaving(str1,str2,len1,len2+1,current+1,result,strSet);
        }
    }
}
