// Sliding Window Maximum Total Accepted: 9985 Total Submissions: 45246 My Submissions Question Solution 
// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].

// Note: 
// You may assume k is always valid, ie: 1 <= k <= input array's size for non-empty array.

// Follow up:
// Could you solve it in linear time?

// Hint:

// How about using a data structure such as deque (double-ended queue)?
// The queue size need not be the same as the window’s size.
// Remove redundant elements and the queue should store only elements that need to be considered.
// Hide Tags Heap
// Hide Similar Problems

import java.util.*;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if (k == 0 || nums == null) {
    		return new int[0];
    	}
    	int size = nums.length;
    	int[] result = new int[size - k + 1];
        Deque<Integer> temp = new LinkedList<Integer>();

        for (int i = 0; i < size; ++i) {
        	if (temp.size() != 0 && temp.peekFirst() <= i - k) {
        		temp.pollFirst();
        	}

        	while (temp.size() != 0 && nums[i] >= nums[temp.peekLast()]) {
        		temp.pollLast();
        	}
        	temp.offerLast(i);

        	if (i >= k - 1) {
        		result[i - k + 1] = nums[temp.peekFirst()];
        	}
        }

        return result;
    }

    public static void main(String args[]) {
    	SlidingWindow A = new SlidingWindow();
    	int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    	// int[] nums = {1, -1};
    	int k = 3;
    	for (int n : A.maxSlidingWindow(nums, k)) {
	    	System.out.println(n);
    	}
    }
}
