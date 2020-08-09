package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/tug-of-war/
 Tug of War
Given a set of n integers, divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
 If n is even, then sizes of two subsets must be strictly n/2 and if n is odd, then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.

For example, let given set be {3, 4, 5, -3, 100, 1, 89, 54, 23, 20}, the size of set is 10. Output for this set should be {4, 100, 1, 23, 20} 
and {3, 5, -3, 89, 54}. Both output subsets are of size 5 and sum of elements in both subsets is same (148 and 148).
Let us consider another example where n is odd. Let given set be {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4}. The output subsets should be 
{45, -34, 12, 98, -1} and {23, 0, -99, 4, 189, 4}. The sums of elements in two subsets are 120 and 121 respectively.

The following solution tries every possible subset of half size. If one subset of half size is formed, the remaining elements form the other subset.
 We initialize current set as empty and one by one build it. There are two possibilities for every element, either it is part of current set, or it
 is part of the remaining elements (other subset). We consider both possibilities for every element. When the size of current set becomes n/2,
 we check whether this solutions is better than the best solution available so far. If it is, then we update the best solution.
 */
public class _14_TugofWar {

	 private int minFoundSoFar = 1000000;
	    public int findMind(int arr[]){
	        int total = 0;
	        for(int i=0; i < arr.length; i++){
	            total += arr[i];
	        }
	        List<Integer> result = new ArrayList<>();
	        combinationUtil(arr,arr.length/2,0,0,total,0,result);
	        return minFoundSoFar;
	    }

	    private void combinationUtil(int arr[],int k, int start,int sum, int total,int pos, List<Integer> result){
	        if(pos == k){
	            if(Math.abs(sum - total/2) < minFoundSoFar) {
	                minFoundSoFar = Math.abs(sum - total/2);
	                System.out.println(result);
	            }
	            return;
	        }
	        for(int i=start; i < arr.length; i++){
	            sum += arr[i];
	            result.add(arr[i]);
	            combinationUtil(arr,k,i+1,sum,total,pos+1,result);
	            result.remove(result.size()-1);
	            sum -= arr[i];
	        }
	    }

	    public static void main(String args[]){
	    	_14_TugofWar tow = new _14_TugofWar();
	        int arr[] = {23, 45, 34, 12,11, 98, 99, 4, 189, 1,7,19,105, 201};
	        int min = tow.findMind(arr);
	        System.out.print(min);
	    }
}
