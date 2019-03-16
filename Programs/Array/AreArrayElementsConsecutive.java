package Array;

/*
Check if array elements are consecutive
Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.

Examples: 
a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
b) If array is {83, 78, 80, 81, 79, 82}, then the function should return true because the array has consecutive numbers from 78 to 83.
c) If the array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.

Method 1 (Use Sorting)
1) Sort all the elements.
2) Do a linear scan of the sorted array. If the difference between current element and next element is anything other than 1, then return false.
   If all differences are 1, then return true.

Time Complexity: O(nLogn)

*/

public class AreArrayElementsConsecutive
{

	public boolean areConsecutive(int input[]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i < input.length; i++){
            if(input[i] < min){
                min = input[i];
            }
        }
        for(int i=0; i < input.length; i++){
            if(Math.abs(input[i]) - min >= input.length){
                return false;
            }
            if(input[Math.abs(input[i]) - min] < 0){
                return false;
            }
            input[Math.abs(input[i]) - min] = -input[Math.abs(input[i]) - min];
        }
        for(int i=0; i < input.length ; i++){
            input[i] = Math.abs(input[i]);
        }
        return true;
    }
    
    public static void main(String args[]){
        int input[] = {76,78,76,77,73,74};
        AreArrayElementsConsecutive cia = new AreArrayElementsConsecutive();
        System.out.println(cia.areConsecutive(input));
    }
}
