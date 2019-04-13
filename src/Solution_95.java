import java.util.ArrayList;
import java.util.List;

public class Solution_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }
        if (start == end) {
            treeNodes.add(new TreeNode(start));
            return treeNodes;
        }
        // 以从start到end为根节点，每次将左边的节点组成的所有二叉搜索树的list和右边节点组成的所有二叉搜索树的list中的元素进行组合生成以i为根节点的list
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode treeNodeLeft : leftList) {
                for (TreeNode treeNodeRight : rightList) {
                    TreeNode rootNode = new TreeNode(i);
                    rootNode.right = treeNodeRight;
                    rootNode.left = treeNodeLeft;
                    treeNodes.add(rootNode);
                }
            }
        }
        return treeNodes;
    }
}
