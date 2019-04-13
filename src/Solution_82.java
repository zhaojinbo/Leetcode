public class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //虚假节点，用来处理头结点直接重复的情况
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = pre.next;
            }else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;

    }
}
