class MyStack {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public MyStack() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    public void push(int val) {
        mainQ.add(val);
    }

    public int pop() {
        while (mainQ.size() != 1) 
            helperQ.add(mainQ.poll());
        int rem = mainQ.poll();
        mainQ = helperQ;
        helperQ = new ArrayDeque<>();
        return rem;
    }

    public int top() {
        while (mainQ.size() != 1) 
            helperQ.add(mainQ.poll());
        int rem = mainQ.poll();
        helperQ.add(rem);
        mainQ = helperQ;
        helperQ = new ArrayDeque<>();
        return rem;
    }

    public boolean empty() {
        return mainQ.size() == 0;
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
