package Array;

import java.util.Arrays;
import java.util.Comparator;

/*

Meetings Room:- Given an array of meeting time intervals consisting of start and end times [s1, e1], [s2, e2], ... , determine if a person could 
                attend all meetings.

For example,
Given [ [0, 30], [5, 10], [15, 20] ],
return false.

The idea is pretty simple: first we sort the intervals in the ascending order of start; then we check for the overlapping of each pair of neighboring
intervals. If they do, then return false; after we finish all the checks and have not returned false, just return true.

Sorting takes O(nlogn) time and the overlapping checks take O(n) time, so this idea is O(nlogn) time in total.

 */
public class _131_Meeting_Room {

	public static void main(String[] args) {
	
		MeetingInterval[] intervals= {new MeetingInterval(0,30),new MeetingInterval(5,10), new MeetingInterval(15, 20)};
		boolean isAttendAble=canAttendMeetings(intervals);

		System.out.println(isAttendAble);
	}
	
	static public boolean canAttendMeetings(MeetingInterval[] intervals) {
	    Arrays.sort(intervals, new Comparator<MeetingInterval>(){
	        public int compare(MeetingInterval a, MeetingInterval b){
	            return a.start-b.start;
	        }
	    });
	 
	    for(int i=0; i<intervals.length-1; i++){
	        if(intervals[i].end>intervals[i+1].start){
	            return false;
	        }
	    }
	 
	    return true;
	}

}


class MeetingInterval
{
	int start;
	int end;
	
	public MeetingInterval(int s, int e) {
		 start=s;
		 end=e;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}