package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 https://segmentfault.com/a/1190000016587068  *****
 
 https://blog.wenxiaoli.me/2018/12/17/305-Number-of-Islands-II/
 
 Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is all 0 
 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means
 that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.
 */

public class _6_Number_of_Islands_II {

	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        
        int[] parents = new int[m*n];
        //fill parents[] with -1 as parents[i] would be in [0, m*n-1];
        Arrays.fill(parents, -1);
        //directions used for calculating positions of 4 neighbors
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        //count varies with each operation (iterating positions)
        int count = 0;
        
        //iterate each operation (adding island on certain position)
        for (int[] position: positions) {
            //2D converted to 1D --> point = n*x+y, save to island
            int island = n*position[0]+position[1];
            //the parent is the island itself
            parents[island] = island;
            //after added the new island, increase count
            count++;
            for (int[] direction: directions) {
                //calculate each neighbor --> 2D to 1D, save to neighbor
                int x = position[0]+direction[0];
                int y = position[1]+direction[1];
                int neighbor = n*x+y;
                //continue if neighbor position invalid or neighbor ancestor remains -1 (no island)
                if (x < 0 || y < 0 || x >= m || y >= n || parents[neighbor] == -1) continue;
                
                //FIND the neighbor ancestor (the existing island)
                int neighborParent = findParent(neighbor, parents);
                //when neighbor's island is a different island, do UNION, and reduce count
                if (neighborParent != island) {
                    parents[island] = neighborParent;
                    island = neighborParent;
                    count--;
                }
            }
            //operation ended, add count of current operation into result list
            res.add(count);
        }
        return res;
    }
    
    private static int findParent(int island, int[] parents) {
        //find the ancestor by calling findParent() recursively
        if (parents[island] != island) 
        	island = findParent(parents[island], parents);
        return island;
    }
	
	public static void main(String args[]) 
	{ 
	        int m = 4; 
           int[][] a = {{1,1},{0,1},{3,3},{3,4}};
	        int n = 5; 
	        System.out.println(numIslands2(m,n,a)); 
	}
	
	// Second 
	//Optimization: path compression + union by rank
	public List<Integer> numberIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;
        //use size[] array to store union size for ranking
        int[] parents = new int[m*n];
        int[] size = new int[m*n];
        Arrays.fill(parents, -1);
        int count = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] pos: positions) {
            int island = pos[0]*n+pos[1];
            parents[island] = island;
            size[island]++;
            count++;
            for (int[] dir: dirs) {
                int x = pos[0]+dir[0];
                int y = pos[1]+dir[1];
                int nb = n*x+y;
                if (x < 0 || x >= m || y < 0 || y >= n || parents[nb] == -1) continue;
                
                int nbParent = find(parents, nb);
                int parent = find(parents, island);
                if (nbParent != parent) {
                    //union-by-rank strategy: smaller union unites to the larger union
                    if (size[parent] >= size[nbParent]) {
                        size[parent] += size[nbParent];
                        parents[nbParent] = parent;
                    } else {
                        size[nbParent] += size[parent];
                        parents[parent] = nbParent;
                    }
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
    private int find(int[] parents, int child) {
        if (parents[child] != child) {
            //path compression
            parents[child] = find(parents, parents[child]);
        } 
        return parents[child];
    }
}
