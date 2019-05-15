import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_515 {
    /**
     * 5ms，层序遍历的思想
     *
     * @param root
     * @return
     */
    public List<Integer> largestValuesOne(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            int temp = 0;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                TreeNode pop = queue.pop();
                if (pop.val > max) {
                    max = pop.val;
                }
                if (pop.left != null) {
                    queue.offer(pop.left);
                    temp++;
                }
                if (pop.right != null) {
                    queue.offer(pop.right);
                    temp++;
                }
            }
            list.add(max);
            i = temp;
        }
        return list;
    }

    /**
     * 遍历的做法，3ms
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, 0, list);
        return list;
    }

    // depth参数用来表示这是位于哪一层的节点，以便更新这一层的最大值
    private void preOrder(TreeNode node, int depth, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(node.val);
        } else {//list.size()>depth
            if (list.get(depth) < node.val) {
                list.set(depth, node.val);
            }
        }
        preOrder(node.left, depth + 1, list);
        preOrder(node.right, depth + 1, list);
    }
}
