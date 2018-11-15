package LinkedList;

public class _16_SwpaNodes_withoutSwapping_Data {

	
	public Node swapNodes(int x, int y, Node head) 
    { 
        // Nothing to do if x and y are same 
        if (x == y) return null; 
  
        // Search for x (keep track of prevX and CurrX) 
        Node prevX = null, currX = head; 
        while (currX != null && currX.val != x) 
        { 
            prevX = currX; 
            currX = currX.next; 
        } 
  
        // Search for y (keep track of prevY and currY) 
        Node prevY = null, currY = head; 
        while (currY != null && currY.val != y) 
        { 
            prevY = currY; 
            currY = currY.next; 
        } 
  
        // If either x or y is not present, nothing to do 
        if (currX == null || currY == null) 
            return null; 
  
        // If x is not head of linked list 
        if (prevX != null) 
            prevX.next = currY; 
        else //make y the new head 
            head = currY; 
  
        // If y is not head of linked list 
        if (prevY != null) 
            prevY.next = currX; 
        else // make x the new head 
            head = currX; 
  
        // Swap next pointers 
        Node temp = currX.next; 
        currX.next = currY.next; 
        currY.next = temp; 
        
        return head;
    } 
	
	
	
	
	public static void main(String [] args)
	{
	  _1_LinkedList list= new _1_LinkedList();
	  
	  
	  Node n1= new Node(10);
	  list.head=n1;
	  Node n2= new Node(15);
	  n1.next=n2;
	  
	  Node n3= new Node(12);
	  n2.next=n3;
	  Node n4= new Node(13);
	  n3.next=n4;
	  Node n5= new Node(20);
	  n4.next=n5;
	  Node n6= new Node(14);
	  n5.next=n6;
	  
	  list.printLinkedList(n1);
	  
	  _16_SwpaNodes_withoutSwapping_Data obj= new _16_SwpaNodes_withoutSwapping_Data();
	  Node changednode= obj.swapNodes(12, 20, n1);
	  
	  list.printLinkedList(changednode);
	  
	}
}
