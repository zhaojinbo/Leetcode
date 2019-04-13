import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Solution_232 {
    private LinkedList<Integer> linkedList1;
    private LinkedList<Integer> linkedList2;

    /** Initialize your data structure here. */
    public Solution_232() {
        linkedList1 = new LinkedList<>();
        linkedList2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!linkedList1.isEmpty()){
            Integer integer = linkedList1.pop();
            linkedList2.push(integer);
        }
        linkedList2.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!linkedList2.isEmpty()){
            Integer integer = linkedList2.pop();
            linkedList1.push(integer);
        }
        return linkedList1.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!linkedList2.isEmpty()){
            Integer integer = linkedList2.pop();
            linkedList1.push(integer);
        }
        Integer f = linkedList1.peek();
        if (f == null)
            throw new NoSuchElementException();
        return f;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return linkedList1.isEmpty()&&linkedList2.isEmpty();
    }
}
