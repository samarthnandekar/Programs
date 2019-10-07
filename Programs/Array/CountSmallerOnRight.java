package Array;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerOnRight {

	static class NumberIndex {
        int val;
        int index;
        NumberIndex(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<Integer>();
        }
        NumberIndex[] input = new NumberIndex[nums.length];
        for (int i = 0; i < nums.length; i++) {
            input[i] = new NumberIndex(nums[i], i);
        }

        int result[] = new int[nums.length];

        mergeUtil(input, result, 0, input.length - 1);

        List<Integer> r = new ArrayList<Integer>();
        for (int s : result) {
            r.add(s);
        }
        return r;
    }

    private void mergeUtil(NumberIndex[] nums, int[] result, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high)/2;
        mergeUtil(nums, result, low, mid);
        mergeUtil(nums, result, mid + 1, high);

        int i = low;
        int j = mid + 1;
        NumberIndex[] t = new NumberIndex[high - low + 1];
        int k = 0;
        int tempResult[] = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (nums[i].val <= nums[j].val) {
                tempResult[nums[i].index - low] = j - mid - 1;
                t[k++] = nums[i++];
            } else {
                tempResult[nums[i].index - low] = j - mid;
                t[k++] = nums[j++];
            }
        }
        int i1= i;
        while (i1 <= mid) {
            tempResult[nums[i1].index - low] = j - mid - 1;
            t[k++] = nums[i1++];
        }

        while (j <= high) {
            t[k++] = nums[j++];
        }
        
        k = 0;
        for (i = low; i <= high; i++) {
            nums[i] = t[k];
            result[i] += tempResult[k++];
        }
    }

    public static void main(String args[]) {
        CountSmallerOnRight csr = new CountSmallerOnRight();
        int nums[] = {5, 2, 6, 1, 11, 3};
        List<Integer> result = csr.countSmaller(nums);
        for(Integer an:result)
        {
        	System.out.print(an+ " ");
        }
    }
}
