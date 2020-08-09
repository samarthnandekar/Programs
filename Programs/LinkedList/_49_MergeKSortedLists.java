package LinkedList;

/*
https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
https://leetcode.com/problems/merge-k-sorted-lists/

23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

 */
public class _49_MergeKSortedLists {

	
	public static void main(String args[]){
		
		_1_LinkedList list= new _1_LinkedList();
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		
		_1_LinkedList list1= new _1_LinkedList();
		list1.insert(13);
		list1.insert(12);
		list1.insert(11);
		list1.insert(10);
		
		_1_LinkedList list2= new _1_LinkedList();
		list2.insert(28);
		list2.insert(4);
		list2.insert(2);
		
		printList(list.head);
		printList(list1.head);
		printList(list2.head);
		
		Node [] arr= {list.head,list1.head,list2.head};
		Node fNode=mergeKLists(arr,2);
		printList(fNode);
	}

	public static void printList(Node node)  
    {  
        while (node != null)  
        {  
            System.out.print(node.val+" "); 
            node = node.next;  
        }  
        System.out.println("");
    } 
	
	// The main function that takes an array of lists arr[0..last] and generates the sorted output  
    public static Node mergeKLists(Node arr[], int last)  
    {  
        // repeat until only one list is left  
        while (last != 0)  
        {  
            int i = 0, j = last;  
    
            // (i, j) forms a pair  
            while (i < j)  
            {  
                // merge List i with List j and store  
                // merged list in List i  
                arr[i] = SortedMerge(arr[i], arr[j]);  
    
                // consider next pair  
                i++; j--;  
    
                // If all pairs are merged, update last  
                if (i >= j)  
                    last = j;  
            }  
        }  
    
        return arr[0];  
    }  
    
    public static Node mergeKLists_2(Node arr[])  
    {
    	Node result=null;
    	
    	for(int i=0;i<arr.length;i++)
    	{
    		mergeTwoList(result,arr[i]);
    	}
    	return null;
    }
    
   static void mergeTwoList(Node n1,Node n2)
    {
    	if(n1==null)
    		return;
    	if(n2==null)
    		return;
    	
       // add iterative approach here to merge linkedList
    	
    }
    
    
    
    /* Takes two lists sorted in increasing order, and merge  their nodes together to make one big sorted list. Below  
    function takes O(Log n) extra space for recursive calls, but it can be easily modified to work with same time and  
    O(1) extra space  */
    public static Node SortedMerge(Node a, Node b)  
    {  
        Node result = null;  
        /* Base cases */
        if (a == null)  
            return b;  
        else if(b == null)  
            return a;  
    
        /* Pick either a or b, and recur */
        if(a.val <= b.val)  
        {  
            result = a;  
            result.next = SortedMerge(a.next, b);  
        }  
        else
        {  
            result = b;  
            result.next = SortedMerge(a, b.next);  
        }  
    
        return result;  
    }
}
