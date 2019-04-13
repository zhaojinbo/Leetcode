public class Solution_235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val > p.val && root.val < q.val)||(root.val < p.val && root.val > q.val)||root.val==p.val||root.val==q.val){
            return root;
        }else if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}
