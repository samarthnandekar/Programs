package Tree;

import java.util.Scanner;
import java.util.Stack;

public class ExprTree {

	private Node root;
    private Scanner in;
    
    public ExprTree() {
        root = null;
        in = new Scanner(System.in);
    }
    
    /**
     * inorderPrint - uses infix notation to print the expression tree.
     * It calls inorderPrintTree to perform a recursive inorder traversal.
     */
    public void inorderPrint() {
        if (root != null) {
            inorderPrintTree(root);
        }
    }
    
    /*
     * inorderPrintTree - uses infix notation to print the (sub)tree
     * with the specified root.  It makes recursive calls to print the
     * left and right subtrees of the specified root.
     */
    private static void inorderPrintTree(Node root) {
        if (root.isLeaf())
            System.out.print(root.key);
        else {
            // internal node - an operator
            System.out.print("(");
            inorderPrintTree(root.left);
            System.out.print(" " + root.key + " ");
            inorderPrintTree(root.right);
            System.out.print(")");
        }
    }
    
    /**
     * preorderPrint - uses prefix notation to print the expression tree.
     * It calls preorderPrintTree to perform a recursive preorder traversal.
     */
    public void preorderPrint() {
        if (root != null) {
            preorderPrintTree(root);
        }
    }
    
    /*
     * preorderPrintTree - uses prefix notation to print the
     * expression tree that has the specified node as its root.  It
     * prints the tree by performing a recursive preorder traversal.
     */
    private static void preorderPrintTree(Node root) {
        if (root.isLeaf()) {
            System.out.print(root.key);
        } else {
            // interior node -- an operator
            // first the node itself (the root of the subtree)
            switch (root.key) {
                case '+':
                    System.out.print("add"); 
                    break;
                case '-':
                    System.out.print("subtr"); 
                    break;
                case '*':
                    System.out.print("mult"); 
                    break;
                case '/':
                    System.out.print("divide"); 
                    break;
            }
            
            // then the left and right subtrees
            System.out.print("(");
            preorderPrintTree(root.left);
            System.out.print(", ");
            preorderPrintTree(root.right);
            System.out.print(")");
        }
    }
    
    /**
     * postorderPrint - uses postfix notation to print the expression tree.
     * It calls postorderPrintTree to perform a recursive postorder traversal.
     */
    public void postorderPrint() {
        if (root != null) {
            postorderPrintTree(root, 0);
        }
    }
    
    /*
     * postorderPrintTree - uses postfix notation to print the
     * expression tree that has the specified node as its root.  It
     * prints the tree by performing a recursive postorder traversal.
     * The margin argument helps to align the output properly.
     */
    private static void postorderPrintTree(Node root, int margin) {
        if (root.isLeaf()) {
            printMargin(margin);
            System.out.print(root.key + "  ");
        } else {
            postorderPrintTree(root.left, margin + 1);
            postorderPrintTree(root.right, margin + 1);
            
            printMargin(margin);
            switch (root.key) {
                case '+':
                    System.out.print("add above"); 
                    break;
                case '-':
                    System.out.print("subtract above"); 
                    break;
                case '*':
                    System.out.print("multiply above"); 
                    break;
                case '/':
                    System.out.print("divide above"); 
                    break;
            }
        }
    }
    
    /**
     * printMargin - used to print leading spaces when outputting
     * expressions in postfix notation
     */
    private static void printMargin(int margin) {
        System.out.println();
        for (int i = 1; i <= margin; i++) {
            System.out.print("    ");
        }
    }
    
    /**
     * readExpression - parses an arithmetic expression entered at the
     * keyboard and builds an expression tree for the expression.  It
     * calls readTree to recursively process the expression.
     */
    public void read() {
       // root = readTree();
        root=readTree2("(((a+b)*c)+(d-(e/f)))");
        root=readTree3("(((a+b)*c)+(d-(e/f)))");
    }
    
    /*
     * readTree - recursively parses an arithmetic expression obtained
     * from the user and builds a binary tree for the expression.  The
     * root of the tree is returned.   (((a+b)*c)+(d-(e/f)))
     */
    private Node readTree() {
        Node n = new Node();
        
        // get next non-whitespace char
        String currStr= in.findInLine("(\\S)");
        char ch =currStr.charAt(0);
        if ((ch >= 'a') && (ch <='z')) {
            // leaf node
            n.key = ch;
            n.left = null;
            n.right = null;
        } else if (ch == '(') {
            // an expression
            n.left = readTree();
            n.key = in.findInLine("(\\S)").charAt(0);
            n.right = readTree();
            ch = in.findInLine("(\\S)").charAt(0);
            if (ch != ')') {
                System.out.print("EXPECTED ) - } ASSUMED...");
            }
        } else {
            System.out.print("EXPECTED ( - CAN'T PARSE");
            System.exit(1);
        }
        
        return n;
    }
    
    /*
     * Program to read an arithmetic expression, convert it to a tree, and
     * print the tree in infix, prefix, and postfix notation.
     */
    public static void main(String[] args) {

        ExprTree tree = new ExprTree();
        tree.read(); 
        
        // Output it using all three types of notation.
        System.out.println("\n* INFIX NOTATION:");
        tree.inorderPrint();
        System.out.print("\n\n* PREFIX NOTATION:\n");
        tree.preorderPrint();
        System.out.print("\n\n* POSTFIX NOTATION:");
        tree.postorderPrint();
        System.out.println();
        
        Node res=readTree3("(3+((5+9)*2))");
        System.out.println(res.key);
    }
    
    
    // modified 
    static int index=0;
    private Node readTree2(String str) {
        Node n = new Node();
        
        // get next non-whitespace char
        char ch =str.charAt(index);
        if ((ch >= 'a') && (ch <='z')) {
            // leaf node
        	index++;
            n.key = ch;
            n.left = null;
            n.right = null;
        } else if (ch == '(') {
            // an expression
        	index++;
            n.left = readTree2(str);
            n.key = str.charAt(index);
            index++;
            n.right = readTree2(str);
            ch =  str.charAt(index);
            index++;
            if (ch != ')') {
                System.out.print("EXPECTED ) - } ASSUMED...");
            }
        } else {
            System.out.print("EXPECTED ( - CAN'T PARSE");
            System.exit(1);
        }
        return n;
    }
    
    
    // (A+B)
  static  private Node readTree3(String str) {
    	
    	Node root= new Node();
    	Stack<Node> stack= new Stack();
     	int openBr=0;
    	for(int i=0;i<str.length();i++)
    	{
    		char currChar=str.charAt(i);
    		if(currChar==')')
    		{
    			openBr--;
    			if(stack.size()>=3 && openBr>=0)
    			{
    				Node left=stack.pop();
    				Node mid=stack.pop();
    				Node right=stack.pop();
    				mid.left=left;
    				mid.right=right;
    				stack.push(mid);
    			}
    			else {
    				System.out.println("Not valid expression");
    			}
    			
    		}
    		else if(currChar=='(')
    		{
    			openBr++;
    			continue;
    		}
    		else
    		{
    			Node node=new Node(currChar);	
    			stack.push(node);
    		}
    	}
    	return root=stack.pop();	
    }
}
