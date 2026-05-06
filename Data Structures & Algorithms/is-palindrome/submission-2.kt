class Solution {
    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) return true
        val cleaned = buildString { 
            for (char in s) {
                if (char.isLetter() || char.isDigit()) append(char.lowercase())
            }
        }

        for (i in 0 until cleaned.length) {
            if (cleaned[i] != cleaned[cleaned.length - 1 - i]) {
                return false
            }
        }
        return true
    }
}
