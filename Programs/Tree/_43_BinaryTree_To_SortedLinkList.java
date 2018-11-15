package Tree;

public class _43_BinaryTree_To_SortedLinkList {

	public Node toSortedLinkList(Node root){
        if(root == null){
            return null;
        }
        
        Node left = toSortedLinkList(root.left);
        Node right = toSortedLinkList(root.right);
        
        root.left = null;
        root.right = null;
        root = merge(left,root);
        return merge(root,right);
    }
    
    private Node merge(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(head1.key <= head2.key){
            head1.next = merge(head1.next, head2);
            return head1;
        }else{
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }
    
    private void print(Node root){
        while(root != null){
            System.out.print(root.key + " ");
            root = root.next;
        }
    }
    
    public static void main(String args[]){
        int in[] = {-6,0,15,10,3,25,2};
        int pre[] = {10,15,-6,0,25,3,2};
        _33_Construct_Tree_From_Inorder_PreOrder ct = new _33_Construct_Tree_From_Inorder_PreOrder();
       // Node root = ct.(in, pre);
        _43_BinaryTree_To_SortedLinkList bt = new _43_BinaryTree_To_SortedLinkList();
         Node root = bt.toSortedLinkList(root);
        bt.print(root);
    }
    
}
