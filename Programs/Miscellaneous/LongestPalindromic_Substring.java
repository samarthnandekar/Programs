package Miscellaneous;

public class LongestPalindromic_Substring {

	public static void main(String[] args) { 
		  
        String str = "forgeeksskeegfor"; 
        
       // System.out.println(isPalandrome("abac"));
        System.out.println("Length is: " +  longestPalSubstr(str)); 
    } 
	
	static String longestPalSubstr(String str)
	{
		String lonPalSubStr= new String();
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				String curSubStr=str.substring(i, j);
				boolean isPla=isPalandrome(curSubStr);
				if(isPla)
				{
					if(lonPalSubStr==null)
						lonPalSubStr=""+ curSubStr;
					else
					{
						if(lonPalSubStr.length()<curSubStr.length())
							lonPalSubStr=curSubStr;
					}
							
				}
			}
		}
		return lonPalSubStr;
	}
	
	
	static boolean isPalandrome(String str)
	{
		boolean isPalandrome=true;
		int j=str.length()-1;
		for(int i=0;i<str.length() && j>=0;i++,j--)
		{
			if(!(str.charAt(i)==str.charAt(j)))
			{
				isPalandrome=false;
				break;
			}		
		}
		return isPalandrome;
	}
	
}
