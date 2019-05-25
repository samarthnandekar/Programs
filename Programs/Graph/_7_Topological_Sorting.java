package Graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/* Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, 
   vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Application of topological sort- build system 


Given a directed acyclic graph, do a topological sort on this graph.
 
Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 Pop from stack to get sorted order.
 
 Space and time complexity is O(n).
 
 
                 
 */



public class _7_Topological_Sorting<T> 
{
	
	private int V;   // No. of vertices 
	 private LinkedList<Integer> adj[]; //Adjacency Lists 

	 // Constructor 
	 _7_Topological_Sorting(int v) 
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
  
        // Recur for all the vertices adjacent to this 
        // vertex 
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
  
    // The function to do Topological Sort. It uses 
    // recursive topologicalSortUtil() 
    void topologicalSort() 
    { 
        Stack stack = new Stack(); 
  
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        // Call the recursive helper function to store 
        // Topological Sort starting from all vertices 
        // one by one 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                topologicalSortUtil(i, visited, stack); 
  
        // Print contents of stack 
        while (stack.empty()==false) 
            System.out.print(stack.pop() + " "); 
    } 
    
    public static void main(String args[]){
    	_7_Topological_Sorting g = new _7_Topological_Sorting(6);

        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        
        g.topologicalSort();
        
   
    }
	
}
/*
Output:
Following is a Topological Sort of the given graph
5 4 2 3 1 0
Time Complexity: The above algorithm is simply DFS with an extra stack. So time complexity is same as DFS which is O(V+E).

Applications:
Topological Sorting is mainly used for scheduling jobs from the given dependencies among jobs. In computer science, applications of
this type arise in instruction scheduling, ordering of formula cell evaluation when recomputing formula values in spreadsheets, logic
synthesis, determining the order of compilation tasks to perform in makefiles, data serialization, and resolving symbol dependencies
in linkers 


 */
