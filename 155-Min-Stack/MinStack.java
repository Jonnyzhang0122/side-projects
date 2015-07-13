// Min Stack Total Accepted: 36327 Total Submissions: 193581 My Submissions Question Solution 
// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Hide Tags Stack Data Structure

import java.util.*;

class MinStack {
	private Stack<Integer> oriStack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        oriStack.push(x);
        if (minStack.isEmpty()) {
        	minStack.push(x);
        }
        else {
        	if ((long)x - (long)minStack.peek() <= 0) {
        		minStack.push(x);
        	}
        }
    }

    public void pop() {
        if (oriStack.peek() - minStack.peek() == 0) {
        	minStack.pop();
        }
    	oriStack.pop();
    }

    public int top() {
		return oriStack.peek();        
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
    	MinStack A =  new MinStack();
    	A.push(2147483646);
    	A.push(2147483646);
    	A.push(2147483647);
    	System.out.println(A.top());
    	A.pop();
    	System.out.println(A.getMin());
    	A.pop();
    	System.out.println(A.getMin());
    	A.pop();
    	A.push(2147483647);
    	System.out.println(A.top());
    	System.out.println(A.getMin());
    	A.push(-2147483648);
    	System.out.println(A.top());
    	System.out.println(A.getMin());
    	A.pop();
    	System.out.println(A.getMin());
    }
}
