package Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _1_SimplyPath {

	public static void main(String[] args) {

		String str1 = "/home/tusroy/";
		String str2 ="/../";
		String str3 ="/home//foo/";
		String str4 ="/a/./b/../../c/";
		String str5 ="/a/../../b/../c//.//";
		String str6 ="/a//b////c/d//././/..";
		
		_1_SimplyPath mfc = new _1_SimplyPath();
        System.out.println(str1+"--->"+mfc.simplifyPath(str1));
        System.out.println(str2+"--->"+mfc.simplifyPath(str2));
        System.out.println(str3+"--->"+mfc.simplifyPath(str3));
        System.out.println(str4+"--->"+mfc.simplifyPath(str4));
        System.out.println(str5+"--->"+mfc.simplifyPath(str5));
        System.out.println(str6+"--->"+mfc.simplifyPath(str6));   
	}

	public String simplifyPath(String path) 
	{
        Deque<String> stack = new LinkedList<>();
        StringTokenizer token = new StringTokenizer(path, "/");
        
        String [] strArray=path.split("/");
        for (int i=1;i<strArray.length;i++) {
         //while (token.hasMoreTokens()) {
          // String tok = token.nextToken();
             String tok=strArray[i];
           //System.out.println("tok.equals(\".\")-->"+tok.equals("."));
            if (tok.equals(".") || tok.equals("")) {
                continue;
            } else if (tok.equals("..")) {
                stack.pollFirst();
            } else {
                stack.offerFirst(tok);
            }
        }
        StringBuffer buff = new StringBuffer();
        if (stack.isEmpty()) {
            buff.append("/");
        }
        while(!stack.isEmpty()) {
            buff.append("/").append(stack.pollLast());
        }
        return buff.toString();
    }
}
