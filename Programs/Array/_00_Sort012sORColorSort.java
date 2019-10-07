package Array;


public class _00_Sort012sORColorSort {
	
	static void sortColors(int A[], int n) {
        int left=0, right=n-1;
        int i = 0;
        while(i<=right) {
            if(A[i]==0) 
            {
            	 swap(A,A[i],A[left]);
            	 i++;
            	 left++;
            }
            else if(A[i]==1) 
                i++;
            else if(A[i]==2) 
            {
            	swap(A,i,right);
            	right--;
            }
        }
    }
	
	static void swap(int []arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String args[])
	{
		int []a= {2,0,2,1,1,0};
		sortColors(a, a.length);
		for(int aVal:a)
		{
			System.out.print(aVal + "  ");	
		}
		
	}

}
