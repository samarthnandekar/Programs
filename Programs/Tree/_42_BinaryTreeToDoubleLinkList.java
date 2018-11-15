package Tree;

/* Link :- https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 
 Convert a given Binary Tree to Doubly Linked List | Set 3

Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. The left and right pointers in nodes are to be used as previous
and next pointers respectively in converted DLL. The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
The first node of Inorder traversal (left most node in BT) must be head node of the DLL.

 */

public class _42_BinaryTreeToDoubleLinkList {

	Node root; 
    
    // head --> Pointer to head node of created doubly linked list 
    Node head; 
       
    // Initialize previously visited node as NULL. This is static so that the same value is accessible in all recursive calls 
    static Node prev = null; 
   
    // A simple recursive function to convert a given Binary tree  to Doubly Linked List 
    // root --> Root of Binary Tree 
    void BinaryTree2DoubleLinkedList(Node root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        BinaryTree2DoubleLinkedList(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
          //  root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        BinaryTree2DoubleLinkedList(root.right); 
    } 
   
    /* Function to print nodes in a given doubly linked list */
    void printList(Node node) 
    { 
        while (node != null)  
        { 
            System.out.print(node.key + " "); 
            node = node.right; 
        } 
    } 
   
    // Driver program to test above functions 
    public static void main(String[] args)  
    { 
        // Let us create the tree as shown in above diagram 
    	_42_BinaryTreeToDoubleLinkList tree = new _42_BinaryTreeToDoubleLinkList(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(12); 
        tree.root.right = new Node(15); 
       // tree.root.left.left = new Node(25); 
        tree.root.left.right = new Node(30); 
        tree.root.right.left = new Node(36); 
   
        // convert to DLL 
        tree.BinaryTree2DoubleLinkedList(tree.root); 
           
        // Print the converted List 
        tree.printList(tree.head); 
   
    } 
}
