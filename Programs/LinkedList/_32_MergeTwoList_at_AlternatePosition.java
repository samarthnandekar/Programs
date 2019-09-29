package LinkedList;

import Sorting.MergeSort;

/*
 https://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/
 
Merge a linked list into another linked list at alternate positions
Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, the first list should become 5->12->7->10->17->2->13->4->11->6 
and second list should become empty. The nodes of second list should only be inserted when there are positions available. For example, if the
first list is 1->2->3 and second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.

Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place. 
Expected time complexity is O(n) where n is number of nodes in first list.

 */
public class _32_MergeTwoList_at_AlternatePosition {
	
	
	public static void main(String[] args) {
		_1_LinkedList ll= new _1_LinkedList();
		
		Node node=ll.createLinkedListOfSize(3);
		Node node2=ll.createLinkedListOfSize(8);
		
		_1_LinkedList ll1= new _1_LinkedList();
		node2=node2.next.next.next;
		ll1.head=node2;
		
		ll.printLinkedList(node);
		ll.printLinkedList(node2);
		
		_32_MergeTwoList_at_AlternatePosition obj= new _32_MergeTwoList_at_AlternatePosition();
		
		System.out.println("-----  after merge -----");
		obj.merge(node,ll1);
		ll.printLinkedList(node);
		ll.printLinkedList(ll1.head);
	}
	
	// Main function that inserts nodes of linked list q into p at alternate positions. Since head of first list never changes 
    // and head of second list/ may change, we need single pointer for first list and double pointer for second list. 
    void merge(Node p,_1_LinkedList q) 
    { 
        Node p_curr = p, q_curr = q.head; 
        Node p_next, q_next; 
  
        // While there are available positions in p; 
        while (p_curr != null && q_curr != null) { 
  
            // Save next pointers 
            p_next = p_curr.next; 
            q_next = q_curr.next; 
  
            // make q_curr as next of p_curr 
            p_curr.next = q_curr; // change next pointer of p_curr
            q_curr.next = p_next; // change next pointer of q_curr 
            
  
            // update current pointers for next iteration 
            p_curr = p_next; 
            q_curr = q_next; 
        } 
        q.head = q_curr; 
    } 
}
