/**
 * 8ms，97.05%
 */
public class Solution_572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }

        if (isSame(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 以p和t位根节点的数是否相等
     */
    private boolean isSame(TreeNode p, TreeNode t) {
        if (p == null) {
            return t == null;
        }
        if (t == null) {
            return false;
        }
        if (p.val != t.val) {
            return false;
        }

        return isSame(p.left, t.left) && isSame(p.right, t.right);
    }
}
