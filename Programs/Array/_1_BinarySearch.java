package Array;

public class _1_BinarySearch {

	 public static void main(String args[]) 
	    { 
		 _1_BinarySearch ob = new _1_BinarySearch(); 
	        int arr[] = { 2, 3, 4, 10, 40 }; 
	        int n = arr.length; 
	        int x = 10; 
	        int result = ob.binarySearch(arr, 0, n - 1, x); 
	        if (result == -1) 
	            System.out.println("Element not present"); 
	        else
	            System.out.println("Element found at index " + result); 
	        
	        int re=ob.binarySearchItr(arr,x);
	        System.out.println(re);
	    } 
	 
	int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r < l) 
          return -1; 
  
        int mid=(l+r)/2;
            // If the element is present at the middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present in right subarray 
            return binarySearch(arr, mid + 1, r, x);     
    } 
	
	int binarySearchItr(int arr[], int x) 
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = (l + r)/ 2; 
  
            // Check if x is present at mid 
            if (arr[m] == x) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m] < x) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
        
        return -1;
}
}