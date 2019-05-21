public class Solution_322 {
    /**
     * 动态规划，跟完全平方数思路一致，24ms
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i) {
                    int temp = dp[i - coin];
                    if (temp != -1) {
                        min = Math.min(min, temp);
                    }
                }
            }
            //min的值没有发生改变有两种情况：一是没有coin的值是小于i的，另一种是i减去所有coin的值之后都是不能组合出来的面值
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

/*    public static void main(String[] args) {
        Solution_322 solution_322 = new Solution_322();
        int res = solution_322.coinChange(new int[]{2}, 3);
        System.out.println(res);
    }*/
}
