class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        val result = IntArray(2)
        
        nums.forEachIndexed { i, num ->
            if (map.containsKey(target-num)) {
                result[0] = map[target-num]!!
                result[1] = i
                return result
            }
            map[num] = i
        }
        return result
    }
}
