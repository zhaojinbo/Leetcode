import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 时间复杂度：8ms,98.10%
 * 空间复杂度：38.3MB，90.34%
 */
public class Solution_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int p = 0; p < len - 3; p++) {
            if (p > 0 && nums[p] == nums[p - 1])
                continue;
            if (nums[p] + nums[p + 1] + nums[p + 2] + nums[p + 3] > target)
                break;
            if (nums[p] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                continue;
            for (int i = p + 1; i < len - 2; i++) {
                if (i > p + 1 && nums[i] == nums[i - 1])
                    continue;
                if (nums[p] + nums[i] + nums[i + 1] + nums[i + 2] > target)
                    break;
                if (nums[p] + nums[i] + nums[len - 1] + nums[len - 2] < target)
                    continue;
                int j = i + 1;
                int k = len - 1;
                while (j < k) {
                    int sum = nums[p] + nums[i] + nums[j] + nums[k];
                    if (sum > target) {
                        k--;
                    } else if (sum < target) {
                        j++;
                    } else {
                        list.add(Arrays.asList(nums[p], nums[i], nums[j], nums[k]));
                        j++;
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        k--;
                        while (j < k && nums[k] == nums[k + 1]) {
                            k--;
                        }
                    }
                }
            }
        }
        return list;
    }

/*    public static void main(String[] args) {
        List<List<Integer>> res = new Solution_18().fourSum(new int[]{0, 0, 0, 0}, 1);
        System.out.println(res);
    }*/
}
