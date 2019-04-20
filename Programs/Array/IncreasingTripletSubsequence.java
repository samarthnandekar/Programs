package Array;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int T[] = new int[3];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < len; j++) {
                if (T[j] >= nums[i]) {
                    T[j] = nums[i];
                    found = true;
                    break;
                }
            }
            if (!found) {
                T[len++] = nums[i];
            }
            if (len == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        IncreasingTripletSubsequence tripletSubsequence = new IncreasingTripletSubsequence();
        int input[] = {9, 10, 8, 6, 7,5,6,2,4};
        System.out.print(tripletSubsequence.increasingTriplet(input));
    }
}