class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int target = -nums[i];
            int L = i + 1;
            int R = nums.length -1;

            while (L < R) {
                int total = nums[L] + nums[R];
                if (total == target) {
                    result.add(List.of(nums[i], nums[L], nums[R]));
                    ++L;
                }
                else if (total < target) {
                    ++L;
                } else {
                    --R;
                }
            }
        }

        System.out.printf("Threesum result for input: %s = %s%n%n", Arrays.toString(nums), result);
        return result.stream().toList();
    }
}
