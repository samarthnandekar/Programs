package LinkedList;

public class _3_DeleteNode {

	
	// delete node for given key
	
	
	// delete node from front
	
	
	// Delete middle Node
	
	
	// delete node, given only access to that node only
	boolean deleteNode(Node node)
	{
		if(node==null || node.next ==null)
		{
			return false;
		}
		
		Node nextnode=node.next;
		node.val=nextnode.val;
		node.next=nextnode.next;
		return true;
	}
}
