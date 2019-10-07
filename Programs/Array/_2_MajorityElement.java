package Array;
/*

Majority Element
Write a function which takes an array and prints the majority element (if it exists), otherwise prints “No Majority Element”.
A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

Examples :
Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
Output : 4 

Input : {3, 3, 4, 2, 4, 4, 2, 4}
Output : No Majority Element

*/

/*
 METHOD 1 (Basic)
The basic solution is to have two loops and keep track of maximum count for all different elements. If maximum count becomes
greater than n/2 then break the loops and return the element having maximum count. If maximum count doesn’t become more than n/2 
then majority element doesn’t exist.

Time Complexity : O(n*n).
Auxiliary Space : O(1).


METHOD 2 (Using Binary Search Tree)
Insert elements in BST one by one and if an element is already present then increment the count of the node. At any stage, if count
of a node becomes more than n/2 then return. The method works well for the cases where n/2+1 occurrences of the majority element
is present in the starting of the array, for example {1, 1, 1, 1, 1, 2, 3, 4}.

Time Complexity : If a Binary Search Tree is used then time complexity will be O(n^2). If a self-balancing-binary-search tree is
used then O(nlogn)
Auxiliary Space : O(n)
 
 
METHOD 3 (Using Moore’s Voting Algorithm)

1. Finding a Candidate :
2. Check if the element obtained in step 1 is majority element or not :

printMajority (a[], size)
1.  Find the candidate for majority
2.  If candidate is majority. i.e., appears more than n/2 times.
       Print the candidate
3.  Else
       Print "No Majority Element"


 */

public class _2_MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// method 1
	static void findMajority(int arr[], int n)  
	{  
	    int maxCount = 0;  
	    int index = -1; // sentinels  
	    for(int i = 0; i < n; i++)  
	    {  
	        int count = 0;  
	        for(int j = 0; j < n; j++)  
	        {  
	            if(arr[i] == arr[j])  
	            count++;  
	        }  
	        // update maxCount if count of  current element is greater  
	        if(count > maxCount)  
	        {  
	            maxCount = count;  
	            index = i;  
	        }  
	    }  
	    // if maxCount is greater than n/2  return the corresponding element  
	    if (maxCount > n/2)  
	    System.out.println (arr[index]);  
	    else
	    System.out.println ("No Majority Element");  
	}  
	  
	 //  method 3   , moore's voting algorithm
	void printMajority(int a[], int size)  
    { 
        /* Find the candidate for Majority*/
        int cand = findCandidate(a, size); 
  
        /* Print the candidate if it is Majority*/
        if (isMajority(a, size, cand)) 
            System.out.println(" " + cand + " "); 
        else 
            System.out.println("No Majority Element"); 
    } 
  
    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size)  
    { 
        int maj_index = 0, count = 1; 
        int i; 
        for (i = 1; i < size; i++)  
        { 
            if (a[maj_index] == a[i]) 
                count++; 
            else
                count--; 
            if (count == 0) 
            { 
                maj_index = i; 
                count = 1; 
            } 
        } 
        return a[maj_index]; 
    } 
  
    /* Function to check if the candidate occurs more than n/2 times */
    boolean isMajority(int a[], int size, int cand)  
    { 
        int i, count = 0; 
        for (i = 0; i < size; i++)  
        { 
            if (a[i] == cand) 
                count++; 
        } 
        if (count > size / 2)  
            return true; 
        else
            return false; 
    } 
}
