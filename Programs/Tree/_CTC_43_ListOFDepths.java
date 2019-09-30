package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/*
  From CTC  book
 */
public class _CTC_43_ListOFDepths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_CTC_43_ListOFDepths lod= new _CTC_43_ListOFDepths();
		
		Node root= new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		
		
		ArrayList<LinkedList<Node>>  res=lod.createLevelLinkedList(root);
		
		for(LinkedList<Node> ll:res)
		{
			ll.forEach(item->System.out.print(item.key));
			System.out.println();
		}
		
		
      ArrayList<LinkedList<Node>>  res2=lod.createLevelLinkedList_2(root);
		
		for(LinkedList<Node> ll:res2)
		{
			ll.forEach(item->System.out.print(item.key));
			System.out.println();
		}
	}

	void createLevelLinkedList(Node root, ArrayList<LinkedList<Node>> lists,int level) {
		
		if (root == null) 
			return; // base case
		
		 LinkedList<Node> list = null;
		 
		 if (lists.size() == level) {    // Level not contained in list
		 list = new LinkedList<Node>();
		 /* Levels are always traversed in order. So, if this is the first time we've
		 * visited level i, we must have seen levels 0 through i - 1. We can
		 * therefore safely add the level at the end. */
		 lists.add(list);
		  } else {
		 list = lists.get(level);
		 }
		 list .add(root) ;
		 createLevelLinkedList(root.left, lists, level + 1);
		 createLevelLinkedList(root.right, lists, level + 1);
		 }
		
ArrayList<LinkedList<Node>> createLevelLinkedList(Node root) {
		 ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		 createLevelLinkedList(root, lists, 0);
		 return lists;
		}


/*
  Alternatively, we can also implement a modification of breadth-first search. With this implementation, we
  want to iterate through the root first, then level 2, then level 3, and so on.
  With each level i , we will have already fully visited all nodes on level i - 1. This means that to get which
  nodes are on level i, we can simply look at all children of the nodes of level i - l.The code below implements this algorithm.  */
 ArrayList<LinkedList<Node>> createLevelLinkedList_2(Node root) 
 {
 ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
 /* "Visit" the root */
 LinkedList<Node> current = new LinkedList<Node>();
  if (root != null) {
    current.add(root);
  }

 while (current.size() > 0) {
	  result.add(current); // Add previous level
	  LinkedList<Node> parents = current; // Go to next level
	  current = new LinkedList<Node>();
	  for (Node parent : parents) 
	   {
		  /* Visit the children */
		  if (parent. left != null) {
		  current.add(parent.left);
		  }
		  if (parent. right != null) {
		  current.add(parent.right);
		  }
	   }
	  }
	  return result;
	  }
}
