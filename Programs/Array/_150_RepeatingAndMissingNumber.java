package Array;

/*
 https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 
 Find the repeating and the missing 
 
Given an unsorted array of size n. Array elements are in the range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs 
twice in the array. Find these two numbers.

Examples:
Input: arr[] = {3, 1, 3}
Output: Missing = 2, Repeating = 3
Explanation: In the array,  2 is missing and 3 occurs twice 

Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: Missing = 5, Repeating = 1

 */
public class _150_RepeatingAndMissingNumber {

	class Pair{
        int repeating;
        int missing;
        public String toString(){
            return repeating + " " + missing;
        }
    }
    
    public Pair findNumbers(int input[]){
        Pair p = new Pair();
        for(int i=0; i < input.length; i++){
            if(input[Math.abs(input[i])-1] < 0){
                p.repeating = Math.abs(input[i]);
            }else{
                input[Math.abs(input[i])-1] = -input[Math.abs(input[i])-1];
            }
        }
    
        for(int i=0; i < input.length; i++){
            if(input[i] < 0){
                input[i] = -input[i];
            }else{
                p.missing = i + 1;
            }
        }
        return p;
    }
    
    public static void main(String args[]){
    	_150_RepeatingAndMissingNumber rmn = new _150_RepeatingAndMissingNumber();
        int input[] = {3,1,2,4,6,8,2,7};
        System.out.println(rmn.findNumbers(input));
    }

}
