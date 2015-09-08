// Contains Duplicate III Total Accepted: 11608 Total Submissions: 72898 My Submissions Question Solution 
// Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

// Hide Tags Binary Search Tree
// Hide Similar Problems (E) Contains Duplicate (E) Contains Duplicate II

import java.util.*;

public class Contains3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || k < 1 || t < 0) {
        	return false;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < nums.length; ++i) {
        	int n = nums[i];

        	// remove the element out of the windows
        	if (i > k) {
        		set.remove(nums[i - k - 1]);
        	}

        	if ((set.floor(n) != null && set.floor(n) + t >= n) || (set.ceiling(n) != null && set.ceiling(n) - t <= n)) {
        		return true;
        	}

        	set.add(n);
        }

        return false;
    }
}
