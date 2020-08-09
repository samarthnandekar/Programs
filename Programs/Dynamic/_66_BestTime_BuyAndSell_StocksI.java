package Dynamic;

/*

 Say you have an array, A, for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (i.e, buy one and sell one share of the stock), 
 design an algorithm to find the maximum profit.

 Return the maximum possible profit.
 
 Input Format:- The first and the only argument is an array of integers, A.
 Output Format :- Return an integer, representing the maximum possible profit.


Example Input
 Input 1: A = [1, 2]
 Input 2: A = [1, 4, 5, 2, 4]

Example Output
 Output 1: 1
 Output 2: 4
 
Example Explanation
 Explanation 1: Buy the stock on day 0, and sell it on day 1.
 Explanation 2: Buy the stock on day 0, and sell it on day 2.

 */
public class _66_BestTime_BuyAndSell_StocksI {

	
	public static void main(String[] args) {
		int [] arr1= {1,2};
		int [] arr2= {1, 4, 5, 2, 4};
		int [] arr3= {5, 4, 2, 4,1,8,1,4,7};
				
		System.out.println(findMaxProfit(arr1));
		System.out.println(findMaxProfit(arr2));
		System.out.println(findMaxProfit(arr3));
	}
	
	
	static int findMaxProfit(int []arr) {
	int maxProfit=0;
	int [] dp= new int[arr.length];
	
	for(int i=0;i<arr.length;i++) {
		for(int j=i;j<arr.length;j++) {
			
			int prof=arr[j]-arr[i];
			if(maxProfit<prof)
				maxProfit=prof;
			
			if(dp[j]<prof) {
				dp[j]=prof;	
			}
		}
	}
	
	return maxProfit;
		
	}
}
