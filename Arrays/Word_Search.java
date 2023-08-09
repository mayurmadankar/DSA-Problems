class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i=0 ;i<row ; i++){
            for(int j=0 ; j<col ;j++){
                if(board[i][j]==word.charAt(0) && search(board , word , i , j , 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean search(char [][]board , String word , int i , int j , int index){
        if(index==word.length()-1)return true;
        board[i][j]-=65;
        if(i>0 && board[i-1][j]==word.charAt(index+1) && search(board , word , i-1 , j , index+1)) return true;

        if(j>0 && board[i][j-1]==word.charAt(index+1) && search(board , word , i , j-1, index+1)) return true;

        if(i<board.length-1 && board[i+1][j] ==word.charAt(index+1) && search(board , word , i+1 , j , index+1)) return true;

       if(j<board[0].length-1 && board[i][j+1] ==word.charAt(index+1) && search(board , word , i , j+1 , index+1)) return true;

        board[i][j]+=65;
        return false;

    }
}