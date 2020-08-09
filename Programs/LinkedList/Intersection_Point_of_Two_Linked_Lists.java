/** 
@Author  - sn656
Creation - Date Dec 12, 2018 3:26:50 PM

*/

package Microsoft;

/**
https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

 There are two singly linked lists in a system. By some programming error, the end node of one of the linked list
 got linked to the second list, forming an inverted Y shaped list. Write a program to get the point where two linked list merge.


 */
public class Intersection_Point_of_Two_Linked_Lists 
{

	/* Method 1:-Simply use two loops
	Use 2 nested for loops. The outer loop will be for each node of the 1st list and inner loop will be for 2nd list. In the inner loop,
	check if any of nodes of the 2nd list is same as the current node of the first linked list. The time complexity of this method will be O(mn)
	where m and n are the numbers of nodes in two lists.     */
	
	/* Method 2:- CTC solution 	 
	 
	  1) Find the length of list1 and list 2
	  2) Check last element is same then there is intersection else no intersection
	  3) ......
	 
	  */
	

	
	/* Method 3 :- Use Hashing
	Basically, we need to find a common node of two linked lists. So we hash all nodes of the first list and then check the second list.
	1) Create an empty hash table such that node address is used as key and a binary value present/absent is used as the value.
	2) Traverse the first linked list and insert all nodes’ addresses in the hash table.
	3) Traverse the second list. For every node check if it is present in the hash table. If we find a node in the hash table, return the node. */
	
	
	

}

