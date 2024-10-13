class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        
        int start = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // If nums[i] is not consecutive, close the current range
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start)); // Single number range
                } else {
                    result.add(start + "->" + nums[i - 1]); // Multiple numbers range
                }
                start = nums[i]; // Update start for the new range
            }
        }
        
        // Add the final range
        if (start == nums[nums.length - 1]) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }
        
        return result;
    }
}
