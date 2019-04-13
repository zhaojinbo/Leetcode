public class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        int lengthA = 1;
        int lengthB = 1;
        while (a.next != null) {
            a = a.next;
            lengthA++;
        }
        while (b.next != null) {
            b = b.next;
            lengthB++;
        }
        a = headA;
        b = headB;
        int difference = lengthA - lengthB;
        if (difference >= 0) {
            for (int i = 0; i < difference; i++) {
                a = a.next;
            }
        } else {
            difference = -difference;
            for (int i = 0; i < difference; i++) {
                b = b.next;
            }
        }
        while (a != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
