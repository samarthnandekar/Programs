package BFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 https://leetcode.com/problems/course-schedule-ii/

 210. Course Schedule II:- There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .

Note:-The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Time complexity O(n)  Space complexity O(n)             */

public class _4_Course_Schedule_2 {

	public static void main(String[] args) {
		int [][] cources= {{1,0},{2,0},{3,1},{3,2}};
		
        int [] ans=findOrder(4, cources);
        for(int a:ans)
        {
        	System.out.println(a);
        }
	}

	static public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] used = new boolean[numCourses];
        Neighbors[] graph = new Neighbors[numCourses];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Neighbors();
        }

        for (int[] tuple : prerequisites) {
            graph[tuple[1]].neighbor.add(tuple[0]);
        }
        Deque<Integer> stack = new LinkedList<>();
        boolean[] dfs = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (topSort(i, graph, used, stack, dfs)) {
                return new int[0];
            }
        }

        int[] output = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            output[index++] = stack.pollFirst();
        }

        return output;
    }



   static private boolean topSort(int course, Neighbors[] graph, boolean[] used, Deque<Integer> stack, boolean[] dfs) {
        if (used[course]) {
            return false;
        }
        if (dfs[course]) {
            return true;
        }
        dfs[course] = true;
        for (int adj : graph[course].neighbor) {
            if (topSort(adj, graph, used, stack, dfs)) {
                return true;
            }
        }
        dfs[course] = false;
        used[course] = true;
        stack.offerFirst(course);
        return false;
    }
}

class Neighbors {
    List<Integer> neighbor = new ArrayList<>();
}
