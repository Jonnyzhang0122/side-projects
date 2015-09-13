
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
