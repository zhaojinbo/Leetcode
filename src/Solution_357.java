public class Solution_357 {
    /**
     * n=3时，个数等于9*9*8再加上n=2时的值
     * n=4时，个数等于9*9*8*7再加上n=3时的值
     * n=5时，个数等于9*9*8*7*6再加上n=4时的值
     * 。。。
     * 前面9*9*8*7*6是第一位确定不为0时的个数，后面再加上第一位确定为0时的个数，就是总的个数
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n > 10) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 10;
        int temp = 11;
        int product = 9;
        for (int i = 2; i <= n; i++) {
            product *= temp - i;
            dp[i] = product + dp[i - 1];
        }
        return dp[n];
    }
}
