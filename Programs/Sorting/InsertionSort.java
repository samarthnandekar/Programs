package Sorting;

public class InsertionSort {

	/*Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
	1) insertionSort(arr, n)
	   Loop from i = 1 to n-1.
	   ……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1] 	 */
	
	static void insertionSort(int [] arr)
	{	
	      int n = arr.length; 
	        for (int i=1; i<n; ++i) 
	        { 
	            int key = arr[i]; 
	            int j = i-1; 
	  
	            /* Move elements of arr[0..i-1], that are greater than key, to one position ahead 
	               of their current position */
	            while (j>=0 && arr[j] > key) 
	            { 
	                arr[j+1] = arr[j]; 
	                j = j--; 
	            } 
	            arr[j+1] = key; 
	        } 
	}
	
	public static void main(String [] args)
	{
		
		int [] arr= {10,9,3,2,5,1,0};
		
		insertionSort(arr);
		for(int a:arr)
		{
			System.out.print(a + "  ");
		}
		
	}
}
