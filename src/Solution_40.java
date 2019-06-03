import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_40 {
    /**
     * 时间复杂度 6ms,95.1%
     * 空间复杂度 36.4MB,96.76%
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, list, 0);
        return res;
    }

    /**
     * 回溯算法，与39题的区别在于两点
     * 第一是，这一题中要求所有元素只能够被使用一次，这是递归传递的index就应该是i+1，而不是i
     * 第二是，这一题中的数组元素是有重复的，所以最后的结果集也会有重复，需要加上判断条件
     *
     * @param list  当前递归位置处的list
     * @param index 搜索范围从index处向后
     */
    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) break;
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
