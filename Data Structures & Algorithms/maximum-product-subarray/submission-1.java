class Solution {
    public int maxProduct(int[] input) {
        int[][] minMaxArray = new int[input.length][2];

        minMaxArray[0][0] = input[0];
        minMaxArray[0][1] = input[0];

        int maxProduct = input[0];

        for (int i = 1; i < input.length; ++i) {

            minMaxArray[i][0] = IntStream.of(
                    minMaxArray[i - 1][0] * input[i],
                    minMaxArray[i - 1][1] * input[i],
                    input[i]).min().orElseThrow();

            minMaxArray[i][1] = IntStream.of(
                    minMaxArray[i - 1][0] * input[i],
                    minMaxArray[i - 1][1] * input[i],
                    input[i]).max().orElseThrow();


            if (minMaxArray[i][1] > maxProduct) {
                maxProduct = minMaxArray[i][1];
            }
        }
        System.out.printf("Max sub-array product for input: %s = %d %n%n", Arrays.toString(input), maxProduct);
        return maxProduct;
    }
}
