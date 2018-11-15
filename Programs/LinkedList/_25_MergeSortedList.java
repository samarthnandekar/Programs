package LinkedList;

public class _25_MergeSortedList {
	
	
	
	static Node mergeList(Node l1, Node l2)
	{
		if(l1==null && l2==null)
			return null;
		
		if(l1==null)
			return l2;
		
		if(l2==null)
			return l1;
		
		Node l1Pointer=l1,l2Pointer=l2;
		Node result=null,pointer=null;
		
		while(l1Pointer!= null && l2Pointer!=null)
		{
		 Node next=null;
			if(l1Pointer.val<l2Pointer.val)
			{
				next=l1Pointer.next;
				l1Pointer.next=null;
				if(result==null)
				{
					result=l1Pointer;
					pointer=l1Pointer;
				}
				else
				{
					pointer.next=l1Pointer;
					pointer=l1Pointer;
				}
					
				l1Pointer=next;
			}
			else
			{
				next=l2Pointer.next;
				l2Pointer.next=null;
				if(result==null)
				{
					result=l2Pointer;
					pointer=l2Pointer;
				}
				else
				{
					pointer.next=l2Pointer;
					pointer=l2Pointer;
				}
					
				l2Pointer=next;
			}
			
		}
		
		// add first remaining list to result
		while(l1Pointer!=null)
		{
		   Node next=l1Pointer.next;
		   pointer.next=l1Pointer;
		   pointer=l1Pointer;
		   l1Pointer=next;
		}
		
		while(l2Pointer!=null)
		{
			Node next=l2Pointer.next;
			   pointer.next=l2Pointer;
			   pointer=l2Pointer;
			   l2Pointer=next;
		}
		
		
		// add second remaining list to result
		
		
		return result;
		
	}
	
	public static void main(String [] args)
	{
		_1_LinkedList list= new _1_LinkedList();
		Node n1= new Node(5);
		Node n2= new Node(7);
		Node n3= new Node(9);
		
		n1.next=n2;
		n2.next=n3;
		list.printLinkedList(n1);
		
		Node l1= new Node(4);
		Node l2= new Node(6);
		Node l3= new Node(8);
		
		l1.next=l2;
		l2.next=l3;
		list.printLinkedList(l1);
		
		Node result= mergeList(n1,l1);
		System.out.println("=== after merge ===");
		list.printLinkedList(result);
		
	}

}
