package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	private static void printAnagrams(String arr[]) 
    { 
        HashMap<Integer, List<String> > map = new HashMap<>(); 
        // loop over all words 
        for (int i = 0; i < arr.length; i++) { 
  
            // convert to char array, sort and then re-convert to string 
            String word = arr[i]; 
            char[] letters = word.toCharArray(); 
            Arrays.sort(letters); 
            String newWord = new String(letters); 
             
            // calculate hashcode of string after sorting 
            int n = newWord.hashCode(); 
            if (map.containsKey(n)) { 
  
                // Here, we already have a word for the hashcode 
                List<String> words = map.get(n); 
                words.add(word); 
                map.put(n, words); 
            } 
            else { 
                // This is the first time we are adding a word for a specific hashcode 
                List<String> words = new ArrayList<>(); 
                words.add(word); 
                map.put(n, words); 
            } 
        } 
        // print all the values where size is > 1 
        // If you want to print non-anagrams, just print the values having size = 1 
        for (Integer i : map.keySet()) { 
            List<String> values = map.get(i); 
            if (values.size() > 1) { 
                System.out.print(values); 
            } 
        } 
    } 
	
	/*
	 Can create HashMap<String, List<String> > map = new HashMap<>(); 
	  sort string and check.. present in map or not.. no need to get hashcode.. 
	 
	 */
	
	static public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    result.addAll(map.values());
	    return result;
	}
	/*
	 Time Complexity:- If the average length of verbs is m and array length is n, then the time is O(n*m).
	 */
  
    public static void main(String[] args) 
    {  
        String arr[] = { "cat", "dog", "tac", "god", "act" }; 
        printAnagrams(arr); 
        groupAnagrams(arr);
    } 
}
