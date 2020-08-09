package Stack;

import java.util.Stack;

/*
 https://www.geeksforgeeks.org/delete-middle-element-stack/
 
Given a stack with push(), pop(), empty() operations, delete middle of it without using any additional data structure.

Input  : Stack[] = [1, 2, 3, 4, 5]
Output : Stack[] = [1, 2, 4, 5]

Input  : Stack[] = [1, 2, 3, 4, 5, 6]
Output : Stack[] = [1, 2, 4, 5, 6]


 */
public class _1_DeleteMiddleElementOfStack {

    public static void main(String args[])  
    { 
        Stack<Character> st = new Stack<Character>(); 
        st.push('1'); 
        st.push('2'); 
        st.push('3'); 
        st.push('4'); 
        st.push('5'); 
        st.push('6'); 
      
        deleteMid(st, st.size(), 0); 
      
        // Printing stack after deletion of middle. 
        while (!st.empty()) 
        { 
            char p=st.pop(); 
            System.out.print(p + " "); 
        } 
        System.out.println();
        System.out.println("=========================");
        Stack<Character> st1 = new Stack<Character>(); 
        st1.push('1'); 
        st1.push('2'); 
        st1.push('3'); 
        st1.push('4'); 
        st1.push('5'); 
        st1.push('6'); 
       int n=st1.size()/2;
        deleteMid_1(st1, n, 0); 
      
        // Printing stack after deletion of middle. 
        while (!st1.empty()) 
        { 
            char p=st1.pop(); 
            System.out.print(p + " "); 
        }
        
        System.out.println();
        System.out.println("=========================");
        Stack<Character> st2 = new Stack<Character>(); 
        st2.push('1'); 
        st2.push('2'); 
        st2.push('3'); 
        st2.push('4'); 
        st2.push('5'); 
        st2.push('6'); 
        int n2=st1.size()/2;
        deleteMid_2(st2, n, 0); 
      
        // Printing stack after deletion of middle. 
        while (!st2.empty()) 
        { 
            char p=st2.pop(); 
            
            
            System.out.print(p + " "); 
        } 
        
        
    } 
	
    // Deletes middle of stack of size n. Curr is current item number 
    static void deleteMid(Stack<Character> st, int n, int curr) 
    { 
          
        // If stack is empty or all items are traversed 
        if (st.empty() || curr == n) 
            return; 
          
        // Remove current item 
        char x = st.pop(); 
          
        // Remove other items 
        deleteMid(st, n, curr+1); 
          
        // Put all items back except middle 
        if (curr != n/2) 
            st.push(x); 
    } 
    
 // Deletes middle of stack of size n. Curr is current item number 
    static void deleteMid_1(Stack<Character> st, int n,int curr) 
    {
    	 // If stack is empty or all items are traversed 
        if (st.empty()) 
            return; 
          
        // Remove current item 
        char x = st.pop(); 
          
        // Remove other items 
        deleteMid_1(st, n,curr+1); 
        
        if(curr!=n)
        {
        	 st.push(x);
        }
    }
    
 // Deletes middle of stack of size n. Curr is current item number 
    static void deleteMid_2(Stack<Character> st, int n,int curr) 
    {
    	 // If stack is empty or all items are traversed 
        if (n==curr) 
        {
        	st.pop();
        	return;
        }
          
        // Remove current item 
        char x = st.pop(); 
          
        // Remove other items 
        deleteMid_2(st, n,curr+1); 
        
        st.push(x);
        
    }
    
    }
   

