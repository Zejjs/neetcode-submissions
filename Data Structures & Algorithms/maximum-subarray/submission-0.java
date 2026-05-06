class Solution {
    public int maxSubArray(int[] input) {
        int ptr = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        while (ptr < input.length) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += input[ptr];
            maxSum = Math.max(maxSum, currentSum);

            ++ptr;
        }
        System.out.printf("Max sub-array sum for input: %s = %d %n%n", Arrays.toString(input), maxSum);
        return maxSum;
    }
}
