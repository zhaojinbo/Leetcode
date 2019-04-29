import java.util.LinkedList;

/**
 * 以这种方式遍历能够保证空间复杂度为O(k)，其中k为二叉树的高度
 */
public class BSTIterator {
    private LinkedList<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
