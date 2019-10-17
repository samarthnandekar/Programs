package Dynamic;

/*
 Cutting a Rod | DP-13
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine 
the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the 
values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20


And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20


 */
public class _17_Cutting_Rob {

	public static void main(String args[]){
		_17_Cutting_Rob cr =new _17_Cutting_Rob();
        int[] price = {3,5,8,9,10,17,17,20};
        int[] price1 = {1,5,8,9,10,17,17,20};
        int []price2= {2,5,7,8};
       
      //  Rod[]proce2 = {new Rod(1,2),new Rod(2,5),new Rod(3,7), new Rod(4,8)};
       // System.out.println(cutRod(price,8));
    //    System.out.println(cutRod(price1,8));
    //    System.out.println(cutRod(price2,5));
    }

	
	
	static int cutRod(Rod[] arr,int length)
	{
		int max=0;
		
		int[][] priceLength=new int[arr.length][length];
		
		for(int i=0;i<arr.length;i++)
		{
			priceLength[i][0]=0;
		}
		
		for(int i=1;i<arr.length;i++)
			for(int j=1;j<length;j++)
		{
			
				
		}
		return max;
	}
	
	class Rod
	{
		int price;
		int length;
		
		Rod(int length,int price)
		{
			this.price=price;
			this.length=length;
		}
		Rod()
		{
			
		}
	}
}
