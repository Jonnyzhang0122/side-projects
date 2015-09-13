
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
