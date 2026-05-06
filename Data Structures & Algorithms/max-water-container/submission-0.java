class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        int L = 0;
        int R = heights.length -1;

        while (L < R) {

            int lHeight = heights[L];
            int rHeight = heights[R];
            int span = R - L;

            int volume = span * Math.min(lHeight, rHeight);

            result = Math.max(volume, result);

            if (rHeight < lHeight) {
                --R;
            } else {
                ++L;
            }
        }
        System.out.printf("Max water for input: %s = %d", Arrays.toString(heights), result);
        return result;
    }
}
