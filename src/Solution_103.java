import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outList = new ArrayList<>();
        if (root == null) {
            return outList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        int headInsert = -1;
        while (!queue.isEmpty()) {
            LinkedList<Integer> innerList = new LinkedList<>();
            int temp = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (headInsert == 1) {
                    innerList.addFirst(node.val);
                } else {
                    innerList.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    temp++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    temp++;
                }
            }
            headInsert = -headInsert;
            size = temp;
            outList.add(innerList);
        }
        return outList;
    }
}
