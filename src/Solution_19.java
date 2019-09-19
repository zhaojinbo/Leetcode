public class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //增加程序鲁棒性，当输入的头节点等于null或者n等于0，直接return
        if (head == null || n < 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;
        for (int i = 0; i < n; i++) {
            if (front.next != null) {
                front = front.next;
            } else {//增加程序鲁棒性，当输入的n大于链表总长度的时候，直接return，避免异常出现
                return head;
            }
        }
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return dummy.next;
    }
}
