public class Solution_198 {
    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //用来存放到某个位置为止能够偷的最大和，下标表示真实的第几个元素;例如maxSum[i]表示到nums的第i个元素为止，能够偷窃的最大数
        int[] maxSum = new int[nums.length + 1];
        maxSum[0] = 0;
        maxSum[1] = nums[0];
        for (int i = 2; i < maxSum.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 2] + nums[i - 1], maxSum[i - 1]);
        }
        return maxSum[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
