package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 LinkedList : 
             Input : A>B>C>D>E 
			 Output: A>E>B>D>C

Method 1: using DeQue
Mathod 2: a) Get middle point
          b) reverse second part of linked list
          c) merge first and second part
 */
public class _48_ArrangeInFirstLastFormat {

	public Node swapApp(Node node) {
	    Deque<Node> stack = new ArrayDeque<>();
	    while (node != null) {
	          stack.addFirst(node);
	          node = node.next;
	    }
	    Node head = new Node('Z');
	    Node dummy = head;
	    boolean isAlternate = true;
	    while (!stack.isEmpty()) {
	        Node n1 = null;
	        if (isAlternate) {
	            n1 = stack.pollLast();
	            head.next = n1;
	        } else {
	            n1 = stack.pollFirst();
	           head.next = n1;
	        }
	        n1.next = null;
	        isAlternate = !isAlternate;
	        head = head.next;
	    }

	    return dummy.next;
	  }
	
	public static void main(String [] args)
	{
		_1_LinkedList lk= new _1_LinkedList();
		
		lk.insert(5);
		lk.insert(4);
		lk.insert(3);
		lk.insert(2);
		lk.insert(1);
		lk.printLinkedList(null);
		_48_ArrangeInFirstLastFormat obj= new _48_ArrangeInFirstLastFormat();
		Node node=obj.swapApp(lk.head);
		lk.printLinkedList(node);
	}
	
	
}
