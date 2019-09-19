public class Solution_21 {
    /**
     * 递归解法，时间复杂度1ms,99.80%
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
            newNode.next = mergeTwoLists(l1.next, l2);
        } else {
            newNode = l2;
            newNode.next = mergeTwoLists(l1, l2.next);
        }
        return newNode;
    }

    /**
     * 合并两个有序链表，非递归解法
     *
     * @param l1 第一个有序链表的头结点
     * @param l2 第二个有序链表的头结点
     * @return 最终合并后的有序链表
     */
    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
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


