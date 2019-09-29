package LinkedList;

/**
 Multiply two numbers in form of link list
 Idea is to multiply one number from head2 with all numbers from head1.
 This result is stored in currentResult. Pass this currentResult and any previous result from multiplication and add them
 
 
 */

/****************** Not working, need to check  **************/
public class _41_MultiplyTwoNumbersLinkList {

	public static void main(String args[]){
		_41_MultiplyTwoNumbersLinkList mtn = new _41_MultiplyTwoNumbersLinkList();
        _1_LinkedList ll = new _1_LinkedList();
      
        Node n1=ll.createLinkedListOfSize(3);
        Node n2=ll.createLinkedListOfSize(2);
            
        Node result = mtn.multiply(n1, n2);
        ll.printLinkedList(result);
    }
	
	public Node multiply(Node head1, Node head2){
		_1_LinkedList ll = new _1_LinkedList();
        head1 = ll.reverseList();
        head2 = ll.reverseList();
        DoubleLinkList dll = new DoubleLinkList();
        Node result = null;
        Node resultStart = null;
        Node currentResult = null;
        Node currentTail = null;
        
        while(head2 != null){
            Node current = head1;
            int carry = 0;
            while(current != null){
                int r = current.data * head2.data;
                r += carry;
                carry = r/10;
                r = r%10;
                if(currentResult == null){
                    currentResult = dll.addAtFront(currentResult, r);
                    currentTail = currentResult;
                }else{
                    currentResult = dll.addAtFront(currentResult, r);
                }
                current = current.next;
            }
            if(carry != 0){
                currentResult = dll.addAtFront(currentResult, carry);
            }
            currentResult = null;
            if(result == null){
                result = add(resultStart,currentTail);
                resultStart = result;
            }else{
                result = add(resultStart,currentTail);
                resultStart = resultStart.before;
            }
            head2 = head2.next;
        }
        while(result.before != null){
            result = result.before;
        }
        head1 = ll.reverse(head1);
        head2 = ll.reverse(head2);
        return result;
    }
	
	private Node add(Node result, Node currentResult){
        if(currentResult == null){
            return result;
        }
        if(result == null){
            return currentResult;
        }
        
        Node r1 = result.before;
        Node addResult = null;
        int carry = 0;
        while(r1 != null && currentResult != null){
            int r = r1.data + currentResult.data + carry;
            Node newNode = Node.newNode(r%10);
            if(addResult == null){
                addResult = newNode;
            }else{
                addResult.before = newNode;
                newNode.next = addResult;
                addResult = addResult.before;
            }
            carry = r/10;
            r1 = r1.before;
            currentResult = currentResult.before;
        }
        while(r1 != null){
            int r = r1.data + carry;
            Node newNode = Node.newNode(r%10);
            if(addResult == null){
                addResult = newNode;
            }else{
                addResult.before = newNode;
                newNode.next = addResult;
                addResult = addResult.before;
            }
            carry = r/10;
            r1 = r1.before;
        }
        while(currentResult != null){
            int r = currentResult.data + carry;
            Node newNode = Node.newNode(r%10);
            if(addResult == null){
                addResult = newNode;
            }else{
                addResult.before = newNode;
                newNode.next = addResult;
                addResult = addResult.before;
            }
            carry = r/10;
            currentResult = currentResult.before;
        }
        if(carry != 0){
            Node newNode = Node.newNode(carry);
            addResult.before = newNode;
            newNode.next = addResult;
            addResult = addResult.before;
        }
        
        while(addResult.next != null){
            addResult = addResult.next;
        }
        addResult.next = result;
        result.before = addResult;
        return result;
    }
}
