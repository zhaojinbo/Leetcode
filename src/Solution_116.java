import java.util.LinkedList;

public class Solution_116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        int temp = 0;
        Node p = root;
        while (!queue.isEmpty()) {
            temp = 0;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i >= 1) {
                    p.next = node;
                }
                p = node;
                if (node.left != null) {
                    queue.offer(node.left);
                    temp++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    temp++;
                }
            }
            size = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root4 = new Node(4,null,null,null);
        Node root5 = new Node(5,null,null,null);
        Node root3 = new Node(3,root4,root5,null);
        Node root2 = new Node(2,null,root3,null);
        Node root1 = new Node(1,null,root2,null);
        Node result = connect(root1);
    }
}
