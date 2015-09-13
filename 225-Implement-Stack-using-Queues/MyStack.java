
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
