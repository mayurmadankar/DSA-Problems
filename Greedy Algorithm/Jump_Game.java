//time complexity -O(n)
//space complexity-O(1)
class Solution {
    public boolean canJump(int[] nums) {
        //mark flag to final position
        int finalPosition=nums.length-1;
        //iterate over the array from second last index
        for(int index=nums.length-2;index>=0;index--){
            //if we able to reach the finalPostion then change finalPosition
            if(index+nums[index]>=finalPosition){
                finalPosition=index;
            }
        }
        return finalPosition==0;
    }
}