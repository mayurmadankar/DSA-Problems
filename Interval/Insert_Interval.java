class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {  // Ensure no overlap
            result.add(intervals[i]);
            i++;
        }

        // Merge intervals that overlap with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {  // Overlap condition
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);  // Adjust the start
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);  // Adjust the end (use Math.max)
            i++;
        }
        result.add(newInterval);  // Add the merged interval

        // Add the remaining intervals that come after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}
