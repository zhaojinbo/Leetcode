import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Solution_225 {

    private LinkedList<Integer> linkedList1;
    private LinkedList<Integer> linkedList2;

    /** Initialize your data structure here. */
    public Solution_225() {
        linkedList1 = new LinkedList<>();
        linkedList2 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (linkedList2.isEmpty()){
            linkedList2.offer(x);
            while (!linkedList1.isEmpty()){
                linkedList2.offer(linkedList1.pop());
            }
        }else if (linkedList1.isEmpty()){
            linkedList1.offer(x);
            while (!linkedList2.isEmpty()){
                linkedList1.offer(linkedList2.pop());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!linkedList1.isEmpty()){
            return linkedList1.pop();
        }else if (!linkedList2.isEmpty()){
            return linkedList2.pop();
        }else{
            throw new NoSuchElementException();
        }
    }

    /** Get the top element. */
    public int top() {
        if (!linkedList1.isEmpty()){
            return linkedList1.peek();
        }else if (!linkedList2.isEmpty()){
            return linkedList2.peek();
        }else{
            throw new NoSuchElementException();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return linkedList1.isEmpty()&&linkedList2.isEmpty();
    }

}
