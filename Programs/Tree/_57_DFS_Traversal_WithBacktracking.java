package Tree;

import java.util.List;
import java.util.Map;

/*
 
 
Status:-Not working
*************************************************************************************************************************
*************************************************************************************************************************
************************************************************************************************************************
*************************************************************************************************************************

https://www.geeksforgeeks.org/print-the-dfs-traversal-step-wise-backtracking-also/
	 
Print the DFS traversal step-wise (Backtracking also)
Given a graph, the task is to print the DFS traversal of a graph which includes the every step including the backtracking.

                          (0)
                       /      \
                    (1)        (2)--- (4)
                   /  \        /   \ 
                 (5)  (6)     (3)--(9)
                      /  \    \    /
                     7--- 8     10
1st step:- 0 -> 1
2nd step:- 1 -> 5
3rd step:- 5 -> 1 (backtracking step)
4th step:- 1 -> 6...
and so on till all the nodes are visited.

Dfs step-wise(including backtracking) is:
0 1 5 1 6 7 8 7 6 1 0 2 4 2 9 3 10
*/

public class _57_DFS_Traversal_WithBacktracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Function to call the DFS function which prints the DFS-travesal stepwise 
	void dfs(int node) 
	{ 
	    // Create a array of visited node 
	    boolean visited[]= new boolean[node]; 
	  
	    // Vector to track last visited road 
	    List<List<Integer, Integer>> road_used; 
	  
	    // call the function 
	    dfsUtil(0, node, visited, road_used, -1, 0); 
	} 
	
	// Function to print the complete DFS-traversal 
	void dfsUtil(int u, int node, boolean visited[], List<Map<Integer, Integer>> road_used, int parent, int it) 
	{ 
	    int unvisited_nodes = 0; 
	  
	    // Check if all th node is visited or not and count unvisited nodes 
	    for (int i = 0; i < node; i++) 
	        if (visited[i]) 
	        	unvisited_nodes++; 
	  
	    // If all the node is visited return; 
	    if (unvisited_nodes == node) 
	        return; 
	  
	    // Mark not visited node as visited 
	    visited[u] = true; 
	  
	    // Track the current edge 
	  //  road_used.push_back({ parent, u }); 
	  
	    // Print the node 
	    System.out.println(" "+ u +" "); 
	  
	    // Check for not visited node and proceed with it. 
	    for (int x : adj[u]) { 
	  
	        // call the DFs function if not visited 
	        if (!visited[x]) 
	            dfsUtil(x, node, visited, road_used, u, it + 1); 
	    } 
	  
	    // Backtrack through the last visited nodes 
	    for (auto y : road_used) 
	        if (y.second == u) 
	            dfsUtil(y.first, node, visited, road_used, u, it + 1); 
	} 

}
