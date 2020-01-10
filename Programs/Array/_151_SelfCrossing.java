package Array;

/*
 https://leetcode.com/problems/self-crossing/
 335. Self Crossing
 
 You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north,
  then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, 
  after each move your direction changes counter-clockwise.

Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.

Example 1:
┌───┐
│   │
└───┼──>
    │
Input: [2,1,1,2]   Output: true

Example 2:
┌──────┐
│      │
│
│
└────────────>
Input: [1,2,3,4]       Output: false 

Example 3:
┌───┐
│   │
└───┼>
Input: [1,1,1,1]  Output: true 
*/
public class _151_SelfCrossing {

	public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) {
            return false;
        }
        int v1 = -x[0];
        int v2 = -x[1];

        int i = 2;
        while (i < x.length) {
            if (i % 2 == 0) {
                if (i % 4 == 0) {
                    v1 -= x[i];
                } else {
                    v1 += x[i];
                }
            } else {
                if ((i + 1) % 4 == 0) {
                    v2 += x[i];
                } else {
                    v2 -= x[i];
                }
            }
            if (i % 2 != 0) {
                if ((v1 >= 0 && v2 <= 0) || (v1 <= 0 && v2 >= 0)) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static void main(String args[]) {
    	_151_SelfCrossing sc = new _151_SelfCrossing();
        int input[] = {3, 3, 4, 2, 2};
        System.out.print(sc.isSelfCrossing(input));
    }

}
