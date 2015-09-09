// 3Sum Total Accepted: 73468 Total Submissions: 434909 My Submissions Question Solution 
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note:
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
// The solution set must not contain duplicate triplets.
//     For example, given array S = {-1 0 1 2 -1 -4},

//     A solution set is:
//     (-1, 0, 1)
//     (-1, -1, 2)
// Hide Tags Array Two Pointers
// Hide Similar Problems (M) Two Sum (M) 3Sum Closest (M) 4Sum (M) 3Sum Smaller

import java.util.*;

public class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
        	return result;
        }

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 2; ++i) {
        	if (i != 0 && nums[i] == nums[i - 1]) {
        		continue;
        	}

	        int index1 = i + 1;
	        int index2 = nums.length - 1;
	        while (index1 < index2) {
	        	int sum = nums[i] + nums[index1] + nums[index2];
	        	if (sum == 0) {
	        		ArrayList<Integer> temp = new ArrayList<Integer>();
	        		temp.add(nums[i]);
	        		temp.add(nums[index1]);
	        		temp.add(nums[index2]);
	        		result.add(temp);
	        		++index1;
	        		--index2;
	        		while (index1 < index2 && nums[index1] == nums[index1 - 1]) {
	        			++index1;
	        		}
	        		while (index1 < index2 && nums[index2] == nums[index2 + 1]) {
	        			--index2;
	        		}
	        	}
	        	else if (sum < 0) {
	        		++index1;
	        		while (index1 < index2 && nums[index1] == nums[index1 - 1]) {
	        			++index1;
	        		}
	        	}
	        	else {
	        		--index2;
	        		while (index1 < index2 && nums[index2] == nums[index2 + 1]) {
	        			--index2;
	        		}
	        	}
	        }
        }


        return result;
    }
}
