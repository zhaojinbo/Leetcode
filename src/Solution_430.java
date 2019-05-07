public class Solution_430 {
    private class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    /**
     * 递归做法，0ms
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        flattenA(head);
        return head;
    }

    /**
     * 扁平化处理
     * @param head
     * @return 返回扁平化后的尾节点
     */
    private Node flattenA(Node head) {
        Node cur = head;
        while (cur.next != null) {
            if (cur.child == null) {
                cur = cur.next;
            } else {
                Node temp = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;
                Node tail = flattenA(cur.child);
                tail.next = temp;
                temp.prev = tail;
                cur.child = null;
                cur = temp;
            }
        }
        if (cur.child == null) {
            return cur;
        } else {
            cur.next = cur.child;
            cur.child.prev = cur;
            Node tail = flattenA(cur.child);
            cur.child = null;
            return tail;
        }
    }
}
