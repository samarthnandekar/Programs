package Tree;

/*
 * 
 * https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-sumtree/
 
 Check if a given Binary Tree is SumTree
Write a function that returns true if the given Binary Tree is SumTree else false. A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
  
  A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present 
 * in its left subtree and right subtree
 
 
 */

public class _54_IS_Sum_Tree {

	 public boolean isSumTree(Node root){
	        Count count = new Count();
	        return isSumTree(root,count);
	    }
	    
	    private boolean isSumTree(Node root,Count count){
	        if(root == null){
	            return true;
	        }
	        if(root.left == null && root.right == null){
	            count.size = root.key;
	            return true;
	        }
	        Count leftCount = new Count();
	        Count rightCount = new Count();
	        boolean isLeft = isSumTree(root.left,leftCount);
	        boolean isRight = isSumTree(root.right,rightCount);
	        count.size = root.key + leftCount.size + rightCount.size;
	        return isLeft && isRight && root.key == (leftCount.size + rightCount.size);
	    }
	    
	    public static void main(String args[]){
	    
	        _54_IS_Sum_Tree st = new _54_IS_Sum_Tree();
	        System.out.println(st.isSumTree(root));
	    }
}

class Count{
    int size;
}
