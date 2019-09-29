package LinkedList;

/*

Add two numbers represented by linked lists:- Given two numbers represented by two lists, write a function that returns the sum list.
                                              The sum list is list representation of the addition of two input numbers.

Input: List1: 5->6->3  // represents number 365
       List2: 8->4->2 //  represents number 248
Output: Resultant list: 3->1->6  // represents number 613

Input: List1: 7->5->9->4->6  // represents number 64957
       List2: 8->4           //  represents number 48
Output: Resultant list: 5->0->0->5->6  // represents number 65005

*/

/*
 Approach: Traverse both lists and One by one pick nodes of both lists and add the values. If the sum is more than 10 then make carry as 1
 and reduce sum. If one list has more elements than the other then consider remaining values of this list as 0.
 
 
 */
public class _50_AddTwoNumbersLinkedlists {

	public static void main(String[] args) {
		

	}

	/* Adds contents of two linked lists and return the head node of resultant list */
    Node addTwoLists(Node first, Node second) { 
        Node res = null;             // res is head node of the resultant list 
        Node prev = null; 
        Node temp = null; 
        int carry = 0, sum; 
  
        while (first != null || second != null) //while both lists exist 
        { 
            // Calculate value of next digit in resultant list. The next digit is sum of following things 
            // (i)  Carry 
            // (ii) Next digit of first list (if there is a next digit) 
            // (ii) Next digit of second list (if there is a next digit) 
            sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0); 
  
            // update carry for next calulation 
            carry = (sum >= 10) ? 1 : 0; 
  
            // update sum if it is greater than 10 
            sum = sum % 10; 
  
            // Create a new node with sum as data 
            temp = new Node(sum); 
  
            // if this is the first node then set it as head of the resultant list 
            if (res == null) { 
                res = temp; 
            } else // If this is not the first node then connect it to the rest. 
            { 
                prev.next = temp; 
            } 
            // Set prev for next insertion 
            prev = temp; 
  
            // Move first and second pointers to next nodes 
            if (first != null) { 
                first = first.next; 
            } 
            if (second != null) { 
                second = second.next; 
            } 
        } 
  
        if (carry > 0) { 
            temp.next = new Node(carry); 
        } 
        // return head of the resultant list 
        return res; 
    } 
	
    //To Do: add second approach.
    
    
}
