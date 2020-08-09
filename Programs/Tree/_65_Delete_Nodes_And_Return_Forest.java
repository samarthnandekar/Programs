package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

Given the root of a binary tree, each node in the tree has a distinct value.
After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
Return the roots of the trees in the remaining forest.  You may return the result in any order.
   
   				     1
   				 /	    \
   				2	     3
   			  /	 \      /  \
   		     4	  5	   6    7	

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

 */


public class _65_Delete_Nodes_And_Return_Forest {

	static List<Node> lst = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) {
		Node root= createTree();
		int [] arr= {2,3};		
		List<Node> list =delNodes1(root,arr);
		 for(Node node:list) {
			 System.out.println(node.key);
		 }
	}

	public static List<Node> delNodes1(Node root, int[] to_delete) {
        for(int i : to_delete){
            set.add(i);
        }
        root = delete(root, true);   
        return lst;
    }
	
    static private Node delete(Node node, boolean isRoot) {
        if(node == null) return null;
        
        boolean delete = set.contains(node.key);
        if(isRoot && !delete) lst.add(node);
        
        node.left = delete(node.left, delete);
        node.right = delete(node.right, delete);

        return delete ? null : node;
    }
    
	public List<Node> delNodes(Node root, int[] to_delete) {
		Set <Integer> set = new HashSet<Integer>();
		for(int i : to_delete){
            set.add(i);
        }
		
		List<Node> reqList= new ArrayList<Node>();	
		return null;
	}
	
	
	public void deleteGivenNotesReturnRemaining(Node root,Set<Integer> set,List<Node> list) {
		
		if (root!=null) 
		{
			int rootval=root.key;
			if(set.contains(rootval)) {
			
				
				
		  }
			else if(rootval>set.stream().findFirst().get())
			{
				
			}
			else {
				
			}
				
		}
	}
	
	static Node createTree() {
		
		Node root= new Node(1);
		root.left= new Node(2);
		root.right= new Node(3);
		
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		
		root.right.left= new Node(6);
		root.right.right= new Node(7);
		
		return root;		
	}
}
