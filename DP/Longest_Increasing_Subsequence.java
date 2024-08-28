//time complexity -O(n^2)
//space cpmplexity -O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        //edge case
        if(nums==null || nums.length==0){
            return 0;
        }
        //length and create the dp and maxLength
        int n =nums.length;
        int dp[]=new int[n];
        int maxLength=1;

        //fill the dp array
        for(int i=0;i<n;i++){
            dp[i]=1;
        }

        // fill the array with defined relation
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}