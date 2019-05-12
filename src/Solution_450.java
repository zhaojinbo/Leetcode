public class Solution_450 {
    /**
     * 时间复杂度1ms，击败98.73%
     * 空间复杂度37.6MB，击败95.94%
     * 本题假设树中只有一个符合条件的节点，不存在值重复的节点
     * 采用递归的方式查找符合条件节点，如果找到就用它左子树中的最大值节点替换他，然后返回新的节点
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            TreeNode replaceNode = findReplaceNode(root);
            if (replaceNode == null) {
                return root.right;
            }
            replaceNode.left = root.left;
            replaceNode.right = root.right;
            root.left = null;
            root.right = null;
            return replaceNode;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    /**
     * 找到左子树中的最大值
     * 当左子树没有右节点时，最大值就是左节点本身
     * 当左子树有右节点时，最大值就是最最右边的节点
     * 当找到节点之后，除了需要将其返回，还需要将该节点从其父节点上断开，然后将其左子树连接到其父节点上
     *
     * @param root
     * @return
     */
    private TreeNode findReplaceNode(TreeNode root) {
        TreeNode par = root;
        TreeNode cur = root.left;
        if (cur == null) {
            return null;
        }
        if (cur.right == null) {
            par.left = cur.left;
            return cur;
        }
        while (cur.right != null) {
            par = cur;
            cur = cur.right;
        }
        par.right = cur.left;
        return cur;
    }
}
