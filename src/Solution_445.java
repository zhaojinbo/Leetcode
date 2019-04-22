import java.util.LinkedList;

public class Solution_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<Integer> stack3 = new LinkedList<>();
        putValueIntoStack(l1, stack1);
        putValueIntoStack(l2, stack2);
        int carrier = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = carrier;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            carrier = sum / 10;
            stack3.push(sum % 10);
        }
        if (carrier>0){
            stack3.push(carrier);
        }
        return stackToLinkedList(stack3);
    }

    private ListNode stackToLinkedList(LinkedList<Integer> stack) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!stack.isEmpty()){
            p.next = new ListNode(stack.pop());
            p = p.next;
        }
        return dummy.next;
    }

    private void putValueIntoStack(ListNode head, LinkedList<Integer> stack) {
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
    }
}
