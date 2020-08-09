package BFS;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 339. Nested List Weight Sum
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1: Given the list [[1,1],2,[1,1]], return 10.
                           1*2+1*2 +2*1+1*2+1*2

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)


 */
public class _0_Nested_List_Weight_Sum {

	public static void main(String[] args) {
		List<NestedInteger> nestedList= new ArrayList<NestedInteger>();
		NestedInteger obj1= new NestedInteger();
		List<Integer> list1=new ArrayList<>();
		list1.add(1);
		list1.add(1);
		obj1.setList(list1);
		
		NestedInteger obj2= new NestedInteger();
		obj2.setNumber(1);
		
		NestedInteger obj3= new NestedInteger();
		List<Integer> list2=new ArrayList<>();
		list2.add(1);
		list2.add(1);
		obj3.setList(list2);
		
		nestedList.add(obj1);
		nestedList.add(obj2);
		nestedList.add(obj3);
		
		
	}

	public int depthSum(List<NestedInteger> nestedList) {
        return depthSumHelper(nestedList, 1);
    }
    
    private int depthSumHelper(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni: nestedList) {
            if (!ni.isList()) {
                sum += ni.getNumber() * level;
            } else {
                sum += depthSumHelper(ni.getList(), level + 1);
            }
        }
        return sum;
    }
    
}
