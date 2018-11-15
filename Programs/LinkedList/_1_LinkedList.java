package LinkedList;

public class _1_LinkedList {

	Node head;
	
	void insert(int val)
	{
		if(head==null)
		{
			head= new Node(val);
		}
		
		Node newNode= new Node(val);
		newNode.next=head;
		head=newNode;
	}
	
	void printLinkedList(Node reqNode)
	{
		Node node=null;
		if(reqNode==null)
		{
			node=head;
		}
		else
			node=reqNode;
		
		while(node!=null)
		{
			System.out.print(node.val + " ---> ");
			node=node.next;
		}
		System.out.println("");
	}
	
	Node reverseList()
	{
		Node res=null, curr=head;
		
		while(curr!=null)
		{
			Node next=curr.next;
			curr.next=res;
			res=curr;
			
			curr=next;
			
		}
		
		return res;
	}
	
	public static void main(String [] args)
	{
		_1_LinkedList list= new _1_LinkedList();
		list.head= new Node(10);
		
		Node n2= new Node(20);
		list.head.next=n2;
		
		Node n3= new Node(30);
		n2.next=n3;
		
		Node n4= new Node(40);
		n3.next=n4;
		
		list.printLinkedList(null);
		
		Node reverse=list.reverseList();
		list.printLinkedList(reverse);
		
		_10_ReverseLinkedList_recursive rlr= new _10_ReverseLinkedList_recursive();
		System.out.println("----Print reverse list ----");
		rlr.printReverseList(reverse);
		//list.printLinkedList(revList);
		
	}
}
