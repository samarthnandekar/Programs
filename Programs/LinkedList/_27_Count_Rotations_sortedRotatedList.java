package LinkedList;

/*
 
 https://www.geeksforgeeks.org/count-rotations-sorted-rotated-linked-list/
 
 Count rotations in sorted and rotated linked list
 Given a linked list of n nodes which is first sorted, then rotated by k elements. Find the value of k.


 */
public class _27_Count_Rotations_sortedRotatedList {

	public static void main(String[] args) {
		
		
		_1_LinkedList ll= new _1_LinkedList();
		Node node=ll.createLinkedListOfSize(4);
		
        ll.printLinkedList(node);
		System.out.println("rotated by->"+countRotation(node));
		
		System.out.println();
		Node n5=new Node(5);
		n5.next=node;
		ll.printLinkedList(n5);
		
		System.out.println("rotated by->"+countRotation(n5));
	}
	
	static int countRotation(Node head) 
	{ 
	    // declare count variable and assign it 1. 
	    int count = 0; 
	  
	    // declare a min variable and assign to data of head node. 
	    int min = head.val; 
	    boolean isRotated=false;
	    
	    // check that while head not equal to NULL. 
	    while (head != null) { 
	  
	        // if min value is greater then head->data then it breaks the while loop and 
	        // return the value of count. 
	        if (min > head.val) 
	        {   
	        	isRotated=true;
	        	break; 
	        }
	        
	        count++;
	        // head assign the next value of head. 
	        head = head.next; 
	    } 
	    if(isRotated)
	    {
	    	return count;
	    }
	    else
	    {
	    	 return 0; 
	    }
	   
	} 
}
