package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;

/*
https://www.geeksforgeeks.org/detect-cycle-in-a-graph/

Detect Cycle in a Directed Graph
Given a directed graph, check whether the graph contains a cycle or not. Your function should return true if the given graph contains at least one cycle,
else return false. For example, the following graph contains three cycles 0->2->0, 0->1->2->0 and 3->3, so your function must return true.

*/
public class _16_CycleInDirectedGraph {

	public boolean hasCycle(Graph<Integer> graph) {
        Set<Vertex<Integer>> whiteSet = new HashSet<>();
        Set<Vertex<Integer>> graySet = new HashSet<>();
        Set<Vertex<Integer>> blackSet = new HashSet<>();

        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            whiteSet.add(vertex);
        }

        while (whiteSet.size() > 0) {
            Vertex<Integer> current = whiteSet.iterator().next();
            if(dfs(current, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Vertex<Integer> current, Set<Vertex<Integer>> whiteSet,Set<Vertex<Integer>> graySet, Set<Vertex<Integer>> blackSet ) {
        //move current to gray set from white set and then explore it.
        moveVertex(current, whiteSet, graySet);
        for(Vertex<Integer> neighbor : current.getAdjacentVertexes()) {
            //if in black set means already explored so continue.
            if (blackSet.contains(neighbor)) {
                continue;
            }
            //if in gray set then cycle found.
            if (graySet.contains(neighbor)) {
                return true;
            }
            if(dfs(neighbor, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        //move vertex from gray set to black set when done exploring.
        moveVertex(current, graySet, blackSet);
        return false;
    }

    private void moveVertex(Vertex<Integer> vertex, Set<Vertex<Integer>> sourceSet,Set<Vertex<Integer>> destinationSet) {
        sourceSet.remove(vertex);
        destinationSet.add(vertex);
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        _16_CycleInDirectedGraph cdg = new _16_CycleInDirectedGraph();
        System.out.println(cdg.hasCycle(graph));
    }
}

class CycleInDirGraph { 
    
    private final int V; 
    private final List<List<Integer>> adj; 
  
    public CycleInDirGraph(int V)  
    { 
        this.V = V; 
        adj = new ArrayList<>(V); 
          
        for (int i = 0; i < V; i++) 
            adj.add(new LinkedList<>()); 
    } 
      
    // This function is a variation of DFSUtil() in  
    private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack)  
    { 
          
        // Mark the current node as visited and part of recursion stack 
        if (recStack[i]) 
            return true; 
  
        if (visited[i]) 
            return false; 
              
        visited[i] = true; 
  
        recStack[i] = true; 
        List<Integer> children = adj.get(i); 
          
        for (Integer c: children) 
            if (isCyclicUtil(c, visited, recStack)) 
                return true; 
                  
        recStack[i] = false;   
        return false; 
    } 
  
    private void addEdge(int source, int dest) { 
        adj.get(source).add(dest); 
    } 
  
    // Returns true if the graph contains a cycle, else false. 
    // This function is a variation of DFS() in  
    private boolean isCyclic()  
    { 
          
        // Mark all the vertices as not visited and not part of recursion stack 
        boolean[] visited = new boolean[V]; 
        boolean[] recStack = new boolean[V]; 
                    
        // Call the recursive helper function to detect cycle in different DFS trees 
        for (int i = 0; i < V; i++) 
            if (isCyclicUtil(i, visited, recStack)) 
                return true; 
  
        return false; 
    } 
  
    public static void main(String[] args) 
    { 
    	CycleInDirGraph graph = new CycleInDirGraph(4); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 3); 
          
        if(graph.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contain cycle"); 
    } 
} 