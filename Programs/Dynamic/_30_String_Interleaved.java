package Dynamic;

/*

Find if a string is interleaved of two other strings

We have discussed a simple solution of this problem here. The simple solution doesn’t work if strings A and B have some common characters. 
For example A = “XXY”, string B = “XXZ” and string C = “XXZXXXY”. To handle all cases, two possibilities need to be considered.

a) If first character of C matches with first character of A, we move one character ahead in A and C and recursively check.
b) If first character of C matches with first character of B, we move one character ahead in B and C and recursively check.

If any of the above two cases is true, we return true, else false. Following is simple recursive implementation of this approach 
http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 */
public class _30_String_Interleaved {

	 public static void main(String []args){ 
         
	        String A = "xxy"; //"AB";  
	        String B = "xxzt";   //"CD";  
	        String C = "xxxzxyt";// "ACBG";  
	       
	        System.out.println("");
	        if (isInterleaved(A.toCharArray(), B.toCharArray(), C.toCharArray()) == true)  
	            System.out.printf("%s is interleaved of %s and %s", C, A, B);  
	        else
	            System.out.printf("%s is not interleaved of %s and %s", C, A, B); 
	        
	        
	    }
	 
	 static public boolean isInterleaved(char str1[], char str2[], char str3[]){
	        boolean T[][] = new boolean[str1.length +1][str2.length +1];
	        
	        if(str1.length + str2.length != str3.length){
	            return false;
	        }
	        
	        for(int i=0; i < T.length; i++){
	            for(int j=0; j < T[i].length; j++){
	                int l = i + j -1;
	                if(i == 0 && j == 0){
	                    T[i][j] = true;
	                }
	                else if(i == 0){
	                    if(str3[l] == str2[j-1]){
	                        T[i][j] = T[i][j-1];
	                    }
	                }
	                else if(j == 0){
	                    if(str1[i-1] == str3[l]){
	                        T[i][j] = T[i-1][j];
	                    }
	                }
	                else{
	                    T[i][j] = (str1[i-1] == str3[l] ? T[i-1][j] : false) || (str2[j-1] == str3[l] ? T[i][j-1] : false);
	                }
	            }
	        }
	        return T[str1.length][str2.length];
	    }
}
