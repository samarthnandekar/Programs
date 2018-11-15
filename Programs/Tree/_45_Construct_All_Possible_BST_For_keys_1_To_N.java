package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
 * 
 In this article, first count of possible BST (Binary Search Trees)s is discussed, then construction of all possible BSTs.

How many structurally unique BSTs for keys from 1..N?
For example, for N = 2, there are 2 unique BSTs
     1               2  
      \            /
       2         1 

For N = 3, there are 5 possible BSTs
  1              3        3         2      1
    \           /        /        /  \      \
     3        2         1        1    3      2
    /       /            \                    \
   2      1               2                    3

How to construct all BST for keys 1..N?
The idea is to maintain a list of roots of all BSTs. Recursively construct all possible left and right subtrees. Create a tree for every pair of left and right subtree and add the tree to list. Below is detailed algorithm.

1) Initialize list of BSTs as empty.  
2) For every number i where i varies from 1 to N, do following
......a)  Create a new node with key as 'i', let this node be 'node'
......b)  Recursively construct list of all left subtrees.
......c)  Recursively construct list of all right subtrees.
3) Iterate for all left subtrees
   a) For current leftsubtree, iterate for all right subtrees
        Add current left and right subtrees to 'node' and add
        'node' to list.
        
 */
public class _45_Construct_All_Possible_BST_For_keys_1_To_N 
{

	public List<Node> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return construct(1, n);
    }

    private List<Node> construct(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }
        
        List<Node> allTrees = new ArrayList<Node>();
        
        for (int root = start; root <= end; root++) {
            //get all subtrees from left and right side.
            List<Node> allLeftSubstrees = construct(start, root - 1);
            List<Node> allRightSubstrees = construct(root + 1, end);
            //iterate through them in all combination and them connect them to root
            //and add to allTrees.
            for (Node left : allLeftSubstrees) {
                for (Node right : allRightSubstrees) {
                    Node node = new Node(root);
                    node.left = left;
                    node.right = right;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }

    public void printAllTrees(List<Node> allTrees) {
        TreeTraversals tt = new TreeTraversals();
        System.out.println("Total number of trees " + allTrees.size());
        for(Node node : allTrees) {
            tt.inOrder(node);
            System.out.println();
            tt.preOrder(node);
            System.out.print("\n\n");
        }
    }

    public static void main(String args[]) {
    	_45_Construct_All_Possible_BST_For_keys_1_To_N ct = new _45_Construct_All_Possible_BST_For_keys_1_To_N();
        List<Node> allTrees = ct.generateTrees(3);
        ct.printAllTrees(allTrees);
    }
}
