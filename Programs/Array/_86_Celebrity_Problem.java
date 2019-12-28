package Array;

import java.util.Stack;

import javax.swing.plaf.nimbus.State;

/*
 
 The Celebrity Problem
In a party of N people, only one person is known to everyone. Such a person may be present in the party, if yes,
 (s)he doesn’t know anyone in the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in minimum number of questions.

We can describe the problem input as an array of numbers/characters representing persons in the party. We also have
 a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.
 
   		A	B	C	D
     A  0   0   1   0
     B  0   0   1   0
     C  0   0   0   0     
     D  0   0   1   0
     
  By this matix, from first row, we can say A knows C. B knows C and D knows C.
  
Method 3 (Using Stack)
We have following observation based on elimination technique (Refer Polya’s How to Solve It book).
	1. If A knows B, then A can’t be celebrity. Discard A, and B may be celebrity.
	2. If A doesn’t know B, then B can’t be celebrity. Discard B, and A may be celebrity.
	3. Repeat above two steps till we left with only one person.
	4. Ensure the remained person is celebrity. (Why do we need this step?)

We can use stack to verity celebrity.
	1. Push all the celebrities into a stack.
	2. Pop off top two persons from the stack, discard one person based on return status of HaveAcquaintance(A, B).
	3. Push the remained person onto stack.
	4. Repeat step 2 and 3 until only one person remains in the stack.
	5. Check the remained person in stack doesn’t have acquaintance with anyone else.
 */
public class _86_Celebrity_Problem {

	 static int MATRIX[][] =   {{ 0, 0, 1, 0 }, 
			 					{ 0, 0, 1, 0 }, 
			 					{ 0, 0, 0, 0 },  
			 					{ 0, 0, 1, 0 }}; 

		// Returns true if a knows b, false otherwise 
		static boolean knows(int a, int b)  
		{ 
			boolean res = (MATRIX[a][b] == 1) ?  true : false; 
			return res; 
		} 

		// Returns -1 if celebrity is not present. If present, returns id (value from 0 to n-1). 
		static int findCelebrity(int n)  
		{ 
			Stack<Integer> st = new Stack<>(); 
			int c; 		
			for (int i = 0; i < n; i++)   	// Step 1 :Push everybody onto stack 
			{ 
			  st.push(i); 
			} 

			while (st.size() > 1)  
			{ 
			// Step 2 :Pop off top  two persons from the  
			// stack, discard one  person based on return status of knows(A, B). 
			int a = st.pop(); 
			int b = st.pop(); 
			
			// Step 3 : Push the remained person onto stack. 
			if (knows(a, b))  
			{ 
			 st.push(b); 
			}			
			else
			 st.push(a); 
			} 
			
			c = st.pop(); 
			
			// Step 5 : Check if the last person is celebrity or not 
			for (int i = 0; i < n; i++)  
			{ 
			// If any person doesn't  know 'c' or 'a' doesn't know any person, return -1 
			if (i != c && (knows(c, i) || !knows(i, c))) 
			 return -1; 
			} 
			return c; 
} 

	// Driver Code 
	public static void main(String[] args)  
	{ 
		int n = 4; 
		int result = findCelebrity(n); 
		if (result == -1)  
		{ 
		System.out.println("No Celebrity"); 
		}  
		else
		System.out.println("Celebrity ID " +  result); 
	} 
	
	/* Method 4 (Using two Pointers)
	The idea is to use two pointers, one from start and one from the end. Assume the start person is A, and the end person is B. 
	If A knows B, then A must not be the celebrity. Else, B must not be the celebrity. We will find a celebrity candidate at the 
	end of the loop. Go through each person again and check whether this is the celebrity. 
	*/
	
	// Returns -1 if celebrity is not present. If present, returns id (value from 0 to n-1). 
    static int findCelebrity2(int n)  
    { 
        // Initialize two pointers as two corners 
        int a = 0; 
        int b = n - 1; 
          
        // Keep moving while the two pointers don't become same. 
        while (a < b)  
        { 
            if (knows(a, b)) 
                a++; 
            else
                b--; 
        } 
  
        // Check if a is actually a celebrity or not 
        for (int i = 0; i < n; i++)  
        { 
            // If any person doesn't know 'a' or 'a' doesn't know any person, return -1 
            if (i != a && (knows(a, i) || !knows(i, a))) 
                return -1; 
        } 
        return a; 
    } 
} 


