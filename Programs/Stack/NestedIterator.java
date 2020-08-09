package Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

Not working, will check later.
/*
 
 341. Flatten Nested List Iterator
Given a nested list of integers, implement an iterator to flatten it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

 */
public class _7_Flatten_Nested_List_Iterator implements Iterator<Integer> {

	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return null if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }

	    private List<Integer> mList = new ArrayList<>();
	    private int index = 0;
	    public _7_Flatten_Nested_List_Iterator(List<_7_Flatten_Nested_List_Iterator> nestedList) {
	        for(int i=0;i<nestedList.size(); i++){
	            flatten(nestedList.get(i));
	            index = 0;
	        }

	    }

	    private void flatten(_7_Flatten_Nested_List_Iterator ni){
	        if(ni.is){
	            mList.add(ni.getInteger());
	        }else{
	            for(_7_Flatten_Nested_List_Iterator i : ni.mList){
	                flatten(i);
	            }
	        }
	    }

	    @Override
	    public Integer next() {
	        return mList.get(index++);
	    }

	    @Override
	    public boolean hasNext() {
	        return index < mList.size();
	    }
	}

	 */
/*
 You can also use a stack:
reversely push each NestedInteger into a stack.
hasNext will check the top if is value then return true, else, poll it push all its content into the stack again, reversely. from size()-1;
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i=nestedList.size()-1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger ni = stack.peek();
            if(ni.isInteger()){
                return true;
            }else{
                stack.pop();
                List<NestedInteger> lni = ni.getList();
                for(int i = lni.size() -1; i>= 0; i--){
                    stack.push(lni.get(i));
                }
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
