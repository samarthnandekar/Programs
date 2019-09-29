package LinkedList;

/*
 https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 
Intersection of two Sorted Linked Lists
Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists.
The new list should be made with its own memory — the original lists should not be changed.

For example, let the first linked list be 1->2->3->4->6 and second linked list be 2->4->6->8, 
then your function should create and return a third list as 2->4->6.


 */
public class _51_IntersectionOfTwoSortedList {

	public static void main(String[] args) {
		_1_LinkedList ll= new _1_LinkedList();
		Node a=ll.createLinkedListOfSize(3);
		Node b=ll.createLinkedListOfSize(3);

		Node aa=new Node(0);
		aa.next=a;
		_51_IntersectionOfTwoSortedList its= new _51_IntersectionOfTwoSortedList();
		
		System.out.print("First Linked List  ->");
		ll.printLinkedList(aa);
		
		System.out.print("Second Linked List  ->");
		ll.printLinkedList(b);
		
		System.out.println();
		Node res=its.sortedIntersect(aa,b);	
		
		System.out.println("Intersection of linked list");
		ll.printLinkedList(res);
		
		System.out.println("Using recursion");
		res=its.sortedIntersect_rec(aa,b);
		ll.printLinkedList(res);
	}
	
	Node sortedIntersect(Node a, Node b)
	{
		Node result=null,tail=null;
		while(a!=null && b!=null)
		{
			if(a.val==b.val)
			{
				if(result==null)
				{
					result=a;
					tail=a;
				}
				else
				{
					tail.next=a;
					tail=a;
				}
				a=a.next;
				b=b.next;
			}
			else if(a.val<b.val)
				a=a.next;
			else
				b=b.next;
		}
		return result;
	}
	
	//
	Node sortedIntersect_rec(Node a, Node b)
	{
		Node res=null;
		if(a==null || b==null)
			return null;
		
		if(a.val<b.val)
			res=sortedIntersect_rec(a.next, b);
		
		else if(a.val>b.val)
	       res=sortedIntersect_rec(a, b.next);
		else
		{
			res=a;
			res.next=sortedIntersect_rec(a.next, b.next);
		}
		return res;
	}

}
