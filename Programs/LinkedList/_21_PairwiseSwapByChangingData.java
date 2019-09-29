package LinkedList;

public class _21_PairwiseSwapByChangingData {
	
	public static void main(String[] args) {

		_1_LinkedList ll= new _1_LinkedList();
		_21_PairwiseSwapByChangingData pwsc= new _21_PairwiseSwapByChangingData();
		Node a=ll.createLinkedListOfSize(5);
		ll.printLinkedList(a);
		pwsc.pairSwap(a);
		ll.printLinkedList(a);
		System.out.println();
		
		Node b=ll.createLinkedListOfSize(5);
		ll.printLinkedList(b);
		pwsc.pairSwap(b);
		ll.printLinkedList(b);
	}

	void pairSwap(Node node)
	{
		Node curr=node;
		while(curr!=null && curr.next!=null)
		{
			int val= curr.val;
			curr.val=curr.next.val;
			curr.next.val=val;
			curr=curr.next.next;
		}
	}
	
	void pairSwapRec(Node node)
	{
		Node curr=node;
		if(node!=null && node.next!=null)
		{
			int val= curr.val;
			curr.val=curr.next.val;
			curr.next.val=val;
			curr=curr.next.next;
			
			pairSwapRec(curr.next.next);
		}
	}
	
}
