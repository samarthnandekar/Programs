package LinkedList;

/*
https://leetcode.com/problems/merge-two-sorted-lists/
21. Merge Two Sorted Lists
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:-
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4


Merge Two sorted linked list
5 ---> 7 ---> 9
4 ---> 6 ---> 8
=== after merge ===
4 ---> 5 ---> 6 ---> 7 ---> 8 ---> 9


 */
public class _25_MergeSortedList {
	
	
	// ********* Using extra space *********
	static Node mergeList(Node l1, Node l2)
	{
		if(l1==null && l2==null)
			return null;
		
		if(l1==null)
			return l2;
		
		if(l2==null)
			return l1;
		
		Node l1Pointer=l1,l2Pointer=l2;
		Node result=null,pointer=null;
		
		while(l1Pointer!= null && l2Pointer!=null)
		{
		    Node next=null;
			if(l1Pointer.val<l2Pointer.val)
			{
				next=l1Pointer.next;
				l1Pointer.next=null;
				if(result==null)
				{
					result=l1Pointer;
					pointer=l1Pointer;
				}
				else
				{
					pointer.next=l1Pointer;
					pointer=l1Pointer;
				}
					
				l1Pointer=next;
			}
			else
			{
				next=l2Pointer.next;
				l2Pointer.next=null;
				if(result==null)
				{
					result=l2Pointer;
					pointer=l2Pointer;
				}
				else
				{
					pointer.next=l2Pointer;
					pointer=l2Pointer;
				}
					
				l2Pointer=next;
			}
			
		}
		
		if(l1Pointer!=null)
		{
			pointer.next=l1Pointer;
		}
		
		if(l2Pointer!=null)
		{
			pointer.next=l2Pointer;
		}
		return result;
	}
	
	
	// using recursion.
	Node mergeTwoSortedList(Node a, Node b)
	{
		if(a==null)
			return b;
		
		if(b==null)
			return a;
		
		Node result=null;
		
		if(a.val <b.val)
		{
			result=a;
			result.next=mergeTwoSortedList(a.next, b);
		}
		else
		{
		result=b;
		result.next=mergeTwoSortedList(a, b.next);
		}
		return result;
	}
	
	public static void main(String [] args)
	{
		_1_LinkedList list= new _1_LinkedList();
		Node n1= new Node(5);
		Node n2= new Node(7);
		Node n3= new Node(9);
		Node n4= new Node(10);
		Node n5= new Node(11);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		list.printLinkedList(n1);
		
		Node l1= new Node(4);
		Node l2= new Node(6);
		Node l3= new Node(8);
		
		l1.next=l2;
		l2.next=l3;
		list.printLinkedList(l1);
		
		Node result= mergeList(n1,l1);
		System.out.println("=== after merge ===");
		list.printLinkedList(result);
		
		System.out.println();
		System.out.println();
		
	}

}
