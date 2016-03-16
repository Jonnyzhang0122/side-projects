// binary search version
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        List<Integer> seq = new ArrayList<>();
        for (int n : nums) {
            // if seq is empty or current number is larger than the largest number in seq
            if (seq.size() == 0 || seq.get(seq.size() - 1) < n) {
                seq.add(n);
            }
            // find correct position an replace previous value
            else {
                int pos = Collections.binarySearch(seq, n);
                if (pos < 0) {
                    // search would return pos = (-(insertion point) - 1)
                    seq.set(-pos - 1, n);
                }
            }
        }
        return seq.size();
    }
}


// N^2 version
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max + 1;
    }
}