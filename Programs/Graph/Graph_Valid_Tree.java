package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check 
 whether these edges make up a valid tree.

For example:
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0]and 
thus will not appear together in edges.

BFS. When a node is polled from queue, iterate through its neighbors. If any of them is visited but not the node's parent, there is a cycle.
If there are no edges, then the graph is a tree only if it has only one node.
Build graph. Use a map of int -> list of int. Iterate through the edge list and add nodes into map.
BFS. Poll a node from queue. Iterate through its neighbors. If queue contains a neighbor, that means there is a cycle in the graph. Return false.
Otherwise, if the neighbor is not visited, offer it to queue.

 */
public class Graph_Valid_Tree {

	public static void main(String[] args) {
		int [][] graph= {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int [][] graph1= {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		
		System.out.println(validTree_1(graph.length,graph));
		System.out.println(validTree_2(graph.length,graph));
		//System.out.println(validTree_3(graph.length,graph));

		
	}

	/* Solution 1 (BFS):
     Time complexity:- Building graph takes O(E). BFS takes O(V + VE) = O(VE) because queue.contains() is not constant time. So the overall time
                       complexity is O(VE).   */
	
	
	  static  public boolean validTree_1(int n, int[][] edges) {
	        if (edges.length == 0) {
	            return n == 1;
	        }
	        
	        Map<Integer, List<Integer>> graph = new HashMap<>();
	        for (int[] edge : edges) {
	            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
	            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
	            neighbors1.add(edge[1]);
	            neighbors2.add(edge[0]);
	            graph.put(edge[0], neighbors1);
	            graph.put(edge[1], neighbors2);
	        }
	        
	        Queue<Integer> queue = new LinkedList<>();
	        Set<Integer> visited = new HashSet<>();
	        queue.offer(edges[0][0]);
	        visited.add(edges[0][0]);
	        int nodes = 0;
	        
	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            nodes++;
	            
	            for (int neighbor : graph.get(node)) {
	                if (queue.contains(neighbor)) {
	                    return false;
	                }
	                if (!visited.contains(neighbor)) {
	                    queue.offer(neighbor);
	                    visited.add(neighbor);
	                }
	            }
	        }
	        return nodes == n;
	    }
	
	
    	/*
	     Solution 2 (DFS):
	     Time complexity: O(V + E).   */
	  static public boolean validTree_2(int n, int[][] edges) {
	        if (edges.length == 0) {
	            return n == 1;
	        }
	        if (n != edges.length + 1) {
	            return false;
	        }
	        
	        Map<Integer, Set<Integer>> graph = new HashMap<>();
	        for (int i = 0; i < n; i++) {
	            graph.put(i, new HashSet<>());
	        }
	        for (int[] edge : edges) {
	            graph.get(edge[0]).add(edge[1]);
	            graph.get(edge[1]).add(edge[0]);
	        }
	        
	        Set<Integer> visited = new HashSet<>();
	        if (hasCycle(0, -1, graph, visited)) {
	            return false;
	        }
	        return visited.size() == n;
	    }
	    
	   static private boolean hasCycle(int node, int parent, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
	        visited.add(node);
	        for (int neighbor : graph.get(node)) {
	            if (neighbor != parent && visited.contains(neighbor)) {
	                return true;
	            }
	            if (!visited.contains(neighbor) && hasCycle(neighbor, node, graph, visited)) {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    /*
	     Solution 3 (Union find):
         Time complexity: O(E).
	     */
	    
	    static private int[] parent;
	    static private int[] size;
	    
	    static public boolean validTree_3(int n, int[][] edges) {
	        parent = new int[n];
	        for (int i = 0; i < n; i++) {
	            parent[i] = i;
	        }
	        size = new int[n];
	        Arrays.fill(size, 1);
	        
	        for (int[] edge : edges) {
	            if (!union(edge[0], edge[1])) {
	                return false;
	            }
	        }
	        return edges.length == n - 1;
	    }
	    
	    static private boolean union(int v1, int v2) {
	        int p1 = find(v1);
	        int p2 = find(v2);
	        
	        if (p1 == p2) {
	            return false;
	        }
	        if (size[p1] < size[p2]) {
	            parent[p1] = p2;
	            size[p2]++;
	        } else {
	            parent[p2] = p1;
	            size[p1]++;
	        }
	        return true;
	    }
	    
	    static private int find(int v) {
	        while (v != parent[v]) {
	            parent[v] = find(parent[parent[v]]);
	            v = parent[v];
	        }
	        return v;
	    }
	
}
