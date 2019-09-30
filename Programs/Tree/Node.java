package Tree;

public class Node {

	int key;
	public Node left,right;
	
	public Node(int val)
	{
		key=val;
	}
	
	Node()
	{
		
		
	}
	public boolean isLeaf() {
        return (left == null && right == null);
    }
	
}
