public class Solution_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.val < x) {
            cur = cur.next;
        }
        ListNode border = cur;//用来指向前面小于部分的最后一个节点
        ListNode temp;
        ListNode start;//用来指向后面小于部分（需要移动到前面）的第一个节点
        while (cur.next != null) {
            if (cur.next.val >= x){
                cur = cur.next;
            }else {
                start = cur;
                while (cur.next != null && cur.next.val < x){
                    cur = cur.next;
                }
                temp = border.next;
                border.next = start.next;
                start.next = cur.next;
                cur.next = temp;
                border = cur;
                cur = start;
            }
        }
        return dummy.next;
    }
}
