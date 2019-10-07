package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 Link :- https://www.geeksforgeeks.org/best-meeting-point-2d-binary-array/

You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in a group. And the group of two or more people wants to
meet and minimize the total travel distance. They can meet anywhere means that there might be a home or not.

The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x – p1.x| + |p2.y – p1.y|.
Find the total distance that needs to be traveled to reach the best meeting point (Total distance traveled is minimum).

Input : grid[][] = {{1, 0, 0, 0, 1},          1 - 0 - 0 - 0 - 1 
                   {0, 0, 0, 0, 0},           0 - 0 - 0 - 0 - 0
                   {0, 0, 1, 0, 0}};          0 - 0 - 1 - 0 - 0
Output : 6, Best meeting point is (0, 2).

Total distance traveled is 2 + 2 + 2 = 6

Input : grid[3][5] = {{1, 0, 1, 0, 1},
                     {0, 1, 0, 0, 0}, 
                     {0, 1, 1, 0, 0}};
Output : 11

 Time complexity O(m*n)
 Space complexity O(m + n)

 */

public class _136_BestMeetingPoint 
{
	
	public static void main(String args[]) 
	{
		_136_BestMeetingPoint bmp = new _136_BestMeetingPoint();
        int[][] grid = {{1, 0, 0, 0, 1}, 
        		        {0, 0, 0, 0, 0},
        		        {0, 0, 1, 0, 0}};
        System.out.print(bmp.minTotalDistance(grid));
    }

	public int minTotalDistance(int[][] grid)
	{
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        List<Integer> vertical = new ArrayList<Integer>();
        List<Integer> horizontal = new ArrayList<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    vertical.add(i);
                    horizontal.add(j);
                }
            }
        }

        Collections.sort(vertical);
        Collections.sort(horizontal);

        int size = vertical.size()/2;
        int x = vertical.get(size);
        int y = horizontal.get(size);
        int distance = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    distance += Math.abs(x - i) + Math.abs(y - j);
                }
            }
        }

        return distance;
    }
}
