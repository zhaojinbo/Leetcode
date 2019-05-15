public class Solution_623 {
    /**
     * 递归的方式，2ms
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d==1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        return preOrder(root, 1, d - 1, v);
    }

    // 先序遍历的方式进行递归，depth表示当前深度，当到达指定指定深度d的时候，停止向下遍历
    private TreeNode preOrder(TreeNode root, int depth, int d, int v) {
        if (root == null) {
            return null;
        }
        if (depth == d) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = left;
            root.right.right = right;
        }else {// 这里使用else能够阻止继续向下递归
            root.left = preOrder(root.left, depth + 1, d, v);
            root.right = preOrder(root.right, depth + 1, d, v);
        }
        return root;
    }
}
