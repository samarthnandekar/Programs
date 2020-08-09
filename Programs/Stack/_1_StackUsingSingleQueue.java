package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class _1_StackUsingSingleQueue {

	Queue <Integer> que= new LinkedList<Integer>();
	
	void push(int val)
	{
		// get previous size for queue
		int size=que.size();
		que.add(val);
		
		for(int i=0;i<size;i++) {
			int x=que.remove();
			que.add(x);
		}
	}
	
	int pop()
	{
		if(que.isEmpty())
		{
			System.out.println("Stack is Empty");
			return -1;
		}
		int x=que.remove();
		return x;
	}
	
	boolean isEmpty()
	{
		return  que.isEmpty();
	}

	int top()
	{
		if(que.isEmpty())
		{
			return -1;
		}
		return que.peek();
	}
	
	public static void main(String[] args) {
	_1_StackUsingSingleQueue newstack = new _1_StackUsingSingleQueue();
	
	newstack.push(1);
	newstack.push(2);
	newstack.push(3);
	
	int val= newstack.pop();
	System.out.println(val);
	newstack.push(4);
	newstack.push(5);
	
	System.out.println(newstack.pop());
	System.out.println(newstack.pop());
	System.out.println(newstack.pop());
	System.out.println(newstack.pop());
	System.out.println(newstack.pop());
	
	}
}
