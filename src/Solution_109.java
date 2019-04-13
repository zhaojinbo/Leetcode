public class Solution_109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        return sortedListToBST(head, p);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (tail==null){
            return null;
        }
        if (head==tail){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode beforeMid = null;
        while (fast != tail && fast.next != tail) {
            beforeMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head, beforeMid);
        node.right = sortedListToBST(slow.next,tail);
        return node;
    }
}
