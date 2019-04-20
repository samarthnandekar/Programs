package Array;

/*
 There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:
Input: [1,0,2]     Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input: [1,2,2]   Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
             
 */
public class _93_Candy {
	public int candy(int[] ratings) {
        int pointOfChange = 0;
        int totalCandies = 1;
        int currentCandy = 1;
        boolean isIndependent = true;
        int maxHeight = 0;
        int diff = 0;
        for (int i = 1; i < ratings.length; i++) {
            diff = 0;
            if (ratings[i] > ratings[i-1]) {
                currentCandy += 1;
            } else if (ratings[i] == ratings[i-1]) {
                isIndependent = true;
                pointOfChange = i;
                currentCandy = 1;
            } else {
                if (currentCandy == 1) {
                    if (!isIndependent) {
                        if (i - pointOfChange == maxHeight - 1) {
                            pointOfChange--;
                        }
                    }
                }
                else {
                    maxHeight = currentCandy;
                    currentCandy = 1;
                    isIndependent = false;
                    pointOfChange = i;
                }
                diff = i - pointOfChange;
            }
            totalCandies += (diff + currentCandy);
        }
        return totalCandies;
    }
}
