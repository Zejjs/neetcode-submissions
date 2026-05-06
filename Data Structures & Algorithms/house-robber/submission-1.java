class Solution {
    public int rob(int[] nums) {
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
