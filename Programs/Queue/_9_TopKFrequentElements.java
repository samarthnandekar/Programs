package Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _9_TopKFrequentElements {

	public static void main(String[] args) {
		
		
		
	}
	
	public List<Integer> topKFrequent(int[] nums, int k)
	{
		HashMap<Integer,Integer> map= new HashMap<Integer, Integer>();
		for(int num:nums)
		{
			if(map.containsKey(num))
			{
				map.put(num, map.get(num)+1);
			}
			else
			{
				map.put(num, 1);
			}
		}
		
		// create a min heap
		PriorityQueue<Pair> queue= new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair a, Pair b)
			{
				return a.count-b.count;
			}
		});

		// Maintain a heap of size k
		for(Map.Entry<Integer, Integer> entry:map.entrySet())
		{
			Pair p= new Pair(entry.getKey(),entry.getValue());
			queue.offer(p);
			if(queue.size()>k)
			{
				queue.poll();
			}
		}
		
		List<Integer> result=new ArrayList<Integer>();
		while(queue.size()>0)
		{
			result.add(queue.poll().num);
		}
		
		//reverse the order
		Collections.reverse(result);
		
		return result;
	}

}

class Pair
{
	int num;
	int count;
	
	Pair(int num,int count)
	{
		this.num=num;
		this.count=count;
	}
}