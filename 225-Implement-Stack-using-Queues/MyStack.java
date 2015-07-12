// Implement Stack using Queues Total Accepted: 7938 Total Submissions: 26213 My Submissions Question Solution 
// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.
// Notes:
// You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
// Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
// You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
// Update (2015-06-11):
// The class name of the Java function had been updated to MyStack instead of Stack.

// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and all test cases.

// Hide Tags Stack Data Structure
// Hide Similar Problems (E) Implement Queue using Stacks

class MyStack {
	private Queue<Integer> queueMain = new LinkedList<Integer>();
	private Queue<Integer> queueTemp = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        queueTemp.offer(x);
        while (!queueMain.isEmpty()) {
        	queueTemp.offer(queueMain.peek());
        	queueMain.poll();
        }

        Queue<Integer> temp;
        temp = queueMain;
        queueMain = queueTemp;
        queueTemp = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queueMain.poll();
    }

    // Get the top element.
    public int top() {
    	return queueMain.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queueMain.isEmpty();
    }
}
