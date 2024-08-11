//time complexity-O(m*n);
//space complexity-O(m*n)
class Solution {
    public int numIslands(char[][] grid) {
        //edge case
        if(grid==null || grid.length==0){
            return 0;
        }
        int NumberOfIsland=0;
        int rows=grid.length;
        int cols=grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]== '1'){
                    NumberOfIsland++;
                    dfs(grid,i,j);
                }
            }
        }
        return NumberOfIsland;
    }
    private void dfs(char[][]grid,int i,int j){
        int rows=grid.length;
        int cols=grid[0].length;

        //edge case if i,j out of bound or visited
        if(i<0||i>=rows||j<0||j>=cols||grid[i][j]=='0'){
            return;
        }
        //marked current island has visited by marking as '0'
        grid[i][j]='0';

        //calling dfs for four side 
        dfs(grid,i-1,j);//up
        dfs(grid,i+1,j);//down
        dfs(grid,i,j-1);//left
        dfs(grid,i,j+1);//right

    }
}