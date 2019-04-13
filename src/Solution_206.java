public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode cur = head;
        ListNode pre = null;

        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
