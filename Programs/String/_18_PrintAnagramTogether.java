package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 
 Given a sequence of words, print all anagrams together
Given an array of words, print all anagrams together. For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output
 may be “cat tac act dog god”.


 */
public class _18_PrintAnagramTogether {

	public static void main(String[] args) {
        String str[] = {"cat","dog","tac","god","act"};
        _18_PrintAnagramTogether pat = new _18_PrintAnagramTogether();
        pat.print(str);


	}
	
	//
    public void print(String[] string){
        Map<String,List<Integer>> invertedIndex = new HashMap<String,List<Integer>>();
        int index = 0;
        for(String str : string){
            char [] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String newString = new String(charArray);
            if(invertedIndex.containsKey(newString)){
                List<Integer> pos = invertedIndex.get(newString);
                pos.add(index);
            }else{
                List<Integer> pos = new ArrayList<Integer>();
                pos.add(index);
                invertedIndex.put(newString, pos);
            }
            index++;
        }
        for(List<Integer> result  : invertedIndex.values()){
            for(Integer i : result){
                System.out.print(string[i]+"   ");
            }
        }
    }


}
