import java.util.Arrays;

public class Solution_628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int temp = nums[len - 1] * nums[0] * nums[1];
        if (temp > max) {
            return temp;
        }
        return max;
    }
}
