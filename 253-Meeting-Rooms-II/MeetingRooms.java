// Meeting Rooms II My Submissions Question Solution 
// Total Accepted: 1033 Total Submissions: 3749 Difficulty: Medium
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.

// Hide Tags Heap Greedy Sort
// Hide Similar Problems (H) Merge Intervals (E) Meeting Rooms

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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] begin = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; ++i) {
            begin[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(begin);
        Arrays.sort(end);
        
        int beginPos = 0, endPos = 0, max = 0, count = 0;
        
        while (beginPos < intervals.length && endPos < intervals.length) {
            if (begin[beginPos] < end[endPos]) {
                ++count;
                ++beginPos;
            }
            else {
                --count;
                ++endPos;
            }
            if (count > max)
                max = count;
        }
        
        return max;
    }
}
