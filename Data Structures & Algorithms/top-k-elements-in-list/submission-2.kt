class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val freq = mutableMapOf<Int, Int>()
        for (num in nums) freq[num] = (freq[num] ?: 0) +1

        val freqArray = Array(nums.size+1) { mutableListOf<Int>() }

        for ((num, count) in freq) {
            freqArray[count].add(num)
        }
        val result = IntArray(k)
        var idx = 0

        for (count in freqArray.size - 1 downTo 1) {
            for (num in freqArray[count]) {
                result[idx++] = num
                if (idx == k) return result
            }
        }
        return result
    }
}
