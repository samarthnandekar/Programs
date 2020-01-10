package Array;

public class _35_EquilibriumIndexOfArray {

	int equilibrium(int arr[], int n) 
	{ 
		int sum = 0; // initialize sum of whole array 
		int leftsum = 0; // initialize leftsum 

		/* Find sum of the whole array */
		for (int i = 0; i < n; ++i) 
			sum += arr[i]; 

		for (int i = 0; i < n; ++i) { 
			sum -= arr[i]; // sum is now right sum for index i 

            leftsum += arr[i]; 
            
			if (leftsum == sum) 
				return i; 	
		} 

		/* If no equilibrium index found, then return 0 */
		return -1; 
	} 

    // Driver code 
	public static void main(String[] args) 
	{ 
		_35_EquilibriumIndexOfArray equi = new _35_EquilibriumIndexOfArray(); 
		int arr[] = { 9,2,3,4 }; 
		int arr_size = arr.length; 
		System.out.println("First equilibrium index is " + 
						equi.equilibrium(arr, arr_size)); 
	} 
}
