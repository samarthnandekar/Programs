package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 320. Generalized Abbreviation
Write a function to generate the generalized abbreviations of a word.

Example:Given word ="word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

Solution:- for each character, choose either abbreviate or not.

1.when the position == word length, update the list
2. else, continuously backtracking
   if abbreviate, update current string, cnt = 0, pos+1
   if not abbreviate, current string not update, cnt+1, pos+1
  
 */
public class _33_Generalized_Abbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str="word";
        _33_Generalized_Abbreviation obj= new _33_Generalized_Abbreviation();
        List<String> ans=obj.generateAbbreviations(str);
        ans.forEach(name -> System.out.println(name));
        
	}

	public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        helper(res, "", word, 0, 0);
        return res;
    }

    private void helper(List<String> res, String curr, String word, int pos, int cnt){
        if(pos == word.length()){
            if(cnt > 0){
                curr += cnt;
            }
            res.add(curr);
        }else{

            helper(res, curr, word, pos+1, cnt+1);
            helper(res, curr+(cnt > 0 ? cnt : "")+word.charAt(pos),word, pos+1, 0);
        }
    }
}
