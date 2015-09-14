
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(len, IntComparator);
        
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        int result = 0;
        for (int i = 0; i < k; ++i) {
            result = maxHeap.poll();
        }
        
        return result;
    }
    
    private Comparator<Integer> IntComparator = new Comparator<Integer>() {
        public int compare(Integer left, Integer right) {
            // let the bigger one be the first
            return right - left;
        }
    };
}
