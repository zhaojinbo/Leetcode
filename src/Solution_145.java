import java.util.*;

public class Solution_145 {
    /**
     * 递归方法，1ms
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalOne(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorderTraversal_(root,list);
        return list;
    }

    private void postorderTraversal_(TreeNode root, ArrayList<Integer> list) {
        if (root==null){
            return;
        }
        postorderTraversal_(root.left,list);
        postorderTraversal_(root.right,list);
        list.add(root.val);
    }

    /**
     * 非递归的方法，2ms
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        // 用来标记那些已经被访问过的节点
        HashSet<TreeNode> hashSet = new HashSet<>();
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            cur = peek.right;
            if (cur==null){
                list.add(peek.val);
                stack.pop();
            }else {
                if (!hashSet.contains(cur)){
                    hashSet.add(cur);
                    while (cur!=null){
                        stack.push(cur);
                        cur = cur.left;
                    }
                }else {// 走到这一步说明右节点已经被访问过，所以直接将该节点弹出栈
                    list.add(peek.val);
                    stack.pop();
                }
            }
        }
        return list;
    }
}
