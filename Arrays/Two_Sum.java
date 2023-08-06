class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Brute Force Approch

        // int n = nums.length;

        // for(int i=0 ; i< n ; i++){
        //     for(int j=i+1 ; j<n ;j++){
        //         if(nums[i]+nums[j]==target){
        //             int a[]={i,j};
        //             return a;
        //         }
        //     }
        // }
        // return null;


// Better approach
        HashMap<Integer , Integer> map = new HashMap<>();
        int n=nums.length;

        for(int i=0 ; i<n ; i++){

            int num =nums[i];
            int moreNeeded = target - num;

            if(map.containsKey(moreNeeded)){
               return new int[]{map.get(moreNeeded) , i};
            }
            map.put(nums[i] , i);
        }
        return null;


        // optimal Approach 

       
        
        // Arrays.sort(nums); // Sort the array

        // int left = 0;
        // int right = nums.length - 1;

        // while (left < right) {
        //     int sum = nums[left] + nums[right];
        //     if (sum == target) {
        //         return new int[]{left, right};
        //     } else if (sum < target) {
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return null;
    }
}
    