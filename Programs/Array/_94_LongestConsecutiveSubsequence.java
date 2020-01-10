package Array;

import java.util.HashMap;
import java.util.Map;

/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
   Your algorithm should run in O(n) complexity.
   
Example:-  Input: [100, 4, 200, 1, 3, 2]
           Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/
public class _94_LongestConsecutiveSubsequence {
	
	public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 1;
        for (int i : nums) {
            if (map.containsKey(i)) {
                continue;
            }
            int left = map.containsKey(i - 1) ? map.get(i - 1) : 0;
            int right = map.containsKey(i + 1) ? map.get(i + 1) : 0;

            int sum = left + right + 1;
            map.put(i, sum);
            result = Math.max(sum, result);
            map.put(i - left, sum);
            map.put(i + right, sum);
        }
        return result;
    }
    public static void main(String args[]) {
        _94_LongestConsecutiveSubsequence lcs = new _94_LongestConsecutiveSubsequence();
        int[] input = {100, 4, 200, 0, 3, 2};
        System.out.println(lcs.longestConsecutive(input));
    }
    
    
    /* Given an array, find longest increasing subsequence in nlogn time complexity
    *
    * References
    * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    * http://www.geeksforgeeks.org/construction-of-longest-monotonically-increasing-subsequence-n-log-n/
    */
    
    /**
     * Returns index in T for ceiling of s
     */
    private int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }
    
    public int longestIncreasingSubSequenceOlogNMethod(int input[]){
        int T[] = new int[input.length];
        int R[] = new int[input.length];
        for(int i=0; i < R.length ; i++) {
            R[i] = -1;
        }
        T[0] = 0;
        int len = 0;
        for(int i=1; i < input.length; i++){
            if(input[T[0]] > input[i]){ //if input[i] is less than 0th value of T then replace it there.
                T[0] = i;
            }else if(input[T[len]] < input[i]){ //if input[i] is greater than last value of T then append it in T
                len++;
                T[len] = i;
                R[T[len]] = T[len-1];
            }else{ //do a binary search to find ceiling of input[i] and put it there.
                int index = ceilIndex(input, T, len,input[i]);
                T[index] = i;
                R[T[index]] = T[index-1];
            }
        }

        //this prints increasing subsequence in reverse order.
        System.out.print("Longest increasing subsequence ");
        int index = T[len];
        while(index != -1) {
            System.out.print(input[index] + " ");
            index = R[index];
        }

        System.out.println();
        return len+1;
    }
}
