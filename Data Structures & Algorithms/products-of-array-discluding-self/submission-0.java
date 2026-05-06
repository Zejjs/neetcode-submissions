class Solution {
    public int[] productExceptSelf(int[] input) {
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; ++i) {
            if (i == 0) {
                output[i] = 1;
            }
            else {
                output[i] = output[i-1] * input[i-1];
            }
        }

        int postfix = 1;

        for (int i = input.length - 1; i >= 0; --i) {
            output[i] *= postfix;
            postfix *= input[i];
        }

        System.out.printf("Product of Array Except Self for input: %s = %s%n%n",
                Arrays.toString(input), Arrays.toString(output));
                
        return output;
    }
}  
