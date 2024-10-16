import java.util.HashSet;
//tc- O(log n), since the sum of squares reduces the number size.
//sc-O(log n), where log n corresponds to the number of digits in n, since we're storing numbers in the HashSet.
class Solution {
    public boolean isHappy(int n) {
        // A set to track numbers we've already seen
        HashSet<Integer> seen = new HashSet<>();
        
        // Continue the process until n becomes 1 or we detect a cycle
        while (n != 1 && !seen.contains(n)) {
            // Add the current number to the set
            seen.add(n);
            
            // Calculate the sum of the squares of the digits
            n = getSumOfSquares(n);
        }
        
        // If n is 1, it's a happy number; otherwise, it's not
        return n == 1;
    }
    
    // Helper function to calculate the sum of the squares of the digits of a number
    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; // Extract the last digit
            sum += digit * digit; // Square it and add to the sum
            n /= 10; // Remove the last digit
        }
        return sum;
    }
}
