package Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/custom-tree-problem/
 
 Custom Tree Problem
You are given a set of links, e.g.

a ---> b
b ---> c
b ---> d
a ---> e 
Print the tree that would form when each pair of these links that has the same character as start and end point is joined together. You have to maintain fidelity w.r.t. the height of nodes, i.e. nodes at height n from root should be printed at same row or column. For set of links given above, tree printed should be –

-->a
   |-->b
   |   |-->c
   |   |-->d
   |-->e
Note that these links need not form a single tree; they could form, ahem, a forest. Consider the following links

a ---> b
a ---> g
b ---> c
c ---> d
d ---> e
c ---> f
z ---> y
y ---> x
x ---> w
The output would be following forest.

-->a
   |-->b
   |   |-->c
   |   |   |-->d
   |   |   |   |-->e
   |   |   |-->f
   |-->g

-->z
   |-->y
   |   |-->x
   |   |   |-->w

 
 
 */

public class _18_PrintArrayInCustomizedFormat {

    private TreeNode root; 
    
    public _18_PrintArrayInCustomizedFormat(TreeNode root) 
    { 
    	this.root = root;  
    }   
    
    _18_PrintArrayInCustomizedFormat()
    {
    	
    }
    
	public static void main(String args[]){
        char str[][] = {{'b','d'},
        		        {'a','c'},
        		        {'d','a'},
        		        {'c','f'},
        		        {'d','f'}};
        
        _18_PrintArrayInCustomizedFormat pac = new _18_PrintArrayInCustomizedFormat();
       
        String [] links1 = {"b d", 
        		            "a c",
        		            "d a",
        		            "c e",
        		            "d e"};

        pac.buildFromLinks(links1);
        printForest(links1);        

    }
   
    /* Returns an array of trees from links input. Links are assumed to be Strings of the form "<s> <e>" where <s> and <e> are starting 
       and ending points for the link. The returned array is of size 26 and has non-null values at indexes corresponding to roots of trees 
       in output */
    public _18_PrintArrayInCustomizedFormat[] buildFromLinks(String [] links) { 
            
        // Create two arrays for nodes and forest 
        TreeNode[] nodes = new TreeNode[26];   
        _18_PrintArrayInCustomizedFormat[] forest = new _18_PrintArrayInCustomizedFormat[26];           
    
        // Process each link  
        for (String link : links) { 
                
            // Find the two ends of current link 
            String[] ends = link.split(" "); 
            int start = (int) (ends[0].charAt(0) - 'a'); // Start node 
            int end   = (int) (ends[1].charAt(0) - 'a'); // End node              
                          
            // If start of link not seen before, add it two both arrays 
            if (nodes[start] == null)  
            {                 
                nodes[start] = new TreeNode((char) (start + 'a'));    
                  
                // Note that it may be removed later when this character is last character of a link. For example, let we first see 
                // a--->b, then c--->a.  We first add 'a' to array of trees and when we see link c--->a, we remove it from trees array. 
                forest[start] = new _18_PrintArrayInCustomizedFormat(nodes[start]);                                             
            }  
               
            // If end of link is not seen before, add it to the nodes array 
            if (nodes[end] == null)                              
                nodes[end] = new TreeNode((char) (end + 'a'));                                  
              
            // If end of link is seen before, remove it from forest if it exists there. 
            else forest[end] = null;  
   
            // Establish Parent-Child Relationship between Start and End 
            nodes[start].addChild(nodes[end], end); 
        }         
        return forest; 
    } 
    
    public static void printForest(String[] links) 
    { 
    	_18_PrintArrayInCustomizedFormat t = new _18_PrintArrayInCustomizedFormat(new TreeNode('\0')); 
        for (_18_PrintArrayInCustomizedFormat t1 : t.buildFromLinks(links)) { 
           if (t1 != null)   
           {   
              t1.root.printTreeIdented(""); 
              System.out.println(""); 
           }   
        } 
    }
}


// Class to represent a tree node 
class TreeNode {     
    TreeNode []children; 
    char c; 
      
    // Adds a child 'n' to this node 
    public void addChild(TreeNode n, int index)
    {
    	this.children[index] = n;
    }   
      
    // Constructor 
    public TreeNode(char c) 
    {
    	this.c = c; 
    	this.children = new TreeNode[26];
    } 
      
    // Recursive method to print indented tree rooted with this node. 
    public void printTreeIdented(String indent) {         
            System.out.println(indent + "-->" + c); 
            for (TreeNode child : children) { 
              if (child != null)   
                child.printTreeIdented(indent + "   |"); 
            }         
    }     
} 