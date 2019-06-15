package String;

import java.util.ArrayList;
import java.util.List;

/*
 Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network
 and is decoded back to the original list of strings.
 
  Reference:- https://leetcode.com/problems/encode-and-decode-strings/
 */
public class _22_StringEncoderAndDecoder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_22_StringEncoderAndDecoder obj= new _22_StringEncoderAndDecoder();
		List<String> strs= new ArrayList<>();
		strs.add("aa");
		strs.add("bb");
		strs.add("zzz");
		
		String encodeStr=obj.encode_1(strs);
		System.out.println("Encode Str -->"+encodeStr);
		List<String> strs1= obj.decode(encodeStr);
		System.out.println(strs1);
	}
	  public String encode_1(List<String> strs) 
	    {
		  String encodeStr="";
		  for (String str : strs) 
	        {
			  int len=str.length();
			  encodeStr=encodeStr+"#"+len+str;
	        }
		  return encodeStr;
	    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        
        for (int i=1;i<s.length();i++) 
        {
            int wordlen=Integer.parseInt(s.charAt(i)+"");
            String word=s.substring(i+1, i+wordlen+1);
            result.add(word);
            i=i+wordlen+1;
            		
        }
        return result;
    }
}
