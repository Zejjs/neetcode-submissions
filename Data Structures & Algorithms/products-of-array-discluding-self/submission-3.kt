class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefixes = IntArray(nums.size)
        val postfixes = IntArray(nums.size)
        prefixes[0] = 1
        postfixes[postfixes.size - 1] = 1

        for (i in 1 until nums.size) {
            prefixes[i] = prefixes[i - 1] * nums[i-1]
        }

        for (i in nums.size - 2 downTo 0) {
            postfixes[i] = postfixes[i+1] * nums[i+1]
        }

        val result = IntArray(nums.size)

        for (i in 0 until nums.size) {
            result[i] = prefixes[i] * postfixes[i]
        }
        return result
    }
}
