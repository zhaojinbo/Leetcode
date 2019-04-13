public class Solution_96 {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;//设为1有助于计算
        nums[1] = 1;//一个节点能够表示的二叉搜索树的数量
        if (n == 1) {
            return nums[1];
        }
        for (int i = 2; i <= n; i++) {
            // i个节点能够表示的二叉查找数的数量是：nums[0]*nums[i-1]+nums[1]*nums[i-2]+...+nums[i-1]*nums[0]
            int sum = 0;
            for (int k = i - 1; k >= 0; k--) {
                sum += nums[k] * nums[i - k - 1];
            }
            nums[i] = sum;
        }
        return nums[n];
    }
}
