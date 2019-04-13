public class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p = head;
        k %= len;
        if (k == 0) {
            return head;
        }
        for (int i = 1; i < len - k; i++) {
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        for (int i = 1; i < k; i++) {
            p = p.next;
        }
        p.next = head;
        return newHead;
    }
}
