class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toHashSet()

        var max = 0
        for (num in numSet) {
            if (numSet.contains(num-1)) {
                continue
            }
            var len = 1
            var nextNum = num+1
            while (numSet.contains(nextNum)) {
                len++
                nextNum++
            }
            if (len > max) {
                max = len
            }
        }

        return max
    }
}
