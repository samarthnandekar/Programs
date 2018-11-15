package LinkedList;

public class _4_Delete_Last_Occurrence_fromLinkedList {

	
	
	static void delete_last_occure(Node head, int val)
	{
		if(head==null)
			return;
		
		Node node=null,prev=null;
		Node curr=head;
		while(curr!=null)
		{
			if(curr.val==val)
				node=prev;
			
			prev=curr;
			curr=curr.next;
			
		}
		
		node.next=node.next.next;
		
		
	}
	
	public static void main(String [] args)
	{
	
		_1_LinkedList list= new _1_LinkedList();
		  
		  
		  Node n1= new Node(10);
		  list.head=n1;
		  Node n2= new Node(20);
		  n1.next=n2;
		  
		  Node n3= new Node(12);
		  n2.next=n3;
		  Node n4= new Node(20);
		  n3.next=n4;
		  Node n5= new Node(20);
		  n4.next=n5;
		  Node n6= new Node(14);
		 // n5.next=n6;
		  
		  list.printLinkedList(n1);   
		  
		   delete_last_occure(n1,20);
		   list.printLinkedList(n1);
		  
	}
}
