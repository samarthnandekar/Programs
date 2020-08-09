package Sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;



/* 
 https://www.geeksforgeeks.org/topological-sorting/
  
Topological Sorting
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, 
vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There can be more than one topological sorting
for a graph. For example, another topological sorting of the following graph is “4 5 2 3 1 0”. The first vertex in topological 
sorting is always a vertex with in-degree as 0 (a vertex with no incoming edges).

         5            4
         | \         /|
         |  \       / | 
         |   \     /  | 
         |    \   /   | 
         |      ↓     |
         |      0     |
         |            |
         ↓            ↓    
         2 ---->3----->1

Topological Sorting vs Depth First Traversal (DFS):
In DFS, we print a vertex and then recursively call DFS for its adjacent vertices. In topological sorting, we need to print
a vertex before its adjacent vertices. For example, in the given graph, the vertex ‘5’ should be printed before vertex ‘0’,
but unlike DFS, the vertex ‘4’ should also be printed before vertex ‘0’. So Topological sorting is different from DFS. 
For example, a DFS of the shown graph is “5 2 3 1 0 4”, but it is not a topological sorting


Algorithm to find Topological Sorting:
We recommend to first see implementation of DFS here. We can modify DFS to find Topological Sorting of a graph.
In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices. 
In topological sorting, we use a temporary stack. We don’t print the vertex immediately, we first recursively 
call topological sorting for all its adjacent vertices, then push it to a stack. Finally, print contents of stack.
Note that a vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on)
are already in stack.


*/


public class TopologicalSort {
	
	    private int V;   // No. of vertices 
	    private LinkedList<Integer> adj[]; // Adjacency List 
	  
	    //Constructor 
	    TopologicalSort(int v) 
	    { 
	        V = v; 
	        adj = new LinkedList[v]; 
	        for (int i=0; i<v; ++i) 
	            adj[i] = new LinkedList(); 
	    } 
	  
	    // Function to add an edge into the graph 
	    void addEdge(int v,int w) 
	    {
	    	adj[v].add(w); 	
	    } 
	  
	    // A recursive function used by topologicalSort 
	    void topologicalSortUtil(int v, boolean visited[], Stack stack) 
	    { 
	        // Mark the current node as visited. 
	        visited[v] = true; 
	        Integer i; 
	  
	        // Recur for all the vertices adjacent to this vertex 
	        Iterator<Integer> it = adj[v].iterator(); 
	        while (it.hasNext()) 
	        { 
	            i = it.next(); 
	            if (!visited[i]) 
	                topologicalSortUtil(i, visited, stack); 
	        } 
	  
	        // Push current vertex to stack which stores result 
	        stack.push(new Integer(v)); 
	    } 
	  
	    // The function to do Topological Sort. It uses recursive topologicalSortUtil() 
	    void topologicalSort() 
	    { 
	        Stack stack = new Stack(); 
	  
	        // Mark all the vertices as not visited 
	        boolean visited[] = new boolean[V];
	  
	        // Call the recursive helper function to store Topological Sort starting from all vertices one by one 
	        for (int i = 5; i >=0; i--) 
	            if (visited[i] == false) 
	                topologicalSortUtil(i, visited, stack); 
	  
	        // Print contents of stack 
	        while (stack.empty()==false) 
	            System.out.print(stack.pop() + " "); 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        // Create a graph given in the above diagram 
	    	TopologicalSort g = new TopologicalSort(6); 
	        g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0); 
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); 
	  
	        System.out.println("Following is a Topological sort of the given graph"); 
	        g.topologicalSort(); 
	    } 
}
