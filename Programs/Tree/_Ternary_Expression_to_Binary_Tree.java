package Tree;

/* Convert Ternary Expression to a Binary Tree :- Given a string that contains ternary expressions. The expressions may be nested, 
task is convert the given ternary expression to a binary Tree. Examples:- Input :  string expression =   a?b:c 
Asked In : Facebook Interview
Output :        a
              /  \
             b    c

Input : expression =  a?b?c:d:e
Output :     a
           /  \
          b    e
        /  \
       c    d    *
       
Idea is that we traverse a string make first character as root and do following step recursively .
1. If we see Symbol ‘?’
…….. then we add next character as the left child of root.
2. If we see Symbol ‘:’
…….. then we add it as the right child of current root.
do this process until we traverse all element of “String”.       */

public class _Ternary_Expression_to_Binary_Tree {

	    // Function to convert Ternary Expression to a Binary 
	    // Tree. It return the root of tree 
	    Node convertExpression(char[] expression, Int i) 
	    { 
	        // Base case 
	        if (i.getSec() >= expression.length) 
	            return null; 
	       
	        // store current character of expression_string [ 'a' to 'z'] 
	        Node root = new Node(expression[i.getSec()]); 
	       
	        // Move ahead in str 
	        i.setSec(i.getSec()+1);
	        if(i.getSec()<expression.length && expression[i.getSec()]=='?'){
	        	i.setSec(i.getSec()+1);
	            root.left = convertExpression(expression,i);
	            i.setSec(i.getSec()+1);
	            root.right = convertExpression(expression,i);
	        }
	        
	        return root; 
	    } 
	      
	    // function print tree 
	    public void printTree( Node root) 
	    { 
	        if (root == null) 
	            return; 
	                  
	        System.out.print(root.data +" "); 
	        printTree(root.left); 
	        printTree(root.right); 
	    } 
	      
	    // Driver program to test above function 
	    public static void main(String args[])  
	    { 
	        String exp = "a?b:c?d:e"; 
	       // String exp = "a?b:c"; 
	        
	        _Ternary_Expression_to_Binary_Tree tree = new _Ternary_Expression_to_Binary_Tree(); 
	        char[] expression=exp.toCharArray();  
	        Node root = tree.convertExpression(expression, new Int(0)); 
	        tree.printTree(root) ; 
	    } 
	} 
	  

