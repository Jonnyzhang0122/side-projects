// Largest Rectangle in Histogram Total Accepted: 37247 Total Submissions: 164767 My Submissions Question Solution 
// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


// The largest rectangle is shown in the shaded area, which has area = 10 unit.

// For example,
// Given height = [2,1,5,6,2,3],
// return 10.

// Hide Tags Array Stack

import java.util.*;

public class Rectangle {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0 || height == null) {
        	return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int cur = -1;
        int h, w;
        for (int i = 0; i <= height.length; ++i) {
        	if (i  == height.length) {
        		cur = -1;
        	}
        	else {
        		cur = height[i];
        	}

    		while (!stack.isEmpty() && cur < height[stack.peek()]) {
    			h = height[stack.pop()];
    			if (stack.isEmpty()) {
    				w = i;
    			}
    			else {
    				w = i - 1 - stack.peek();
    			}
    			max = Math.max(max, h * w);
    		}
    		stack.push(i);
        }

        return max;
    }
}
