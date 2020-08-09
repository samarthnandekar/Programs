package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _28_Unique_Word_Abbreviation {

	public static void main(String[] args) {

		String []dictionary = {"deer", "door", "cake", "card"};
		_28_Unique_Word_Abbreviation obj= new _28_Unique_Word_Abbreviation();
		boolean isPresent=obj.isUnique(dictionary,"dear");
		System.out.println(isPresent);
		
		isPresent=obj.isUnique(dictionary,"cart");
		System.out.println(isPresent);
		
		isPresent=obj.isUnique(dictionary,"cane");
		System.out.println(isPresent);
		
		isPresent=obj.isUnique(dictionary,"make");
		System.out.println(isPresent);
	}
	
	 public boolean isUnique(String[] dictionary,String word) {
	        String abbr = getAbbr(word);
	        Set<String> hashSet= validWordAbbr(dictionary);
	        return !hashSet.contains(abbr);
	    }
	    
	    public Set<String> validWordAbbr(String[] dictionary) {

		   Set<String> hashSet= new HashSet<String>();
	        for (String s : dictionary){
	            String abbr = getAbbr(s);
	            if (hashSet.contains(abbr)){
	                continue;
	            }else{
	            	hashSet.add(abbr);
	            }
	        }
	        return hashSet;
	    }
    
	    public String getAbbr(String s){
	        if (s == null || s.length() < 3){return s;}
	        Integer length = s.length() - 2;
	        return s.substring(0,1) + length.toString() + s.substring(s.length() - 1);
	    }
}
