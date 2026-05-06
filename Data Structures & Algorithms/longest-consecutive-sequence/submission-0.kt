class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toHashSet()

        var result = listOf<Int>()
        for (num in numSet) {
            if (numSet.contains(num-1)) {
                continue
            }
            val candidate = mutableListOf(num)
            var nextNum = num+1
            while (numSet.contains(nextNum)) {
                candidate.add(nextNum)
                nextNum++
            }
            if (candidate.size > result.size) {
                result = candidate
            }
        }

        return result.size
    }
}
