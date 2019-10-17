package Dynamic;


class Node implements Comparable<Node>
{
    int inputIndex;
    int index;
    int val;
    
    Node (int inputIndex, int index, int val) 
    {
        this.inputIndex = inputIndex;
        this.index = index;
        this.val = val;
    }
    
	public int compareTo(Node o)
	{
		return this.val-o.val;
	}
	
}