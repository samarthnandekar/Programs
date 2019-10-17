package Dynamic;
/*
174. Dungeon Game
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid.
Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) 
or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

https://leetcode.com/problems/dungeon-game/
 -2  -3    3
 -5  -10   1
 10  30   -5

Note:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class _39_Dungeon_Game {

	public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int[][] health = new int[dungeon.length][dungeon[0].length];

        int m = dungeon.length - 1;
        int n = dungeon[0].length - 1;

        health[m][n] = Math.max(1 - dungeon[m][n] , 1);
        
         //init last row
        for (int i = m - 1; i >= 0; i--) {
            health[i][n] = Math.max(health[i + 1][n] - dungeon[i][n], 1);
        }
         //init last column
        for (int i = n - 1; i >= 0; i--) {
            health[m][i] = Math.max(health[m][i+1] - dungeon[m][i], 1);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
            	int down=Math.max(health[i + 1][j] - dungeon[i][j], 1);
            	int right=Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(down,right);
            }
        }
        return health[0][0];
    }

    public static void main(String args[]) {
    	_39_Dungeon_Game dg = new _39_Dungeon_Game();
        int[][] dungeon = {{-2, -3, 3},
        		           {-5, -10, 1},
        		           {10, 30, -30}};
        int[][] dungeon1 = {{-2, -3, 3},
		                   {-5, -10, 1},
		                   {10, 30, -5}};
        System.out.println(dg.calculateMinimumHP(dungeon1));
       
    }
}
