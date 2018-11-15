package LinkedList;

public class _10_ReverseLinkedList_recursive {

	Node head;
	
	
	Node reverseList(Node node)
	{
		if(node.next==null)
			return node;
		
		
		Node result=reverseList(node.next);
		node.next=null;
		result.next=node;		
				
				
		return result;		
	}
	
	void printReverseList(Node node)
	{
		if(node==null)
			return;
		
		printReverseList(node.next);
		System.out.print(node.val+ "--->");
	}
	
	
}
