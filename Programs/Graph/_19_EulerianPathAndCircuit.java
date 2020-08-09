package Graph;

import java.util.Iterator;
import java.util.LinkedList;

/*
 https://www.geeksforgeeks.org/eulerian-path-and-circuit/
 
 Eulerian path and circuit for undirected graph
 Eulerian Path is a path in graph that visits every edge exactly once. Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex.
 
*** How to find whether a given graph is Eulerian or not? *** 
The problem is same as following question. “Is it possible to draw a given graph without lifting pencil from the paper and without tracing any of 
the edges more than once”.

A graph is called Eulerian if it has an Eulerian Cycle and called Semi-Eulerian if it has an Eulerian Path. The problem seems similar to Hamiltonian 
Path which is NP complete problem for a general graph. Fortunately, we can find whether a given graph has a Eulerian Path or not in polynomial time.
In fact, we can find it in O(V+E) time.

Following are some interesting properties of undirected graphs with an Eulerian path and cycle. We can use these properties to find whether a graph 
is Eulerian or not.

Eulerian Cycle
An undirected graph has Eulerian cycle if following two conditions are true.
….a) All vertices with non-zero degree are connected. We don’t care about vertices with zero degree because they don’t belong to Eulerian Cycle or Path
     (we only consider all edges).
….b) All vertices have even degree.

Eulerian Path
An undirected graph has Eulerian Path if following two conditions are true.
….a) Same as condition (a) for Eulerian Cycle
….b) If two vertices have odd degree and all other vertices have even degree. Note that only one vertex with odd degree is not possible in an undirected graph
     (sum of all degrees is always even in an undirected graph)

Note that a graph with no edges is considered Eulerian because there are no edges to traverse.

How does this work?
In Eulerian path, each time we visit a vertex v, we walk through two unvisited edges with one end point as v. Therefore, all middle vertices in Eulerian Path 
must have even degree. For Eulerian Cycle, any vertex can be middle vertex, therefore all vertices must have even degree.

*/
public class _19_EulerianPathAndCircuit {

	private int V;   // No. of vertices 
	  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    _19_EulerianPathAndCircuit(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);// Add w to v's list. 
        adj[w].add(v); //The graph is undirected 
    } 
  
    // A function used by DFS 
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited 
        visited[v] = true; 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // Method to check if all non-zero degree vertices are connected. It mainly does DFS traversal starting from 
    boolean isConnected() 
    { 
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[V]; 
        int i; 
        for (i = 0; i < V; i++) 
            visited[i] = false; 
  
        // Find a vertex with non-zero degree 
        for (i = 0; i < V; i++) 
            if (adj[i].size() != 0) 
                break; 
  
        // If there are no edges in the graph, return true 
        if (i == V) 
            return true; 
  
        // Start DFS traversal from a vertex with non-zero degree 
        DFSUtil(i, visited); 
  
        // Check if all non-zero degree vertices are visited 
        for (i = 0; i < V; i++) 
           if (visited[i] == false && adj[i].size() > 0) 
                return false; 
  
        return true; 
    } 
  
    /* The function returns one of the following values 
       0 --> If grpah is not Eulerian 
       1 --> If graph has an Euler path (Semi-Eulerian) 
       2 --> If graph has an Euler Circuit (Eulerian)  */
    int isEulerian() 
    { 
        // Check if all non-zero degree vertices are connected 
        if (isConnected() == false) 
            return 0; 
  
        // Count vertices with odd degree 
        int odd = 0; 
        for (int i = 0; i < V; i++) 
            if (adj[i].size()%2!=0) 
                odd++; 
  
        // If count is more than 2, then graph is not Eulerian 
        if (odd > 2) 
            return 0; 
  
        // If odd count is 2, then semi-eulerian. If odd count is 0, then eulerian 
        // Note that odd count can never be 1 for undirected graph 
        return (odd==2)? 1 : 2; 
    } 
  
    void test() 
    { 
        int res = isEulerian(); 
        if (res == 0) 
            System.out.println("graph is not Eulerian"); 
        else if (res == 1) 
            System.out.println("graph has a Euler path"); 
        else
           System.out.println("graph has a Euler cycle"); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Let us create and test graphs shown in above figures 
    	_19_EulerianPathAndCircuit g1 = new _19_EulerianPathAndCircuit(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.test(); 
  
        _19_EulerianPathAndCircuit g2 = new _19_EulerianPathAndCircuit(5); 
        g2.addEdge(1, 0); 
        g2.addEdge(0, 2); 
        g2.addEdge(2, 1); 
        g2.addEdge(0, 3); 
        g2.addEdge(3, 4); 
        g2.addEdge(4, 0); 
        g2.test(); 
  
        _19_EulerianPathAndCircuit g3 = new _19_EulerianPathAndCircuit(5); 
        g3.addEdge(1, 0); 
        g3.addEdge(0, 2); 
        g3.addEdge(2, 1); 
        g3.addEdge(0, 3); 
        g3.addEdge(3, 4); 
        g3.addEdge(1, 3); 
        g3.test(); 
  
        // Let us create a graph with 3 vertices 
        // connected in the form of cycle 
        _19_EulerianPathAndCircuit g4 = new _19_EulerianPathAndCircuit(3); 
        g4.addEdge(0, 1); 
        g4.addEdge(1, 2); 
        g4.addEdge(2, 0); 
        g4.test(); 
  
        // Let us create a graph with all veritces with zero degree 
        _19_EulerianPathAndCircuit g5 = new _19_EulerianPathAndCircuit(3); 
        g5.test(); 
    } 
}
