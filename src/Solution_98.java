public class Solution_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left==null){
            return isValidBST(root.right) && root.val < findMin(root.right);
        }
        if (root.right==null){
            return isValidBST(root.left) && root.val > findMax(root.left);
        }
        return isValidBST(root.left) && root.val > findMax(root.left) && isValidBST(root.right) && root.val < findMin(root.right);
    }

    private int findMax(TreeNode root) {
        if (root.right == null) {
            return root.val;
        } else {
            return findMax(root.right);
        }
    }

    private int findMin(TreeNode root) {
        if (root.left == null) {
            return root.val;
        } else {
            return findMin(root.left);
        }
    }
}
