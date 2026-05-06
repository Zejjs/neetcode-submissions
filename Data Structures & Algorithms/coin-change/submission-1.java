class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int amt = 1; amt < dp.length; ++amt) {
            for (int coin : coins) {
                if (amt - coin >= 0) {
                    dp[amt] = Math.min(dp[amt - coin] + 1, dp[amt]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.printf("You need at least %d coins to give change from %d using %s as coins%n%n",
                dp[amount], amount, Arrays.toString(coins));

        if (dp[amount] == amount +1) {
            return -1;
        } else{
            return dp[amount];
        }
    }
}
