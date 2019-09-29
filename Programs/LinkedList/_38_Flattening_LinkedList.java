package LinkedList;

/*
 https://www.geeksforgeeks.org/flattening-a-linked-list/
 
 Flattening a Linked List
Given a linked list where every node represents a linked list and contains two pointers of its type:
(i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
(ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
All linked lists are sorted. See the following example

       5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45

Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be sorted.
For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.


 */
public class _38_Flattening_LinkedList {
     NodewithDown head;
	
	 /* Drier program to test above functions */
    public static void main(String args[]) 
    { 
    	_38_Flattening_LinkedList L = new _38_Flattening_LinkedList(); 
  
        /* Let us create the following linked list 
            5 -> 10 -> 19 -> 28 
            |    |     |     | 
            V    V     V     V 
            7    20    22    35 
            |          |     | 
            V          V     V 
            8          50    40 
            |                | 
            V                V 
            30               45 
        */
  
        L.head = L.push(L.head, 30); 
        L.head = L.push(L.head, 8); 
        L.head = L.push(L.head, 7); 
        L.head = L.push(L.head, 5); 
  
        L.head.right = L.push(L.head.right, 20); 
        L.head.right = L.push(L.head.right, 10); 
  
        L.head.right.right = L.push(L.head.right.right, 50); 
        L.head.right.right = L.push(L.head.right.right, 22); 
        L.head.right.right = L.push(L.head.right.right, 19); 
  
        L.head.right.right.right = L.push(L.head.right.right.right, 45); 
        L.head.right.right.right = L.push(L.head.right.right.right, 40); 
        L.head.right.right.right = L.push(L.head.right.right.right, 35); 
        L.head.right.right.right = L.push(L.head.right.right.right, 28); 
  
        // flatten the list 
        L.head = L.flattenItr(L.head); 
  
        L.printList(); 
    } 
	// An utility function to merge two sorted linked lists 
    NodewithDown merge(NodewithDown a, NodewithDown b) 
    { 
        // if first linked list is empty then second is the answer 
        if (a == null)     return b; 
  
        // if second linked list is empty then first is the result 
        if (b == null)      return a; 
  
        // compare the data members of the two linked lists and put the larger one in the result 
        NodewithDown result; 
  
        if (a.data < b.data) 
        { 
            result = a; 
            result.down =  merge(a.down, b); 
        } 
        else
        { 
            result = b; 
            result.down = merge(a, b.down); 
        } 
        return result; 
    } 
    
 // An utility function to merge two sorted linked lists 
    NodewithDown flattenItr(NodewithDown node) 
    { 
    	int length=0;
    	NodewithDown itr=node;
    	while(itr!=null)
    	{
    		length++;
    	   itr=	itr.right;
    	}
    	NodewithDown[] allrootNode= new NodewithDown[length];
    	allrootNode[0]=node;
    	int rootCount=1;
    	while( node.right!=null)
    	{
    		allrootNode[rootCount++]=node.right;
    		node=node.right;
    	}
    	
    	NodewithDown res= new NodewithDown();
    	NodewithDown finalRes=res;
    	for(int i=allrootNode.length-1;i>=1;i--)
    	{
    		res.right=merge(allrootNode[i-1], allrootNode[i]);
    		
    	}
    	return finalRes.right;
    }
    
    NodewithDown flatten(NodewithDown root) 
    { 
        // Base Cases 
        if (root == null || root.right == null) 
            return root; 
  
        // recur for list on right 
        root.right = flatten(root.right); 
  
        // now merge 
        root = merge(root, root.right); 
  
        // return the root, it will be in turn merged with its left 
        return root; 
    } 
    
    /* Utility function to insert a node at begining of the linked list */
    NodewithDown push(NodewithDown head_ref, int data) 
 { 
     /* 1 & 2: Allocate the Node & 
               Put in the data*/
	 NodewithDown new_node = new NodewithDown(data); 

     /* 3. Make next of new Node as head */
     new_node.down = head_ref; 

     /* 4. Move the head to point to new Node */
     head_ref = new_node; 

     /*5. return to link it back */
     return head_ref; 
 } 

 void printList() 
 { 
	 NodewithDown temp = head; 
     while (temp != null) 
     { 
         System.out.print(temp.data + " "); 
         temp = temp.down; 
     } 
     System.out.println(); 
 } 
}
class NodewithDown 
{ 
    int data; 
    NodewithDown right, down; 
    NodewithDown(int data) 
    { 
        this.data = data; 
        right = null; 
        down = null; 
    } 
    
    NodewithDown()
    {
    	
    }
} 