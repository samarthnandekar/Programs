package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 272. Closest Binary Search Tree Value II
 
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
Note: Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.

You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up: Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?


 */
public class _63_Closest_BinarySearch_TreeValue_II {

	public static void main(String[] args) {
		 Node  root = new Node(9); 
		    root.left    = new Node(4); 
		    root.right   = new Node(17); 
		    root.left.left = new Node(3); 
		    root.left.right = new Node(6); 
		    root.left.right.left = new Node(5); 
		    root.left.right.right = new Node(7); 
		    root.right.right = new Node(22); 
		    root.right.right.left = new Node(20); 
		  
		    _63_Closest_BinarySearch_TreeValue_II obj= new _63_Closest_BinarySearch_TreeValue_II();
		    System.out.println(obj.closestKValues(root,4.0,3)); 
	}
	//https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleHard/272.html
	public List<Integer> closestKValues(Node root, double target, int k) {
        Queue<Integer> list = new LinkedList<>();

        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if(list.size() < k){
                list.offer(node.key);
            }else{
                if(Math.abs(list.peek() - target) > Math.abs(node.key - target)){
                    list.poll();
                    list.offer(node.key);
                }else{
                    break;
                }
            }

            node = node.right;
        }
        return (List<Integer>) list;
    }

	//https://www.jianshu.com/p/0ad1cbac47a4
	 public List<Integer> closestKValues_2(Node root, double target, int k) {
	        LinkedList<Integer> res = new LinkedList<>();
	        Stack<Node> stack = new Stack<>();
	        Node curt = root;
	        while (curt != null){
	            stack.push(curt);
	            curt = curt.left;
	        }
	        while (!stack.isEmpty()){
	            curt = stack.pop();
	            if (res.size() == k){
	                if (Math.abs(curt.key - target) >= Math.abs(res.getFirst() - target)){
	                    break;
	                } else {
	                    res.removeFirst();
	                }
	            }
	            res.add(curt.key);
	            if (curt.right != null){
	                curt = curt.right;
	                while (curt != null){
	                    stack.push(curt);
	                    curt = curt.left;
	                }
	            }
	        }
	        return res;
	    }
}
