package Tree;

import LinkedList._12_MiddleElement_LinkList;
import LinkedList._1_LinkedList;

/*
 https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/
 
 Sorted Linked List to Balanced BST
Given a Singly Linked List which has data members sorted in ascending order. Construct a Balanced Binary Search Tree which has same data members as the given Linked List. 

Examples:

Input:  Linked List 1->2->3
Output: A Balanced BST 
     2   
   /  \  
  1    3 


Input: Linked List 1->2->3->4->5->6->7
Output: A Balanced BST
        4
      /   \
     2     6
   /  \   / \
  1   3  5   7  

Input: Linked List 1->2->3->4
Output: A Balanced BST
      3   
    /  \  
   2    4 
 / 
1

Input:  Linked List 1->2->3->4->5->6
Output: A Balanced BST
      4   
    /   \  
   2     6 
 /  \   / 
1   3  5   
 
 
 */

/*
Method 1 (Simple)
Following is a simple algorithm where we first find the middle node of the list and make it the root of the tree to be constructed.

1) Get the Middle of the linked list and make it root.
2) Recursively do same for the left half and right half.
       a) Get the middle of the left half and make it left child of the root
          created in step 1.
       b) Get the middle of right half and make it the right child of the
          root created in step 1.

Time complexity: O(nLogn) where n is the number of nodes in Linked List.

Method 2 (Tricky) 
Method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root. The idea is to insert nodes in BST in the 
same order as they appear in Linked List so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in 
the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left
subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct the right subtree
and link it with root. While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.

 */
public class _9_Sorted_LinkedList_to_BalancedBST {

	static LNode head; 
	/* This function counts the number of nodes in Linked List 
    and then calls sortedListToBSTRecur() to construct BST */
 Node sortedListToBST()  
 { 
     /*Count the number of nodes in Linked List */
     int n = countNodes(head); 

     /* Construct BST */
     return sortedListToBSTRecur(n); 
 } 

 /* The main function that constructs balanced BST and 
    returns root of it. 
    n  --> No. of nodes in the Doubly Linked List */
 Node sortedListToBSTRecur(int n)  
 { 
     /* Base Case */
     if (n <= 0)  
         return null; 

     /* Recursively construct the left subtree */
     Node left = sortedListToBSTRecur(n / 2); 

     /* head_ref now refers to middle node,  
        make middle node as root of BST*/
     Node root = new Node(head.val); 

     // Set pointer to left subtree 
     root.left = left; 

     /* Change head pointer of Linked List for parent  
        recursive calls */
     head = head.next; 

     /* Recursively construct the right subtree and link it  
        with root. The number of nodes in right subtree  is  
        total nodes - nodes in left subtree - 1 (for root) */
     root.right = sortedListToBSTRecur(n - n / 2 - 1); 

     return root; 
 } 

 /* A utility function that returns count of nodes in a  given Linked List */
 int countNodes(LNode head)  
 { 
     int count = 0; 
     LNode temp = head; 
     while (temp != null) 
     { 
         temp = temp.next; 
         count++; 
     } 
     return count; 
 } 
 
 /* Function to print nodes in a given linked list */
 void printList(LNode node)  
 { 
     while (node != null)  
     { 
         System.out.print(node.val + " "); 
         node = node.next; 
     } 
 } 

 /* A utility function to print preorder traversal of BST */
 void preOrder(Node node)  
 { 
     if (node == null) 
         return; 
     System.out.print(node.key + " "); 
     preOrder(node.left); 
     preOrder(node.right); 
 } 
 
 /* Function to insert a node at the beginging of  
 the Doubly Linked List */
void push(int new_data)  
{ 
  /* allocate node */
  LNode new_node = new LNode(new_data); 
 
  /* link the old list off the new node */
  new_node.next = head; 

  /* move the head to point to the new node */
  head = new_node; 
} 
 public static void main(String[] args) { 
    
	 _9_Sorted_LinkedList_to_BalancedBST slb= new _9_Sorted_LinkedList_to_BalancedBST();
	 
	 slb.push(3); 
	 slb.push(2); 
	 slb.push(1); 

     System.out.println("Given Linked List "); 

     slb.printList(head); 

     /* Convert List to BST */
     Node root = slb.sortedListToBST(); 
     System.out.println(""); 
     System.out.println("Pre-Order Traversal of constructed BST "); 
     slb.preOrder(root); 
     
     System.out.println();
     System.out.println("==========================");
     slb.push(3); 
	 slb.push(2); 
	 slb.push(1); 
     Node root1=slb.sortedListToBSTRecur(head);
     slb.preOrder(root1); 
     
 } 
	
 /*
    Method 1 (Simple)
Following is a simple algorithm where we first find the middle node of the list and make it the root of the tree to be constructed.

1) Get the Middle of the linked list and make it root.
2) Recursively do same for the left half and right half.
       a) Get the middle of the left half and make it left child of the root
          created in step 1.
       b) Get the middle of right half and make it the right child of the
          root created in step 1.

Time complexity: O(nLogn) where n is the number of nodes in Linked List.
  */
 
 Node sortedListToBSTRecur(LNode node)  
 { 
     if(node==null)
         return null;
      LNode first=node;
  
      LNode reqNode=middle(node);
      
      if(reqNode==node && node.next==null)
      {
    	  Node resNode= new Node(node.val);
    	  return resNode;
      }
      
      LNode middle=reqNode.next;
      
      reqNode.next=null;
      LNode secodHalf=middle.next;
      
      Node root=new Node(middle.val);
      root.left=sortedListToBSTRecur(first);
      root.right=sortedListToBSTRecur(secodHalf);
        		  
      return root; 
 } 
 
	static public LNode middle(LNode head){
        if(head == null || head.next == null){
            return head;
        }
        LNode reqNode=null;
        LNode slow = head;
        LNode fast = head.next;
        while(fast != null && fast.next != null){
        	reqNode=slow;
        	slow = slow.next;
            fast = fast.next.next;
        }
        return reqNode;
    }
 
 
}
