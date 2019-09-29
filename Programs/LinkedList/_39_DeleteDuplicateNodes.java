package LinkedList;

import java.util.HashSet;

/*
  1) Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
  numbers from the original list.
 
  For example,
  Given 1->2->3->3->4->4->5, return 1->2->5.
  Given 1->1->1->2->3, return 2->3.
 
  https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 
 
 2)  unsorted linked list,
 
 
 
 */
public class _39_DeleteDuplicateNodes {

	public static void main(String[] args) {
		Node node= new Node(1);
		Node node1= new Node(1);
		Node node2= new Node(1);
		Node node3= new Node(2);
		Node node4= new Node(3);
		
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		_1_LinkedList ll= new _1_LinkedList();
		ll.printLinkedList(node);
		deleteDups(node);
		ll.printLinkedList(node);

		System.out.println("===========");
		System.out.println();
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		ll.printLinkedList(node);
		deleteDups2(node);
		ll.printLinkedList(node);
		
		System.out.println("===========");
		System.out.println();
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		ll.printLinkedList(node);
		Node res=deleteDuplicates(node);
		ll.printLinkedList(res);
		System.out.println("===========");
		System.out.println();
		
		//1->2->3->3->4->4->5
		node1 = new Node(2);
		node2 = new Node(3);
		node3 = new Node(3);
		node4 = new Node(4);
		Node node5 = new Node(4);
		Node node6 = new Node(5);
		System.out.println("===========");
		System.out.println();
		
		
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		ll.printLinkedList(node);
		Node res2=deleteDuplicates_2(node);
		ll.printLinkedList(res2);

	}
	/*  takes o(n) times.  */
	static void deleteDups(Node node)
	{
		HashSet<Integer> set= new HashSet<Integer>();
		Node previous=null;
		
		while(node !=null)
		{
			if(set.contains(node.val))
			{
				previous.next=node.next;
			}
			else
			{
				set.add(node.val);
				previous=node;
			}
			node=node.next;
					
		}
	}
	
	/*  Given 1->2->3->3->4->4->5, return 1->2->5.
        Given 1->1->1->2->3, return 2->3.     */
	static void deleteDups2(Node head)
	{
		Node current=head;
		while(current!=null)
		{
			Node runner=current;
			while(runner.next!=null)
			{
	            if(runner.next.val==current.val)
	            {
	            	runner.next=runner.next.next;
	            }
	            else
	            {
	            	runner= runner.next;
	            }
			}
			current=current.next;
		}
	}
	
	
	/*  */
	static public Node deleteDuplicates_2(Node head) {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node current = head;
        Node prev = dummyNode;
        while (current != null) {
            while(current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if (prev.next == current) {
                prev = current;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
        return dummyNode.next;
    }
    
	
	static public Node deleteDuplicates(Node head) {
      
        Node result=null,rear=null;
        Node current = head;
        Node startPoint=head;
        while (current != null) 
        {
            while(current.next != null && current.val == current.next.val) {
                current = current.next;
            }
            if(startPoint.val==current.val)
            {
            	startPoint=current;
            }
            else {
            	 if(result==null)
                 {
              	   result=current;
              	   rear=current;
                 }
                 else {
              	   rear.next=current;
              	   rear=current;
                 }
            }
            current = current.next;
        }
        return result;
    }
	 
	
}
