class Solution {
    public int findMin(int[] array) {
        int result = Integer.MAX_VALUE;

        int L = 0;
        int R = array.length - 1;
        int M = array.length / 2;

        while (L <= R) {
            // M in left sorted half
            if (array[M] >= array[L]) {
                result = Math.min(result, array[L]);
                L = M + 1;
                M = (R + L) / 2;
            } else {
                result = Math.min(result, array[M]);
                R = M - 1;
                M = (R + L) / 2;
            }
        }
        System.out.printf("Minimum value in rotated sorted array: %s = %d%n%n", Arrays.toString(array), result);
        return result;
    }
}
