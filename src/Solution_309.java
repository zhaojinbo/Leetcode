public class Solution_309 {
    /**
     * 动态规划
     * 状态：dp[i][0|1]，i表示第几天，0|1表示持有或者不持有
     * 选择：购买，卖出，无操作
     * 但是并不是每天都会有每一种选择，根据状态的不同，选择也会有不同，
     * 前一天如果是不持有，那么选择就不能是购买，因为前一天的不持有可能是卖出导致的，那么今天就处于冷冻期
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        /*
         * 每天，股民手中有两种状态，持有和不持有股票
         * hold和unhold两个数组分别表示了第i+1天，持有股票和不持有股票两种状态下分别能够获得的最大收益
         */
        int[] hold = new int[length];
        int[] unhold = new int[length];
        hold[0] = -prices[0];
        unhold[0] = 0;
        hold[1] = Math.max(hold[0], unhold[0] - prices[1]);
        unhold[1] = Math.max(unhold[0], hold[0] + prices[1]);
        for (int i = 2; i < length; i++) {
            /*
             * 持有股票的状态可能是前一天持有，今天无操作变成的，也可能是前两天不持有，今天购买变成的（前一天不持有，今天不一定能买）
             * 不持有股票的状态可能是前一天不持有，今天无操作变成的，也可能是前一天持有，今天卖出变成的
             */
            hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }
        return unhold[length - 1];
    }

/*    public static void main(String[] args) {
        int i = new Solution_309().maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }*/
}
