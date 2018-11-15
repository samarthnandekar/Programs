package DFS;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
  
 Given a square chess board of N x N size, the position of Knight and position of a target is given. We need to find out minimum steps a Knight 
 will take to reach the target position.

This problem can be seen as shortest path in unweighted graph. Therefore we use BFS to solve this problem. We try all 8 possible positions where a Knight 
can reach from its position. If reachable position is not already visited and is inside the board, we push this state into queue with distance 1 more than
its parent state. Finally we return distance of target position, when it gets pop out from queue.
 
Below code implements BFS for searching through cells, where each cell contains its coordinate and distance from starting node. In worst case,
 below code visits all cells of board, making worst-case time complexity as O(N^2)

 */

public class _4_MinSteps_ToReach_Target_Knight {

	// Utility method returns true if (x, y) lies inside Board 
	static boolean isInside(int x, int y, int N) 
	{ 
	    if (x >= 1 && x <= N && y >= 1 && y <= N) 
	        return true; 
	    return false; 
	}
	
	// Method returns minimum step to reach target position 
	static int minStepToReachTarget(int knightPos[], int targetPos[], int N) 
	{ 
	    // x and y direction, where a knight can move 
	    int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2}; 
	    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1}; 
	  
	    // queue for storing states of knight in board 
	    Queue<Cell> q = new LinkedList<Cell>();
	  
	    // push starting position of knight with 0 distance 
	    q.add(new Cell(knightPos[0], knightPos[1], 0)); 
	  
	    Cell t; 
	    int x, y; 
	    boolean visit[][] = new boolean[N+1][N+1];
	    int result=0;
	    
	    // make all cell unvisited 
	    for (int i = 1; i <= N; i++) 
	        for (int j = 1; j <= N; j++) 
	            visit[i][j] = false; 
	  
	    // visit starting state 
	    visit[knightPos[0]][knightPos[1]] = true; 
	  
	    // loop untill we have one element in queue 
	    while (!q.isEmpty()) 
	    { 
	        t = q.poll(); 
	  
	        // if current cell is equal to target cell, 
	        // return its distance 
	        if (t.x == targetPos[0] && t.y == targetPos[1]) 
	        	{
	        	result= t.dis;
	        	break;
	        	}
	  
	        // loop for all reachable states 
	        for (int i = 0; i < 8; i++) 
	        { 
	            x = t.x + dx[i]; 
	            y = t.y + dy[i]; 
	  
	            // If reachable state is not yet visited and 
	            // inside board, push that state into queue 
	            if (isInside(x, y, N) && !visit[x][y]) { 
	                visit[x][y] = true; 
	                q.add( new Cell(x, y, t.dis + 1)); 
	            } 
	        } 
	    } 
	    
	    return result;
	} 
	
	public static void main(String [] args)
	{
		int N=30;
		int knightPos[] = {0, 0}; 
	    int targetPos[] = {2, 4}; 
	    System.out.println(minStepToReachTarget(knightPos, targetPos, N)); 
	 
	}
	
}

class Cell 
{ 
    int x, y; 
    int dis; 
    Cell() {} 
    
    Cell(int x, int y, int dis)
    	{
    	this.x=x;
    	this.y=y;
    	this.dis=dis;
    	}
};