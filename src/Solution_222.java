public class Solution_222 {
    public int countNodes(TreeNode root) {
        TreeNode cur = root;
        int deep = 0;
        while (cur != null) {
            deep++;
            cur = cur.left;
        }
        if (deep < 2) {
            return deep;
        }
        return comp(root, deep) + (int) Math.pow(2, deep - 1) - 1;
    }

    /**
     * 计算最后一层节点数量，采用二分查找的思路
     * 先判断左节点是不是满二叉树，然后递归计算左孩子或者右孩子的最后一层节点数量
     *
     * @param root
     * @param deep
     * @return
     */
    private int comp(TreeNode root, int deep) {
        // 递归退出条件
        if (deep == 2) {
            if (root.right != null) {
                return 2;
            } else if (root.left != null) {
                return 1;
            } else {
                return 0;
            }
        }
        int res = 0;
        if (exitRightMost(root.left, deep - 1)) {
            res += (int) Math.pow(2, deep - 1) / 2;
            res += comp(root.right, deep - 1);
        } else {
            res += comp(root.left, deep - 1);
        }
        return res;
    }

    /**
     * 判断是不是满二叉树
     *
     * @param left
     * @param deep
     * @return
     */
    private boolean exitRightMost(TreeNode left, int deep) {
        TreeNode cur = left;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.right;
        }
        return i == deep;
    }
}
