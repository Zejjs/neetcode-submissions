class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }

        var lptr = 0
        var rptr = 1
        var result = 0

        while (rptr < prices.size) {
            if (prices[rptr] > prices[lptr]) {
                val profit = prices[rptr] - prices[lptr]
                result = max(result, profit)
            }
            if (prices[lptr] > prices[rptr]) {
                lptr = rptr
            }
            rptr++
        }

        return result
    }
}
