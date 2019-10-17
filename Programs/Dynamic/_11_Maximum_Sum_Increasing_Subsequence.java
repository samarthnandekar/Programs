package Dynamic;

/*

 int []arr={4,6,1,3,8,4,6}
 
 Increasing sub sequence 1,3,4,6
 Maximum sum increasing Subsequene - 4, 6, 8
 
 https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/ ?

 */


public class _11_Maximum_Sum_Increasing_Subsequence {

	 public int maxSum(int arr[]){
	        int T[] = new int[arr.length];

	        for (int i = 0; i < T.length; i++) {
	            T[i] = arr[i];
	        }

	        for(int i=1; i < T.length; i++){
	            for(int j = 0; j < i; j++){
	                if(arr[j] < arr[i]){
	                    T[i] = Math.max(T[i], T[j] + arr[i]);
	                }
	            }
	        }

	        int max = T[0];
	        for (int i=1; i < T.length; i++){
	            if(T[i] > max){
	                max = T[i];
	            }
	        }
	        return max;
	    }
	    
	    public static void main(String args[]){
	    	_11_Maximum_Sum_Increasing_Subsequence mss = new _11_Maximum_Sum_Increasing_Subsequence();
	        int arr[] = {1, 101, 10, 2, 3, 100,4};
	        int r = mss.maxSum(arr);
	        System.out.print(r);
	    }

}
