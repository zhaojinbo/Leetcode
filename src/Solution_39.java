import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_39 {
    /**
     * 时间复杂度 4ms,99.68%
     * 空间复杂度 37.1MB,97.36%
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, list, 0);

        return res;
    }

    /**
     * 回溯算法
     *
     * @param list  当前递归位置处的list
     * @param index 搜索范围从index处向后，这样保证多有的结果不会包含重复的组合
     */
    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], res, list, i);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }
}
