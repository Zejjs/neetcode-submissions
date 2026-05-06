class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = dp.length-1; i >= 0; --i) {

            for (String word : wordDict) {
                if (s.startsWith(word, i) && dp[i + word.length()]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.printf("%b: string %s can be broken up with %s%n%n", dp[0], s, wordDict);
        return dp[0];
    }
}
