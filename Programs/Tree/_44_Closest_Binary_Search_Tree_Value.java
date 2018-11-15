package Tree;

/*  link :- https://www.geeksforgeeks.org/find-closest-element-binary-search-tree/
 Given a binary search tree and a target node K. The task is to find the node with minimum absolute difference with given target value K.


			9
		  /   \
		4		17
	  /	 \        \
	3	  6			22
		 /  \      /
		5	 7	  20


// For above binary search tree
Input  :  k = 4
Output :  4

Input  :  k = 18
Output :  17

Input  :  k = 12
Output :  9
 */
public class _44_Closest_Binary_Search_Tree_Value {
	
	public int closestValue(Node root, double target) {
        int r = target > 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return closestValueUtil(root, target, r);
    }

    private int closestValueUtil(Node root, double target, int result) {
        if (root == null) {
            return result;
        }
        if (target == root.key) {
            return root.key;
        }
        if (Math.abs(root.key - target) < Math.abs(result - target)) {
            result = root.key;
        }
        if (target < root.key) {
            return closestValueUtil(root.left, target, result);
        } else {
            return closestValueUtil(root.right, target, result);
        }
    }

}
