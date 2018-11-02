package Tree;

import java.util.LinkedList;
import java.util.*;

public class Connect_Nodes_atsame_level {

	NodeWR root;
	
	static void connectRight(NodeWR root) 
    { 
        Queue<NodeWR> q = new LinkedList<NodeWR>();  
        q.add(root); 
       
        // null marker to represent end of current level 
        q.add(null);  
       
        // Do Level order of tree using NULL markers 
        while (!q.isEmpty()) { 
        	NodeWR p = q.peek(); 
            q.remove(); 
            if (p != null) { 
       
                // next element in queue represents next  
                // node at current Level  
                p.nextRight = q.peek(); 
       
                // push left and right children of current 
                // node 
                if (p.left != null) 
                    q.add(p.left);  
                if (p.right != null) 
                    q.add(p.right); 
            }  
              
            // if queue is not empty, push NULL to mark  
            // nodes at this level are visited 
            else if (!q.isEmpty())  
                q.add(null);  
        } 
    } 
	
    public static void main(String args[]) 
	{     
        /* Constructed binary tree is 
                  10 
                /   \ 
              8      2 
            /         \ 
          3            90 
        */
        NodeWR root = new NodeWR(10); 
        root.left = new NodeWR(8); 
        root.right = new NodeWR(2); 
        root.left.left = new NodeWR(3); 
        root.right.right = new NodeWR(90); 
       
        // Populates nextRight pointer in all nodes 
        connectRight(root);
        System.out.println("Done");
        
	}
	
	
}
