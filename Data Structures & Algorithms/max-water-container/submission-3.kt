class Solution {
    fun maxArea(heights: IntArray): Int {
        var lptr = 0
        var rptr = heights.size-1
        var result = 0
        
        while (lptr < rptr) {
            val area  = min(heights[lptr], heights[rptr]) * (rptr - lptr)
            result = max(result, area)
            if (heights[lptr] < heights[rptr]) {
                lptr++
            } else {
                rptr--
            }
        }
        
        return result
    }
}
