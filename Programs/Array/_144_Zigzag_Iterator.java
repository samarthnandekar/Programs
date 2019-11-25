package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/*
 
 281. Zigzag Iterator
 
 Given two 1d vectors, implement an iterator to return their elements alternately.
For example, given two 1d vectors:
v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 
 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 For example, given the following input:
[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].

 */
public class _144_Zigzag_Iterator {

	public static void main(String[] args) {
	
		List<List<Integer>> arrList= new ArrayList<>();
		List<Integer> list1= new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);		
		List<Integer> list2= new ArrayList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.add(7);
		List<Integer> list3= new ArrayList<>();
		list3.add(8);
		list3.add(9);		
		arrList.add(list1);
		arrList.add(list2);
		arrList.add(list3);
		
		List<Integer> ans=ZigzagIterator(arrList);		
		System.out.println(ans);
		
		List<List<Integer>> arrList1= new ArrayList<>();
		List<Integer> list4= new ArrayList<>();
		list4.add(1);
		list4.add(2);
		list4.add(3);		
		List<Integer> list5= new ArrayList<>();
		list5.add(4);
		list5.add(5);
		list5.add(6);
		list5.add(7);
		List<Integer> list6= new ArrayList<>();
		list6.add(8);
		list6.add(9);		
		arrList1.add(list4);
		arrList1.add(list5);
		arrList1.add(list6);
        List<Integer> ans1=ZigzagIterator_2(arrList1);		
		System.out.println(ans1);
	}

	
	static List<Integer> ZigzagIterator(List<List<Integer>> arrList)
	{
		List<Integer> mergedList= new ArrayList<>();
		boolean isElementPresent=true;
		while(isElementPresent) 
		{
			 Iterator<List<Integer>> iteratorList = arrList.iterator(); 
			 while(iteratorList.hasNext())
			 {
				 List<Integer> list=iteratorList.next();
				 if(list.size()>0)
					{
					  mergedList.add(list.get(0));	
					  list.remove(0);
					}
					if(list.size()==0)
						iteratorList.remove();
			 }
			
			
			if(arrList.size()==0)
			{
				isElementPresent=false;
			}
		}	
		return mergedList;
	}
	
	static List<Integer> ZigzagIterator_2(List<List<Integer>> arrList)
	{
		List<Integer> mergedList= new ArrayList<>();
		boolean isElementPresent=true;
		int totalSize=0;
		for(List<Integer> list:arrList)
		{
		totalSize=totalSize+list.size();	
		}
		 int i=0;
		while(isElementPresent) 
		{
			for(List<Integer> list:arrList)
			{
				if(i<list.size())
				{
					mergedList.add(list.get(i));
				}

			}
			i++;
			if(mergedList.size()==totalSize)
				break;
			
		}
		
		return mergedList;
	}
}
