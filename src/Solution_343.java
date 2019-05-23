public class Solution_343 {
    /**
     * 动态规划配合递归，1ms
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        //当n小于等于3的时候，我们需要单独处理，因为它们的dp与应该返回的值不一致
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        return compMaxProduct(n, dp);
    }

    private int compMaxProduct(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        int max = 0;
        for (int i = 2; i <= n / 2; i++) {
            max = Math.max(max, compMaxProduct(i, dp) * compMaxProduct(n - i, dp));
        }
        dp[n] = max;
        return max;
    }

/*    public static void main(String[] args) {
        int res = new Solution_343().integerBreak(10);
        System.out.println(res);
    }*/
}
