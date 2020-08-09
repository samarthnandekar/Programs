package String;
import java.util.Stack;

public class _34_SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String test="/a//b////c/d//././/..";
		 System.out.println(simplifyPath2(test));
	}
	
	
	static public String simplifyPath2(String path)
	{

	 if(path.length()<=1)
	  return path;
	  
	  String []each=path.split("/");
	  Stack<String> stack= new Stack<String>();
	  for(String curr:each)
	  {
	    if(curr.equals(".."))
		{
		if (!stack.empty())
		      stack.pop();
		}
		else if(!curr.equals(".") && !curr.isEmpty())
		{
		  stack.push(curr);
		}
	  }
	  
	  String result="";
	  
	  if(stack.empty())
	    return "/";
		
		while(!stack.empty())
		{
		 String newpop= stack.pop();
		 result="/"+ newpop+result;
		}
		
		return result;
	}

}
