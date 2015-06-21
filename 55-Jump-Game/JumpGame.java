// Jump Game Total Accepted: 45651 Total Submissions: 168657 My Submissions Question Solution 
// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.

// Hide Tags Array Greedy

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return false;
        }

        boolean[] table = new boolean[nums.length];
        table[0] = true;

        for (int i = 1; i < nums.length; ++i) {
        	for (int j = 0; j < i; ++j) {
        		if (table[j] && nums[j] + j >= i) {
        			table[i] = true;
        			break;
        		}
        		else {
        			table[i] = false;
        		}
        	}
        }

        return table[nums.length - 1];
    }
}