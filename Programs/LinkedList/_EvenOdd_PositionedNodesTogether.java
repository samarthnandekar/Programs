package LinkedList;

/*
 https://www.geeksforgeeks.org/rearrange-a-linked-list-such-that-all-even-and-odd-positioned-nodes-are-together/
 
Rearrange a linked list such that all even and odd positioned nodes are together
Rearrange a linked list in such a way that all odd position nodes are together and all even positions node are together,

Examples:
Input:   1->2->3->4
Output:  1->3->2->4

Input:   10->22->30->43->56->70
Output:  10->30->56->22->43->70
 */

/*
 The important thing in this question is to make sure that all below cases are handled
1) Empty linked list
2) A linked list with only one node
3) A linked list with only two nodes
4) A linked list with odd number of nodes
5) A linked list with even number of nodes

The below program maintains two pointers ‘odd’ and ‘even’ for current nodes at odd an even positions respectively.
We also store first node of even linked list so that we can attach the even list at the end of odd list after all.
odd and even nodes are connected together in two different lists.

 */
public class _EvenOdd_PositionedNodesTogether {

	public static void main(String[] args) {
	
		_1_LinkedList ll = new _1_LinkedList();
	   Node node= ll.createLinkedListOfSize(5);
	   
		Node res=rearrangeEvenOdd(node);
		
		ll.printLinkedList(res);
			

	}
	
	// Rearranges given linked list such that all even positioned  
	// nodes are before odd positioned. Returns new head of linked List.  
	static Node rearrangeEvenOdd(Node head)  
	{  
	    if (head == null)  
	        return null;  
	  
	    // Initialize first nodes of even and odd lists  
	    Node odd = head;  
	    Node even = head.next;  
	  
	    // Remember the first node of even list so that we can connect the even list at the end of odd list.  
	    Node evenFirst = even;  
	  
	    while (true)  
	    {  
	        // If there are no more nodes, then connect first node of even   
	        // list to the last node of odd list  
	        if (odd == null || even == null || (even.next) == null)  
	        {  
	            odd.next = evenFirst;  
	            break;  
	        }  
	  
	        // Connecting odd nodes  
	        odd.next = even.next;  
	        odd = even.next;  
	  
	        // If there are NO more even nodes after current odd.  
	        if (odd.next == null)  
	        {  
	            even.next = null;  
	            odd.next = evenFirst;  
	            break;  
	        }  
	        // Connecting even nodes  
	        even.next = odd.next;  
	        even = odd.next;  
	    }  
	    return head;  
	}  

}
