package LinkedList;

public class _1_LinkedList {

	Node head;
	
	public void insert(int val)
	{
		if(head==null)
		{
			head= new Node(val);
			return;
		}
		Node newNode= new Node(val);
		newNode.next=head;
		head=newNode;
	}
	
	static void printLinkedList(Node reqNode)
	{
		while(reqNode.next!=null)
		{
			System.out.print(reqNode.val + " ---> ");
			reqNode=reqNode.next;
		}
		System.out.println(reqNode.val+"");
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
		list.head=createLinkedList();
		
		list.printLinkedList(list.head);
		
		Node reverse=list.reverseList();
		list.printLinkedList(reverse);
		
		_10_ReverseLinkedList_recursive rlr= new _10_ReverseLinkedList_recursive();
		System.out.println("----Print reverse list ----");
		rlr.printReverseList(reverse);
		//list.printLinkedList(revList);
		
	}
	
	static Node createLinkedList()
	{
		_1_LinkedList list= new _1_LinkedList();
		list.head= new Node(10);
		
		Node n2= new Node(20);
		list.head.next=n2;
		
		Node n3= new Node(30);
		n2.next=n3;
		
		Node n4= new Node(40);
		n3.next=n4;
		
		return list.head;
	}
	
	static Node createLinkedListOfSize(int size)
	{
		Node res=null;
	    Node current=null;
		for(int i=1;i<=size;i++)
		{
			Node node= new Node(i);
			if(res==null)
			{
				res=node;
				current=node;
			}
			else
			{
				current.next=node;
				current=node;
			}
		}
				
	  return res;
	}
}
