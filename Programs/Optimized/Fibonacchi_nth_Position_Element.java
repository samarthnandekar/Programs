package Optimized;

public class Fibonacchi_nth_Position_Element {

	
	public static void main(String [] args)
	{
		
		System.out.println(nthPositionElement_ConstantSpace(6));
	}
	
	// normal approach
	static int nthPositionElement(int n) {
		
		int [] arr= new int [n+1];
		 arr[0]=0;
		 arr[1]=1;
		 
		 int i;
		 for(i=2;i<n;i++)
		 {
			 arr[i]=arr[i-1]+arr[i-2];
		 }
		 return arr[i-1];
	}
	
     // constant space
     static int nthPositionElement_ConstantSpace(int n) {
		
		 int secLast=0,last=1,ans=0;
		 for(int i=2;i<n;i++)
		 {
			 ans=secLast+last;
			 secLast=last;
			 last=ans;
		 }
		 return ans;
	}
}
