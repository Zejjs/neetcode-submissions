class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var max = 0
        val numSet = nums.toHashSet()

        for (num in numSet) {
            if (numSet.contains(num - 1)) {
                continue
            }
            var localMax = 1
            var nextNum = num + 1
            while (numSet.contains(nextNum)) {
                localMax += 1
                nextNum += 1
            }
            if (localMax > max) max = localMax
        }

        return max
    }
}
