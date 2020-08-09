/** 
@Author  - sn656
Creation - Date Dec 1, 2018 9:22:47 PM

*/
package Maths;
// Microsoft;

/** Link :- https://www.geeksforgeeks.org/find-two-rectangles-overlap/

	Find if two rectangles overlap
	Given two rectangles, find if the given two rectangles overlap or not.
	
	Note that a rectangle can be represented by two coordinates, top left and bottom right. So mainly we are given following four coordinates.
	l1: Top Left coordinate of first rectangle.
	r1: Bottom Right coordinate of first rectangle.
	l2: Top Left coordinate of second rectangle.
	r2: Bottom Right coordinate of second rectangle.
	

	Note : It may be assumed that the rectangles are parallel to the coordinate axis.

https://www.hackerearth.com/practice/notes/how-to-check-if-two-rectangles-intersect-or-not/

Given two rectangles R1 and R2 . It is easy to visualize that the given two rectangles can not be intersect if one of the following conditions is true.

Condition 1: When left edge of R1 is on the right of R2's right edge. ( That is , R1 is completely on the right of R2).
Condition 2: When right edge of R1 is on the left of R2's left edge. ( That is , R1 is completely on the left of R2).
Condition 3: When top edge of R1 is on bottom of R2's bottom edge ( That is , R1 is completely under R2).
Condition 4: When bottom edge of R1 is on top of R2's top edge ( That is , R1 is completely over R2).


 */
public class Two_Rectangles_Overlap {
    
	static class Point
	{ 
		  
	    int x, y; 
	} 
	
	// Returns true if two rectangles (l1, r1) and (l2, r2) overlap  
	 static  boolean doOverlap(Point l1, Point r1, Point l2, Point r2)
	 { 
	        // If one rectangle is on left side of other  
	        if (l1.x > r2.x || l2.x > r1.x) { 
	            return false; 
	        } 
	  
	        // If one rectangle is above other  
	        if (l1.y < r2.y || l2.y < r1.y) { 
	            return false; 
	        } 
	  
	        return true; 
	    } 
	  
	    /* Driver program to test above function */
	    public static void main(String[] args) 
	    { 
	        Point l1 = new Point(),r1 = new Point(), 
	              l2 = new Point(),r2 = new Point();
	        
	         l1.x=0;l1.y=10; r1.x=10;r1.y=0; 
	         l2.x=5;l2.y=5; r2.x=15;r2.y=0; 
	  
	        if (doOverlap(l1, r1, l2, r2)) { 
	            System.out.println("Rectangles Overlap"); 
	        } else { 
	            System.out.println("Rectangles Don't Overlap"); 
	        } 
	    } 
	
	    /*
	     Output:- Rectangles Overlap
		 Time Complexity of above code is O(1) as the code doesn’t have any loop or recursion.

	     */
	
}



