// Meeting Rooms My Submissions Question Solution 
// Total Accepted: 974 Total Submissions: 2983 Difficulty: Easy
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return false.

// Hide Tags Sort
// Hide Similar Problems (H) Merge Intervals (M) Meeting Rooms II

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; ++i) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int startPos = 0, endPos = 0, count = 0;
        
        while (startPos < intervals.length) {
            if (starts[startPos] < ends[endPos]) {
                ++count;
                ++startPos;
            }
            else {
                --count;
                ++endPos;
            }
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}
