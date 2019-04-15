public class Solution_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;//前半段已排序的尾节点
        ListNode second = head.next;//后半段待排序的头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (second != null) {
            if (second.val > tail.val) {
                tail = tail.next;
                second = second.next;
            } else {
                ListNode next = second.next;
                ListNode pre = dummy;
                ListNode cur = pre.next;
                while (cur != second) {
                    if (second.val >= cur.val) {
                        pre = pre.next;
                        cur = cur.next;
                    } else {
                        pre.next = second;
                        second.next = cur;
                        tail.next = next;
                        break;
                    }
                }
                second = next;
            }
        }
        return dummy.next;
    }
}
