package String;

/*
 * 
 * 
 */
public class _0_ReverseString {

	public static void main(String[] args) {
		String inStr="sam";
		
		_0_ReverseString rvString= new _0_ReverseString();
		String reverseString =rvString.reverseString(inStr);
		System.out.println(reverseString);
	}
	
	
	String reverseString(String instr)
	{
		if(instr.length()==1)
			return instr;
		
		int instrLen=instr.length();
		String reveseStr=instr.charAt(instrLen-1)+reverseString(instr.substring(0, instrLen-1));
		return reveseStr;
	}

}
