class Solution {
    public boolean hasDuplicate(int[] input) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : input) {
            if (set.contains(i)) {
                System.out.printf("Input %s contains a duplicate%n%n", Arrays.toString(input));
                return true;
            }
            set.add(i);
        }
        System.out.printf("Input %s contains no duplicates%n%n", Arrays.toString(input));
        return false;
    }
}
