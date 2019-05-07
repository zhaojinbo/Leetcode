import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Solution_232 {
    private LinkedList<Integer> linkedList1;
    private LinkedList<Integer> linkedList2;

    /**
     * Initialize your data structure here.
     */
    public Solution_232() {
        linkedList1 = new LinkedList<>();
        linkedList2 = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        // 每次放元素都往第一个栈里面放
        linkedList1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 每次取元素都从第二个栈里取，直到取空时，将第一个栈里面放的元素移动过来
        if (linkedList2.isEmpty()) {
            while (!linkedList1.isEmpty()) {
                Integer pop = linkedList1.pop();
                linkedList2.push(pop);
            }
        }
        return linkedList2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (linkedList2.isEmpty()) {
            while (!linkedList1.isEmpty()) {
                Integer pop = linkedList1.pop();
                linkedList2.push(pop);
            }
        }
        Integer peek = linkedList2.peek();
        if (peek == null) {
            throw new NoSuchElementException();
        }
        return peek;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return linkedList1.isEmpty() && linkedList2.isEmpty();
    }
}
