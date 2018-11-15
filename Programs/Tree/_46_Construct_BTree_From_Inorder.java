package Tree;

/*
 * https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/

Given Inorder Traversal of a Special Binary Tree in which key of every node is greater than keys in left and right children, construct the Binary Tree and return root.
Examples:

Input: inorder[] = {5, 10, 40, 30, 28}
Output: root of following tree
         40
       /   \
      10     30
     /         \
    5          28 

Input: inorder[] = {1, 5, 10, 40, 30, 
                    15, 28, 20}
Output: root of following tree
          40
        /   \
       10     30
      /         \
     5          28
    /          /  \
   1         15    20

 */
public class _46_Construct_BTree_From_Inorder {
	
	public Node createTree(int inorder[]){
        return createTree(inorder,0,inorder.length-1);
    }
    private Node createTree(int inorder[],int low,int high)
    {
        if(low > high){
            return null;
        }
        int i;
        int maxIndex = low;
        for(i=low ; i <= high; i++){
            if(inorder[maxIndex] > inorder[i]){
                maxIndex = i;
            }
        }
        Node root = Node.newNode(inorder[maxIndex]);
        root.left = createTree(inorder,low,maxIndex-1);
        root.right = createTree(inorder,maxIndex+1,high);
        return root;
    }
    
    public static void main(String args[]){
        int inorder[] = {9,15,25,6,18,-1,3,-3};
        _46_Construct_BTree_From_Inorder tf = new _46_Construct_BTree_From_Inorder();
        Node root = tf.createTree(inorder);
        TreeTraversals tt = new TreeTraversals();
        tt.inOrder(root);
    }

}
