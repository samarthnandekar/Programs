package Array;

/**
 * http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 * Given an array of size n, the array contains numbers in range from 0 to k-1 
 * where k is a positive integer and k <= n. Find the maximum repeating number in this array
 */
public class _98_MaxRepeatingNumber {

	public int maxRepeatingNumber(int arr[], int k){
        int len = k;
        for(int i=0;  i < arr.length; i++){
            arr[arr[i]%len] += len;
        }
        int maxRepeating = 0;
        int maxRepeatingIndex =0;
        for(int i=0; i < len; i++){
            if(maxRepeating < arr[i]){
                maxRepeating = arr[i];
                maxRepeatingIndex = i;
            }
        }
        return maxRepeatingIndex;
    }
    
    public static void main(String args[]){
    	_98_MaxRepeatingNumber mrn = new _98_MaxRepeatingNumber();
        int arr[] = {2,2,2,1,3,1,2,2,3,0,2,0,4,5,4,4,4,4};
        System.out.println(mrn.maxRepeatingNumber(arr, 6));
    }
}
