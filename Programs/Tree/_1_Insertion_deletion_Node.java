package Tree;

public class _1_Insertion_deletion_Node {

	
	Node root;
	
	 void insert(int key)
	{
		root=insertNode(root, key);
	}
	
	
	
	Node insertNode(Node node, int key)
	{
		
		if(node==null)
		{
			node=new Node(key);
			return node;
		}
		
		if(key<node.data)
		{
			node.left=insertNode(node.left, key);
		}
		else if(key>node.data)
		{
			node.right=insertNode(node.right, key);
		}
		
		return node;
	}
	
	void delete(int val)
	{
		root=deleteNode(root, val);
		
	}
	
	Node deleteNode(Node root, int key)
	{
		if(root==null)
		{
			return null;
		}
		
		if(key<root.data)
			root.left=deleteNode(root.left, key);
		else if(key>root.data)
			root.right=deleteNode(root.right, key);
		else
		{
			if(root.left==null)
				return root.right;
			if(root.right==null)
				return root.left;
			else
			{
				root.data=minVal(root.right);
				root.right=deleteNode(root.right, root.data);
			}
		}
		return root;
		
	}
	
	static int minVal(Node node)
	{
		int min=node.data;
		while(node.left!=null)
			min=node.data;
		
		return min;
	}
	
	void printInOrder(Node node)
	{
		if(node!=null)
		{
			printInOrder(node.left);
			
			System.out.print(node.data +"  ");
			printInOrder(node.right);
		}
	}
	
	public static void main (String[] args) 
    {

	 _1_Insertion_deletion_Node node= new _1_Insertion_deletion_Node();
	 node.insert(50);
	 node.insert(30);
	 node.insert(70);
	 node.insert(20);
	 node.insert(40);
	 node.insert(60);
	 node.insert(80);
	 
	 node.printInOrder(node.root);
	 
	 
	 node.delete(70);
     System.out.println("");
	 node.printInOrder(node.root);
	 
    }

}
