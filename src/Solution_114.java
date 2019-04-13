public class Solution_114 {
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root;
        while (p.right!=null){
            p = p.right;
        }
        p.right = right;
    }
}
