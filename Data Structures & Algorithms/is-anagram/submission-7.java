class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            sMap.compute(c, (key, value) -> (value == null) ? 1 : value + 1);

            c = t.charAt(i);
            tMap.compute(c, (key, value) -> (value == null) ? 1 : value + 1);
        }

        for (char c : sMap.keySet()) {
            if(!sMap.get(c).equals(tMap.get(c))) {
                return false;
            }
        }
        return true;
    }
}
