package BFS;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

	 int number;
	 List<Integer> list= new ArrayList<Integer>();
	 
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}

	public boolean isList()
	{
		if(list.size()==0)
			return true;
		
	   return false;
	}
	 
}
