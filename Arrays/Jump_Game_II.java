class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest index that can be reached from current position
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we've reached the current end, we need to make a jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }
}
