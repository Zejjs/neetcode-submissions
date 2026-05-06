class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int wordLength = 0;
            while (Character.isDigit(str.charAt(i))) {
                wordLength = wordLength * 10 + (str.charAt(i) - '0');
                i++;
            }
            i++;

            String word = str.substring(i, i + wordLength);

            result.add(word);
            i += wordLength;
        }
        return result;
    }
}
