class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }

        int[] notFirst = Arrays.copyOf(nums, nums.length);
        notFirst[0] = 0;

        int[] notLast = Arrays.copyOf(nums, nums.length);
        notLast[nums.length-1] = 0;

        int result = Math.max(robSimple(notFirst), robSimple(notLast));

        System.out.printf("Best profit from robbing: %s in a circle is %d%n%n", Arrays.toString(nums), result);
        return result;
    }

    public int robSimple(int[] nums) {

    int twoHousesAgo = 0;
    int oneHouseAgo = 0;

    for (int value : nums) {
        int currentMax = Math.max(value + twoHousesAgo, oneHouseAgo);
        twoHousesAgo = oneHouseAgo;
        oneHouseAgo = currentMax;
    }
    return oneHouseAgo;
    
    }
}
