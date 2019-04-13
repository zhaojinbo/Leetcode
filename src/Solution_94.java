import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                list.add(node.val);
                cur = node.right;
            }
        }
        return list;
    }

/*  递归中序遍历算法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(list,root);
        return list;
    }
    private void inorderTraversal(List<Integer> list, TreeNode root){
        if (root==null){
            return;
        }
        inorderTraversal(list,root.left);
        list.add(root.val);
        inorderTraversal(list,root.right);
    }*/
}
