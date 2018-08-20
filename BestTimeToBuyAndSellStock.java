public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int result = 0;
        int small = 0;
        if (prices.length == 0) return 0;
        else small = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if ((prices[i] - small) > result) {
                result = prices[i] - small;
            }
            if (prices[i] < small) {
                small = prices[i];
            }
        }
        return result;
    }

}
