class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagraMap = mutableMapOf<String, MutableList<String>>()

        for (str in strs) {
            val alphaArray = IntArray(26)
            for (char in str) {
                alphaArray[char - 'a']++
            }
            val key = alphaArray.contentToString()
            anagraMap.getOrPut(key) { mutableListOf() }
                .add(str)
        }
        
        return anagraMap.values.toList()
    }
}
