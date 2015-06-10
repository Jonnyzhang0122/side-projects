// Two Sum Total Accepted: 98277 Total Submissions: 557012 My Submissions Question Solution 
// Given an array of integers, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

// Hide Tags Array Hash Table

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
    	int index1 = 0, index2 = 0;
    	for (int i = 0; i < nums.length; ++i) {
    		for (int j = 0; j < nums.length; ++j) {
    			if (nums[i] + nums[j] == target && i != j) {
    				index1 = i + 1;
    				index2 = j + 1;
			    	int[] result = {index1, index2};
	    			return result;
    			}
    		}
    	}

    	int[] result = {};
    	return result;
    }

	// // smarter version (need to assume that the array is sorted)
 //    public int[] twoSum(int[] nums, int target) {
 //    	int index1 = 0, index2 = 0;
	// 	for (int i = 0, j = nums.length - 1; i < j;) {
	// 		if (nums[i] + nums[j] == target) {
	// 			index1 = i + 1;
	// 			index2 = j + 1;
	// 	    	int[] result = {index1, index2};
 //    			return result;
	// 		}
	// 		else if (nums[i] + nums[j] > target) {
	// 			--j;
	// 		}
	// 		else {
	// 			++i;
	// 		}
	// 	}

 //    	int[] result = {};
 //    	return result;
 //    }

    public static void main(String[] args) {
    	TwoSum A= new TwoSum();
    	int[] nums = {2, 7, 11, 15};
    	int target = 13;
    	int[] result;
    	result = A.twoSum(nums, target);
    	for (int i = 0; i < result.length; ++i) {
    		System.out.printf("%d\n", result[i]);
    	}
    }
}