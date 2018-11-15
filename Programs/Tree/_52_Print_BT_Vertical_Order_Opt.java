package Tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.TreeMap;


/*
an efficient solution based on hash map is discussed. We need to check the Horizontal Distances from root for all nodes. 
If two nodes have the same Horizontal Distance (HD), then they are on same vertical line. The idea of HD is simple. HD for root is 0,
a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and a left edge is considered as -1 horizontal 
distance. For example, in the above tree, HD for Node 4 is at -2, HD for Node 2 is -1, HD for 5 and 6 is 0 and HD for node 7 is +2.
We can do preorder traversal of the given Binary Tree. While traversing the tree, we can recursively calculate HDs. We initially pass 
the horizontal distance as 0 for root. For left subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. 
For right subtree, we pass the Horizontal Distance as Horizontal Distance of root plus 1. For every HD value, we maintain a list of nodes
in a hasp map. Whenever we see a node in traversal, we go to the hash map entry and add the node to the hash map using HD as a key in map.

*/

//Utility function to store vertical order in map 'm' 
// 'hd' is horizontal distance of current node from root. 
// 'hd' is initially passed as 0 



public class _52_Print_BT_Vertical_Order_Opt {

	Node root;
	
	public void printVertical(Node root){
        Map<Integer,List<Node>> map = new TreeMap<Integer,List<Node>>();
        populateMap(root,map,0);
        printLevel(map);
    }
    
    private void printLevel(Map<Integer,List<Node>> map){
        for(Integer key : map.keySet()){
            List<Node> listNodes = map.get(key);
            for(Node n : listNodes){
                System.out.print(n.key + " ");
            }
            System.out.println();
        }
    }
    
    private void populateMap(Node root, Map<Integer,List<Node>> map,int level){
        if(root == null){
            return;
        }
        List<Node> listNodes = null;
        if(map.containsKey(level)){
            listNodes = map.get(level);
        }else{
            listNodes = new ArrayList<Node>();
            map.put(level, listNodes);
        }
        listNodes.add(root);
        populateMap(root.left,map,level-1);
        populateMap(root.right,map,level+1);
    }
    
    public static void main(String args[]){
    	_52_Print_BT_Vertical_Order_Opt  tree= new _52_Print_BT_Vertical_Order_Opt();
    	
    	tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
        tree.root.right.right.right = new Node(9); 
   
        
        
        tree.printVertical(tree.root);
    }
}
