class CustomStack {
    int arr[];
    int top, maxSize;

    public CustomStack(int max) {
        maxSize = max;
        arr = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top == maxSize - 1) return; 
        else arr[++top] = x; // stack is full
    }

    public int pop() {
        if (top != -1) { // stack not empty
            top--;
            return arr[top + 1];
        }
        return -1; // stack is empty, return -1
    }

    public void increment(int k, int val) {
        if (k > top)  // less elements in stack -> add val to all elements
            for (int i = 0; i <= top; ++i) arr[i] += val;
        else  //add val to k no. of elements
            for (int i = 0; i < k; ++i) arr[i] += val;
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
