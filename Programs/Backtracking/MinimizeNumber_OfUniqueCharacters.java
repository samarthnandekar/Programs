package Backtracking;

import java.util.HashMap;

/*

Status:-Not working
*************************************************************************************************************************
*************************************************************************************************************************
************************************************************************************************************************
*************************************************************************************************************************

https://www.geeksforgeeks.org/minimize-number-unique-characters-string/

Given two strings A and B. Minimize the number of unique characters in string A by either swapping A[i] with B[i] 
or keeping it unchanged. The number of swaps can be greater than or equal to 0. Note that A[i] can be swapped only
with same index element in B. Print the minimum number of unique characters. Constraints: 0 < length of A ≤ 15.

Examples:
Input : A = ababa
        B = babab
Output : 1
Swapping all b's in string A, with a's in string B results in string A having all characters as a. 

Input : A = abaaa
        B = bbabb
Output : 2
Initially string A has 2 unique characters. Swapping at any index does not change this count.



Approach: The problem can be solved using backtracking. Create a map in which key is A[i] and value is count of corresponding character. 
The size of the map tells the number of distinct characters as only those elements which are present in string A are present as key in map.
At every index position, there are two choices: either swap A[i] with B[i] or keep A[i] unchanged. Start from index 0 and do following for each index:

Keep A[i] unchanged, increment count of A[i] by one in map and call recursively for next index.
Backtrack by decreasing count of A[i] by one, swap A[i] with B[i], increment count of A[i] by one in map and again recursively call for next index.
Keep a variable ans to store overall minimum value of distinct characters. In both the cases mentioned above, when entire string is traversed 
compare current number of distinct characters with overall minimum in ans and update ans accordingly.


 */
public class MinimizeNumber_OfUniqueCharacters {

	public static void main(String[] args) {
		
		String A = "abaaaa"; 
	    String B = "bbabGc"; 
	  
	    System.out.println(minCount(A, B));  
	}
	
	static void minCountUtil(char [] A, char [] B, HashMap<Character, Integer> ele, CusInteger ans, int ind) 
    { 

	// If entire string is traversed, then compare current number of distinct characters in A with overall minimum. 
    if (ind == A.length)
    { 
      ans.val = Math.min(ans.val, (int)ele.size()); 
      return; 
    } 
    
   //swap A[i] with B[i], increase count of corresponding character in map and call recursively for next index. 
    swap(A,ind, B); 
    
    // put in map
    putInMap(ele,A[ind],+1);
    
    minCountUtil(A, B, ele, ans, ind + 1); 
    
    // Backtrack (Undo the changes done)  
    putInMap(ele,A[ind],-1);

    // If count of character is reduced to zero, then that character is not present in A. So remove that character from map. 
    if (ele.get(A[ind]) == 0)  
    	 ele.remove(A[ind]); 

    // Restore A to original form. (Backtracking step) 
     swap(A,ind, B); 

    // Increase count of A[i] in map and call recursively for next index. 
    putInMap(ele,A[ind],+1);
    minCountUtil(A, B, ele, ans, ind + 1); 

    // Restore the changes done (Backtracking step) 
    putInMap(ele,A[ind],-1); 
    if (A[ind] == 0)  
    	ele.remove(A[ind]);     
} 

//Function to find minimum number of distinct characters in string. 
static int minCount(String a, String b) 
{ 
   // Variable to store minimum number of distinct character. Initialize it with length of A as maximum possible value is length of A. 
	CusInteger ans = new CusInteger();
	ans.val=a.length();
    	
   // Map to store count of distinct characters in A. To keep complexity of insert operation constant unordered_map is used. 
  HashMap <Character, Integer> ele= new HashMap<Character, Integer>(); 

   // Call utility function to find minimum number of unique characters. 
   char [] A=a.toCharArray();
   char [] B=b.toCharArray();
   minCountUtil(A, B, ele, ans, 0); 

   return ans.val; 
 } 

 static void putInMap(HashMap<Character, Integer> map, char a, int num)
 {
	 if(map.containsKey(a))
	 {
		 int count=map.get(a);
		 map.put(a, count-num);
	 }
	 else
	 {
		 map.put(a, 1);
	}
 }


 static void swap(char [] A, int index, char [] B)
 {
	A[index]=B[index]; 
 }

}

class CusInteger
{
  int val;
 
}
