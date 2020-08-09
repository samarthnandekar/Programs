package DFS;

import java.util.LinkedList;
import java.util.Queue;

import javax.sql.rowset.RowSetWarning;

/* Shortest path in a Binary Maze:- Given a MxN matrix where each element can either be 0 or 1. We need to find the shortest path between a given source
cell to a destination cell. The path can only be created out of a cell if its value is 1.

Expected time complexity is O(MN).  */

public class _1_Find_Minimum_Path_InMaze {
	
	
	static boolean isSafe(int [][]arr,int row, int col) 
	{ 
		int length=arr.length;
	    return (row >= 0) && (row < length) &&  (col >= 0) && (col < length) && arr[row][col]==1;     
	} 
	
	public static void main(String [] args)
	{
		int mat[][] = {{ 1, 1, 1, 1, 1, 1}, 
		               { 1, 0, 1, 0, 1, 1}, 
		               { 1, 0, 1, 0, 1, 1}, 
		               { 1, 0, 1, 1, 1, 0}, 
		               { 1, 0, 1, 0, 1, 1,},
		               { 1, 1, 1, 0, 1, 1,}}; 
		  
		    Point source = new Point(0, 0); 
		    Point dest = new Point(3, 4); 
            int length=mat.length;
		    boolean visited[][] = new boolean[length][length];
		    
		    int rowNum[] = {-1, 0, 0, 1}; 
		    int colNum[] = {0, -1, 1, 0}; 
			  
     	    if(mat[source.x][source.y]==1 && mat[dest.x][dest.y] ==1)
		    {
		    	 int dist = BFS(mat, source, dest,visited,rowNum,colNum);
		    	 System.out.println(dist);
		    }
	}
	
	
	static int BFS(int mat[][], Point src, Point dest, boolean [][]visited, int [] rowNum,int [] colNum) 
	{ 
	    // Mark the source cell as visited 
	    visited[src.x][src.y] = true; 
	    Queue q = new LinkedList<QueueNode>(); 
	    QueueNode s = new QueueNode(src, 0); 
	    q.add(s); // q.push(s);  // Enqueue source cell 
	  
	    // Do a BFS starting from source cell 
	    while (!q.isEmpty()) 
	    { 
	        QueueNode curr = (QueueNode) q.peek(); 
	        Point pt = curr.point; 
	  
	        // If we have reached the destination cell, we are done 
	        if (pt.x == dest.x && pt.y == dest.y) 
	            return curr.dist; 
	  
	        // Otherwise dequeue the front cell in the queue and enqueue its adjacent cells 
	        q.remove(); 
	  
	        for (int i = 0; i < 4; i++) 
	        { 
	            int row = pt.x + rowNum[i]; 
	            int col = pt.y + colNum[i]; 
	              
	            // if adjacent cell is valid, has path and not visited yet, enqueue it. 
	            if (isSafe(mat, row, col) && !visited[row][col]) 
	            { 
	                // mark cell as visited and enqueue it 
	                visited[row][col] = true; 
	                Point p= new Point(row,col);
	                QueueNode Adjcell = new QueueNode(p,curr.dist + 1); 
	                q.add(Adjcell); 
	            } 
	        } 
	    } 
	    //return -1 if destination cannot be reached 
	    return -1; 
	} 
}

class Point
{
   int x;
   int y;
   
   Point(int x, int y)
   {
	   this.x=x;
	   this.y=y;
   }
}

class QueueNode 
{
	Point point;
	int dist;
	
	QueueNode(Point p,int dist)
	{
		point=p;
		this.dist=dist;
	}
}
