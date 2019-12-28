package Array;

import java.util.ArrayList;
import java.util.List;

/*
 https://leetcode.com/problems/insert-interval/
 
 57. Insert Interval
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 */
public class _127_InsertInterval {

	public static class Interval {
        int start; 
        int end;

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        boolean alreadyAdded = false;
        for (int i = 0; i < intervals.size(); i++) 
        {
            if ((intervals.get(i).end < newInterval.start)) {
                result.add(intervals.get(i));
            } 
            else if (intervals.get(i).start > newInterval.end) 
            {
                if (!alreadyAdded) {
                    result.add(newInterval);
                    alreadyAdded = true;
                }
                result.add(intervals.get(i));
            } 
            else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
                if (!alreadyAdded) {
                    result.add(newInterval);
                    alreadyAdded = true;
                }
            }
        }
        if (!alreadyAdded) {
            result.add(newInterval);
        }
        return result;
    }

    public static void main(String args[]) {
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(4,9);
        //Interval i3 = new Interval(9,10);
        //Interval i4 = new Interval(11,12);
        List<Interval> input = new ArrayList<>();
        input.add(i1);
        input.add(i2);
        //input.add(i3);
      //  input.add(i4);
        _127_InsertInterval ii = new _127_InsertInterval();
        System.out.println(ii.insert(input, new Interval(2, 5)));
    }
}
