//time complexity -O(n^2)
//space complexity -O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //set of wordset
        Set<String> WordSet = new HashSet<>(wordDict);

        //boolean array for true value storing
        boolean[] dp = new boolean[s.length()+1];

        //if 0 word then also true
        dp[0]=true;

        //iterate over the word given
        for(int i=1;i<=s.length();i++){
            //check for word from start to end of word 
            for(int j=0;j<i;j++){
                if(dp[j] && WordSet.contains(s.substring(j,i))){
                    //if contains the word then make that last number true
                    dp[i]=true;
                    break;
                }
            }
        }
        //return that last element
        return dp[s.length()];
    }
}