package Tree;

import java.util.LinkedList;
import java.util.Queue;

// check for constant space as well
/*
 Link :- https://www.geeksforgeeks.org/connect-nodes-at-same-level/
 Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.

Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL

*/
public class _37_Connect_Nodes_At_SamaLevel {

	// Sets nextRight of all nodes of a tree 
    static void connect(Node root) 
    { 
        Queue<Node> q = new LinkedList<Node>();  
        q.add(root); 
       
        // null marker to represent end of current level 
        q.add(null);  
       
        // Do Level order of tree using NULL markers 
        while (!q.isEmpty()) { 
            Node p = q.peek(); 
            q.remove(); 
            if (p != null) { 
       
                // next element in queue represents next  
                // node at current Level  
                p.right = q.peek(); 
       
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
       
    /* Driver program to test above functions*/
    public static void main(String args[]) 
    { 
       
        /* Constructed binary tree is 
                  10 
                /   \ 
              8      2 
            /         \ 
          3            90 
        */
        Node root = new Node(10); 
        root.left = new Node(8); 
        root.right = new Node(2); 
        root.left.left = new Node(3); 
        root.right.right = new Node(90); 
       
        // Populates nextRight pointer in all nodes 
        connect(root); 
       
        // Let us check the values of nextRight pointers 
        System.out.println("Following are populated nextRight pointers in \n" + 
      "the tree (-1 is printed if there is no nextRight)"); 
        System.out.println("nextRight of "+ root.key +" is "+ 
        ((root.right != null) ? root.right.key : -1)); 
        System.out.println("nextRight of "+ root.left.key+" is "+ 
        ((root.left.right != null) ? root.left.right.key : -1)); 
        System.out.println("nextRight of "+ root.right.key+" is "+ 
        ((root.right.right != null) ? root.right.right.key : -1)); 
        System.out.println("nextRight of "+  root.left.left.key+" is "+ 
        ((root.left.left.right != null) ? root.left.left.right.key : -1)); 
        System.out.println("nextRight of "+  root.right.right.key+" is "+ 
        ((root.right.right.right != null) ? root.right.right.right.key : -1)); 
    } 
    
    
    //https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/ConnectNodesAtSameLevel.java
    
    
}
