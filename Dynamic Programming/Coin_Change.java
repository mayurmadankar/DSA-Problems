//time complexity -O(mxn) , m-number of coins that you make | n- total amount that you make
//space complexity -O(n) , n-number of amount
class Solution {
    public int coinChange(int[] coins, int amount) {
        // edge case: if amount is 0, no coins are needed
        if (amount == 0) {
            return 0;
        }

        // create a dp array to store the minimum coins required for each amount
        int[] minCoinDP = new int[amount + 1];
        // fill the dp array with a high value (like Integer.MAX_VALUE)
        Arrays.fill(minCoinDP, amount + 1); // Using amount + 1, which is greater than any valid result
        minCoinDP[0] = 0; // base case: 0 coins are needed to make 0 amount

        // iterate over each amount from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // update dp array with the minimum coins needed
                    minCoinDP[i] = Math.min(minCoinDP[i], 1 + minCoinDP[i - coin]);
                }
            }
        }

        // if no combination is found, return -1
        return minCoinDP[amount] > amount ? -1 : minCoinDP[amount];
    }
}
