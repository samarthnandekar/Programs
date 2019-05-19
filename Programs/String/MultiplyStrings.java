package String;

public class MultiplyStrings {

	 public static void main(String args[]) {
	        MultiplyStrings ms = new MultiplyStrings();
	        System.out.println(ms.multiply("123","41"));
	        System.out.println(ms.multiply_1("123","41"));
	        System.out.println(ms.multiply_2("123","41"));
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
	 
	 
	 // without reversing string. ***** it's good method
	 public String multiply_1(String num1, String num2) {
		    String n1 = new StringBuilder(num1).toString();
		    String n2 = new StringBuilder(num2).toString();
		 
		    int[] d = new int[num1.length()+num2.length()];
		 
		    int count=0;
		    //multiply each digit and sum at the corresponding positions
		    for(int i=0; i<n1.length(); i++){
		        for(int j=0; j<n2.length(); j++){
		            d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
		            count=i+j;
		        }
		    }
		 
		    StringBuilder sb = new StringBuilder();		 
		    int n = d.length;
		    //calculate each digit
		    for(int i=count; i>=0; i--){
		        int mod = d[i]%10;
		        int carry = d[i]/10;
		        if(i-1>=0 && carry> 0){
		            d[i-1] += carry;
		        }
		        sb.insert(0, mod);
		    }

		 
		    return sb.toString();
		}
	 
	 // only one for loop.. done everything in that.
	 public String multiply_2(String num1, String num2) {
		    int m = num1.length();
		    int n = num2.length();
		    int[] pos = new int[m + n];
		   
		    for(int i = m - 1; i >= 0; i--) {
		        for(int j = n - 1; j >= 0; j--) {
		            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
		            int p1 = i + j, p2 = i + j + 1;
		            int sum = mul + pos[p2];

		            pos[p1] += sum / 10;
		            pos[p2] = (sum) % 10;
		        }
		    }  
		    
		    StringBuilder sb = new StringBuilder();
		    for(int p : pos) 
		    {
		    	if(!(sb.length() == 0 && p == 0))
		    		sb.append(p);
		    }
		    return sb.length() == 0 ? "0" : sb.toString();
		}
}
