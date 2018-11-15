package LinkedList;

// add recursive and iterrative approach both

public class _35_AddOne_inLinkedList {

	static int addWithCarry(Node head)
	{
		if(head==null)
			return 1;
		
		int res=head.val+addWithCarry(head.next);
		
		head.val=res%10;
		return res/10;
	}
	
	static Node addOne(Node head)
	{
		int carry= addWithCarry(head);
		
		if(carry>0)
		{
			Node newNode= new Node(carry);
			newNode.next=head;
			head=newNode;
		}
		return head;
	}
	
	
	public static void main(String [] args)
	{
	  Node n1= new Node(9);
	  Node n2= new Node(9);
	  n1.next=n2;
	  Node n3= new Node(9);
	  n2.next=n3;
	  Node n4= new Node(9);
	  n3.next=n4;
	  
		_1_LinkedList list= new _1_LinkedList();
		list.printLinkedList(n1);
		
		Node addOne = addOne(n1);
		list.printLinkedList(addOne);
		
	
	}
	
}
