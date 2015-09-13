// Wiggle Sort My Submissions Question Solution 
// Total Accepted: 655 Total Submissions: 1481 Difficulty: Medium
// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

// For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

// Hide Tags Array Sort
// Hide Similar Problems (M) Sort Colors

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
