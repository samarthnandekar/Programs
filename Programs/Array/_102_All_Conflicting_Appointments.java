package Array;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
Given n appointments, find all conflicting appointments.

Examples:
Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
Output: Following are conflicting intervals
[3,7] Conflicts with [1,5]
[2,6] Conflicts with [1,5]
[5,6] Conflicts with [3,7]
[4,100] Conflicts with [1,5]
An appointment is conflicting, if it conflicts with any of the previous appointments in array.

*/

/*
 
 A Simple Solution is to one by one process all appointments from second appointment to last. For every appointment i, check if it conflicts with
 i-1, i-2, … 0. The time complexity of this method is O(n2).

 We can use Interval Tree to solve this problem in O(nLogn) time. Following is detailed algorithm.
 1) Create an Interval Tree, initially with the first appointment.
 2) Do following for all other appointments starting from the second one.
   a) Check if the current appointment conflicts with any of the existing appointments in Interval Tree.  If conflicts, then print the current
     appointment.  This step can be done O(Logn) time.
   b) Insert the current appointment in Interval Tree. This step also can be done O(Logn) time.

 */


public class _102_All_Conflicting_Appointments
 {

	public static void main(String []args)
	{
		Interval appt[] = {new Interval(1,2), new Interval(3,7),new Interval(2,6), new Interval(10,15), new Interval(5,6), new Interval(4,100)};
		int n=appt.length;
		printConflicting(appt, n); 
	}
	 
	static ITNode newNode(int start, int end) 
	{ 
	    ITNode temp = new ITNode(); 
	    temp.i = new Interval(start,end); 
	    temp.max = end;  
	    
	    return temp;
	}
	  
	// A utility function to insert a new Interval Search Tree Node. This is similar to BST Insert.  Here the low value 
	// of interval is used tomaintain BST property 
	static ITNode insert(ITNode root, Interval i) 
	{ 
	    // Base case: Tree is empty, new node becomes root 
	    if (root == null) 
	        return newNode(i.start,i.end); 
	  
	    // Get low value of interval at root 
	    int l = root.i.start; 
	  
	    // If root's low value is smaller, then new interval goes to left subtree 
	    if (i.start < l) 
	        root.left = insert(root.left, i); 
	  
	    // Else, new node goes to right subtree. 
	    else
	        root.right = insert(root.right, i); 
	  
	    // Update the max value of this ancestor if needed 
	    if (root.max < i.end) 
	        root.max = i.end; 
	  
	    return root; 
	} 
	  
	// A utility function to check if given two intervals overlap 
	static boolean doOVerlap(Interval i1, Interval i2) 
	{ 
	    if (i1.start < i2.end && i2.start < i1.end) 
	        return true; 
	    return false; 
	} 
      
	// The main function that searches a given interval i in a given Interval Tree. 
	static Interval  overlapSearch(ITNode root, Interval i) 
	{ 
	    // Base Case, tree is empty 
	    if (root == null) 
	    	return null; 
	  
	    // If given interval overlaps with root 
	    if (doOVerlap((root.i), i)) 
	        return root.i; 
	  
	    // If left child of root is present and max of left child is greater than or equal to given interval, then i may 
	    // overlap with an interval is left subtree 
	    if (root.left != null && root.left.max >= i.start) 
	        return overlapSearch(root.left, i); 
	  
	    // Else interval can only overlap with right subtree 
	    return overlapSearch(root.right, i); 
	} 
	  
	// This function prints all conflicting appointments in a given array of apointments. 
	static void printConflicting(Interval appt[], int n) 
	{ 
	     // Create an empty Interval Search Tree, add first appointment 
	     ITNode root = null; 
	     root = insert(root, appt[0]); 
	  
	     // Process rest of the intervals 
	     for (int i=1; i<n; i++) 
	     { 
	         // If current appointment conflicts with any of the existing intervals, print it 
	         Interval res = overlapSearch(root, appt[i]); 
	         if (res != null) 
	            System.out.println("[" + appt[i].start + "," + appt[i].end +"] Conflicts with ["+res.start+","+ res.end +"]"); 
	  
	         // Insert this appointment 
	         root = insert(root, appt[i]); 
	     } 
	}   
 }

class ITNode
{
	Interval i;
	int max;
	ITNode left, right;
	
	
}


