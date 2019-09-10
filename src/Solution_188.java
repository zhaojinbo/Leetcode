public class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        if (k > length / 2) {
            int res = 0;
            for (int i = 1; i < length; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        /*
         * 两个二维数组表示状态
         * 持有股票和不持有股票分别能获得的最大利润，二维数组
         * 第一维表示第i+1天，第二维表示第j次交易
         */
        int[][] hold = new int[length][k + 1];
        int[][] unhold = new int[length][k + 1];

        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= k; j++) {
                /*
                 * 处理第一天的初始状态，无论j等于多少，因为第一天j大于等于1也没有意义
                 */
                if (i == 0) {
                    hold[i][j] = -prices[i];
                    unhold[i][j] = 0;
                    continue;
                }
                /*
                 * 持有状态可以由前一天持有，今天不做为，状态转移过来
                 * 也可以由前一天不持有，今天买入，状态转移过来，但是必须是由上一次交易转为下一次交易
                 * 不持有状态可以由前一天不持有，今天不作为，状态转移过来
                 * 也可以由前一天持有，今天卖出，状态转移过来
                 */
                hold[i][j] = Math.max(hold[i - 1][j], unhold[i - 1][j - 1] - prices[i]);
                unhold[i][j] = Math.max(unhold[i - 1][j], hold[i - 1][j] + prices[i]);
            }
        }
        return unhold[length - 1][k];
    }
}
