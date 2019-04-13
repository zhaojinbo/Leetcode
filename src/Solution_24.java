public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;//待交换的两个节点前面的节点
        ListNode b = head;//待交换的两个节点的第一个节点
        ListNode c;//待交换的两个节点的第二个节点
        while (true){
            if (b!=null){
                c = b.next;
                if (c!=null){
                    ListNode next = c.next;
                    c.next = b;
                    b.next = next;
                    a.next = c;
                    a = b;
                    b = next;
                }else{
                    break;
                }

            }else {
                break;
            }

        }
        return dummy.next;
    }
}
