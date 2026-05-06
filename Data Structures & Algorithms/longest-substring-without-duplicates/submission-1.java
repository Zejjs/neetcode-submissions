class Solution {
        public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int lptr = 0;
        int rptr = 0;
        int maxlen = 1;
        Set<Character> uniqueChars = new HashSet<>();
        uniqueChars.add(s.charAt(rptr));

        while (rptr < s.length() - 1) {
            rptr++;

            while (uniqueChars.contains(s.charAt(rptr))){
                uniqueChars.remove(s.charAt(lptr));
                lptr++;
            }
            uniqueChars.add(s.charAt(rptr));

            if (rptr - lptr + 1 > maxlen) {
                maxlen = rptr - lptr + 1;
            }
        }

        return maxlen;
    }
}
