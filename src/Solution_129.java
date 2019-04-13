public class Solution_129 {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode root, int s) {
        if (root == null) {
            return 0;
        }
        s = s * 10 + root.val;
        if (root.left == null && root.right == null) {
            return s;
        }
        return sum(root.left, s) + sum(root.right,s);
    }
}