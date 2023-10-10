class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
    
    // Start from the rightmost digit
    for (int i = n - 1; i >= 0; i--) {
        // If the current digit is less than 9, we can simply increment it and return
        if (digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        // If the current digit is 9, set it to 0 and continue to the next digit
        digits[i] = 0;
    }
    
    // If we reach this point, it means all digits were 9, so we need to create a new array with an extra digit
    int[] newDigits = new int[n + 1];
    newDigits[0] = 1;
    
    return newDigits;
    }
}