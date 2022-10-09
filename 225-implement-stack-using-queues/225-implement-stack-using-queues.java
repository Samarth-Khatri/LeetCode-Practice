class MyStack {
    Queue<Integer> que;

    public MyStack() {
        que = new LinkedList<Integer>();
    }

    public void push(int val) {
        if (que.size() == 0) que.add(val);
        else {
            que.add(val);
            int len = que.size() - 1;
            for (int i = 1; i <= len; ++i) 
                que.add(que.poll());
        }
    }

    public int pop() {
        if (que.size() == 0) return -1;
        else return que.poll();
    }

    public int top() {
        if (que.size() == 0) return -1;
        else return que.peek();
    }

    public boolean empty() {
        return que.size() == 0;
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
