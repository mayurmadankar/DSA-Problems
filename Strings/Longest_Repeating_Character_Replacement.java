class Solution {
    public int characterReplacement(String s, int k) {

        int charCount[] = new int[26];
        int n = s.length();
        int left =0;
        int maxCount =0;

        for(int right=0 ; right<n ; right++){
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount , charCount[s.charAt(right)-'A']);

            if((right-left+1 - maxCount)> k ){
               charCount[s.charAt(left)-'A']--;
                left++;
             }
        }
        return s.length()-left;
    }
     
}