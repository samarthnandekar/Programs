package LinkedList;

/*
 https://www.geeksforgeeks.org/merge-sort-for-linked-list/
 
 Merge sort is often preferred for sorting a linked list. The slow random-access performance of a linked list
 makes some other algorithms (such as quicksort) perform poorly, and others (such as heapsort) completely impossible.
 
 Let head be the first Node of the linked list to be sorted and headRef be the pointer to head. Note that we need a reference to head in MergeSort() as the below implementation changes next links to sort the linked lists (not data at the Nodes), so head Node has to be changed if the data at the original head is not the smallest value in the linked list.

MergeSort(headRef)
1) If the head is NULL or there is only one element in the Linked List 
    then return.
2) Else divide the linked list into two halves.  
      FrontBackSplit(head, &a, &b); // a and b are two halves 
3) Sort the two halves a and b.
      MergeSort(a);
      MergeSort(b);
4) Merge the sorted a and b (using SortedMerge() discussed here) 
   and update the head pointer using headRef.
     *headRef = SortedMerge(a, b);

 */
public class _28_Merge_Sort {
 
	      Node head;
	
	 Node sortedMerge(Node a, Node b) 
	    { 
		 Node result = null; 
	        /* Base cases */
	        if (a == null) 
	            return b; 
	        if (b == null) 
	            return a; 
	  
	        /* Pick either a or b, and recur */
	        if (a.val <= b.val) { 
	            result = a; 
	            result.next = sortedMerge(a.next, b); 
	        } 
	        else { 
	            result = b; 
	            result.next = sortedMerge(a, b.next); 
	        } 
	        return result; 
	    }
	 
	 
	 Node mergeSort(Node h) 
	    { 
	        // Base case : if head is null 
	        if (h == null || h.next == null) { 
	            return h; 
	        } 
	  
	        // get the middle of the list 
	        Node middle = getMiddle(h); 
	        Node nextofmiddle = middle.next; 
	  
	        // set the next of middle Node to null 
	        middle.next = null; 
	  
	        // Apply mergeSort on left list 
	        Node left = mergeSort(h); 
	  
	        // Apply mergeSort on right list 
	        Node right = mergeSort(nextofmiddle); 
	  
	        // Merge the left and right lists 
	        Node sortedlist = sortedMerge(left, right); 
	        return sortedlist; 
	    } 
	 
	 Node getMiddle(Node h) 
	    { 
	        // Base case 
	        if (h == null) 
	            return h; 
	        Node fastptr = h.next; 
	        Node slowptr = h; 
	  
	        // Move fastptr by two and slow ptr by one Finally slowptr will point to middle Node 
	        while (fastptr != null) { 
	            fastptr = fastptr.next; 
	            if (fastptr != null) { 
	                slowptr = slowptr.next; 
	                fastptr = fastptr.next; 
	            } 
	        } 
	        return slowptr; 
	    } 
	 
	 void push(int new_data) 
	    { 
	        /* allocate Node */
	        Node new_Node = new Node(new_data); 
	  
	        /* link the old list off the new Node */
	        new_Node.next = head; 
	  
	        /* move the head to point to the new Node */
	        head = new_Node; 
	    } 
	  
	    // Utility function to print the linked list 
	    void printList(Node headref) 
	    { 
	        while (headref != null) { 
	            System.out.print(headref.val + " "); 
	            headref = headref.next; 
	        } 
	    } 
	  
	    public static void main(String[] args) 
	    { 
	  
	    	_28_Merge_Sort li = new _28_Merge_Sort(); 
	        /* 
	         * Let us create a unsorted linked list to test the functions 
	         * created. The list shall be a: 2->3->20->5->10->15 
	         */
	        li.push(15); 
	        li.push(10); 
	        li.push(5); 
	        li.push(20); 
	        li.push(3); 
	        li.push(2); 
	  
	        li.printList(li.head); 
	        // Apply merge Sort 
	        li.head = li.mergeSort(li.head); 
	        System.out.print("\n Sorted Linked List is: \n"); 
	        li.printList(li.head); 
	    } 
}
