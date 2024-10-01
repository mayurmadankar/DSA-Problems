import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap to store the element and its last seen index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the map and the difference between indices is <= k
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true; // Duplicate found within the range
                }
            }
            // Update the map with the current index
            map.put(nums[i], i);
        }
        
        // If no duplicates found within the given range
        return false;
    }
}
