package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class _1_Graph<T> {

	 private int V;   // No. of vertices 
	 private LinkedList<Integer> adj[]; //Adjacency Lists 

	 // Constructor 
	_1_Graph(int v) 
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
	 
	  
	 
	// Driver method to 
	 public static void main(String args[]) 
	 { 
		 _1_Graph g = new _1_Graph(4); 

	     g.addEdge(0, 1); 
	     g.addEdge(0, 2); 
	     g.addEdge(1, 2); 
	     g.addEdge(2, 0); 
	     g.addEdge(2, 3); 
	     g.addEdge(3, 3); 

	     System.out.println("Following is Breadth First Traversal "+ 
	                        "(starting from vertex 2)"); 

	 } 
}
