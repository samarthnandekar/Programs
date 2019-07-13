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
		
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		ll.printLinkedList(node);
		deleteDups2(node);
		ll.printLinkedList(node);
		
		
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
	
	/*       */
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
	
}
