package Tree;


/*
  link :-https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

 */
public class _30_Lowest_CommonAncestor_InBinaryTree {

	Node root;
	
	public Node lca(Node root, Node n1, Node n2){
        if(root == null){
            return null;
        }
        if(root == n1 || root == n2){
            return root;
        }
        
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
	/*
	  Time Complexity: Time complexity of the above solution is O(n) as the method does a simple tree traversal in bottom up fashion.
    Note that the above method assumes that keys are present in Binary Tree. If one key is present and other is absent, then it returns
 the present key as LCA (Ideally should have returned NULL). We can extend this method to handle all cases by passing two boolean variables v1 and v2.
  v1 is set as true when n1 is present in tree and v2 is set as true if n2 is present in tree.
	 */
	
	 static boolean v1 = false, v2 = false; 
	  
	    // This function returns pointer to LCA of two given 
	    // values n1 and n2. 
	    // v1 is set as true by this function if n1 is found 
	    // v2 is set as true by this function if n2 is found 
	    Node findLCAUtil(Node node, int n1, int n2) 
	    { 
	        // Base case 
	        if (node == null) 
	            return null; 
	          
	        //Store result in temp, in case of key match so that we can search for other key also. 
	        Node temp=null; 
	  
	        // If either n1 or n2 matches with root's key, report the presence 
	        // by setting v1 or v2 as true and return root (Note that if a key 
	        // is ancestor of other, then the ancestor key becomes LCA) 
	        if (node.key == n1) 
	        { 
	            v1 = true; 
	            temp = node; 
	        } 
	        if (node.key == n2) 
	        { 
	            v2 = true; 
	            temp = node; 
	        } 
	  
	        // Look for keys in left and right subtrees 
	        Node left_lca = findLCAUtil(node.left, n1, n2); 
	        Node right_lca = findLCAUtil(node.right, n1, n2); 
	  
	        if (temp != null) 
	            return temp; 
	  
	        // If both of the above calls return Non-NULL, then one key 
	        // is present in once subtree and other is present in other, 
	        // So this node is the LCA 
	        if (left_lca != null && right_lca != null) 
	            return node; 
	  
	        // Otherwise check if left subtree or right subtree is LCA 
	        return (left_lca != null) ? left_lca : right_lca; 
	    } 
	  
	    // Finds lca of n1 and n2 under the subtree rooted with 'node' 
	    Node findLCA(int n1, int n2) 
	    { 
	        // Initialize n1 and n2 as not visited 
	        v1 = false; 
	        v2 = false; 
	  
	        // Find lca of n1 and n2 using the technique discussed above 
	        Node lca = findLCAUtil(root, n1, n2); 
	  
	        // Return LCA only if both n1 and n2 are present in tree 
	        if (v1 && v2) 
	            return lca; 
	  
	        // Else return NULL 
	        return null; 
	    } 
	
}
