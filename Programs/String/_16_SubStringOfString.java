package String;

/*
 
 Link :- https://www.geeksforgeeks.org/check-string-substring-another/
 
Check if a string is substring of another
Given two strings s1 and s2, find if s1 is substring of s2. If yes, return index of first occurrence, else return -1.

Examples :- Input : s1 = "for", s2 = "geeksforgeeks"
Output : 5, String "for" is present as a substring of s2.

Input : s1 = "practice", s2 = "geeksforgeeks"
Output : -1.

 */
public class _16_SubStringOfString 
{
	
    /* Driver program to test above function */
    public static void main(String args[]) 
    { 
        String s1 = "for"; 
        String s2 = "geeksforgeeks"; 
          
        int res = isSubstring(s1, s2); 
          
        if (res == -1) 
            System.out.println("Not present"); 
        else
            System.out.println("Present at index " + res); 
        
        System.out.println("----------------------------");
        boolean isSubString=hasSubstring(s2.toCharArray(),s1.toCharArray());
        System.out.println(isSubString);
    } 
    
	/*
       Time complexity : O(m * n) where m and n are lengths of s1 and s2 respectively.
        Returns true if s1 is substring of s2
	 */
    static int isSubstring(String s1, String s2) 
    { 
        int M = s1.length(); 
        int N = s2.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++)
        { 
            int j;
            /* For current index i, check for pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return i; 
        }
        return -1; 
    } 
      

   // Time complexity: o(n) 
   static public boolean hasSubstring(char[] text, char[] pattern)
    {
        int i=0;
        int j=0;
        while(i < text.length && j < pattern.length)
        {
            if(text[i] == pattern[j])
            {
                i++;
                j++;
            }else
            {
                j=0;
                i ++;
            }
        }
        if(j == pattern.length)
        {
            return true;
        }
        return false;
    }
   
   // using KMP algorithm of pattern matching. o(m+n)
   public boolean KMP(char []text, char []pattern){
       
       int lps[] = computeTemporaryArray(pattern);
       int i=0;
       int j=0;
       while(i < text.length && j < pattern.length){
           if(text[i] == pattern[j]){
               i++;
               j++;
           }else{
               if(j!=0){
                   j = lps[j-1];
               }else{
                   i++;
               }
           }
       }
       if(j == pattern.length){
           return true;
       }
       return false;
   }
   
   /**
    * Compute temporary array to maintain size of suffix which is same as prefix
    * Time/space complexity is O(size of pattern)
    */
   private int[] computeTemporaryArray(char pattern[]){
       int [] lps = new int[pattern.length];
       int index =0;
       for(int i=1; i < pattern.length;){
           if(pattern[i] == pattern[index]){
               lps[i] = index + 1;
               index++;
               i++;
           }else{
               if(index != 0){
                   index = lps[index-1];
               }else{
                   lps[i] =0;
                   i++;
               }
           }
       }
       return lps;
   }
   
}
