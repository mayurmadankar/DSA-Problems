//time complexity -O(n^2) > two for loops
//space complexity-O(n^2) > we store the element into the 2D Array

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int dp[][]=new int[height+1][height+1];

        //iterate over the height
        for(int level=height-1;level>=0;level--){
            //iterate over the level >row
            for(int i=0;i<=level;i++){
                //add the minimun amoungst two from the bottom level
                dp[level][i]=triangle.get(level).get(i)+Math.min(dp[level+1][i],dp[level+1][i+1]);
            }
        }
        return dp[0][0];
    }
}