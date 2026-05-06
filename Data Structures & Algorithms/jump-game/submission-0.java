class Solution {
    public boolean canJump(int[] input) {

        boolean[] dp = new boolean[input.length];

        dp[input.length - 1] = true;

        for (int origin = input.length-1; origin >= 0; --origin) {
            for (int distance = 0; distance <= input[origin] && distance < dp.length; ++distance) {
                if (dp[origin+distance]) {
                    dp[origin] = true;
                    break;
                }
            }
        }

        System.out.printf("Is it possible to jump game through array of %s ? %b", Arrays.toString(input), dp[0]);
        return dp[0];
    }
}
