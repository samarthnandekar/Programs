package LinkedList;

public class _12_MiddleElement_LinkList {
	
	static public int middle(Node head){
        if(head == null || head.next == null){
            return head.val;
        }
        
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
	// Output --> 2 . For even no length gives first middle element 
	
	static public int middle_sec(Node head)
	{
		 if(head == null || head.next == null){
	            return head.val;
	        }
	        
	        Node slow = head;
	        Node fast = head;
	        while(fast != null && fast.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow.val;	
	}
	// Output --> 3 
	// For even no length gives second middle element 
	
	public static void main(String [] args)
	{
		
		Node n1= new Node(1);
		Node n2= new Node(2);
		Node n3= new Node(3);
		Node n4= new Node(4);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		System.out.println(middle(n1));
		System.out.println(middle_sec(n1));
		
	}
	
}
