import java.util.LinkedList;

public class Solution_513 {
    /**
     * 4ms，采用层序遍历的方法，记录每一层的第一个元素
     *
     * @param root
     * @return
     */
    public int findBottomLeftValueOne(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        TreeNode res = root;
        while (!queue.isEmpty()) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                TreeNode pop = queue.pop();
                if (j == 0) {
                    res = pop;
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
            i = temp;
        }
        return res.val;
    }

    /**
     * 1ms，递归做法
     * 对二叉树进行先序遍历
     *
     * @param root
     * @return
     */
    private int finalResult;
    private int maxDepth = 1;

    public int findBottomLeftValue(TreeNode root) {
        finalResult = root.val;
        return findBottomLeftValue(root, 1);
    }

    private int findBottomLeftValue(TreeNode root, int depth) {
        //在递归过程中能够满足此条件的情况就是新的一层最左边的一个元素，将其值保存在finalResult中
        if (depth > maxDepth) {
            finalResult = root.val;
            maxDepth = depth;
        }
        if (root.left != null) findBottomLeftValue(root.left, depth + 1);
        if (root.right != null) findBottomLeftValue(root.right, depth + 1);
        return finalResult;
    }
}
