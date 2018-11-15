package Tree;
/*
https://www.geeksforgeeks.org/flip-binary-tree/


 */
public class _53_Convert_UpsidedownBinaryTree {

	Node root;
	
	public Node upsideDownBinaryTree(Node root) {
        if (root == null) {
            return null;
        }
        return upsideDownBinaryTree(root, null, null);
    }

    public Node upsideDownBinaryTree(Node root, Node parent, Node rightChild) {
        if (root == null) {
            return parent;
        }
        Node left = root.left;
        Node right = root.right;

        root.right = parent;
        root.left = rightChild;

        return upsideDownBinaryTree(left, root, right);
    }
    
    { 
        int sum = 21; 
          
        /* Constructed binary tree is 
              1 
             /  \ 
           2     3 
          / \   / \
         4   5 6    7 
        */
        _53_Convert_UpsidedownBinaryTree tree = new _53_Convert_UpsidedownBinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.left = new Node(7); 
        
        // print before
        
        // convert
        
        // Print after
        
        
  
    } 
    
}
