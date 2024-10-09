//time complexity is O(n+m)
//space complexity is O(1)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create an array to store the frequency of each character in the magazine
        int[] charCount = new int[26];
        
        // Count the occurrences of each character in the magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Check if we can construct the ransom note from the magazine
        for (char c : ransomNote.toCharArray()) {
            // If there are not enough characters, return false
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            // Decrease the count of the character used
            charCount[c - 'a']--;
        }
        
        // If we haven't returned false, we can construct the ransom note
        return true;
    }
}
