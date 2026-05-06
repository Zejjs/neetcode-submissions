class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf()
        
        val result = IntArray(2)
        
        nums.forEachIndexed { i, num ->
            if (map.containsKey(target - num)) {
                result[0] = map[target-num]!!
                result[1] = i
            }
            map[num] = i
        }
        
        return result
    }
}
