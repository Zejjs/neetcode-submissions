class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length];
        int[] suffixes = new int[nums.length];

        prefixes[0] = 1;
        suffixes[nums.length - 1] = 1;

        for (int i = 1; i < prefixes.length; i++) {
            prefixes[i] = nums[i - 1] * prefixes[i - 1];
        }

        for (int i = suffixes.length - 2; i >= 0; i--) {
            suffixes[i] = nums[i + 1] * suffixes[i + 1];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = prefixes[i] * suffixes[i];
        }

        return result;
    }
}  
