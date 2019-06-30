package Queue;
/*
  
  Array implementation of queue :- implement queue using array
 
 rear=(rear+1)%capacity - Using this so no need to shift element 
 
 */
public class _0_QueueUsingArray {

	int front,rear,size;
	int capacity;
	int [] array;
	
	
	_0_QueueUsingArray(int capacity)
	{
		this.capacity=capacity;
		front=size=0;
		rear=capacity-1;
		array= new int[capacity];
	}
	
	boolean isFull()
	{
		return size==capacity;
	}
	
	boolean isEmpty()
	{
		return size==0;
	}
	
	void enqueue(int item)
	{
		if(isFull())
		{
			return;
		}
		
		rear=(rear+1)%capacity;
		array[rear]=item;
		size=size+1;
		System.out.println(item+ " enqueued to queue");
	}
	
	int dequeqe()
	{
		if(isEmpty())
			return -1;
		
		int item=array[front];
		front=(front+1)%capacity;
		size=size-1;
		return item;
	}
	
	 
	  /*
	 // function to insert an element at the rear of the queue 
     void queueEnqueue(int data) 
    { 
    	 // check queue is full or not 
        if (capacity == rear) { 
            System.out.printf("\nQueue is full\n"); 
            return; 
        } 
        // insert element at the rear 
        else { 
            array[rear] = data; 
            rear++; 
        } 
    } 
	 
	   int queueDequeue() 
    { 
         int val=0;
        // if queue is empty 
        if (front == rear) { 
            System.out.printf("\nQueue is empty\n"); 
        } 
  
        // shift all the elements from index 2 till rear to the right by one 
        else { 
        val=array[0];
            for (int i = 0; i < rear - 1; i++) { 
            	array[i] = array[i + 1]; 
            } 
  
            // store 0 at rear indicating there's no element 
            if (rear < capacity) 
            	array[rear] = 0; 
  
            // decrement rear 
            rear--; 
        } 
        return val;
    } 

	 */
	
	
	
	public static void main(String[] args) {
		
		int capacity=5;
		_0_QueueUsingArray queue= new _0_QueueUsingArray(capacity);
		  queue.enqueue(1);
		  System.out.println("dequeue value  ->"+queue.dequeqe());
		  queue.enqueue(2);
		  queue.enqueue(3);
		  System.out.println("dequeue value  ->"+queue.dequeqe());
		  System.out.println("dequeue value  ->"+queue.dequeqe());
		  System.out.println("dequeue value  ->"+queue.dequeqe());

	}
	
	

}
