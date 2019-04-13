public class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null||q==null){
            return p==q;
        }else{
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
