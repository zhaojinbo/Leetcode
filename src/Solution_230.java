import java.util.LinkedList;

public class Solution_230 {
    /**
     * 第一种方法，用栈来存储TreeNode
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestOne(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            TreeNode node = stack.pop();
            cur = node.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            res = node.val;
        }
        return res;
    }

    /**
     * 第二种方法，递归
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        int cou = comCount(root.left);
        if (cou >= k) {
            return kthSmallest(root.left, k);
        } else if (cou + 1 < k) {
            return kthSmallest(root.right, k - cou - 1);
        }
        return root.val;
    }

    private int comCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + comCount(root.left) + comCount(root.right);
    }
}
