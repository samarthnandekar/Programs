package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 Given a digit string, return all possible letter combinations that the number could represent. (Check out your cellphone to see the mappings)
 Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Java Solution 1 - DFS
This problem can be solves by a typical DFS algorithm. DFS problems are very similar and can be solved by using a simple recursion.

https://www.programcreek.com/2014/04/leetcode-letter-combinations-of-a-phone-number-java/

 */
public class LetterCombinations {

	public static void main(String[] args) {
		
		List<String> list=letterCombinations_DFS("23");
		list.forEach(item->System.out.println(item));
		
		List<String> list1=letterCombinations_BFS("23");
		list1.forEach(item->System.out.println(item));
		
	}
	
	public static List<String> letterCombinations_DFS(String digits) {
	    HashMap<Character, char[]> dict = new HashMap<Character, char[]>();
	    dict.put('2',new char[]{'a','b','c'});
	    dict.put('3',new char[]{'d','e','f'});
	    dict.put('4',new char[]{'g','h','i'});
	    dict.put('5',new char[]{'j','k','l'});
	    dict.put('6',new char[]{'m','n','o'});
	    dict.put('7',new char[]{'p','q','r','s'});
	    dict.put('8',new char[]{'t','u','v'});
	    dict.put('9',new char[]{'w','x','y','z'});
	 
	    List<String> result = new ArrayList<String>();
	    if(digits==null||digits.length()==0){
	        return result;
	    }
	 
	    char[] arr = new char[digits.length()];
	    helper(digits, 0, dict, result, arr);
	 
	    return result;
	}
	 
	static private void helper(String digits, int index, HashMap<Character, char[]> dict, 
	                        List<String> result, char[] arr){
	    if(index==digits.length()){
	        result.add(new String(arr));
	        return;
	    }
	 
	    char number = digits.charAt(index);
	    char[] candidates = dict.get(number);
	    for(int i=0; i<candidates.length; i++){
	        arr[index]=candidates[i];
	        helper(digits, index+1, dict, result, arr);
	    }
	}
	
	
	public static List<String> letterCombinations_BFS(String digits) {
	    HashMap<Character, String> map = new HashMap<>();
	    map.put('2', "abc");
	    map.put('3', "def");
	    map.put('4', "ghi");
	    map.put('5', "jkl");
	    map.put('6', "mno");
	    map.put('7', "pqrs");
	    map.put('8', "tuv");
	    map.put('9', "wxyz");
	 
	    List<String> ansList = new ArrayList<>();
	    if (digits == null || digits.length() == 0) {
	        return ansList;
	    }
	 
	    ansList.add("");
	 
	    for (int i = 0; i < digits.length(); i++) {
	        ArrayList<String> temp = new ArrayList<>();
	        String option = map.get(digits.charAt(i));
	 
	        for (int j = 0; j < ansList.size(); j++) {
	            for (int p = 0; p < option.length(); p++) {
	                temp.add(new StringBuilder(ansList.get(j)).append(option.charAt(p)).toString());
	            }
	        }
	 
	        ansList.clear();
	        ansList.addAll(temp);
	    }
	 
	    return ansList;
	}
}
