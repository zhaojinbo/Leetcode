public class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;//前面的指针
        ListNode q = head;//后面的指针
        while (p.next != null) {
            q = p.next;
            while (p.val == q.val) {
                if (q.next != null) {
                    q = q.next;
                } else {
                    p.next = null;
                    return head;
                }
            }
            p.next = q;
            p = q;
        }
        return head;
    }
}
