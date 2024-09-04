//time compleaxity -O(mxn)
//space complexity -O(mxn)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int dp[][]=new int[m][n];
        dp[0][0]=1;
        
        //fill the first row 
        for(int i =1;i<n;i++){
            dp[0][i]=(obstacleGrid[0][i]==1)?0:dp[0][i-1];
        }
        //fill the first col
        for(int j=1;j<m;j++){
            dp[j][0]=(obstacleGrid[j][0]==1)?0:dp[j-1][0];
        }
        //fill rest of the remaning dp[][]
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from top and left
                }
            }
        }
        return dp[m-1][n-1];
    }
}