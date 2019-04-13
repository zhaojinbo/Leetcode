import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> outlist = new LinkedList<>();
        if (root == null){
            return outlist;
        }
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        nodeList.addLast(root);
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            ArrayList<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeList.poll();
                integerList.add(node.val);
                if (node.left != null) nodeList.addLast(node.left);
                if (node.right != null) nodeList.addLast(node.right);
            }
            outlist.addFirst(integerList);
        }
        return outlist;
    }
}
