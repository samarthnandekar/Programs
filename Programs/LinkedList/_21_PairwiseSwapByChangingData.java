package LinkedList;

/*
 https://leetcode.com/problems/swap-nodes-in-pairs/
 
 24. Swap Nodes in Pairs
 
Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

 */
public class _21_PairwiseSwapByChangingData {

	public static void main(String[] args) {

		_1_LinkedList ll = new _1_LinkedList();
		_21_PairwiseSwapByChangingData pwsc = new _21_PairwiseSwapByChangingData();
		Node a = ll.createLinkedListOfSize(5);
		ll.printLinkedList(a);
		pwsc.pairSwap(a);
		ll.printLinkedList(a);
		System.out.println();

		Node b = ll.createLinkedListOfSize(5);
		ll.printLinkedList(b);
		pwsc.pairSwap(b);
		ll.printLinkedList(b);
	}

	void pairSwap(Node node) {
		Node curr = node;
		while (curr != null && curr.next != null) {
			int val = curr.val;
			curr.val = curr.next.val;
			curr.next.val = val;
			curr = curr.next.next;
		}
	}

	void pairSwapRec(Node node) {
		Node curr = node;
		if (node != null && node.next != null) {
			int val = curr.val;
			curr.val = curr.next.val;
			curr.next.val = val;
			curr = curr.next.next;

			pairSwapRec(curr.next.next);
		}
	}

}
