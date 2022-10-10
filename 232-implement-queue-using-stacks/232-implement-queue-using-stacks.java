class MyQueue {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public MyQueue() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    public void push(int val) {
        mainS.push(val);
    }

    public int pop() {
        while (mainS.size() != 1) helperS.push(mainS.pop());
        int rem = mainS.pop();
        while (!helperS.isEmpty()) mainS.push(helperS.pop());
        return rem;
    }

    public int peek() {
        while (mainS.size() != 1) helperS.push(mainS.pop());
        int rem = mainS.pop();
        mainS.push(rem);
        while (!helperS.isEmpty()) mainS.push(helperS.pop());
        return rem;
    }

    public boolean empty() {
        return mainS.size() == 0;
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
