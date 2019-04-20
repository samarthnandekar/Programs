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
}
