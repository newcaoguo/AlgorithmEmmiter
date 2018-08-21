public class BestTimeToBuyAndSellStockII {
    /**
     *  5 - 1 = 4 ； 6 - 3 = 3 = 7
     *  1 买入 5 卖出 -> 4 ；3买入6卖出 -> 3  =  7
     *
     * Input: [7,1,5,3,6,4]
     * Output: 7
     *
     * Input: [1,2,3,4,5]
     * Output: 4
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     *
     */
    public int maxProfit(int[] prices) {
        int pricesLength = prices.length;
        if (pricesLength <= 1) return 0;
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return result;
    }
}
