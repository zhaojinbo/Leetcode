import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null)
            return list;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        int num = 1;//实际表示每层节点数量的变量
        while (!treeNodes.isEmpty()){
            int temp = 0;// 用来存储每一层最右边的节点的值
            int num2 = 0;// 用来每次从零开始计数每层节点数量的变量
            for (int i=0;i<num;i++){
                TreeNode node = treeNodes.pop();
                temp = node.val;
                if (node.left!=null){
                    treeNodes.offer(node.left);
                    num2++;
                }
                if (node.right!=null){
                    treeNodes.offer(node.right);
                    num2++;
                }
            }
            num = num2;// 一层计数完毕，将num2赋值给num
            list.add(temp);
        }
        return list;
    }
}
