package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class _13_BridgeinGraph<T> {

	 private int time;
	    
	    public Set<Edge<T>> getBridge(Graph<T> graph){
	        
	        Set<Edge<T>> result = new HashSet<Edge<T>>();
	        Map<Vertex<T>,Integer> discovery = new HashMap<Vertex<T>,Integer>();
	        Map<Vertex<T>,Integer> low = new HashMap<Vertex<T>,Integer>();
	        Map<Vertex<T>,Vertex<T>> parent = new HashMap<Vertex<T>,Vertex<T>>();
	        Map<Vertex<T>,Boolean> visited = new HashMap<Vertex<T>,Boolean>();
	        
	        for(Vertex<T> vertex : graph.getAllVertex()){
	            if(!visited.containsKey(vertex)){
	                BridgeUtil(vertex,result,discovery,low,parent,visited);
	            }
	        }
	        return result;
	    }

	    private void BridgeUtil(Vertex<T> vertex, Set<Edge<T>> result,Map<Vertex<T>,Integer> discovery,
	            Map<Vertex<T>,Integer> low,Map<Vertex<T>,Vertex<T>> parent,Map<Vertex<T>,Boolean> visited){
	        visited.put(vertex, true);
	        discovery.put(vertex, time);
	        low.put(vertex, time);
	        time++;
	        for(Vertex<T> child : vertex.getAdjacentVertexes()){
	            if(!visited.containsKey(child)){
	                parent.put(child, vertex);
	                BridgeUtil(child,result,discovery,low,parent,visited);
	                
	                if(discovery.get(vertex) < low.get(child) ){
	                    result.add(new Edge<T>(vertex,child));
	                }
	                low.put(vertex, Math.min(discovery.get(vertex), low.get(child)));
	            }else{
	                if(!child.equals(parent.get(vertex))){
	                    low.put(vertex,Math.min(discovery.get(vertex), low.get(child)));
	                }
	            }
	        }
	    }
	    
	    public static void main(String args[]){
	        
	        Graph<Integer> graph = new Graph<Integer>(false);
	        graph.addEdge(2, 1);
	        graph.addEdge(3, 1);
	        graph.addEdge(1, 4);
	        graph.addEdge(4, 5);
	        graph.addEdge(5, 1);
	        _13_BridgeinGraph<Integer> ap = new _13_BridgeinGraph<Integer>();
	        Set<Edge<Integer>> result = ap.getBridge(graph);
	        System.out.print(result);
	    }
}

class BridgeGraph 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
    int time = 0; 
    static final int NIL = -1; 
  
    // Constructor 
    BridgeGraph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
        adj[w].add(v);    //Add v to w's list 
    } 
  
    // A recursive function that finds and prints bridges using DFS traversal 
    // u --> The vertex to be visited next,  visited[] --> keeps tract of visited vertices 
    // disc[] --> Stores discovery times of visited vertices,   parent[] --> Stores parent vertices in DFS tree 
    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) 
    {   
        // Mark the current node as visited 
        visited[u] = true; 
  
        // Initialize discovery time and low value 
        disc[u] = low[u] = ++time; 
  
        // Go through all vertices aadjacent to this 
        LinkedList<Integer> curr =adj[u];
        Iterator i = (Iterator) curr.iterator(); 
        while (i.hasNext()) 
        { 
            int v = (int) i.next();  // v is current adjacent of u  
            // If v is not visited yet, then make it a child  of u in DFS tree and recur for it. 
            // If v is not visited yet, then recur for it 
            if (!visited[v]) 
            { 
                parent[v] = u; 
                bridgeUtil(v, visited, disc, low, parent); 
  
                // Check if the subtree rooted with v has a connection to one of the ancestors of u 
                low[u]  = Math.min(low[u], low[v]); 
  
                // If the lowest vertex reachable from subtree under v is below u in DFS tree, then u-v is a bridge 
                if (low[v] > disc[u]) 
                    System.out.println(u+" "+v); 
            }  
            // Update low value of u for parent function calls. 
            else if (v != parent[u]) 
                low[u]  = Math.min(low[u], disc[v]); 
        } 
    }   
  
    // DFS based function to find all bridges. It uses recursive function bridgeUtil() 
    void bridge() 
    { 
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[V]; 
        int disc[] = new int[V]; 
        int low[] = new int[V]; 
        int parent[] = new int[V]; 
    
        // Call the recursive helper function to find Bridges in DFS tree rooted with vertex 'i' 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                bridgeUtil(i, visited, disc, low, parent); 
    } 
  
    public static void main(String args[]) 
    { 
        // Create graphs given in above diagrams 
        System.out.println("Bridges in first graph "); 
        BridgeGraph g1 = new BridgeGraph(5); 
        g1.addEdge(3, 4); 
        g1.addEdge(2, 1);
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(0, 3); 
        g1.bridge(); 
        System.out.println(); 
  
        System.out.println("Bridges in Second graph"); 
        BridgeGraph g2 = new BridgeGraph(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3); 
        g2.bridge(); 
        System.out.println(); 
  
        System.out.println("Bridges in Third graph "); 
        BridgeGraph g3 = new BridgeGraph(7); 
        g3.addEdge(0, 1); 
        g3.addEdge(1, 2); 
        g3.addEdge(2, 0); 
        g3.addEdge(1, 3); 
        g3.addEdge(1, 4); 
        g3.addEdge(1, 6); 
        g3.addEdge(3, 5); 
        g3.addEdge(4, 5); 
        g3.bridge(); 
    } 
} 
