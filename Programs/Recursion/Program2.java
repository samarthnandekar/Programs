package Recursion;

public class Program2 {

	
	public static void main(String [] args)
	{
		int arr[]= {2,3,4,5,1};
		
		fun2(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + "  ");
		}
	}
	
	
	static void fun2(int arr[], int start_index, int end_index) 
	{ 
	  if(start_index >= end_index)    
	     return; 
	  int min_index;  
	  int temp;  
	  
	  /* Assume that minIndex() returns index of minimum value in  array arr[start_index...end_index] */
	  min_index = minIndex(arr, start_index, end_index); 
	  
	  temp = arr[start_index]; 
	  arr[start_index] = arr[min_index]; 
	  arr[min_index] = temp;         
	  
	  fun2(arr, start_index + 1, end_index); 
	} 
	
	
	static int minIndex(int [] arr,int sIndex, int lIndex)
	{
	    int minVal=arr[sIndex];
	    int minIndex=sIndex;
	    
	    while(sIndex<=lIndex)
	    {
	    	if(minVal>arr[sIndex])
	    	{
	    		minVal=arr[sIndex];
	    		minIndex=sIndex;
	    	}
	    	sIndex++;
	    }
		
		return minIndex;
	}
}
