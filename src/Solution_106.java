public class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode buildTree(int[] postorder, int poFrom, int poTo, int[] introder, int inFrom, int inTo) {
        if (poFrom > poTo) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[poTo]);
        int index = inFrom;
        int leftCount = 0;
        for (int i = inFrom; i <= inTo; i++) {
            if (introder[i] == postorder[poTo]) {
                index = i;
                leftCount = index - inFrom;
                break;
            }
        }
        node.left = buildTree(postorder, poFrom, poFrom + leftCount - 1, introder, inFrom, index - 1);
        node.right = buildTree(postorder, poFrom + leftCount, poTo - 1, introder, index + 1, inTo);
        return node;
    }
}
