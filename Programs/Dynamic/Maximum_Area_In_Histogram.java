package Dynamic;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/* Linked:- https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

Given an array representing height of bar in bar graph, find max histogram area in the bar graph. Max histogram will be max rectangular
area in the graph.


 ** Maintain a stack
  
 If stack is empty or value at index of stack is less than or equal to value at current index, push this into stack.
 Otherwise keep removing values from stack till value at index at top of stack is less than value at current index.
 
 While removing value from stack calculate area
 if stack is empty 
   it means that till this point value just removed has to be smallest element
   so area = input[top] * i
   if stack is not empty then this value at index top is less than or equal to 
   everything from stack top + 1 till i. So area will
   area = input[top] * (i - stack.peek() - 1);
  
   Finally maxArea is area if area is greater than maxArea.
  
  Time complexity is O(n)
  Space complexity is O(n)

 */
public class Maximum_Area_In_Histogram {

	
	public int maxHistogram(int input[]){
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        
        for(i=0; i < input.length;)
        {
            if(stack.isEmpty() || input[stack.peek()] <= input[i]){
                stack.push(i);
                i++;
            }
            else
            {
                int currentMax_index = stack.pop();
                //if stack is empty means everything till i has to be greater or equal to input[top] so get area by input[top] * i;
                
                if(stack.isEmpty()){
                    area = input[currentMax_index] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1 has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else
                {
                    area = input[currentMax_index] * (i - stack.peek() - 1);
                }
                if(area > maxArea)
                {
                    maxArea = area;
                }
            }
        }
        
        while(!stack.isEmpty())
        {
            int currentMax_index = stack.pop();
            //if stack is empty means everything till i has to be greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[currentMax_index] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1 has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else
            {
                area = input[currentMax_index] * (i - stack.peek() - 1);
            }
            if(area > maxArea)
            {
                maxArea = area;
            }
        }
        return maxArea;
    }
	
	public static void main(String args[]){
		Maximum_Area_In_Histogram mh = new Maximum_Area_In_Histogram();
        //int input[] = {2,2,2,6,1,5,4,2,2,2,2};
        int input[]= {1,4,4};
        int maxArea = mh.maxHistogram(input);
        System.out.println(maxArea);

    }
	
}
