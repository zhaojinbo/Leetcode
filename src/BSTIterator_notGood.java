import java.util.ArrayList;

/**
 * 存在问题，空间复杂度为O(n)，n是二叉树节点个数，而非二叉树高度
 */
public class BSTIterator_notGood {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    private int cur = -1;
    private int size;

    public BSTIterator_notGood(TreeNode root) {
        traversal(root);
        size = arrayList.size();
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        arrayList.add(root.val);
        traversal(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        cur++;
        return arrayList.get(cur);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return cur < size - 1;
    }
}
