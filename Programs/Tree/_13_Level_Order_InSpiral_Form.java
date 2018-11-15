package Tree;

import java.util.Deque;
import java.util.LinkedList;

/*
  Given a root of binary tree, print in spiral order. 
  e.g               1 
              2           3 
         4       5     6      7
       8   9  10    11 
  should print 1 3 2 4 5 6 7 8 9 10 11
 
  Solution 1 : Use two stack. Put root in stack1. While stack1 is not
  empty take items from stack1 and put its child left,right in stack2.
  Then once stack1 is empty pop from stack2 and put its child right,
  left into stack1.
  
  Solution 2 : Use one dequeue. Technique is like above but instead of
  using two stack use dequeue. Also keep count till which point you read
  in the dequeue.
  
  Solution 3: Use one dequeue. Use a delimiter to separate between one 
  stack growing from top and another one growing from bottom.
          
  Time complexity is O(n) 
  Space complexity is O(n)  */

public class _13_Level_Order_InSpiral_Form {

	 /**
     * One deque with count method to print tree in spiral order
     */
	
	Node root;
	
    public void spiralWithOneDeque(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> deque = new LinkedList<Node>();
        deque.offerFirst(root);
        int count = 1;
        boolean flip = true;
        while (!deque.isEmpty()) {
            int currentCount = 0;
            while (count > 0) {
                if (flip) {
                    root = deque.pollFirst();
                    System.out.print(root.key + " ");
                    if (root.left != null) {
                        deque.offerLast(root.left);
                        currentCount++;
                    }
                    if (root.right != null) {
                        deque.offerLast(root.right);
                        currentCount++;
                    }
                } else {
                    root = deque.pollLast();
                    System.out.print(root.key + " ");
                    if (root.right != null) {
                        deque.offerFirst(root.right);
                        currentCount++;
                    }
                    if (root.left != null) {
                        deque.offerFirst(root.left);
                        currentCount++;
                    }
                }
                count--;
            }
            flip = !flip;
            count = currentCount;
        }
    }

    /**
     * One deque with delimiter to print tree in spiral order
     */
    public void spiralWithOneDequeDelimiter(Node root)
    {
        if(root == null){
            return;
        }
        Deque<Node> q = new LinkedList<Node>();
        q.offer(null);
        q.offerFirst(root);
        //if only delimiter(in this case null) is left in queue then break
        while(q.size() > 1){
            root = q.peekFirst();
            while(root != null){
                root = q.pollFirst();
                System.out.print(root.key + " ");
                if(root.left != null){
                    q.offerLast(root.left);
                }
                if(root.right != null){
                    q.offerLast(root.right);
                }
                root = q.peekFirst();
            }
            root = q.peekLast();
            while(root != null){
                System.out.print(root.key + " ");
                root = q.pollLast();
                if(root.right != null){
                    q.offerFirst(root.right);
                }
                if(root.left != null){
                    q.offerFirst(root.left);
                }
                root = q.peekLast();
            }
        }
    }
    
    public static void main(String args[])  
    { 
        int sum = 21; 
          
        /* Constructed binary tree is 
              10 
             /  \ 
           8     2 
          / \   / 
         3   5 2 
        */
        _13_Level_Order_InSpiral_Form tree = new _13_Level_Order_InSpiral_Form(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(2); 
   
        tree.spiralWithOneDeque(tree.root);
        System.out.println("");
        tree.spiralWithOneDequeDelimiter(tree.root);
    } 
}
