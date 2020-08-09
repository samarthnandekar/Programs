package Queue;

/*
 
 https://www.geeksforgeeks.org/queue-based-approach-for-first-non-repeating-character-in-a-stream/
 
Queue based approach for first non-repeating character in a stream
Given a stream of characters and we have to find first non repeating character each time a character is inserted to the stream.

Examples:

Input  : a a b c
Output : a -1 b b

Input  : a a c
Output : a -1 c


 */

/*
Approach-

1) Create a count array of size 26(assuming only lower case characters are present) and initialize it with zero.
2) Create a queue of char datatype.
3) Store each character in queue and increase its frequency in the hash array.
4) For every character of stream, we check front of the queue.
5) If the frequency of character at the front of queue is one, then that will be the first non repeating character.
6) Else if frequency is more than 1, then we pop that element.
7) If queue became empty that means there are no non repeating character so we will print -1.


 */
public class _6_QBasedFirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
