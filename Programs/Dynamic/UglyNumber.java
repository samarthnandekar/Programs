package Dynamic;

import java.util.PriorityQueue;

public class UglyNumber 
{

	public int nthSuperUglyNumber1(int n, int[] primes) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new Node(i, 0, primes[i]));
        }
        
        int[] val = new int[n];
        val[0] = 1;
        for (int i = 1; i < n; ) {
            Node node = pq.poll();
            if (val[i-1] != node.val) {
                val[i] = node.val;
                i++;
            }
            node.index = node.index + 1;
            node.val = primes[node.inputIndex]*val[node.index];
            pq.offer(node);
        }
        return val[n - 1];
    }
	
	int ugly(int n)
	{
        int arr[] = new int[n];
        int count = 1;
        arr[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while(count < n)
        {
            int minNumber = min(arr[i2] * 2, arr[i3] * 3, arr[i5] * 5);
            if(minNumber == arr[i2]*2){
                i2++;
            }
            if(minNumber == arr[i3]*3){
                i3++;
            }
            if(minNumber == arr[i5]*5){
                i5++;
            }
            arr[count++] = minNumber;
        }
        
        return arr[n-1];
    }
	
	private int min(int a,int b, int c){
        int l = Math.min(a, b);
        return Math.min(l, c);
    }
	
	
	public static void main(String args[]) {
		UglyNumber ugly = new UglyNumber();
        int result = ugly.ugly(10);
        System.out.println(result);
        int[] primes = {2,7,13,19};
        System.out.print(ugly.nthSuperUglyNumber1(12, primes));
    }
	
}
