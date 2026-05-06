class Solution {
    public int missingNumber(int[] nums) {
        int numCount = nums.length;

        int total = Arrays.stream(nums).sum();
        int expectedTotal = numCount * (numCount + 1) / 2;

        int result = expectedTotal - total;
        System.out.printf("Missing number from sequence: %s = %d", Arrays.toString(nums), result);

        return result;
    }
}
