/** 
@Author  - sn656
Creation - Date Dec 7, 2018 2:45:26 PM

*/

package Microsoft;

/**
https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/

****** Function to check if a singly linked list is palindrome  ****** 

Given a singly linked list of characters, write a function that returns true if the given list is palindrome, else false.

METHOD 1 (Use a Stack)
A simple solution is to use a stack of list nodes. This mainly involves three steps.
1) Traverse the given list from head to tail and push every visited node to stack.
2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
3) If all nodes matched, then return true, else false.

Time complexity of above method is O(n), but it requires O(n) extra space. Following methods solve this with constant extra space.


METHOD 2 (By reversing the list)
This method takes O(n) time and O(1) extra space.


METHOD 3 (Using Recursion)
Use two pointers left and right. Move right and left using recursion and check for following in each recursive call.
1) Sub-list is palindrome.
2) Value at current left and right are matching.

If both above conditions are true then return true.


 *
 */
public class Singly_Linked_List_Is_Palindrome
{
	
	Node head;  // head of list 
    Node left; 
  
    /* Linked list Node*/
    class Node  
    { 
        char data; 
        Node next; 
  
        Node(char d)  
        { 
            data = d; 
            next = null; 
        } 
    } 
    
	 // Initial parameters to this function are &head and head 
    boolean isPalindromeUtil(Node right)  
    { 
        left = head; 
          
        /* stop recursion when right becomes NULL */
        if (right == null) 
            return true; 
  
        /* If sub-list is not palindrome then no need to 
           check for current left and right, return false */
        boolean isp = isPalindromeUtil(right.next); 
        if (isp == false) 
            return false; 
  
        /* Check values at current left and right */
        boolean isp1 = (right.data == (left).data); 
  
        /* Move left to next node */
        left = left.next; 
  
        return isp1; 
    } 
  
    // A wrapper over isPalindromeUtil() 
    boolean isPalindrome(Node head)  
    { 
        boolean result = isPalindromeUtil(head); 
        return result; 
    } 
    /* Push a node to linked list. Note that this function 
    changes the head */
 public void push(char new_data)  
 { 
     /* Allocate the Node & 
        Put in the data */
     Node new_node = new Node(new_data); 

     /* link the old list off the new one */
     new_node.next = head; 

     /* Move the head to point to new Node */
     head = new_node; 
 } 

 // A utility function to print a given linked list 
 void printList(Node ptr)  
 { 
     while (ptr != null)  
     { 
         System.out.print(ptr.data + "->"); 
         ptr = ptr.next; 
     } 
     System.out.println("NULL"); 
 } 

 public static void main(String[] args)  
 { 
     /* Start with the empty list */
	 Singly_Linked_List_Is_Palindrome llist = new Singly_Linked_List_Is_Palindrome(); 

     char str[] = {'a', 'b', 'a', 'c', 'a', 'b', 'a'}; 
     String string = new String(str); 
     for (int i = 0; i < 7; i++)  
     { 
         llist.push(str[i]); 
         llist.printList(llist.head); 
         if (llist.isPalindrome(llist.head) != false)  
         { 
             System.out.println("Is Palindrome"); 
             System.out.println(""); 
         }  
         else 
         { 
             System.out.println("Not Palindrome"); 
             System.out.println(""); 
         } 
     } 
 } 

}

