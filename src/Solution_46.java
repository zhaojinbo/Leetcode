import java.util.ArrayList;
import java.util.List;

public class Solution_46 {
    /**
     * 时间复杂度：3ms, 91.43%
     * 空间复杂度：37.4MB, 92.14%
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0);
        return res;
    }

    /**
     * 回溯算法
     * @param index 将index到nums.length-1范围的内容进行全排列
     */
    private void dfs(int[] nums, List<List<Integer>> res, int index) {
        if (index == nums.length) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int num : nums) {
                arrayList.add(num);
            }
            res.add(arrayList);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            exc(nums, i, index);
            dfs(nums, res, index + 1);
            exc(nums, i, index);
        }
    }

    private void exc(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
