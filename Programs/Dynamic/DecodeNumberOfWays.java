package Dynamic;

public class DecodeNumberOfWays {

	static int decodeWays(String data, int len)
	{
		if(data==null||data.length()==0||data=="0")
		{
			return 0;
		}
		
		if(len==1 || len ==0)
			return 1;
		
		int result=decodeWays(data, len-1);
		
		if (data.charAt(len - 2) == '1' || (data.charAt(len - 2) == '2' && data.charAt(len - 1) < '7')) 
			result += decodeWays(data, len - 2); 
		
		return result;
		
	}
	
	static int decodeWaysHelper(String input)
	{
		Integer [] memo = new Integer[input.length()+1];
		//return decodeWays(input, input.length(),memo);
		return decodeWaysDP(input, input.length());
	}
	
	public static void main(String args[]){
    	PrintMaxUsingKeyWords ca =new PrintMaxUsingKeyWords();
        System.out.println(decodeWaysHelper("0001"));
        
       // System.out.println(numDecodings("00012"));
    }
	
	static int decodeWaysDP(String data, int len, Integer [] memo)
	{
		if(data==null||data.length()==0||data=="0")
		{
			return 0;
		}
		
		if(len==1 || len ==0)
			return 1;
		
		if(memo[len]!=null)
			return memo[len];
		
		int result=decodeWaysDP(data, len-1,memo);
		
		if (data.charAt(len - 2) == '1' || (data.charAt(len - 2) == '2' && data.charAt(len - 1) < '7')) 
			result += decodeWaysDP(data, len - 2,memo); 
		
		memo[len]=result;
		return result;
		
	}
	
	
	static int decodeWaysDP(String data, int len)
	{
		if(data==null||data.length()==0||data=="0")
		{
			return 0;
		}
		
		int []dp= new int[len+1];
		dp[0]=dp[1]=1;
		
		for(int i=2; i<=data.length(); i++)
		{
			if(data.charAt(i-1)!='0'){
	            dp[i]+=dp[i-1];
	        }
			
			if (data.charAt(i-2) == '1' || (data.charAt(i-2) == '2' && data.charAt(i-1) < '7') || data.charAt(i-1)=='0') 
                dp[i] += dp[i-2];
		}
		return dp[len];	
	}
}
