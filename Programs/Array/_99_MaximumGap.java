package Array;
/*
 Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
Return 0 if the array contains less than 2 elements.

Example 1:
Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
 Time complexity O(n)
 Space complexity O(n)
 */
public class _99_MaximumGap {

	class Bucket {
        int low ;
        int high;
        boolean isSet = false;
        void update(int val) {
            if (!isSet) {
                low = val;
                high = val;
                isSet = true;
            } else {
                low = Math.min(low, val);
                high = Math.max(high, val);
            }
        }
    }

    public int maximumGap(int[] input) {
        if (input == null || input.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            min = Math.min(min, input[i]);
            max = Math.max(max, input[i]);
        }

        int gap = (int) Math.ceil((double) (max - min) / (input.length - 1));

        Bucket[] buckets = new Bucket[input.length - 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] == max || input[i] == min) {
                continue;
            }
            buckets[(input[i] - min) / gap].update(input[i]);
        }

        int prev = min;
        int maxGap = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (!buckets[i].isSet) {
                continue;
            }
            maxGap = Math.max(maxGap, buckets[i].low - prev);
            prev = buckets[i].high;
        }

        return Math.max(maxGap, max - prev);
    }

    public static void main(String args[]) {
        int[] input = {4, 3, 13, 2, 9, 7};
        _99_MaximumGap mg = new _99_MaximumGap();
        System.out.println(mg.maximumGap(input));
    }
}
