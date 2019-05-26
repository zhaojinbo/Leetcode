import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        if (length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
        int[] dp = new int[length];//记录以当前元素结尾的最长子序列长度
        int[] prePosition = new int[length];//记录当前元素能够整除的前面一个元素的位置
        dp[0] = 1;
        int max = 1;
        int max_index = 0;
        for (int i = 1; i < length; i++) {
            boolean flag = true;
            int temp;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    temp = dp[j] + 1;
                    if (temp > dp[i]) {
                        dp[i] = temp;
                        if (dp[i] > max) {
                            max = dp[i];
                            max_index = i;
                        }
                        prePosition[i] = j;
                    }
                    flag = false;
                }
            }
            if (flag) {
                dp[i] = 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            res.add(nums[max_index]);
            max_index = prePosition[max_index];
        }
        return res;
    }
}
