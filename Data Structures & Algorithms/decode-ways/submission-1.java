class Solution {
    public int numDecodings(String s) {

        int twoAhead = 0;
        int oneAhead = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int temp;
            if (s.charAt(i) == '0') {
                temp = 0;
            } else {
                temp = oneAhead;
                if (i + 1 < s.length() && (s.charAt(i) == '1' ||
                        s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    temp += twoAhead;
                }
            }
            twoAhead = oneAhead;
            oneAhead = temp;
        }


        System.out.printf("String %s has %d decodings%n%n", s, oneAhead);
        return oneAhead;
    }
}
