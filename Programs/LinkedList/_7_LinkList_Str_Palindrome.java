package LinkedList;

/*
 Palindrome Linked List:- Given a singly linked list, determine if it is a palindrome.

Example 1:-  Input: 1->2         Output: false
Example 2:   Input: 1->2->2->1   Output: true

Follow up:Could you do it in O(n) time and O(1) space?

 Approach 1 :-  create a new list in reversed order and then compare each node. The time and space are O(n). 
 
 Approach 2:- We can use a fast and slow pointer to get the center of the list, then reverse the second 
 list and compare two sublists. The time is O(n) and space is O(1).
 
 Approach 3:-Recursive  Time is O(n) and space is O(n).
 
 */
public class _7_LinkList_Str_Palindrome 
{
	public static void main(String [] args)
	{
		
		
		_7_LinkList_Str_Palindrome pl= new _7_LinkList_Str_Palindrome();
		
		Node node1=pl.createLinkedList();
		Node node2=pl.createLinkedList();
		Node node3=pl.createLinkedList();
		System.out.println(pl.isPalindrome_1(node1));
		System.out.println(pl.isPalindrome_2(node2));
		System.out.println(pl.isPalindrome_3(node3));
		
	}
	
	public boolean isPalindrome_1(Node head) {
	    if(head == null)
	        return true;
	 
	    Node p = head;
	    Node prev = new Node(head.val);
	 
	    while(p.next != null){
	        Node temp = new Node(p.next.val);
	        temp.next = prev;
	        prev = temp;
	        p = p.next;
	    }
	 
	    Node p1 = head;
	    Node p2 = prev;
	 
	    while(p1!=null){
	        if(p1.val != p2.val)
	            return false;
	 
	        p1 = p1.next;
	        p2 = p2.next;
	    }
	 
	    return true;
	}
	
	public boolean isPalindrome_2(Node head) {
		 
	    if(head == null || head.next==null)
	        return true;
	 
	    //find list center
	    Node fast = head;
	    Node slow = head;
	 
	    while(fast.next!=null && fast.next.next!=null){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	 
	    Node secondHead = slow.next;
	    slow.next = null;
	 
	    //reverse second part of the list
	    Node p1 = secondHead;
	    Node p2 = p1.next;
	 
	    while(p1!=null && p2!=null){
	        Node temp = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = temp;
	    }
	 
	    secondHead.next = null;
	 
	    //compare two sublists now
	    Node p = (p2==null?p1:p2);
	    Node q = head;
	    while(p!=null)
	    {
	        if(p.val != q.val)
	            return false;
	 
	        p = p.next;
	        q = q.next;
	    }
	    return true;
	}
	

        static Node left;	 
	    public boolean isPalindrome_3(Node head) {
	        left = head;
	 
	        boolean result = helper(head);
	        return result;
	    }
	 
	    public boolean helper(Node right){
	 
	        //stop recursion
	        if (right == null)
	            return true;
	 
	        //if sub-list is not palindrome,  return false
	        boolean x = helper(right.next);
	        if (!x)
	            return false;
	 
	        //current left and right
	        boolean y = (left.val == right.val);
	 
	        //move left to next
	        left = left.next;
	 
	        return y;
	    }
	    
	    Node createLinkedList()
	    {
	    	Node node1= new Node(1);
			Node node2= new Node(2);
			Node node3= new Node(3);
			Node node4= new Node(2);
			Node node5= new Node(1);
			
			node1.next=node2;
			node2.next=node3;
			node3.next=node4;
			node4.next=node5;
			
			return node1;
	    }
}
