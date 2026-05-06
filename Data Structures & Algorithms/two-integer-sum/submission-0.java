class Solution {
    public int[] twoSum(int[] input, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < input.length; ++i) {
            int value = input[i];
            int diff = target - value;

            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;

                System.out.printf("TwoSum result for input: %s with target: %d = %s%n%n",
                        Arrays.toString(input), target, Arrays.toString(result));

                return result;
            }
            map.put(value, i);
        }

        System.out.printf("TwoSum failed to find result for input: %s with target: %d%n%n",
                Arrays.toString(input), target);

        return result;
    }
}
