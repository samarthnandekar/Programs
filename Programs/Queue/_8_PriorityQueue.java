package Queue;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class _8_PriorityQueue {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		
		pq.add(3);
		pq.add(7);
		pq.add(2);
		pq.add(4);
		pq.add(1);
		pq.add(5);
		
        Iterator<Integer> itr=pq.iterator();
       
        while(itr.hasNext())
        {
        	System.out.print(itr.next()+ "  ");
        }
        System.out.println();
       
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println();
        
        PriorityQueue<Integer> pqRev= new PriorityQueue<>(Collections.reverseOrder());
        pqRev.add(3);
        pqRev.add(7);
        pqRev.add(2);
        pqRev.add(4);
        pqRev.add(1);
        pqRev.add(5);
        Iterator<Integer> itrRev=pqRev.iterator();
        
        while(itrRev.hasNext())
        {
        	System.out.print(itrRev.next()+ "  ");
        }
        System.out.println();
        System.out.println(pqRev.poll());
        System.out.println(pqRev.poll());
	}

	
}
