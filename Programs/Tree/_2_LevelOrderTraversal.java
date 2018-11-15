package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class _2_LevelOrderTraversal {

	
	Node root; 
	  
    public _2_LevelOrderTraversal() 
    { 
        root = null; 
    } 
  
    /* function to print level order traversal of tree*/
    void printLevelOrder() 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
    
/* METHOD 1 (Use function to print a given level)
 Algorithm:- There are basically two functions in this method. One is to print all nodes at a given level (printGivenLevel),
 and other is to print level order traversal of the tree (printLevelorder). printLevelorder makes use of printGivenLevel to 
 print nodes at all levels one by one starting from root.

printLevelorder(tree)
 for d = 1 to height(tree)
    printGivenLevel(tree, d);


printGivenLevel(tree, level)
  if tree is NULL then return;
  if level is 1, then
      print(tree->data);
  else if level greater than 1, then
      printGivenLevel(tree->left, level-1);
      printGivenLevel(tree->right, level-1);
      
 Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes 
 in the skewed tree. So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).        */

	/* Number of nodes along the longest path from the root node down to the farthest leaf node.*/
    int height(Node root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
            /* use the larger one */
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    } 
  
    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.key + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 	

    /* METHOD 2 (Use Queue)

    Algorithm:- For each node, first the node is visited and then it’s child nodes are put in a FIFO queue.

    printLevelorder(tree)
    1) Create an empty queue q
    2) temp_node = root 
    3) Loop while temp_node is not NULL
        a) print temp_node->data.
        b) Enqueue temp_node’s children (first left then right children) to q
        c) Dequeue a node from q and assign it’s value to temp_node             */

    void printLevelOrder_usingQueue()  
    { 
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root); 
        while (!queue.isEmpty())  
        {
            /* poll() removes the present head. For more information on poll() visit  
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll(); 
            System.out.print(tempNode.key + " "); 
  
            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    } 
    
    /**
     * Use one queue and delimiter to print level by level
     */
    public void levelByLevelOneQueueUsingDelimiter(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            root = q.poll();
            if (root != null) 
            {
                System.out.print(root.key + " ");
                if (root.left != null) {
                    q.offer(root.left);
                }
                if (root.right != null) {
                    q.offer(root.right);
                }
            } else {
                if (!q.isEmpty()) {
                    System.out.println();
                    q.offer(null);
                }
            }
        }
    }
    
    /**
     * Use one queue and count to print level by level
     */
    public void levelByLevelOneQueueUsingCount(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        int levelCount = 1;
        int currentCount = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            while (levelCount > 0) {
                root = q.poll();
                System.out.print(root.key + " ");
                if (root.left != null) {
                    currentCount++;
                    q.offer(root.left);
                }
                if (root.right != null) {
                    currentCount++;
                    q.offer(root.right);
                }
                levelCount--;
            }
            System.out.println();
            levelCount = currentCount;
            currentCount = 0;
        }
    }
   
    
    
    public static void main(String args[]) 
    { 
       _2_LevelOrderTraversal tree = new _2_LevelOrderTraversal(); 
       tree.root= new Node(1); 
       tree.root.left= new Node(2); 
       tree.root.right= new Node(3); 
       tree.root.left.left= new Node(4); 
       tree.root.left.right= new Node(5); 
         
       System.out.println("Level order traversal of binary tree is "); 
       tree.printLevelOrder();
       System.out.println();
       System.out.println("Level order traversal(using queue) of binary tree is ");
       tree.printLevelOrder_usingQueue();
       
       System.out.println("Level order traversal(levelByLevelOneQueueUsingDelimiter) of binary tree is ");
       tree.levelByLevelOneQueueUsingDelimiter(tree.root);
       System.out.println("Level order traversal(levelByLevelOneQueueUsingCount) of binary tree is ");
       tree.levelByLevelOneQueueUsingCount(tree.root);
    } 
	
}
