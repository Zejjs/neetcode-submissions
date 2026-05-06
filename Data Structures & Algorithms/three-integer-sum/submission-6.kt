class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result: MutableSet<List<Int>> = mutableSetOf()

        for (i in 0 until nums.size - 2) {
            val subTarget = 0 - nums[i]
            val subArray = nums.copyOfRange(i+1, nums.size)
            val twoSumIndices = twoSumMultiple(subArray, subTarget)

            for (pair in twoSumIndices) {
                result.add(listOf(nums[i], nums[pair[0]+i+1], nums[pair[1]+i+1]).sorted())
            }
        }

        return result.toList()
    }

    fun twoSumMultiple(nums: IntArray, target: Int): List<IntArray> {
        val map: MutableMap<Int, Int> = mutableMapOf()

        val result: MutableList<IntArray> = mutableListOf()

        nums.forEachIndexed { i, num ->
            if (map.containsKey(target - num)) {
                val newResult = IntArray(2)
                newResult[0] = map[target-num]!!
                newResult[1] = i
                result.add(newResult)
            }
            map[num] = i
        }

        return result
    }
}
