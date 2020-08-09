package Queue;

import java.util.Stack;

/*
   Implement Queues using stack
   
    
 */
public class _4_Queue_UsingSingleStack {
	
	Stack<Integer> newStack= new Stack<Integer>();
	
	 void enqueue(int val) {
		newStack.push(val);
	}

	 int dequeue()
	{
		int x,res=0;
		
		if(newStack.isEmpty())
		{
			System.out.println("Queue is empty");
		}
		
		else if(newStack.size()==1)
		{
			return newStack.pop();
		}
		else
		{
			x=newStack.pop();
			res=dequeue();
			newStack.push(x);
		}
		return res;
	}
	
	 public static void main(String[] args) {
		 
		 _4_Queue_UsingSingleStack queue= new _4_Queue_UsingSingleStack();
		 
		 queue.enqueue(1);
		 queue.enqueue(2);
		 queue.enqueue(3);
		 queue.enqueue(4);
		 
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
		 queue.enqueue(5);
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
	 }
	
}
