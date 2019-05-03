import java.util.HashSet;
import java.util.LinkedList;

public class Solution_236 {
    /**
     * 非递归做法，时间34ms
     * 做法是用栈来遍历每个节点，当找到p或者q的时候，存一下现在的栈的内容，然后比较两个保存下来的数组
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorOne(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        Object[] pp = new Object[0], qq = new Object[0];
        HashSet<TreeNode> hashSet = new HashSet<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            hashSet.add(cur);
            if (cur == p) {
                pp = stack.toArray();
            }
            if (cur == q) {
                qq = stack.toArray();
            }
            cur = cur.left;
        }
        while (!stack.isEmpty()) {
            cur = stack.peek();
            cur = cur.right;
            // 当没有右孩子，或者右孩子已经被遍历过，那么就通过出栈来进行回退，往根节点方向回退
            if (cur == null || hashSet.contains(cur)) {
                stack.pop();
            } else {
                while (cur != null) {
                    stack.push(cur);
                    hashSet.add(cur);
                    if (cur == p) {
                        pp = stack.toArray();
                    }
                    if (cur == q) {
                        qq = stack.toArray();
                    }
                    cur = cur.left;
                }
            }
        }

        int ppLen = pp.length;
        int qqLen = qq.length;
        int min = Math.min(ppLen, qqLen);
        boolean flag = false;
        int index = -1;
        for (int i = 1; i <= min; i++) {
            if (pp[ppLen - i] != qq[qqLen - i]) {
                flag = true;
                index = i - 1;
                break;
            }
        }
        if (flag) {
            return (TreeNode) pp[ppLen - index];
        }
        return (TreeNode) (ppLen < qqLen ? pp[0] : qq[0]);
    }

    /**
     * 递归的做法，比较难以理解
     * 当存在其中一个节点是两个节点的公共祖先时，找到上面的那个就停止向下继续遍历，所以用时较短，15ms
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果分别存在于左右子树，则最近公共祖先就是该节点
        if (left != null && right != null) {
            return root;
        }
        // 将从子树中找到的单个节点或者公共祖先向上传递，这里需要注意的是，传递的值可能是已经找到的公共祖先，也可能是已经找到的某一个节点
        if (left!=null){
            return left;
        }
        // 将从子树中找到的单个节点或者公共祖先向上传递，这里需要注意的是，传递的值可能是已经找到的公共祖先，也可能是已经找到的某一个节点
        if (right!=null){
            return right;
        }
        return null;
    }
}
