class Solution {
        public int maxArea(int[] heights) {
        int lptr = 0;
        int rptr = heights.length - 1;
        int maxArea = 0;

        while (lptr < rptr) {
            int currentArea = Integer.min(heights[lptr], heights[rptr]) * (rptr - lptr);
            maxArea = Integer.max(maxArea, currentArea);
            if (heights[lptr] > heights[rptr]) {
                rptr--;
            }
            else {
                lptr++;
            }
        }
        return maxArea;
    }
}
