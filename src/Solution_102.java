import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> outList = new ArrayList<>();
        if (root == null){
            return outList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 1;
        while (!queue.isEmpty()){
            List<Integer> innerList = new ArrayList<>();
            int temp = 0;
            for (int i=0;i<size;i++){
                TreeNode node = queue.poll();
                innerList.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                    temp++;
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    temp++;
                }
            }
            size = temp;
            outList.add(innerList);
        }
        return outList;
    }
}
