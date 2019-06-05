import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution_47 {
    /**
     * 时间复杂度：4ms, 94.58%
     * 空间复杂度：38.2MB, 97.00%
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0);
        return res;
    }

    /**
     * 回溯算法，与不存在重复数字的全排列不同，这里需要加上判断
     * 如果一个数字之前已经出现过，那就不再与位于index处的数字交换位置
     * 因为前面那个与它相等的数字一定已经与位于index处的数字交换过了
     *
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
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])){
                hashSet.add(nums[i]);
            }else {
                continue;
            }
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
