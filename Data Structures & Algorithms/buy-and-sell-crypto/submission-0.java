class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buyPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < buyPrice) {
                buyPrice = price;
            }
            int profit = price - buyPrice;
            res = Math.max(res, profit);
        }
        return res;
    }
}
