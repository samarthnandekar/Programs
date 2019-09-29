package LinkedList;

import javax.sound.midi.Soundbank;

public class _10_ReverseLinkedList_recursive {

	static Node head;

	static Node reverseList(Node node)
	{
		if(node.next==null)
			{
			head=node;
			return node;
			}
		
		Node result=reverseList(node.next);
		node.next=null;
		result.next=node;
		result=node;
				
		return result;		
	}
	
	static void reverseList1(Node curr, Node prev)
	{
		if(curr.next==null)
		{
		  head=curr;
		  curr.next=prev;
		  return;
		}
		
		Node next=curr.next;
		curr.next=prev;
		reverseList1(next, curr);
       
	}
	
	static void printReverseList(Node node)
	{
		if(node==null)
			return;
		
		printReverseList(node.next);
		System.out.print(node.val+ "--->");
	}
	
	public static void main(String [] args)
	{
		_1_LinkedList ll= new _1_LinkedList();
		Node node=ll.createLinkedList();
		
		printReverseList(node);
		System.out.println("");
		
		ll.printLinkedList(node);
		
		reverseList(node);
		ll.printLinkedList(head);
		System.out.println("");
		System.out.println("");
		Node node1=head;
		reverseList1(node1, null);
		ll.printLinkedList(head);
	}
	
}
