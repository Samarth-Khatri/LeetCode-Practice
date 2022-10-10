***POP EFFICIENT METHOD***
```
public static class QueueToStackAdapter {
Queue<Integer> mainQ;
Queue<Integer> helperQ;
​
public QueueToStackAdapter() {
mainQ = new ArrayDeque<>();
helperQ = new ArrayDeque<>();
}
​
int size() {
return mainQ.size();
}
​
void push(int val) {
helperQ.add(val);
while(!mainQ.isEmpty())
helperQ.add(mainQ.poll());
mainQ = helperQ;
helperQ = new ArrayDeque<>();
}
​
int pop() {
if(mainQ.isEmpty()) {
System.out.println("Stack underflow");
return -1;
}
return mainQ.remove();
}
​
int top() {
if(mainQ.isEmpty()) {
System.out.println("Stack underflow");
return -1;
}
return mainQ.peek();
}
}
```