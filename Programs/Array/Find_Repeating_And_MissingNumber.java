/** 
@Author  - sn656
Creation - Date Dec 6, 2018 3:38:06 PM

*/

package Microsoft;

/**
  Link :- https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
  
  Find the repeating and the missing | Added 3 new methods
  Given an unsorted array of size n. Array elements are in range from 1 to n. One number from set {1, 2, …n} is missing and one number occurs twice in array. Find these two numbers.

Examples:-
  arr[] = {3, 1, 3}
  Output: 2, 3   // 2 is missing and 3 occurs twice 

  arr[] = {4, 3, 6, 2, 1, 1}
  Output: 1, 5  // 5 is missing and 1 occurs twice 
 
Method 1 (Use Sorting)
1) Sort the input array.
2) Traverse the array and check for missing and repeating.
Time Complexity: O(nLogn)


Method 2 (Use count array)
1) Create a temp array temp[] of size n with all initial values as 0.
2) Traverse the input array arr[], and do following for each arr[i]
……a) if(temp[arr[i]] == 0) temp[arr[i]] = 1;
……b) if(temp[arr[i]] == 1) output “arr[i]” //repeating
3) Traverse temp[] and output the array element having value as 0 (This is the missing element)

Time Complexity: O(n)
Auxiliary Space: O(n)

Method 3 (Use elements as Index and mark the visited places)
Traverse the array. While traversing, use absolute value of every element as index and make the value at this
index as negative to mark it visited. If something is already marked negative then this is the repeating element. 
To find missing, traverse the array again and look for a positive value.


*/
public class Find_Repeating_And_MissingNumber 
{

	static void printTwoElements(int arr[], int size) 
    { 
        int i; 
        System.out.print("The repeating element is "); 
  
        for (i = 0; i < size; i++) { 
            int abs_val = Math.abs(arr[i]); 
            if (arr[abs_val - 1] > 0) 
                arr[abs_val - 1] = -arr[abs_val - 1]; 
            else
                System.out.println(abs_val); 
        } 
  
        System.out.print("And the missing element is "); 
        for (i = 0; i < size; i++) { 
            if (arr[i] > 0) 
                System.out.println(i + 1); 
        } 
    } 
  
    /* Driver program to test above function */
    public static void main(String[] args) 
    { 
        int arr[] = { 7, 3, 4, 5, 5, 6, 2 }; 
        int n = arr.length; 
        printTwoElements(arr, n); 
    } 
	
	
}

/*
Output:- 
The repeating element is 5 
and the missing element is 1

Time Complexity: O(n)
*/
