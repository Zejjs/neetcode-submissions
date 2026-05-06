class Solution {
    public int maxProfit(int[] prices) {
        int buyIndex = 0;
        int sellIndex = 1;
        int maxProfit = 0;

        while (sellIndex < prices.length) {
            int currentProfit = prices[sellIndex] - prices[buyIndex];

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            if (prices[buyIndex] > prices[sellIndex]) {
                buyIndex = sellIndex;
            }

            ++sellIndex;
        }
        System.out.printf("Buy/Sell Stock max profit for input: %s = %d%n%n", Arrays.toString(prices), maxProfit);
        return maxProfit;
    }
}
