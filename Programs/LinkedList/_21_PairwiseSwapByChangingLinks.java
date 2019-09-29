package LinkedList;


/*
 Pairwise swap elements of a given linked list by changing links

Given a singly linked list, write a function to swap elements pairwise. For example, if the linked list is 1->2->3->4->5->6->7
then the function should change it to 2->1->4->3->6->5->7, and if the linked list is 1->2->3->4->5->6 then the function should
change it to 2->1->4->3->6->5


 */
public class _21_PairwiseSwapByChangingLinks {
	
	public static void main(String[] args) {
	_1_LinkedList ll= new _1_LinkedList();
	Node node=ll.createLinkedListOfSize(6);
	ll.printLinkedList(node);
	_21_PairwiseSwapByChangingLinks psbc= new _21_PairwiseSwapByChangingLinks();
	Node res=psbc.pairWiseSwap(node);
	
	ll.printLinkedList(res);
	
	System.out.println("==========");
	
	Node node1=ll.createLinkedListOfSize(4);
	ll.printLinkedList(node1);
	Node res1=pairWiseSwapRec(node1);
	ll.printLinkedList(res1);
	}
	
	/* Function to pairwise swap elements of a linked list */
    Node pairWiseSwap(Node node) 
    { 
  
        // If linked list is empty or there is only one node in list 
        if (node == null || node.next == null) { 
            return node; 
        } 
  
        // Initialize previous and current pointers 
        Node prev = node; 
        Node curr = node.next; 
  
        node = curr; // Change head before proceeeding 
  
        // Traverse the list 
        while (true) { 
            Node next = curr.next; 
            curr.next = prev; // Change next of current as previous node 
  
            // If next NULL or next is the last node 
            if (next == null || next.next == null) { 
                prev.next = next; 
                break; 
            } 
  
            // Change next of previous to next next 
            prev.next = next.next; 
  
            // Update previous and curr 
            prev = next; 
            curr = next.next; 
        } 
        return node; 
    }
    
    
    /* Function to pairwise swap elements of a linked list */
    Node pairWiseSwap_2(Node node) 
    { 
  
        // If linked list is empty or there is only one node in list 
        if (node == null || node.next == null) { 
            return node; 
        } 
  
        // Initialize previous and current pointers 
        Node prev = node; 
        Node curr = node.next; 
  
        node = curr; // Change head before proceeeding 
  
        // Traverse the list 
        while (true) { 
            Node next = curr.next; 
            curr.next = prev; // Change next of current as previous node 
  
            // If next NULL or next is the last node 
            if (next == null || next.next == null) { 
                prev.next = next; 
                break; 
            } 
  
            // Change next of previous to next next 
            prev.next = next.next; 
  
            // Update previous and curr 
            prev = next; 
            curr = next.next; 
        } 
        return node; 
    }
    
    
    
    
    
    
    /* Function to pairwise swap elements of a linked list. It returns head of the modified list, 
       so return value of this node must be assigned */
  static Node pairWiseSwapRec(Node node) 
   { 
 
       // Base Case: The list is empty or has only one node 
       if (node == null || node.next == null) { 
           return node; 
       } 
 
       // Store head of list after two nodes 
       Node remaing = node.next.next; 
 
       // Change head 
       Node newhead = node.next; 
 
       // Change next of second node 
       newhead.next = node; 
 
       // Recur for remaining list and change next of head 
       node.next = pairWiseSwapRec(remaing); 
 
       // Return new head of modified list 
       return newhead; 
   } 
}
