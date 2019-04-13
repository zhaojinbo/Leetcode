import java.util.ArrayList;
import java.util.List;

public class Solution_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        if (root == null)
            return arrayLists;
        List<Integer> inArrayLists = new ArrayList<>();
        findPath(root, sum, arrayLists, inArrayLists);
        return arrayLists;
    }

    private void findPath(TreeNode root, int sum, List<List<Integer>> arrayLists, List<Integer> inArrayLists) {
        if (root == null) {
            return;
        }
        inArrayLists.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> temp = new ArrayList<>(inArrayLists);
            arrayLists.add(temp);
        }
        findPath(root.left, sum - root.val, arrayLists, inArrayLists);
        findPath(root.right, sum - root.val, arrayLists, inArrayLists);
        inArrayLists.remove(inArrayLists.size() - 1);
    }
}
