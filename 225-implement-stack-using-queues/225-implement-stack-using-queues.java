class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int val) {
        if (queue.size() == 0) queue.add(val);
        else {
            queue.add(val);
            int len = queue.size() - 1;
            for (int i = 1; i <= len; ++i) 
                queue.add(queue.poll());
        }
    }

    public int pop() {
        if (queue.size() == 0) return -1;
        else return queue.poll();
    }

    public int top() {
        if (queue.size() == 0) return -1;
        else return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
