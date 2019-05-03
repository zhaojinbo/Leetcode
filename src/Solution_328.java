public class Solution_328 {
    /**
     * 分成两个链表，然后将奇数链表和偶数链表连接起来
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode even = head.next;
        ListNode cur1 = head;//奇数链表的末尾节点
        ListNode cur2 = even;//偶数链表的末尾节点
        ListNode cur = head.next.next;//当前节点，准备将其连接到偶数链表或者奇数链表的后面
        int i = 1;
        while (cur != null) {
            if (i % 2 == 1) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
            i++;
        }
        // 需要将奇数或者偶数链表末尾的节点next置为null
        if (i % 2 == 0) {
            cur2.next = null;
        } else {
            cur1.next = null;
        }
        cur1.next = even;
        return head;
    }
}
