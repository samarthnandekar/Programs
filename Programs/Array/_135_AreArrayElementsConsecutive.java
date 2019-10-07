package Array;

/*
Check if array elements are consecutive
Given an unsorted array of numbers, write a function that returns true if array consists of consecutive numbers.

Examples: 
a) If array is {5, 2, 3, 1, 4}, then the function should return true because the array has consecutive numbers from 1 to 5.
b) If array is {83, 78, 80, 81, 79, 82}, then the function should return true because the array has consecutive numbers from 78 to 83.
c) If the array is {34, 23, 52, 12, 3 }, then the function should return false because the elements are not consecutive.
d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false because 5 and 5 are not consecutive.

Method 1 (Use Sorting)
1) Sort all the elements.
2) Do a linear scan of the sorted array. If the difference between current element and next element is anything other than 1, then return false.
   If all differences are 1, then return true.

Time Complexity: O(nLogn)


Method 2:- o(n)
 1) 

*/


public class _135_AreArrayElementsConsecutive
{
	// work only for positive values, but take it as one learning point.
	public boolean areConsecutive(int input[]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i < input.length; i++){
            if(input[i] < min){
                min = input[i];
            }
        }
        for(int i=0; i < input.length; i++){
            if(Math.abs(input[i]) - min >= input.length){
                return false;
            }
            if(input[Math.abs(input[i]) - min] < 0){
                return false;
            }
            input[Math.abs(input[i]) - min] = -input[Math.abs(input[i]) - min];
        }  
        return true;
    }
    
    public static void main(String args[]){
        int input[] = {76,78,76,77,73,74};
        _135_AreArrayElementsConsecutive cia = new _135_AreArrayElementsConsecutive();
        System.out.println(cia.areConsecutive(input));
        System.out.println(cia.areConsecutive(input,input.length));
        System.out.println("------------------------------------");
        
        int input1[] = {5,2,3,1,4};
        System.out.println(cia.areConsecutive(input1));
        System.out.println(cia.areConsecutive(input1,input1.length));
        System.out.println("------------------------------------");
        
        int input2[] = {51,55,50,52,54,53};
        System.out.println(cia.areConsecutive(input2));
        System.out.println(cia.areConsecutive(input2,input2.length));
        System.out.println("------------------------------------");
        
        int input3[] = {51,55,50,52,54,52};
        System.out.println(cia.areConsecutive(input3));
        System.out.println(cia.areConsecutive(input3,input3.length));
        System.out.println("------------------------------------");
        
        int input4[] = {-51,-55,-50,-52,-54,-53};
        System.out.println(cia.areConsecutive(input4));
        System.out.println(cia.areConsecutive(input4,input4.length));
    }
    
	boolean areConsecutive(int arr[], int n) 
	{ 
		if (n < 1) 
			return false; 

		int min = getMin(arr, n); 
		int max = getMax(arr, n); 

		/* 3) max - min + 1 is equal to n, then only check all elements */
		if (max - min + 1 == n) 
		{ 
			boolean visited[] = new boolean[n]; 
			int i; 
			for (i = 0; i < n; i++) 
			{ 
				/* If we see an element again, then return false */
				if (visited[arr[i] - min] != false) 
					return false; 

				/* If visited first time, then mark the element as visited */
				visited[arr[i] - min] = true; 
			} 
			
			/* If all elements occur once, then return true */
			return true; 
		} 
		return false; // if (max - min + 1 != n) 
	} 

	int getMin(int arr[], int n) 
	{ 
		int min = arr[0]; 
		for (int i = 1; i < n; i++) 
		{ 
			if (arr[i] < min) 
				min = arr[i]; 
		} 
		return min; 
	} 

	int getMax(int arr[], int n) 
	{ 
		int max = arr[0]; 
		for (int i = 1; i < n; i++) 
		{ 
			if (arr[i] > max) 
				max = arr[i]; 
		} 
		return max; 
	} 
}
