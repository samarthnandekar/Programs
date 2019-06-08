package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 
 Link :- https://leetcode.com/problems/reconstruct-itinerary/
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:- 
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. 
For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].

All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.

Example 1:
Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

Example 2:
Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
             
 */
public class _19_Reconstruct_Itinerary {

	public static void main(String[] args) {
	
		String input[][] = {{"MUC","LHR"},
				            {"JFK","MUC"},
				            {"SFO","SJC"},
				            {"LHR","SFO"}};
		
		String input2[] []= {{"JFK","SFO"},
				             {"JFK","ATL"},
				             {"SFO","BOS"},
				             {"BOS","CHO"}};
		
		_19_Reconstruct_Itinerary ri = new _19_Reconstruct_Itinerary();
        List<String> output = ri.findItinerary(input2);
        output.forEach(r -> System.out.print(r + " -->"));
        
        System.out.println("==============");
        ri.findItinerary_1(input2);
        System.out.println(result);
        System.out.println("==============");
        
        Map<String, String> dataSet = new HashMap<String, String>(); 
        dataSet.put("Chennai", "Banglore"); 
        dataSet.put("Bombay", "Delhi"); 
        dataSet.put("Goa", "Chennai"); 
        dataSet.put("Delhi", "Goa"); 
  
        printResult(dataSet); 

	}
	
	public List<String> findItinerary(String[][] tickets) 
	{
        List<Itinerary> input = new ArrayList<>();
        for (String[] ticket : tickets) 
        {
            input.add(new Itinerary(ticket[0], ticket[1]));
        }
        Collections.sort(input);
        List<String> output = new ArrayList<>();
        boolean[] used = new boolean[input.size()];
        findItineraryUtil(input, used, "JFK", output, 0);
        return output;
    }

    boolean findItineraryUtil(List<Itinerary> input, boolean[] used, String end, List<String> output, int count) {
        if (count == used.length) {
            output.add(end);
            return true;
        }
        for (int i = 0; i < input.size(); i++) {
            if (used[i]) {
                continue;
            }
            Itinerary itr = input.get(i);
            if (itr.start.equals(end)) {
                output.add(itr.start);
                used[i] = true;
                if (findItineraryUtil(input, used, itr.dest, output, count + 1)) {
                    return true;
                }
                used[i] = false;
                output.remove(output.size() - 1);
            }
        }
        return false;
    }


    
    // approach 2
    static HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	static LinkedList<String> result = new LinkedList<String>();
    public List<String> findItinerary_1(String[][] tickets) 
    {
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				PriorityQueue<String> q = new PriorityQueue<String>();
				map.put(ticket[0], q);
			}
			map.get(ticket[0]).offer(ticket[1]);
		}
 
		dfs("JFK");
		return result;
	}
 
	static public void dfs(String s)
	{
		PriorityQueue<String> q = map.get(s);
 
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
 
		result.addFirst(s);
	}

/*
 https://www.geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
 
 Find Itinerary from a given list of tickets
Given a list of tickets, find itinerary in order using the given list.

Example:

Input:
"Chennai" -> "Banglore"
"Bombay" -> "Delhi"
"Goa"    -> "Chennai"
"Delhi"  -> "Goa"

Output: - Bombay->Delhi, Delhi->Goa, Goa->Chennai, Chennai->Banglore,

It may be assumed that the input list of tickets is not cyclic and there is one ticket from every city except final destination.

One Solution is to build a graph and do Topological Sorting of the graph. Time complexity of this solution is O(n).

We can also use hashing to avoid building a graph. The idea is to first find the starting point. A starting point would never be on
‘to’ side of a ticket. Once we find the starting point, we can simply traverse the given map to print itinerary in order. Following are steps.

1) Create a HashMap of given pair of tickets.  Let the created 
   HashMap be 'dataset'. Every entry of 'dataset' is of the form 
   "from->to" like "Chennai" -> "Banglore"

2) Find the starting point of itinerary.
     a) Create a reverse HashMap.  Let the reverse be 'reverseMap'
        Entries of 'reverseMap' are of the form "to->form". 
        Following is 'reverseMap' for above example.
        "Banglore"-> "Chennai" 
        "Delhi"   -> "Bombay" 
        "Chennai" -> "Goa"
        "Goa"     ->  "Delhi"
 
     b) Traverse 'dataset'.  For every key of dataset, check if it
        is there in 'reverseMap'.  If a key is not present, then we 
        found the starting point. In the above example, "Bombay" is
        starting point.

3) Start from above found starting point and traverse the 'dataset' 
   to print itinerary.
All of the above steps require O(n) time so overall time complexity is O(n).


 */

// This function populates 'result' for given input 'dataset' 
private static void printResult(Map<String, String> dataSet) 
{ 
    // To store reverse of given map 
    Map<String, String> reverseMap = new HashMap<String, String>(); 

    // To fill reverse map, iterate through the given map 
    for (Map.Entry<String,String> entry: dataSet.entrySet()) 
        reverseMap.put(entry.getValue(), entry.getKey()); 

    // Find the starting point of itinerary 
    String start = null; 
    for (Map.Entry<String,String> entry: dataSet.entrySet()) 
    { 
          if (!reverseMap.containsKey(entry.getKey())) 
          { 
               start = entry.getKey(); 
               break; 
          } 
    } 

    // If we could not find a starting point, then something wrong 
    // with input 
    if (start == null) 
    { 
       System.out.println("Invalid Input"); 
       return; 
    } 

    // Once we have starting point, we simple need to go next, next 
    // of next using given hash map 
    String to = dataSet.get(start); 
    while (to != null) 
    { 
        System.out.print(start +  "->" + to + ", "); 
        start = to; 
        to = dataSet.get(to); 
    } 
} 
} 


class Itinerary implements Comparable<Itinerary> 
{
    String start;
    String dest;
    Itinerary(String start, String dest) {
        this.start = start;
        this.dest = dest;
    }

    @Override
    public int compareTo(Itinerary other) {
        if (this.start.equals(other.start)) {
            return this.dest.compareTo(other.dest);
        } else {
            return this.start.compareTo(other.start);
        }
    }
}
