package Sorting;

public class BubbleSort {

	static int[] bubbleSort(int [] arr) {
		
		int len=arr.length;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<len-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					// swap element
					int temp=arr[j+1];
					arr[j+1] =arr[j];
				    arr[j]=temp;	
				}
			}	
		}
		return arr;
	}
	
	static int[] bubbleSort_Opt(int [] arr) {
		
		int len=arr.length;
		boolean swap=false;
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<len-i-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					// swap element
					int temp=arr[j+1];
					arr[j+1] =arr[j];
				    arr[j]=temp;	
				    swap=true;
				}
			}
			if(!swap)
			{
				break;
			}
		}
		
		return arr;
	}
	
	
	public static void main(String [] args)
	{
		
		int [] arr= {10,11,3,2,5,1,0};
		
		bubbleSort(arr);
		for(int a:arr)
		{
			System.out.print(a + "  ");
		}
		
	}
}
