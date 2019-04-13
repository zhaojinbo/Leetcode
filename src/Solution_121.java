public class Solution_121 {
    public int maxProfit(int[] prices) {
        int minValue_index = 0;
        int maxprofit = 0;
        if (prices.length<=1)
            return maxprofit;
        for (int i=1;i<prices.length;i++){
            if (prices[i]<prices[minValue_index])
                minValue_index = i;
            else{
                int profit = prices[i]-prices[minValue_index];
                if (profit>maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
