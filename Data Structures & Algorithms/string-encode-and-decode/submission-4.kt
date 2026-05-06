class Solution {

    fun encode(strs: List<String>): String {
        if (strs.isEmpty()) return ""

        val sb = StringBuilder()
                for (str in strs) {
            sb.append(str.length).append('#').append(str)
        }

        return sb.toString()
    }

    fun decode(str: String): List<String> {
        if (str.isEmpty()) return listOf()

        val result = mutableListOf<String>()
        var idx = 0
        while (idx < str.length - 1) {
            var wordLen = 0

            while (idx < str.length && str[idx].isDigit()) {
                wordLen = wordLen*10 + (str[idx] - '0')
                idx++
            }
            idx++
            val nextWord = str.substring(idx, idx + wordLen)
            result.add(nextWord)
            idx+=wordLen
        }

        return result
    }
}
