public class Solution_198 {
    public int rob(int[] nums) {
        if (nums.length ==0){
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] maxSum = new int[nums.length];//用来存放每个坐标位置之前能够偷的最大和
        maxSum[0] = nums[0];
        maxSum[1] = nums[1];
        if (nums.length>2){
            maxSum[2] = nums[2] + maxSum[0];
        }
        for (int i = 3; i < nums.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 2], maxSum[i - 3]) + nums[i];
        }
        return Math.max(maxSum[maxSum.length - 1], maxSum[maxSum.length - 2]);
    }
}
