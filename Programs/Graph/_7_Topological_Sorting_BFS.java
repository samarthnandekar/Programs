package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
 
 Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, 
 vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

 For example, a topological sorting of the following graph is “5 4 2 3 1 0?. There can be more than one topological sorting for a graph.
  For example, another topological sorting of the following graph is “4 5 2 0 3 1″. The first vertex in topological sorting is always a
 vertex with in-degree as 0 (a vertex with no in-coming edges).
 
 */
public class _7_Topological_Sorting_BFS {

	int V;// No. of vertices 
    
    //An Array of List which contains references to the Adjacency List of each vertex 
    List <Integer> adj[]; 
    public _7_Topological_Sorting_BFS(int V)// Constructor 
    { 
        this.V = V; 
        adj = new ArrayList[V]; 
        for(int i = 0; i < V; i++) 
            adj[i]=new ArrayList<Integer>(); 
    } 
      
    // function to add an edge to graph 
    public void addEdge(int u,int v) 
    { 
        adj[u].add(v); 
    } 
    // prints a Topological Sort of the complete graph     
    public void topologicalSort() 
    { 
        // Create a array to store indegrees of all vertices. Initialize all indegrees as 0. 
        int indegree[] = new int[V]; 
          
        // Traverse adjacency lists to fill indegrees of  vertices. This step takes O(V+E) time         
        for(int i = 0; i < V; i++) 
        { 
            ArrayList<Integer> temp =  (ArrayList<Integer>) adj[i]; 
            for(int node : temp) 
            { 
                indegree[node]++; 
            } 
        } 
          
        // Create a queue and enqueue all vertices with indegree 0 
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 0;i < V; i++) 
        { 
            if(indegree[i]==0) 
                q.add(i); 
        } 
          
        // Initialize count of visited vertices 
        int cnt = 0; 
          
        // Create a vector to store result (A topological ordering of the vertices) 
        List <Integer> topOrder=new ArrayList<Integer>(); 
        while(!q.isEmpty()) 
        { 
            // Extract front of queue (or perform dequeue) and add it to topological order 
            int u=q.poll(); 
            topOrder.add(u); 
              
            // Iterate through all its neighbouring nodes of dequeued node u and decrease their in-degree by 1 
            for(int node : adj[u]) 
            { 
                // If in-degree becomes zero, add it to queue 
                if(--indegree[node] == 0) 
                    q.add(node); 
            } 
            cnt++; 
        } 
          
        // Check if there was a cycle         
        if(cnt != V) 
        { 
            System.out.println("There exists a cycle in the graph"); 
            return ; 
        } 
          
        // Print topological order             
        for(int i : topOrder) 
        { 
            System.out.print(i+" "); 
        } 
    } 
	
		public static void main(String args[]) 
	    { 
	        // Create a graph given in the above diagram 
			_7_Topological_Sorting_BFS g=new _7_Topological_Sorting_BFS(6); 
	        g.addEdge(5, 2); 
	        g.addEdge(5, 0); 
	        g.addEdge(4, 0); 
	        g.addEdge(4, 1); 
	        g.addEdge(2, 3); 
	        g.addEdge(3, 1); 
	        System.out.println("Following is a Topological Sort"); 
	        g.topologicalSort(); 
	  
	    } 

}
