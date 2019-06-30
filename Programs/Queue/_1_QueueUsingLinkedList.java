package Queue;

import LinkedList.Node;

public class _1_QueueUsingLinkedList {

	Node front,rear;
	
	_1_QueueUsingLinkedList()
	{
		this.front=this.rear=null;
	}
	
	void enqueue(int key)
	{
	   Node node= new Node(key);
	   
	   if(this.rear==null)
	   {
		   this.front=this.rear=node;
	   }
	   this.rear.next=node;
	   this.rear=node;
	}
	
	int dequeue()
	{
		if(this.front==null)
			return -1;
		
		Node node= front;
		front=front.next;
		
		if(this.front==null)
			this.rear=null;
		return node.val;
	}
	
	public static void main(String[] args) 
	{
		_1_QueueUsingLinkedList queue= new _1_QueueUsingLinkedList();
		 queue.enqueue(1);
		 queue.enqueue(2);
		 System.out.println(queue.dequeue());
		 queue.enqueue(3);
		 queue.enqueue(4);
		 queue.enqueue(5);
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
		 System.out.println(queue.dequeue());
	}

}
