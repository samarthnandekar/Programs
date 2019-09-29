package LinkedList;

/*
 https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 
 https://leetcode.com/problems/reverse-nodes-in-k-group/
 
25. Reverse Nodes in k-Group

Reverse a Linked List in groups of given size | Set 1
Given a linked list, write a function to reverse every k nodes (where k is an input to the function). 
Example:

Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3 
Output:  3->2->1->6->5->4->8->7->NULL. 

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL. 

 Practice Tags : Paytm,VMWare,Accolite,Microsoft,Snapdeal,Adobe,MakeMyTrip,Linked List,Reverse
 
 */
public class _19_Reverse_Alternate_KNodes {

	
	
	public static void main(String []args)
	{
		_1_LinkedList ll= new _1_LinkedList();
		Node node= ll.createLinkedListOfSize(9);
		
		_19_Reverse_Alternate_KNodes rak= new _19_Reverse_Alternate_KNodes();
		int k=3;
		Node res=rak.kAltReverse(node,k);
		
		ll.printLinkedList(res);
	}
	
	
	/* Reverses alternate k nodes and returns the pointer to the new head node */
   Node kAltReverse(Node node, int k) { 
       Node current = node; 
       Node next = null, prev = null; 
       int count = 0; 
 
       /*1) reverse first k nodes of the linked list */
       while (current != null && count < k) { 
           next = current.next; 
           current.next = prev; 
           prev = current; 
           current = next; 
           count++; 
       } 
 
       /* 2) Now head points to the kth node.  So change next of head to (k+1)th node*/
       if (node != null) { 
           node.next = current; 
       } 
 
       /* 3) We do not want to reverse next k nodes. So move the current pointer to skip next k nodes */
       count = 0; 
       while (count < k - 1 && current != null) { 
           current = current.next; 
           count++; 
       } 
 
       /* 4) Recursively call for the list starting from current->next. And make rest of the list as next of first node */
       if (current != null) { 
           current.next = kAltReverse(current.next, k); 
       } 
 
       /* 5) prev is new head of the input list */
       return prev; 
   }
   
   
  
}
