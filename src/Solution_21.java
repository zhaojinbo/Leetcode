public class Solution_21 {
    /**
     * 合并两个有序链表
     *
     * @param l1 第一个有序链表的头结点
     * @param l2 第二个有序链表的头结点
     * @return 最终合并后的有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode;
        if (l1.val < l2.val) {
            newNode = l1;
            l1 = l1.next;
        } else {
            newNode = l2;
            l2 = l2.next;
        }
        ListNode n = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                n.next = l1;
                l1 = l1.next;
            } else {
                n.next = l2;
                l2 = l2.next;
            }
            n = n.next;
        }
        //最后再将剩余的节点连在最后
        if (l1 == null) {
            n.next = l2;
        } else {
            n.next = l1;
        }
        return newNode;
    }
}


