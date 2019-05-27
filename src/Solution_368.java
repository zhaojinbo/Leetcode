import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int[] dp = new int[length];//记录以当前元素结尾的最长子序列长度
        int[] prePosition = new int[length];//记录当前元素能够整除的前面一个元素的位置
        for (int i = 0; i < length; i++) {
            dp[i] = 1;//先将所有值都初始化为1
        }
        int max = 1;//最长子序列的长度
        int max_index = 0;//最长子序列是以哪个元素结尾的
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prePosition[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                max_index = i;
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
