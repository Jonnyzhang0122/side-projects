
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i += 2) {
            int temp =nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = temp;
        }
        
        return;
    }
}
