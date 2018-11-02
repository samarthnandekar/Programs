package Optimized;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Find_odd_numberofTimes_present_Element {

	public static void main(String [] args)
	{
		int []arr= {1,2,3,3,2};
		System.out.println(usingHashMap_ImprovedVersion(arr));
	}
	
	static int usingHashMap_ImprovedVersion(int numArr[])
	{
		int oddNumber=0;		
		HashMap<Integer, Integer> numAndCountMap= new HashMap<Integer, Integer>();		
		for(int i=0;i<numArr.length;i++)
		{
		    int currNum=numArr[i];	
			if(numAndCountMap.containsKey(currNum))
			{
				numAndCountMap.remove(currNum);				
			}
			else
			{
				numAndCountMap.put(currNum, 1);
			}
		}
		Entry<Integer, Integer> entry = numAndCountMap.entrySet().iterator().next();
		Integer firstKey = (Integer)numAndCountMap.keySet().toArray()[0];

		return firstKey;
	}
	
	
	static int usingHashMap(int numArr[])
	{
		int oddNumber=0;
		
		HashMap<Integer, Integer> numAndCountMap= new HashMap<Integer, Integer>();
		
		for(int i=0;i<numArr.length;i++)
		{
		    int currNum=numArr[i];	
			if(numAndCountMap.containsKey(currNum))
			{
				int count=numAndCountMap.get(currNum);
				numAndCountMap.put(currNum, count+1);				
			}
			else
			{
				numAndCountMap.put(currNum, 1);
			}
			
		}
		System.out.println(numAndCountMap.size());
		
		Set set = numAndCountMap.entrySet();
		
		Iterator<Entry<Integer, Integer>> entSet= set.iterator();
		
		while(entSet.hasNext())
		{
			Entry< Integer, Integer> entrySet= entSet.next();
			
			if(entrySet.getValue()==1)
			{
				oddNumber=entrySet.getKey();
				break;		
			}
		}
		
		return oddNumber;
	}
}
