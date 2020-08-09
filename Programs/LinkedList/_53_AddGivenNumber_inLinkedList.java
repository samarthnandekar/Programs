package LinkedList;

import java.util.List;
import java.util.Stack;

// add recursive and iterrative approach both

/*

Given a non-negative integer represented as non-empty a singly linked list of digits, add given to the last node.
You may assume the integer do not contain any leading zero, except the number 0 itself.
The digits are stored such that the most significant digit is at the head of the list.

Example:

Input:  1-> 2-> 3 , n= 7
Output: 1-> 3-> 0

Input    9 ---> 9 ---> 9 ---> 9  , n=7
output:- 1 ---> 0 ---> 0 ---> 0 ---> 6

Input    9 ---> 9 ---> 9 ---> 9  , n=30
output:- 1 ---> 0 ---> 0 ---> 2 ---> 9

 */
public class _53_AddGivenNumber_inLinkedList {

	static int addWithCarry(Node head, int num) {
		if (head == null)
			return num;

		int res = head.val + addWithCarry(head.next, num);

		head.val = res % 10;
		return res / 10;
	}

	static Node addGivenNumber(Node head, int num) {
		int carry = addWithCarry(head, num);

		if (carry > 0) {
			Node newNode = new Node(carry);
			newNode.next = head;
			head = newNode;
		}
		return head;
	}

	public static Node plusGivenNumber(Node head, int num) {

		if (head == null)
			return null;

		Stack<Node> stack = new Stack<Node>();
		Node node = head;
		while (node != null) {
			stack.push(node);
			node = node.next;
		}

		Node finalNode = null;

		int carry = 0;

		int currVal = stack.peek().val;
		int sum = currVal + num;
		stack.pop().val = sum % 10;
		carry = sum / 10;

		while (!stack.isEmpty()) {
			currVal = stack.peek().val;
			sum = currVal + carry;
			stack.pop().val = sum % 10;
			carry = sum / 10;
		}
		finalNode = new Node(carry);
		finalNode.next = head;
		return finalNode;
	}

	public static void main(String[] args) {
		Node n1 = new Node(9);
		Node n2 = new Node(9);
		n1.next = n2;
		Node n3 = new Node(9);
		n2.next = n3;
		Node n4 = new Node(9);
		n3.next = n4;

		_1_LinkedList list = new _1_LinkedList();
		list.printLinkedList(n1);
		int num = 30;

		Node addOne = addGivenNumber(n1, num);
		list.printLinkedList(addOne);

		Node finalNode = plusGivenNumber(n1, num);
		list.printLinkedList(finalNode);

	}

}
