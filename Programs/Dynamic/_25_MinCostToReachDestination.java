package Dynamic;

/*
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * 
 
 Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 Each cell of the matrix represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that path
 (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell
 (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?
 
 1	2	3
 4	8	2
 1	5	3
The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).




 */
public class _25_MinCostToReachDestination {

public int minCost(int [][]cost,int m,int n){
        
        int temp[][] = new int[m+1][n+1];
        int sum = 0;
        for(int i=0; i <= n; i++){
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        sum = 0;
        for(int i=0; i <= m; i++){
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }
        
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                temp[i][j] = cost[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
            }
        }
        return temp[m][n];
    }

public int minCostRec(int cost[][], int m, int n){
    return minCostRec(cost, m, n, 0 , 0);
}

public int minCostRec(int cost[][], int m, int n, int x, int y){
    if(x > m || y > n){
        return Integer.MAX_VALUE;
    }
    if(x == m && y == n){
        return cost[m][n];
    }
    
    int t1 = minCostRec(cost, m , n, x+1, y);
    int t2 = minCostRec(cost, m , n, x+1, y+1);
    int t3 = minCostRec(cost, m , n, x, y+1);
    
    return cost[x][y] + min(t1,t2,t3);
}

private int min(int a,int b, int c){
    int l = Math.min(a, b);
    return Math.min(l, c);
}



public static void main(String args[]){
	_25_MinCostToReachDestination mcp = new _25_MinCostToReachDestination();
    int cost[][] = {{1,2,3},
    		        {4,8,2},
    		        {1,5,3},
    		        {6,2,9}};
    int result = mcp.minCost(cost, 3, 2);
    int result1 = mcp.minCostRec(cost, 3, 2);
    System.out.println(result);
    System.out.println(result1);
    
    int cost2[][] = {{1,3,1},
    				 {1,5,1},
    				 {4,2,1}};
    
    result = mcp.minCost2(cost2, 2, 2);
    System.out.println(result);
    }


/*
 https://leetcode.com/problems/minimum-path-sum/
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.

Example:Input:
    [[1,3,1],
     [1,5,1],
     [4,2,1]]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
// Only for down or right at any point in time.
public int minCost2(int [][]cost,int m,int n){
    
    int temp[][] = new int[m+1][n+1];
    int sum = 0;
    for(int i=0; i <= n; i++){
        temp[0][i] = sum + cost[0][i];
        sum = temp[0][i];
    }
    sum = 0;
    for(int i=0; i <= m; i++){
        temp[i][0] = sum + cost[i][0];
        sum = temp[i][0];
    }
    
    for(int i=1; i <= m; i++){
        for(int j=1; j <= n; j++){
            temp[i][j] = cost[i][j] + Math.min(temp[i-1][j],temp[i][j-1]);  //** down or right at any point in time.
        }
    }
    return temp[m][n];
}
}
