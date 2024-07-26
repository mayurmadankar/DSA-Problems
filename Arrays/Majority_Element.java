class Solution {
    public int majorityElement(int[] nums) {
        
        int n = nums.length;
        int count = 0;
        int element = 0;

        for(int i=0 ; i<n ; i++){

            if(count == 0){
                count=1;
                element = nums[i];
            }else if(nums[i]==element){
                count+=1;
            }else{
                count-=1;
            }
        }
        int count2=0;
        for(int i=0 ;i<n ; i++){
            if(nums[i]==element){
                count2+=1;
            }
        }
        if(count2 > (n/2)){
            return element;
        }
        return -1;
    }
}