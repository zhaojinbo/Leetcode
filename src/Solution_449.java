public class Solution_449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        preOrder(root, str);
        return str.toString();
    }

    private void preOrder(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val).append(" ");
        preOrder(root.left, stringBuilder);
        preOrder(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] split = data.trim().split(" ");
        int arrLen = split.length;
        int[] arr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return buildTree(arr, 0, arrLen - 1);
    }

    private TreeNode buildTree(int[] arr, int from, int to) {
        if (from > to) {
            return null;
        }
        TreeNode node = new TreeNode(arr[from]);
        if (from == to) {
            return node;
        }
        int index = from + 1;
        // 找到左右树的分界点，通过与第一个元素进行比较大小
        while (index <= to && arr[index] < arr[from]) {
            index++;
        }
        node.left = buildTree(arr, from + 1, index - 1);
        node.right = buildTree(arr, index, to);

        return node;
    }
}
