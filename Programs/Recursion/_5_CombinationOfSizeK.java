package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/

  Print all possible combinations of r elements in a given array of size n
  Given an array of size n, generate and print all possible combinations of r elements in array. For example, if input array is {1, 2, 3, 4} and r is 2, 
  then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.


 */
public class _5_CombinationOfSizeK {

	 public static void main(String args[]){
		 _5_CombinationOfSizeK kk = new _5_CombinationOfSizeK();
	        int arr[] = {1,2,3,4};
	        kk.combination(arr, 2);
	        System.out.println("************");
	        printCombination(arr,arr.length,2);
	        
	        System.out.println("++++++++++++");
	        ansmakeCombi(4,2);
	    }
	 
	public void combination(int arr[],int k){
        int result[] = new int[k];
        Arrays.sort(arr);
        combinationUtil1(arr,k,0,result,0);
    }

    private void combinationUtil1(int arr[],int k, int pos,int result[],int start){
        if(pos == k){
            for(int i=0; i < k; i++){
                System.out.print(result[i] + " ");
            }
            System.out.print("\n");
            return;
        }
        for(int i=start; i < arr.length; i++)
        {
        	if(i+1<arr.length && arr[i] == arr[i+1])
        		continue;
            result[pos] = arr[i];
            combinationUtil1(arr,k,pos+1,result,i+1);
        }
    }
    
      // Method 2
	  static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) 
	{ 
		// Current combination is ready to be printed, print it 
		if (index == r) 
		{ 
		for (int j=0; j<r; j++) 
		System.out.print(data[j]+" "); 
		System.out.println(""); 
		return; 
		} 
	
		// When no more elements are there to put in data[] 
		if (i >= n) 
		return; 
		
		while (i+1<arr.length && arr[i] == arr[i+1])
            i++; 
		
		// current is included, put next at next location 
		data[index] = arr[i]; 
		combinationUtil(arr, n, r, index+1, data, i+1); 
		
		// current is excluded, replace it with next (Note that i+1 is passed, but index is not changed) 
		combinationUtil(arr, n, r, index, data, i+1); 
	} 
	
	// The main function that prints all combinations of size r in arr[] of size n. This function mainly uses combinationUtil() 
	static void printCombination(int arr[], int n, int r) 
	{ 
	// A temporary array to store all combination one by one 
	int data[]=new int[r]; 
	
	// Print all combination using temprary array 'data[]' 
	Arrays.sort(arr);
	combinationUtil(arr, n, r, 0, data, 0); 
	} 
	
	// method3  -> not working need to fix it
	static void makeCombiUtil(List<List<Integer>> ans, List<Integer> tmp, int n, int left, int k) 
		{ 
		    // Pushing this vector to a vector of vector 
		    if (k == 0) { 
		        ans.add(tmp); 
		        return; 
		    } 
		  
		    // i iterates from left to n. First time left will be 1 
		    for (int i = left; i <= n; ++i) 
		    { 
		        tmp.add(i); 
		        makeCombiUtil(ans, tmp, n, i + 1, k - 1); 
		  
		        // Popping out last inserted element from the vector 
		        tmp.remove(tmp.size()-1); 
		    } 
		} 
		  
		// Prints all combinations of size k of numbers from 1 to n. 
	static List<List<Integer>> ansmakeCombi(int n, int k) 
		{ 
	
		List<List<Integer>> ans =new ArrayList<>() ; 
		
		List<Integer> tmp= new ArrayList<Integer>(); 
		    makeCombiUtil(ans, tmp, n, 1, k); 
		    
		    ans.forEach(items->System.out.println(items));
		    return ans; 
		} 
}
