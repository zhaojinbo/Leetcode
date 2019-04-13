public class Solution_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode start = pre;//翻转链表的前一个元素
        ListNode end = cur;//待翻转链表的第一个元素，也就是翻转后的链表的最后一个元素
        for (int i = m; i <= n; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //最后设置一下开始元素和结束元素的next指针
        end.next = cur;
        start.next = pre;

        return fake.next;
    }
}
