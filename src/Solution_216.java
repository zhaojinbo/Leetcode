import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度：1ms,99.86%
 */
public class Solution_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> templist = new ArrayList<>();
        combinationSum(res, templist, k, n, 1);
        return res;
    }

    /**
     * 回溯算法
     *
     * @param res      结果集
     * @param templist 临时存放list
     * @param k        还需要几步递归结束
     * @param n        对于目前还有k步的情况下，需要得到的和为n
     * @param from     为了保证每个组合中都不存在重复，需要从from开始选择数字
     */
    private void combinationSum(List<List<Integer>> res, ArrayList<Integer> templist, int k, int n, int from) {
        if (n < 0) {
            return;
        }
        //走到这一步一定需要return
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(templist));//需要new一个新的list
            }
            return;
        }
        //为了保证每个组合中都不存在重复，需要从from开始选择数字，最后结束选择的范围是9 - k + 1
        for (int i = from; i <= 9 - k + 1; i++) {
            templist.add(i);
            combinationSum(res, templist, k - 1, n - i, i + 1);
            templist.remove(templist.size() - 1);//回溯算法常规步骤
        }
    }
}
