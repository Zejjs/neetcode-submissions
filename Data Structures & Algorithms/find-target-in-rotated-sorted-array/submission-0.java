class Solution {
    public int search(int[] array, int target) {
        int result = -1;

        int L = 0;
        int R = array.length - 1;
        int M = array.length / 2;

        while (L <= R) {
            System.out.printf("L: %d, M: %d, R: %d%n", L, M, R);
            if (array[M] == target) {
                result = M;
                break;
            }

            // left sorted half
            if (array[M] >= array[L]) {
                if (target > array[M] || target < array[L]) {
                    // is on the right
                    L = M + 1;
                }
                else  {
                    R = M - 1;
                }
                M = (L + R) / 2;
            }
            // right sorted half
            else {
                if (target < array[M] || target > array[R]) {
                    // is on the left
                    R = M - 1;
                }
                else {
                    // is on the right
                    L = M + 1;
                }
                M = (L + R) / 2;
            }

        }

        System.out.printf("Index of %d in rotated sorted array: %s = %d%n%n", target, Arrays.toString(array), result);
        return result;
    }
}
