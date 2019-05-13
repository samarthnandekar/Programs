/** 
@Author  - sn656
Creation - Date Dec 13, 2018 4:51:37 PM

*/
package Maths;
//package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/** **** Median of Stream of Running Integers using STL  *****

Given that integers are being read from a data stream. Find median of all the elements read so far starting from the first integer till the
last integer. This is also called Median of Running Integers. The data stream can be any source of data, example: a file, an array of integers,
input stream etc.

What is Median?
Median can be defined as the element in the data set which separates the higher half of the data sample from the lower half. 
In other words we can get the median element as, when the input size is odd, we take the middle element of sorted data. If the input size is even,
we pick average of middle two elements in sorted stream.

Example:- Input: 5 10 15
Output: 5
        7.5
        10

Explanation: Given the input stream as an array of integers [5,10,15]. We will now read integers one by one and print the median correspondingly.
So, after reading first element 5,median is 5. After reading 10,median is 7.5 After reading 15 ,median is 10.

So, the idea is to use some data structure that will maintain two lists of elements such that first list is less
then or equal to current median and the second list is greater then or equal to the current median. If both list 
are of same size then the average of the top of the two lists is the median. Otherwise, median is top of the bigger list.

 */
public class Median_OfStream_Of_Integer 
{

	public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
	{
		if(lowers.size()==0 || number<lowers.peek())
		{
			lowers.add(number);
		}
		else
		{
			highers.add(number);
		}
		
	}
	public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
	{
		PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
		PriorityQueue<Integer> smallerHeap = lowers.size()>highers.size()?highers:lowers;
		
		if(biggerHeap.size()-smallerHeap.size() >=2)
		{
		 	smallerHeap.add(biggerHeap.size());
		}
		
	}
	
	public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers)
	{
		PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
		PriorityQueue<Integer> smallerHeap = lowers.size()>highers.size()?highers:lowers;
		
		if(biggerHeap.size()== smallerHeap.size())
		{
			return (biggerHeap.peek()+smallerHeap.peek())/2f;
		}
		else   // for this we need to find biggerHeap
		{
			return biggerHeap.peek();
		}
	}

	public  double[] getStreamMedian(int[] stream)
	{
	    float median = 0;
	     PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder());
	     PriorityQueue<Integer> highers = new PriorityQueue<Integer>();

	     double [] medians= new double[stream.length];
	     
	    for (int i = 0; i < stream.length; i++) 
	    {
	    	int number=stream[i];
	    	
	    	addNumber(number,lowers, highers);
            rebalance(lowers,highers);
            medians[i]=getMedian(lowers,highers);
	    }
	    return medians;
	}
	
	public static void main(String args[])
	{
		Median_OfStream_Of_Integer obj= new Median_OfStream_Of_Integer();
		
		int [] arr= {5,10,15};
		obj.getStreamMedian(arr);
		//obj.medianOfStream(arr);
		
	}
	
	
	// n2
	void medianOfStream(int []arr)
	{
		int arrlen= arr.length;
		List<Integer> arrList= new ArrayList<Integer>();
		
		Arrays.sort(arr);
		
		for(int i=0;i<arrlen;i++)
		{
			arrList.add(arr[i]);
			
			// for odd
			if((i+1)%2!=0)
			{
				int index=i+1/2;
				System.out.println(arr[index]);
			}
			else if((i+1)%2==0)   // for even
			{
			 int index= i/2;
			 float med=(arr[index]+arr[index+1])/2f;
			 
			 System.out.println(med);
			}	
		}
	}

}

