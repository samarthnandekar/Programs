package Recursion;

import java.util.*;


public class Program1 {

		public static void main(String args[]) 
		{ 
		  fun1(5);
		} 
		
    static void fun1(int n)
	{

	if (n > 1) 
		fun1(n-1); 
	
	for (int i = 0; i < n; i++) 
	{
	    System.out.print(" * "); 
	}
	System.out.println();	
	
	}
	
}
