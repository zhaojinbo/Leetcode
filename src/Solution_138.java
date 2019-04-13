import java.util.HashMap;

public class Solution_138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    /**
     * 使用哈希表的方式来实现
     * 第一次遍历新建节点，作为旧节点的value
     * 第二次遍历按照新节点的next random指针指向来修正value的指针指向
     *
     * @param head
     * @return
     */
    public Node copyRandomList_methodOne(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> hashMap = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val, cur.next, cur.random);
            hashMap.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node value = hashMap.get(cur);
            value.next = hashMap.get(cur.next);
            value.random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    /**
     * 另外一种思路，1ms
     * 先将新建节点都放在原有节点的后面，第二次遍历改变新建节点的random指针
     * 第三次遍历，将next指针修正，即将旧链表和新链表分开
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node temp;
        while (cur != null) {
            Node node = new Node(cur.val, cur.next, cur.random);
            temp = cur.next;
            cur.next = node;
            node.next = temp;
            cur = temp;
        }
        cur = head;
        while (cur != null) {
            temp = cur.next;
            if (cur.random != null) {
                temp.random = cur.random.next;
            }
            cur = temp.next;
        }
        Node newNode = head.next;
        cur = head;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }

        return newNode;

    }
}
