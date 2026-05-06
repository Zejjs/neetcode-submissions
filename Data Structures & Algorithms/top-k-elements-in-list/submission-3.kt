class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freqMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            freqMap[num] = (freqMap[num] ?: 0) + 1
        }

        val freqArray = Array(nums.size + 1) { mutableListOf<Int>() }

        for ((num, count) in freqMap) {
            freqArray[count].add(num)
        }

        val result = IntArray(k)
        var idx = 0
        for (count in freqArray.size - 1 downTo 0) {
            for (num in freqArray[count]) {
                result[idx] = num
                idx++
                if (idx == k) return result
            }
        }
        return result
    }
}
