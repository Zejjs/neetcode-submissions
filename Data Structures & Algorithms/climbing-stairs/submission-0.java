class Solution {
    public int climbStairs(int steps) {
                int result = 0;

        int[] dp = new int[steps + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= steps; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        result = dp[steps];
        System.out.printf("There's %d ways to climb a staircase with %d steps%n%n", result, steps);

        return result;
    }
}
