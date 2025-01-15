class Solution {
    public int minimizeXor(int num1, int num2) {
        // Count the number of set bits in num2
        int targetSetBits = Integer.bitCount(num2);

        // Start with num1 as the base
        int result = 0;

        // Step 1: Use the set bits of num1 (highest to lowest) to match targetSetBits
        for (int i = 31; i >= 0 && targetSetBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) {
                result |= (1 << i); // Set the bit in the result
                targetSetBits--;   // Reduce the count of needed set bits
            }
        }

        // Step 2: If there are still set bits to assign, use the lowest unset bits
        for (int i = 0; i <= 31 && targetSetBits > 0; i++) {
            if ((result & (1 << i)) == 0) {
                result |= (1 << i); // Set the bit in the result
                targetSetBits--;   // Reduce the count of needed set bits
            }
        }

        return result;
    }
}
