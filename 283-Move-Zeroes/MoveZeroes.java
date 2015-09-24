
public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        
        int zeroIndex = len;
        int cur = 0;
        for (int num : nums) {
            if (num == 0) {
                --zeroIndex;
            }
            else {
                nums[cur] = num;
                ++cur;
            }
        }
        
        while (zeroIndex < len) {
            nums[zeroIndex] = 0;
            ++zeroIndex;
        }
    }
}
