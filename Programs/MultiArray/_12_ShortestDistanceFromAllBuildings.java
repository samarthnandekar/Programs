package MultiArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right.
You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2). The point (1,2) is an ideal empty land to build a house, 
as the total travel distance of 3+3+1=7 is minimal. So return 7.

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

 */
public class _12_ShortestDistanceFromAllBuildings 
{
	public int shortestDistance(int[][] grid) {
        int totalBuild = 0;
        int[][] reach = new int[grid.length][grid[0].length];
        int[][] distance = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(i, j, 0));
                    totalBuild++;
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    while (!queue.isEmpty()) {
                        List<Point> neighbors = getNeighbors(queue.poll(), grid, visited, grid.length, grid[0].length);
                        for (Point neigh : neighbors) {
                            visited[neigh.x][neigh.y] = true;
                            reach[neigh.x][neigh.y]++;
                            distance[neigh.x][neigh.y] += neigh.dist;
                            queue.offer(neigh);
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < reach.length; i++) {
            for (int j = 0; j < reach[0].length; j++) {
                if (reach[i][j] == totalBuild) {
                    min = Math.min(min, distance[i][j]);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private List<Point> getNeighbors(Point p, int[][] grid, boolean[][] visited, int n, int m) {
        List<Point> resultList = new ArrayList<>();
        if(p.x > 0 && grid[p.x -1][p.y] == 0 && !visited[p.x - 1][p.y])
            resultList.add(new Point(p.x -1, p.y, p.dist + 1));
        if(p.x < n - 1 && grid[p.x + 1][p.y] == 0 && !visited[p.x + 1][p.y])
            resultList.add(new Point(p.x + 1, p.y, p.dist + 1));
        if(p.y > 0 && grid[p.x][p.y - 1] == 0 && !visited[p.x][p.y - 1])
            resultList.add(new Point(p.x, p.y - 1, p.dist + 1));
        if(p.y < m - 1 && grid[p.x][p.y + 1] == 0 && !visited[p.x][p.y + 1])
            resultList.add(new Point(p.x, p.y + 1, p.dist + 1));

        return resultList;
    }

    public static void main(String args[]) {
        int[][] grid = {{1,1,1,1,1,0},
        		        {0,0,0,0,0,1},
        		        {0,1,1,0,0,1},
        		        {1,0,0,1,0,1},
        		        {1,0,1,0,0,1},
        		        {1,0,0,0,0,1},
        		        {0,1,1,1,1,0}};
        
        int[][] grid1 = {{1,0,2,0,1},
                        {0,0,0,0,0},
                        {0,0,1,0,0}};
        
        int[][] grid2 = {{1,1},{0,1}};
        
        _12_ShortestDistanceFromAllBuildings shortestDistanceFromAllBuildings = new _12_ShortestDistanceFromAllBuildings();
        System.out.println(shortestDistanceFromAllBuildings.shortestDistance(grid1));
    }
	
	/* Can found the solution below as well.
	 * https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleHard/317.html
	 */
	
}
