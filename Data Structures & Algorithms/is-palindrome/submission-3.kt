class Solution {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) return true

        val cleaned = s.filter { it.isLetterOrDigit() }.lowercase()

        for (i in 0 until cleaned.length / 2) {
            if (cleaned[i] != cleaned[cleaned.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}
