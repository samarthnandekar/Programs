package String;

public class MultiplyStrings {

	 public static void main(String args[]) {
	        MultiplyStrings ms = new MultiplyStrings();
	        System.out.print(ms.multiply("123","41"));
	    }
	 
	 public String multiply(String num1, String num2) {
		    String n1 = new StringBuilder(num1).reverse().toString();
		    String n2 = new StringBuilder(num2).reverse().toString();
		 
		    int[] d = new int[num1.length()+num2.length()];
		 
		    //multiply each digit and sum at the corresponding positions
		    for(int i=0; i<n1.length(); i++){
		        for(int j=0; j<n2.length(); j++){
		            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
		        }
		    }
		 
		    StringBuilder sb = new StringBuilder();		 
		    //calculate each digit
		    for(int i=0; i<d.length; i++){
		        int mod = d[i]%10;
		        int carry = d[i]/10;
		        if(i+1<d.length){
		            d[i+1] += carry;
		        }
		        sb.insert(0, mod);
		    }
		 
		    //remove front 0's
		    while(sb.charAt(0) == '0' && sb.length()> 1){
		        sb.deleteCharAt(0);
		    }
		 
		    return sb.toString();
		}
	 
	 String multiply_1(String num1, String num2) {
	        if(num1==null || num2==null )
	        	return "";
	        
	         num1 = new StringBuilder(num1).reverse().toString();
		     num2 = new StringBuilder(num2).reverse().toString();
	        
		     
		     int []ret= new int[num1.length()+num2.length()];
		     
	        for(int j=0; j<num2.length(); j++) {
	            int carry = 0;
	            int val = num2.charAt(j) - '0';
	            for(int i=0; i<num1.length(); i++) {
	                carry += ((num1.charAt(i)-'0')*val + (ret[i+j]-'0'));
	                ret[i+j] = carry%10 + '0';
	                carry /= 10;
	            }
	            if(carry!=0) ret[num1.length()+j] = carry + '0';
	        }
	       // reverse(ret.begin(),ret.end());
	        
	        int count = 0;
	        while(count<ret.length-1 && ret[count]=='0')
	        	count++;
	        
	        //ret.erase(0,count);
	       // String res= new String(ret);
	        return null;
	 }
	 
}
