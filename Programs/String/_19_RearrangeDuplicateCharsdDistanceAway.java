package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

/*
 * 
 Rearrange a string so that all same characters become d distance away
Given a string and a positive integer d. Some characters may be repeated in the given string. Rearrange characters of the given string such 
that the same characters become d distance away from each other. Note that there can be many possible rearrangements, the output should be 
one of the possible rearrangements. If no such arrangement is possible, that should also be reported.

Expected time complexity is O(n) where n is length of input string.

Examples: Input:  "abb", d = 2
		  Output: "bab"

Input:  "aacbbc", d = 3
Output: "abcabc"

Input: "geeksforgeeks", d = 3
Output: egkegkesfesor

Input:  "aaa",  d = 2
Output: Cannot be rearranged


Note:- implement where function should return string, instead of boolean value
 */
public class _19_RearrangeDuplicateCharsdDistanceAway {

	public static void main(String[] args) {
	
		String str = "ABBACCCCDD"; 
        char input[] = str.toCharArray();
        _19_RearrangeDuplicateCharsdDistanceAway rdc  =new _19_RearrangeDuplicateCharsdDistanceAway();
        boolean r =rdc.rearrangeAtleastkDistanceAway(input, 3);
        if(r){
            for(char ch : input){
                System.out.print(ch + " ");
            }
        }else{
            System.out.println("Not possible");
        }
    }

	
	public boolean rearrangeAtleastkDistanceAway(char input[],int d){
        PriorityQueue<CharCount> heap = new PriorityQueue<CharCount>();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i < input.length; i++){
            int count = 1;
            if(map.containsKey(input[i])){
                count = map.get(input[i]);
                count++;
            }
            map.put(input[i], count);
            input[i] = 0;
        }
        for(Character ch : map.keySet()){
            CharCount cc = new CharCount();
            cc.ch = ch;
            cc.count = map.get(ch);
            heap.add(cc);
        }
        
        while(heap.size() > 0){
            CharCount cc = heap.poll();
            int i;
            for(i=0; i < input.length && input[i] != 0; i++);
            if(i == input.length){
                return false;
            }
            while(cc.count > 0 && i < input.length){
                input[i] = cc.ch;
                i = i + d;
                cc.count--;
            }
            if(cc.count > 0){
                return false;
            }
        }
        return true;
    }
	
	
	
	@Test
	public void test1() 
	{
	   String input="abb";
	   int d=2;
	   boolean exp=true;
	   boolean act=rearrangeAtleastkDistanceAway(input.toCharArray(),d);
	   Assert.assertEquals(exp, act);
	}
}

class CharCount implements Comparable<CharCount>{
    char ch;
    int count;

        
    @Override
    public String toString() {
        return "CharCount [ch=" + ch + ", count=" + count + "]";
    }
    @Override
    public int compareTo(CharCount cc) {
        if(this.count >= cc.count){
            return -1;
        }else{
            return 1;
        }
    }
    
}
