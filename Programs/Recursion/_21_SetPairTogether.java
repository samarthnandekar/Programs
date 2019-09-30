package Recursion;

import java.util.HashMap;
import java.util.Map;

/*
  http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/

Minimum number of swaps required for arranging pairs adjacent to each other
There are n-pairs and therefore 2n people. everyone has one unique number ranging from 1 to 2n. All these 2n persons are arranged
in random fashion in an Array of size 2n. We are also given who is partner of whom. Find the minimum number of swaps required to 
arrange these pairs such that all pairs become adjacent to each other.

Example:-

Input:
n = 3  
pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
arr[] = {3, 5, 6, 4, 1, 2}

Output: 2
We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1

Time complexity is O(2^n)

 */
public class _21_SetPairTogether {

	public static void main(String[] args) {
		_21_SetPairTogether spt= new _21_SetPairTogether();
		int input[] = {3, 5, 6, 4, 1, 2};
        Map<Integer, Integer> pair = new HashMap<>();
        pair.put(1, 3);
        pair.put(3, 1);
        pair.put(2, 6);
        pair.put(6, 2);
        pair.put(4, 5);
        pair.put(5 ,4);
        System.out.println(spt.findMinimumSwaps(input, pair));
    }
	
	public int findMinimumSwaps(int input[], Map<Integer, Integer> pair)
	{
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            index.put(input[i], i);
        }
        int count= findMinimumSwapsUtil(input, pair, index, 0);
        return count;
    }

    public int findMinimumSwapsUtil(int input[], Map<Integer, Integer> pair, Map<Integer, Integer> index, int current) {
        if (current == input.length) {
            return 0;
        }

        int v1 = input[current];
        int v2 = input[current + 1];
        int pv2 = pair.get(v1);

        if(pv2 == v2) {
            return findMinimumSwapsUtil(input, pair, index, current + 2);
        } else {
            int idx1 = index.get(v1);
            int idx2 = index.get(v2);

            int idx3 = index.get(pair.get(v1));
            int idx4 = index.get(pair.get(v2));

            swap(index, input, idx2, idx3);
            int val1 = findMinimumSwapsUtil(input, pair, index, current + 2);
            swap(index, input, idx2, idx3);

            swap(index, input, idx1, idx4);
            int val2 = findMinimumSwapsUtil(input, pair, index, current + 2);
            swap(index, input, idx1, idx4);

            return 1 + Math.min(val1, val2);
        }
    }

    private void swap(Map<Integer, Integer> index, int input[], int i, int j) {
//        index.compute(input[i], (k, v) -> j); is it required?
//        index.compute(input[j], (k, v) -> i);

        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }

}
