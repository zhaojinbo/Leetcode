public class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int prFrom, int prTo, int[] inorder, int inFrom, int inTo) {
        if (prFrom > prTo) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[prFrom]);
        int index = prFrom;
        int leftCount = 0;
        for (int i = inFrom; i <= inTo; i++) {
            if (inorder[i] == preorder[prFrom]) {
                index = i;
                leftCount = index - inFrom;
                break;
            }
        }
        node.left = buildTree(preorder, prFrom + 1, leftCount + prFrom, inorder, inFrom, index - 1);
        node.right = buildTree(preorder, leftCount + prFrom + 1, prTo, inorder, index + 1, inTo);
        return node;
    }
}
