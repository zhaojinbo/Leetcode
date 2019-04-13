public class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        int jinwei = (l1.val + l2.val) / 10;
        ListNode first = l1.next;
        ListNode second = l2.next;
        ListNode newList = new ListNode((l1.val + l2.val) % 10);
        ListNode p = newList;
        while (first != null || second != null) {
            int sum = jinwei;
            if (first != null) {
                sum += first.val;
                first = first.next;
            }
            if (second != null) {
                sum += second.val;
                second = second.next;
            }
            ListNode temp = new ListNode(sum % 10);
            p.next = temp;
            p = temp;
            jinwei = sum / 10;
        }
        if (jinwei!=0){
            ListNode temp = new ListNode(jinwei);
            p.next = temp;
        }
        return newList;
    }
}
