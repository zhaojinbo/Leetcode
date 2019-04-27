public class Solution_148 {
    public ListNode sortList(ListNode head) {
        return head == null ? null : sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 这一步将前后两个链表断开
        pre.next = null;
        //前面排序，后面排序，然后归并
        ListNode l = sort(head);
        ListNode r = sort(slow);
        return merge(l, r);
    }

    /**
     * 归并两个链表，不需要额外的空间
     *
     * @param l
     * @param r
     * @return 返回值为归并后有序链表的头结点
     */
    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                cur.next = l;
                cur = cur.next;
                l = l.next;
            } else {
                cur.next = r;
                cur = cur.next;
                r = r.next;
            }
        }
        if (l != null) {
            cur.next = l;
        }
        if (r != null) {
            cur.next = r;
        }
        return dummyHead.next;
    }
}
