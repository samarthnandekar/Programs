package Dynamic;

/*

https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/ 

Count number of binary strings without consecutive 1’s
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Examples:
Input:  N = 2
Output: 3
// The 3 strings are 00, 01, 10

Input: N = 3
Output: 5
// The 5 strings are 000, 001, 010, 100, 101
 
 
 */
public class _12_Count_Number_ofBinary {

	public static void main(String[] args) {
		_12_Count_Number_ofBinary cnb= new _12_Count_Number_ofBinary();
		System.out.println(cnb.count(5));
		System.out.println(cnb.countSimple(3));
		System.out.println(cnb.count1(3));
	}
	
	public int count1(int n)
	{
		int []res=new int[n+1];
		res[0]=1;
		res[1]=2;
		for(int i=2;i<=n;i++)
		{
			res[i]=res[i-1]+res[i-2];
		}
		
		return res[n];
	}
	
	 public int count(int n){
	        int a[] = new int[n];
	        int b[] = new int[n];
	        
	        a[0] = 1;
	        b[0] = 1;
	        
	        for(int i=1; i < n; i++){
	            a[i] = a[i-1] + b[i-1];
	            b[i] = a[i-1];
	        }
	        
	        return a[n-1] + b[n-1];
	    }
	    
	    public int countSimple(int n){
	        int a = 1;
	        int b = 1;
	        
	        for(int i=1; i < n; i++){
	            int tmp = a;
	        	a = a + b;
	            b = tmp;
	        }
	        
	        return a + b;
	    }

}
