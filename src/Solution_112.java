public class Solution_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        int newSum = sum - root.val;
        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
}
