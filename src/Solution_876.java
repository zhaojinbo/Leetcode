public class Solution_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;
        while (back != null && back.next != null) {
            front = front.next;
            back = back.next.next;
        }
        if (back == null) {
            return front;
        } else {
            return front.next;
        }
    }
}
