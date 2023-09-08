<<<<<<< HEAD
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i=1 ; i<nums.length ; i++)
        {
            currentSum = Math.max(nums[i] , currentSum + nums[i]);

            maxSum = Math.max(maxSum , currentSum);
        }
        return maxSum;
    }
=======
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i=1 ; i<nums.length ; i++)
        {
            currentSum = Math.max(nums[i] , currentSum + nums[i]);

            maxSum = Math.max(maxSum , currentSum);
        }
        return maxSum;
    }
>>>>>>> 04fd6af8b327f2700142df79dd19a9208118eab2
}