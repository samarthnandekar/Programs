package Queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 https://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/
 
An Interesting Method to Generate Binary Numbers from 1 to n
Given a number n, write a function that generates and prints all binary numbers with decimal values from 1 to n.

Examples:
Input: n = 2
Output: 1, 10

Input: n = 5
Output: 1, 10, 11, 100, 101

Following is an interesting method that uses queue data structure to print binary numbers.
1) Create an empty queue of strings
2) Enqueue the first binary number “1” to queue.
3) Now run a loop for generating and printing n binary numbers.
……a) Dequeue and Print the front of queue.
……b) Append “0” at the end of front item and enqueue it.
……c) Append “1” at the end of front item and enqueue it.

*/

public class _3_GenerateBinaryNumbers {

	public static void main(String[] args) {
		
		int n=6;
        generatePrintBinary(n);
	}
	
	static void generatePrintBinary(int n) 
    { 
        // Create an empty queue of strings 
        Queue<String> q = new LinkedList<String>(); 
          
        // Enqueue the first binary number 
        q.add("1"); 
          
        // This loops is like BFS of a tree with 1 as root 0 as left child and 1 as right child and so on 
        while(n-- > 0) 
        { 
            // print the front of queue 
            String s1 = q.peek(); 
            q.remove(); 
            System.out.println(s1); 
              
            // Store s1 before changing it 
            String s2 = s1; 
              
            // Append "0" to s1 and enqueue it 
            q.add(s1 + "0"); 
              
            // Append "1" to s2 and enqueue it. Note that s2 contains the previous front 
            q.add(s2 + "1"); 
        } 
    } 

}
