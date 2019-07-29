import java.util.Arrays;

/**
 * 时间复杂度：7ms，98.11%
 * 空间复杂度：35.7MB，85.78%
 */
public class Solution_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > target / 3) {
                int sum = nums[i] + nums[i + 1] + nums[i + 2];
                if (Math.abs(sum - target) < minDistance) {
                    result = sum;
                }
                break;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int distance = Math.abs(sum - target);
                if (distance < minDistance) {
                    minDistance = distance;
                    result = sum;
                }
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
