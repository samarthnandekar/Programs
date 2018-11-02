package String;

/* Find largest word in dictionary by deleting some characters of given string
Giving a dictionary and a string ‘str’, find the longest string in dictionary which can be formed by deleting some characters of the given ‘str’.

Examples:

Input : dict = {"ale", "apple", "monkey", "plea"}   
        str = "abpcplea"  
Output : apple 

Input  : dict = {"pintu", "geeksfor", "geeksgeeks", 
                                        " forgeek"} 
         str = "geeksforgeeks"
Output : geeksgeeks

Asked In : Google Interview 
 
 */
public class Largest_word_indictionary_bydeleting_some_char {



    public static String checkforsubsequence(String dict[],String input){
        
    	String maxSubString="";
        
        for (String temp:dict) {
            int maxLength=0;
            char[] tempArray=temp.toCharArray();
            char[] inputArray=input.toCharArray();
            for(int i=0, j=0;i<tempArray.length && j<inputArray.length;){
                if(tempArray[i]==inputArray[j]){
                    i++;
                    j++;
                    maxLength++;
                }
                else{
                    j++;
                }
            }
            
            if(maxSubString.length()<maxLength){
                maxSubString=temp;
            }
        }
        return maxSubString;
    }
	
	public static void main (String[] args) {
		String dict[]={"ale", "appple", "monkey", "plea"};
        String input="abpcplea";
        String maxSubtring=checkforsubsequence(dict,input);
        System.out.println("maxSubtring "+maxSubtring);
	
	}
	
}
