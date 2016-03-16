

// binary search version
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int index = findInsertPos(sorted, nums[i]);
            res.add(index);
            sorted.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
    
    // find the insertion index of n, list sorted in ascending order
    private int findInsertPos(List<Integer> sorted, int n) {
        if (sorted.size() == 0) return 0;
        int start = 0;
        int end = sorted.size() - 1;
        if (sorted.get(end) < n) return end + 1;
        if (sorted.get(0) >= n) return 0; 
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < n) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        if (sorted.get(start) >= n ) return start;
        return end;
    }
}