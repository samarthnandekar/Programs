package LinkedList;

public class _52_DoubleLinkList {

	public static void main(String args[]){
		_52_DoubleLinkList dll = new _52_DoubleLinkList();
        DlNode head = null;
        head = dll.addDlNode(head,1);
        head = dll.addDlNode(head,2);
        head = dll.addDlNode(head,3);
        head = dll.addDlNode(head,4);
        head = dll.addDlNode(head,5);
        dll.print(head);
        System.out.println();
        System.out.println();
        dll.printFrontBack(head);
    }
	
	 public DlNode addDlNode(DlNode head,int data){
	        if(head == null){
	            head = new DlNode(data);
	            return head;
	        }
	        DlNode newDlNode = new DlNode(data);
	        DlNode current = head;
	        while(current.next != null){
	            current = current.next;
	        }
	        current.next = newDlNode;
	        newDlNode.prev = current;
	        return head;
	    }
	    
	    public DlNode addAtFront(DlNode head, int data){
	        DlNode newDlNode = new DlNode(data);
	        if(head == null){
	            return newDlNode;
	        }
	        newDlNode.next = head;
	        head.prev = newDlNode;
	        return newDlNode;
	    }
	    
	    public void print(DlNode head){
	        while(head != null){
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	    }
	    

	    public void printFrontBack(DlNode head){
	        DlNode prev = null;
	        while(head != null){
	            System.out.print(head.val + " ");
	            prev = head;
	            head = head.next;
	        }
	        System.out.println();
	        while(prev != null){
	            System.out.print(prev.val + " ");
	            prev = prev.prev;
	        }
	    }
	    
	    public DlNode find(DlNode head, int data){
	        while(head != null){
	            if(head.val == data){
	                return head;
	            }
	            head = head.next;
	        }
	        return null;
	    }
}
