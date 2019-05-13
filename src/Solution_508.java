import java.util.*;

public class Solution_508 {

    //保存每个子树元素和出现的次数
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int max = 1;

    /**
     * 最好表现：7ms
     * @param root
     * @return
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        computeSum(root);
        ArrayList<Integer> list = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] ints = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            ints[i++] = integer;
        }
        return ints;
    }

    private int computeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + computeSum(root.left) + computeSum(root.right);
        int count = 1;
        if (map.containsKey(sum)) {
            count = map.get(sum) + 1;
        }
        if (count > max) {
            max = count;
        }
        map.put(sum, count);
        return sum;
    }
}
