public class Solution_279 {
    /**
     * 动态规划的解法，33ms
     * 定义一个函数f(n)表示我们要求的解。f(n)的求解过程为：
     * f(n) = 1 + min{
     * f(n-1^2), f(n-2^2), f(n-3^2), f(n-4^2), ... , f(n-k^2) //k为满足k^2<=n的最大的k
     * }
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
