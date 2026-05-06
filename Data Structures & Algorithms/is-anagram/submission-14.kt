class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val alphaArray = IntArray(26)

        for (char in s) {
            alphaArray[char - 'a']++
        }

        for (char in t) {
            if (alphaArray[char - 'a'] == 0) {
                return false
            }
            alphaArray[char - 'a']--
        }

        return true
    }
}
