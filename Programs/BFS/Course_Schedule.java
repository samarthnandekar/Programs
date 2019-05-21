package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

//https://www.programcreek.com/2014/05/leetcode-course-schedule-java/

/*
  There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses may have prerequisites, for example to take course 0 you
  have to first take course 1, which is expressed as a pair: [0,1]. Given the total number of courses and a list of prerequisite pairs, is it 
  possible for you to finish all courses?

    For example, given 2 and [[1,0]], there are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
    For another example, given 2 and [[1,0],[0,1]], there are a total of 2 courses to take. To take course 1 you should have finished course 0, and 
    to take course 0 you should also have finished course 1. So it is impossible.

	Note:-
	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	You may assume that there are no duplicate edges in the input prerequisites.
	
	******  https://www.youtube.com/watch?v=VvKwqfXri0I   ****** check there are links with videos
	
	
 */
public class Course_Schedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCources=2;
		int [][] prerequisites= {{1,0},
				                 {0,1}};
		
	   boolean isPossible=canFinish(numCources,prerequisites);
       System.out.println(isPossible);
       
       System.out.println(canFinish_dfs(numCources, prerequisites));
		
	}	
	/*
	 Java Solution 1 - BFS:- This solution uses breath-first search and it is easy to understand.
	 */
	static public boolean canFinish(int numCourses, int[][] prerequisites) {
	    if(prerequisites == null){
	        throw new IllegalArgumentException("illegal prerequisites array");
	    }
	 
	    int len = prerequisites.length;
	 
	    if(numCourses == 0 || len == 0){
	        return true;
	    }
	 
	    // counter for number of prerequisites
	    int[] pCounter = new int[numCourses];
	    for(int i=0; i<len; i++){
	        pCounter[prerequisites[i][0]]++;
	    }
	 
	    //store courses that have no prerequisites
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    for(int i=0; i<numCourses; i++){
	        if(pCounter[i]==0){
	            queue.add(i);
	        }
	    }
	 
	    // number of courses that have no prerequisites
	    int numNoPre = queue.size();
	 
	    while(!queue.isEmpty()){
	        int top = queue.remove();
	        for(int i=0; i<len; i++){
	            // if a course's prerequisite can be satisfied by a course in queue
	            if(prerequisites[i][1]==top){
	                pCounter[prerequisites[i][0]]--;
	                if(pCounter[prerequisites[i][0]]==0){
	                    numNoPre++;
	                    queue.add(prerequisites[i][0]);
	                }
	            }
	        }
	    }
	 
	    return numNoPre == numCourses;
	}
	
	/*
	 * Java Solution 2 - DFS
	 */

	static public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {
	    if(prerequisites == null){
	        throw new IllegalArgumentException("illegal prerequisites array");
	    }
	 
	    int len = prerequisites.length;
	 
	    if(numCourses == 0 || len == 0){
	        return true;
	    }
	 
	    //track visited courses
	    int[] visit = new int[numCourses];
	 
	    // use the map to store what courses depend on a course 
	    HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
	    for(int[] a: prerequisites){
	        if(map.containsKey(a[1])){
	            map.get(a[1]).add(a[0]);
	        }else{
	            ArrayList<Integer> l = new ArrayList<Integer>();
	            l.add(a[0]);
	            map.put(a[1], l);
	        }
	    }
	 
	    for(int i=0; i<numCourses; i++){
	        if(!canFinishDFS(map, visit, i))
	            return false;
	    }
	 
	    return true;
	}
	 
	static private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
	    if(visit[i]==-1) 
	        return false;
	    if(visit[i]==1) 
	        return true;
	 
	    visit[i]=-1;
	    if(map.containsKey(i)){
	        for(int j: map.get(i)){
	            if(!canFinishDFS(map, visit, j)) 
	                return false;
	        }
	    }
	 
	    visit[i]=1;
	 
	    return true;
	}
}
