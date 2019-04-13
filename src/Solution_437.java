public class Solution_437 {

    private int totalPathNum = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        findPath(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return totalPathNum;
    }

    /**
     * 经过节点root，但却不一定终止于叶子节点的和位sum的路径数量
     *
     * @param root
     * @param sum
     */
    private void findPath(TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.val == sum) {
            totalPathNum++;
        }
        findPath(root.left, sum - root.val);
        findPath(root.right, sum - root.val);
    }
}
