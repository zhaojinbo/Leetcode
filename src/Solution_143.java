public class Solution_143 {
    /**
     * 第一种思路，耗时比较久，因为每次都要从头开始向后找到尾节点
     *
     * @param head
     */
    public void reorderListOne(ListNode head) {
        if (head == null) {
            return;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (len <= 2) {
            return;
        }
        cur = head;
        for (int i = 1; i < len / 2 + 1; i++) {
            cur = cur.next;
        }
        ListNode p = cur.next;//p用来表示后半段的头结点
        cur.next = null;

        //经过上面步骤已经将前后段分开
        ListNode q = head;//q用来作为前半段的活动指针
        for (int i = len - len / 2 - 1; i > 0; i--) {
            cur = p;
            for (int j = 1; j < i; j++) {
                cur = cur.next;
            }
            ListNode temp = q.next;
            q.next = cur;
            cur.next = temp;
            q = temp;
        }
    }

    /**
     * 第二种思路，可以将后半段进行节点翻转，这样就能够将多次查找尾节点的操作转变为一次逆向操作
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;//以second作为后半段的头结点
        slow.next = null;

        //反转后半段链表
        ListNode newSecond = reverseList(second);

        ListNode cur1 = head;
        ListNode cur2 = newSecond;
        ListNode temp = null;
        while (cur2!=null){
            temp = cur1.next;
            cur1.next = cur2;
            newSecond = cur2.next;
            cur2.next = temp;
            cur1 = temp;
            cur2 = newSecond;
        }
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
