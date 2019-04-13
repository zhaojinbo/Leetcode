public class Solution_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxArr = new int[nums.length];//用来记录以索引结尾的子序列的最大乘积
        int[] minArr = new int[nums.length];//用来记录以索引结尾的子序列的最小乘积
        maxArr[0] = nums[0];
        minArr[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxArr[i] = Math.max(maxArr[i - 1] * nums[i], nums[i]);
                minArr[i] = Math.min(minArr[i - 1] * nums[i], nums[i]);
            } else {
                maxArr[i] = Math.max(minArr[i - 1] * nums[i], nums[i]);
                minArr[i] = Math.min(maxArr[i - 1] * nums[i], nums[i]);
            }
            if (maxArr[i] > max) {
                max = maxArr[i];
            }
        }
        return max;
    }
}
