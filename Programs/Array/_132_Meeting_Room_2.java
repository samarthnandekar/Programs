package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


/*
 
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 find the minimum number of conference rooms required.

 * Both methods have time comlexity of nlogn
 * Method 1 has space complexity of O(1)
 
For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.

https://leetcode.com/problems/meeting-rooms-ii/

 */
public class _132_Meeting_Room_2 
{
   public static void main(String [] args)
   {
	   MeetingInterval [] arr= {new MeetingInterval(0,30),new MeetingInterval(5,10), new MeetingInterval(15, 20)};
	   int roomReq=minMeetingRooms(arr);
	   int roomReq1=minMeetingRooms1(arr);
	   System.out.println(roomReq);
	   System.out.println(roomReq1);
   }
	


 static public int minMeetingRooms1(MeetingInterval[] intervals) {
     int[] start = new int[intervals.length];
     int[] end = new int[intervals.length];

     for (int i = 0; i < intervals.length; i++) {
         start[i] = intervals[i].start;
         end[i] = intervals[i].end;
     }

     Arrays.sort(start);
     Arrays.sort(end);

     int j = 0;
     int rooms = 0;
     for (int i = 0; i < start.length; i++) {
         if (start[i] < end[j]) {
             rooms++;
         } else {
             j++;
         }
     }
     return rooms;
 }

 // ***** check why we have to use priorityqueue ****
 static public int minMeetingRooms(MeetingInterval[] intervals) {
     if (intervals.length == 0) {
         return 0;
     }
     Arrays.sort(intervals, (a, b) ->  a.start - b.start);
     PriorityQueue<MeetingInterval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
     pq.offer(intervals[0]);
     int rooms = 1;
     for (int i = 1; i < intervals.length; i++) {
         MeetingInterval it = pq.poll();
         if (it.end <= intervals[i].start) {
             it = new MeetingInterval(it.start, intervals[i].end);
         } else {
             rooms++;
             pq.offer(intervals[i]);
         }
         pq.offer(it);
     }
     return rooms;
 }
}



/*
 
 public int minMeetingRooms(Interval[] intervals) {
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        
        for(int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int max_count = 0;
        int room_count = 0;
        int e = 0;
        for(int s = 0; s < start.length; s++) {
            room_count++;
            for(; end[e] <= start[s]; e++) {
                room_count--;
            }
            max_count = Math.max(max_count, room_count);
        }
        
        return max_count;
    }
 
 
 */
