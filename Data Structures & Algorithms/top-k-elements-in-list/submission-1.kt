class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val countMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            countMap.compute(num) { _, v -> (v ?: 0) + 1 }
        }

        val pq = PriorityQueue<MutableMap.MutableEntry<Int, Int>>(compareByDescending { it.value })

        countMap.entries.forEach { pq.add(it) }

        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = pq.poll().key
        }
        return result
    }
}
