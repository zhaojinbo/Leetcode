public class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode p1 = head;//fast
        ListNode p2 = head;//slow
        ListNode p3 = head;//new

        while (p1.next != null && p1.next.next != null) {
            p2 = p2.next;
            p1 = p1.next.next;
            if (p1 == p2) {
                while (p2 != p3) {
                    p2 = p2.next;
                    p3 = p3.next;
                }
                return p2;
            }
        }
        return null;
    }
}
