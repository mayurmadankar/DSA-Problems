//tc-O(n)
//sc-O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        // 4
        int minSoFar = prices[0];
        // 5,2

        for(int i=0;i<prices.length;i++){

            minSoFar = Math.min(minSoFar , prices[i]);

            int profit = prices[i]-minSoFar;
            // 0,0,4,0 , 3

            maxprofit = Math.max(maxprofit , profit);
            // (0,0) , (0,0) . (0,4) , (4,0) , (4, 3)
        }
        return maxprofit;
    }
}