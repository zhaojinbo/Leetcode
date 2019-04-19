public class Solution_213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int fir = rob(nums, 0, length - 2);
        int sec = rob(nums, 1, length - 1);

        return Math.max(fir, sec);
    }

    // 对打家劫舍的非环版进行复用，注意修改nums的下标
    private int rob(int[] nums, int from, int to) {
        int length = to - from + 1;
        int[] maxSum = new int[length + 1];
        maxSum[0] = 0;
        maxSum[1] = nums[from];
        for (int i = 2; i < maxSum.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 2] + nums[i - 1 + from], maxSum[i - 1]);
        }
        return maxSum[length];
    }
}
