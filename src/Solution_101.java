public class Solution_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return isSymmetric(left, right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else {
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
