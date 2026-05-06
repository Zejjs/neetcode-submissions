class Solution {
    public int lengthOfLIS(int[] input) {

        int[] dp = new int[input.length];
        Arrays.fill(dp, 1);

        for (int i = dp.length -2; i >=0; --i) {
            for (int j = i+1; j < dp.length; ++j) {
                if (input[i] < input[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        int result = Arrays.stream(dp).max().getAsInt();
        System.out.printf("Longest increasing subsequence in array %s is of length %d%n%n",
                Arrays.toString(input), result);

        return result;
    }
}
