//time complexity -O(n)
//space complexity -O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int startIndex = i;
            int endIndex = s.lastIndexOf(s.charAt(startIndex));

            for (int j = startIndex + 1; j < endIndex; j++) {
                int lastIndexOfNextChar = s.lastIndexOf(s.charAt(j));

                if (lastIndexOfNextChar > endIndex) {
                    endIndex = lastIndexOfNextChar;
                }
            }

            partitions.add(endIndex - startIndex + 1);
            i = endIndex + 1; // Move to the next partition
        }
        
        return partitions;
    }
}
