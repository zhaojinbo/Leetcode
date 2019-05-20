public class Solution_309 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int sell = 0, preSell = 0;
        int buy = -prices[0], preBuy;
        for (int i = 1; i < prices.length; i++) {
            preBuy = buy;
            buy = Math.max(preSell - prices[i], preBuy);
            preSell = sell;
            sell = Math.max(preBuy + prices[i], preSell);
        }
        return sell;
    }
}
