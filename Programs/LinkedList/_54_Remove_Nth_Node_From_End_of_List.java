package LinkedList;


/*
  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 
 19. Remove Nth Node From End of List
 
 Given a linked list, remove the n-th node from the end of list and return its head.

Example: Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 */
public class _54_Remove_Nth_Node_From_End_of_List {

	public static void main(String[] args) {
		Node n1= new Node(1);
		  Node n2= new Node(2);
		  n1.next=n2;
		  Node n3= new Node(3);
		  n2.next=n3;
		  Node n4= new Node(4);
		  n3.next=n4;
		  Node n5= new Node(5);
		  n4.next=n5;
		  printLinkedList(n1);
		  Node returnNode=removeNthFromEnd(n1,2);
		  printLinkedList(returnNode);
	}

	static public Node removeNthFromEnd(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i ++){
            fast = fast.next;
        }
        while (fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next; //because n is valid so that slow.next is gauranteed to be non-null
        return head;
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
}
