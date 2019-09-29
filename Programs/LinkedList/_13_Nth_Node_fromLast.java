package LinkedList;

/*
 https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 
 Program for n’th node from the end of a Linked List
 Given a Linked List and a number n, write a function that returns the value at the n’th node from end of the Linked List.
 For example, if input is below list and n = 3, then output is “B”


 */

/*
 Method 1 (Use length of linked list)
1) Calculate the length of Linked List. Let the length be len.
2) Print the (len – n + 1)th node from the begining of the Linked List.
Time Complexity: O(n) where n is the length of linked list.

Method 2 (Use two pointers) 
Maintain two pointers – reference pointer and main pointer. Initialize both reference and main pointers to head. First,
move reference pointer to n nodes from head. Now move both pointers one by one until the reference pointer reaches the end. 
Now the main pointer will point to nth node from the end. Return the main pointer.


 */
public class _13_Nth_Node_fromLast {
	
	public static void main(String [] args)
	{
	  
	  Node head=_1_LinkedList.createLinkedList();
      _1_LinkedList.printLinkedList(head);		
	  printNthfromLastRecursive(head,4);
	  
	}

	/* Function to get the nth node from the last of a linked list */
    void printNthFromLast(Node head,int n) 
   { 
     int len = 0; 
     Node temp = head; 

     // 1) count the number of nodes in Linked List 
     while (temp != null) { 
         temp = temp.next; 
         len++; 
     } 

     // check if value of n is not more than length of the linked list 
     if (len < n) 
         return; 

     temp = head; 
     // 2) get the (len-n+1)th node from the begining 
     for (int i = 1; i < len - n + 1; i++) 
         temp = temp.next; 

     System.out.println(temp.val); 
 }
    
    
    /* Function to get the nth node from end of list */
    void printNthFromLast2(Node head,int n) 
    { 
        Node main_ptr = head; 
        Node ref_ptr = head; 
  
        int count = 0; 
        if (head != null) { 
            while (count < n) { 
                if (ref_ptr == null) { 
                    System.out.println(n + " is greater than the no of nodes in the list"); 
                    return; 
                } 
                ref_ptr = ref_ptr.next; 
                count++; 
            } 
            while (ref_ptr != null) { 
                main_ptr = main_ptr.next; 
                ref_ptr = ref_ptr.next; 
            } 
            System.out.println("Node no. " + n + " from last is " + main_ptr.val); 
        } 
    } 
  
    /* Function to get the nth node from end of list */
    static int printNthfromLastRecursive(Node node, int k)
    {
    	if(node==null)
    	{
    	return 0;	
    	}
    	int index=printNthfromLastRecursive(node.next,k)+1;
    	if(index==k)
    	{
    		System.out.println(node.val);
    	}
    	return index;
    }
}
