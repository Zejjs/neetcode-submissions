class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, List.of(), 0, target, result);

        System.out.printf("You can get to %d using %s in the following ways %s%n%n", target, Arrays.toString(nums), result);
        return result;
    }

    private static void dfs(int[] nums, int i, List<Integer> current, int total, int target, List<List<Integer>> result) {
        if (total == target) {
            result.add(current);
        }

        else if (total < target) {
            List<Integer> newCurrent = new ArrayList<>(List.copyOf(current));
            newCurrent.add(nums[i]);
            dfs(nums, i, newCurrent, total+nums[i], target, result);

            if (i < nums.length - 1) {
                List<Integer> newCurrentPlusOne = new ArrayList<>(List.copyOf(current));
                dfs(nums, i + 1, newCurrentPlusOne, total, target, result);
            }
        }
    }
}
